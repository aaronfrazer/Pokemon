import javax.swing.*;

/**
 * Window for the entire game.
 *
 * @author Aaron Frazer
 *
 */
public class Window extends JFrame
{
    /**
     * Creates the window for the game.
     */
    public Window()
    {
        setTitle("Pokemon Purple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}