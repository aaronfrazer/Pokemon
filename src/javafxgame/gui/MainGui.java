package javafxgame.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A class used for the GUI of the game.
 * 
 * @author Aaron Frazer
 */
public class MainGui extends JFrame
{
	JPanel startPanel  = new JPanel();
	JPanel battlePanel = new JPanel();
	
	/**
	 * Construct the initial GUI.
	 */
	public MainGui()
	{
		super("Pokemon");

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JButton btn = new JButton("Start Battle");
		btn.addActionListener(new MyStartListener());

		setLayout(new BorderLayout());
		add(btn);
		pack();
	}
	
	/**
	 * Event for when "Start Battle" button is clicked.
	 * 
	 * @author Aaron Frazer
	 */
	public class MyStartListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			// need to swap the JPanels
			
			
			JOptionPane.showMessageDialog(MainGui.this, "Button Pressed", "Hey", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}