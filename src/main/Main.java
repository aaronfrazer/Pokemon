package main;

import gui.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pokemon.Attack;
import pokemon.Battle;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;

/**
 * The Main class to run the Pokemon application.
 * For now this is just a console based game.
 * 
 * @author Aaron Frazer
 */
public class Main extends Application
{
	public Stage window;
	public Scene battleScene;
	public TextArea console; // Console to output battle events
	public BorderPane borderPane;
	public Label p1nameLabel, p1levelLabel, p1healthLabel; // Labels for Pokemon 1
	public Label p2nameLabel, p2levelLabel, p2healthLabel; // Labels for Pokemon 2
	public ArrayList<Label> p1labelList = new ArrayList<Label>(); // An arraylist of labels for Pokemon 1
	public ArrayList<Label> p2labelList = new ArrayList<Label>(); // An arraylist of labels for Pokemon 2
	public ArrayList<Button> p1buttonList = new ArrayList<Button>(); // An arraylist of buttons for Pokemon 1
	public ArrayList<Button> p2buttonList = new ArrayList<Button>(); // An arraylist of buttons for Pokemon 2
    public VBox p1VBox = new VBox(); // Labels and buttons for Pokemon 1
    public VBox p2VBox = new VBox(); // Labels and buttons for Pokemon 2
    public Battle battle;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	/**
	 * Runs the application when the program first starts.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("Pokemon Battle Simulation");
		borderPane = new BorderPane();
		
	    console = new TextArea();
	    console.setText("Welcome to Pokemon! This is a battle.");
	    
		// Create two pokemon
		Pokemon p1 = new Pokemon("Pikachu", 5, 80, 20, 20, Type.ELECTRIC);
		Pokemon p2 = new Pokemon("Charmander", 5, 100, 20, 20, Type.FIRE);
				
		// Create their attacks (a pokemon will have a max of 4 attacks)
		Attack a1 = new Attack("Thundershock", 20);
		Attack a2 = new Attack("Quick Attack", 25);
		Attack b1 = new Attack("Slash", 10);
		Attack b2 = new Attack("Ember", 30);
		
		// Assign attacks to a pokemon
		p1.assignAttack(a1);
		p1.assignAttack(a2);
		p2.assignAttack(b1);
		p2.assignAttack(b2);
		
		// Create the battle
		battle = new Battle(p1, p2);
		battle.start();
		
		// Assign labels
		p1nameLabel = new Label("Pokemon 1: " + p1.getName());
		p1levelLabel = new Label("Level: " + p1.getLevel());
		p1healthLabel = new Label("Health: " + p1.getHealth());
		p2nameLabel = new Label("Pokemon 2: " + p2.getName());
		p2levelLabel = new Label("Level: " + p2.getLevel());
		p2healthLabel = new Label("Health: " + p2.getHealth());
		
		// Add labels to lists
		p1labelList.add(p1nameLabel);
		p1labelList.add(p1levelLabel);
		p1labelList.add(p1healthLabel);
		p2labelList.add(p2nameLabel);
		p2labelList.add(p2levelLabel);
		p2labelList.add(p2healthLabel);
		
		p1VBox.getChildren().addAll(p1labelList);
		p2VBox.getChildren().addAll(p2labelList);
		
		assignButtonsToAttacks(p1, p2); // assign Pokemon attacks to buttons, assign buttons to event handlers
	    
		// when game first begins, p1 goes first
		// therefore p2's attacks are disabled
		// set all of p2's attacks to disabled
		
		if (battle.getTurn() == p1)
			setDisabledButtons(2);
		else if (battle.getTurn() == p2)
			setDisabledButtons(1);

		
	    p1VBox.getChildren().addAll(p1buttonList);
	    p2VBox.getChildren().addAll(p2buttonList);
		
	    borderPane.setLeft(p1VBox);
	    borderPane.setRight(p2VBox);
	    borderPane.setBottom(console);
	    
	    Button resetBtn = new Button("Reset Battle (Testing Purposes)");
	    borderPane.setCenter(resetBtn);
	    resetBtn.setOnAction(e -> {
	    	battle.reset();
	    });
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		// Initalize scene
		battleScene = new Scene(borderPane, 600, 400);
		window.setScene(battleScene);
		window.show();
	}

	/**
	 * Sets a Pokemon's attack buttons to disabled.
	 * 
	 * @param i - the Pokemon number to enable buttons for
	 */
	private void setDisabledButtons(int i) 
	{
		if (i == 1)
		{
			for (Button button: p2buttonList) 
			    button.setDisable(true);
			for (Button button: p1buttonList)
				button.setDisable(false);
		} else if (i == 2)
		{
			for (Button button: p1buttonList) 
			    button.setDisable(true);
			for (Button button: p2buttonList)
				button.setDisable(false);
		}

	}

	/**
	 * Loops through both Pokemon's attacks and assigns a button to each attack.
	 */
	private void assignButtonsToAttacks(Pokemon p1, Pokemon p2)
	{
		// Assign each of the Pokemon attacks to a button
		for (Attack a : p1.getAttacks())
		{
			Button button = new Button(a.getName() + " (" + a.getBaseDamage() + ")");
			p1buttonList.add(button);
			button.setOnAction(e -> {
				
				// use the attack
				p1.attack(p2, a.getBaseDamage(), 1.0f, 1.0f, 1.0f, 1.0f);

				// Update the stats of the defending pokemon (labels)
				p2healthLabel.setText("Health: " + p2.getHealth());

				// Output what harppend to the console
				String newLine = System.getProperty("line.separator");
				console.setText(p1.getName() + " used " + a.getName());
				console.appendText(newLine);
				System.out.println(p1.getName() + " used " + a.getName());
				System.out.println(newLine);
				
				if (p2.isAlive())
				{
					console.appendText(p2.getName() + " has " + p2.getHealth() + " HP remaining");
					System.out.println(p2.getName() + " has " + p2.getHealth() + " HP remaining");
				}
				else
				{
					console.appendText(p2.getName() + " has fainted!");
					System.out.println(p2.getName() + " has fainted!");
				}
				
				battle.nextRound();
				if (battle.getTurn() == p1)
					setDisabledButtons(2);
				else if (battle.getTurn() == p2)
					setDisabledButtons(1);
			});
		}
		
		// Assign each of the Pokemon attacks to a button
		for (Attack a : p2.getAttacks())
		{
			Button button = new Button(a.getName() + " (" + a.getBaseDamage() + ")");
			p2buttonList.add(button);
			button.setOnAction(e -> {
				
				// use the attack
				p2.attack(p1, a.getBaseDamage(), 1.0f, 1.0f, 1.0f, 1.0f);

				// Update the stats of the defending pokemon (labels)
				p1healthLabel.setText("Health: " + p1.getHealth());

				// Output what harppend to the console
				String newLine = System.getProperty("line.separator");
				console.setText(p2.getName() + " used " + a.getName());
				console.appendText(newLine);
				System.out.println(p2.getName() + " used " + a.getName());
				System.out.println(newLine);
				
				if (p1.isAlive())
				{
					console.appendText(p1.getName() + " has " + p1.getHealth() + " HP remaining");
					System.out.println(p1.getName() + " has " + p1.getHealth() + " HP remaining");
				}
				else
				{
					console.appendText(p1.getName() + " has fainted!");
					System.out.println(p1.getName() + " has fainted!");
				}
				
				battle.nextRound();
				if (battle.getTurn() == p1)
					setDisabledButtons(2);
				else if (battle.getTurn() == p2)
					setDisabledButtons(1);
			});
		}
		
	}

	/**
	 * Terminates the program asking if the user wants to quit.
	 */
	private void closeProgram()
	{
		boolean answer = ConfirmBox.display("Title", "Are you sure you want to quit?");
		
		if(answer)
			window.close();		
	}
}