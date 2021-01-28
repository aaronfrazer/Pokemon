import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * JPanel used for the main window.
 *
 *  @author Aaron Frazer
 *
 */
public class GamePanel extends JPanel implements Runnable
{
    public static int width, height;

    private Thread thread;
    private boolean running = false;
    private BufferedImage img;
    private Graphics2D g;

    /**
     * Creates a JPanel that goes inside of the window.
     * @param width  - JPanel width
     * @param height - JPanel height
     */
    public GamePanel(int width, int height)
    {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    /**
     * Creates a buffered image and graphics.
     */
    public void init()
    {
        running = true;

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
    }

    @Override
    public void addNotify()
    {
        super.addNotify();

        if (thread == null)
        {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    @Override
    public void run()
    {
        init();

        while(running)
        {
            update();
            render();
            draw();
        }
    }

    private int x = 0;

    public void update()
    {
        x++;
        System.out.println(x);
    }

    public void render()
    {

    }

    public void draw()
    {

    }
}
