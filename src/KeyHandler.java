package src;
//Provides all the visuals, buttons/controls, basically the actual game

//Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.lang.*;

//If you don't know what a thread is it is basically

//JPanel allows us to get the methods to make the game

//Implements Runnable means we can multithread (basically means we can run multiple programs at once)
public class GamePanel extends JPanel implements Runnable {

    // set variables for the dimensions of the window
    public static int width;
    public static int height;

    // Use the Thread class to set a game clock (FPS)
    // It allows us to start something and stop it if not stopped it will keep on
    // running until the entire program is stopped
    // We use a thread here because we want the fps run simultainiously run with the
    // program until it ends
    // We implement runnable to use the thread
    Thread thread;


    //Initialize KeyHandler function
    KeyHandler keyH = new KeyHandler();

    //Initialize player function
    Player player = new Player(this,keyH);

    //Set player's default postion
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 1;

    //FPS
    int FPS = 60;

    public GamePanel(int width, int height) {

        // sets the dimension of the screen but we call it in the window class with the
        // method setContentPane
        this.setPreferredSize(new Dimension(width, height));

        // set background color
        this.setBackground(Color.black);

        // Allow many graphics to load at once and its faster, improve rendering
        // performance
        this.setDoubleBuffered(true);

        //Adds the keyboard input and GamePanel can recognize the key input
        this.addKeyListener(keyH);

        // Allows the Jpanel to focus and have input as soon as the JFrame is made (keyboard input
        // and shit)
        this.setFocusable(true);
        requestFocus();

    }

    public void gameThreadStart() {

        // Instantiate a thread
        thread = new Thread(this);

        // call the run function
        thread.start();
    }

    public void addNotify() {

        // call the superclass method addNotify and it connects the awt to the window so
        // like we can actually move stuff or somethign i think (idk)
        super.addNotify();

    }

    @Override
    // Overrides the implements runnable
    // When we call the thread the run function will automatically start
    public void run() {

        // Game Loop below

        //We are dividing one second by 60fps per second which equals it draws the screen every 0.016 seconds
        //To change just divide by a different number
        double drawInterval = 100000000/FPS;

        //Gives us 0.0166 seconds before the frame redraws
        //We use nano seconds instead of milliseconds to get a more accurate time
        double nextDrawTime = System.nanoTime() + drawInterval;


        // as long as the thread is not stopped it repeats everything in side the
        // brackets
        while (thread != null) {

            //Restriction to make the computer update 60 frames per seconds


            // test if the thread is running you can put it in or not
//            System.out.println("The game loop is running");

            // Code to update information (e.g. Character Positions)
            update(); // Calls the update function

            // Draw the screen with updated informatin (e.g. the background and shit)

            repaint(); // Call the paintComponents function, it's not called paintComponents but it's
            // called repaint



            //Try the code
            try {
                //We find the different to tell us how much time is remaining until the next draw time so we can tell the program how much time it needs to sleep
                double remainingTime = nextDrawTime - System.nanoTime();

                //Convert from nano to milliseconds
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                //pauses the game loop
                Thread.sleep((long) remainingTime);

                //The new time after the frame has passed
                nextDrawTime += drawInterval;

            //Handles exceptions and errors and prints the issues
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void update() {
        //Updates everything in the game
        player.update();

    }

    // Built in method by java
    // Standard name to draw things on JPanel
    // Other ways to draw but like I don't know anymore 😔

    public void paintComponent(Graphics g) { // Graphics is a class that has many functions that allow us to draw
        // objects onto the screen

        // We need to type this if we are using paintComponents because
        // I honestly don't know what this is for but people say it's like for JPanel's
        // opaquity
        super.paintComponent(g);

        // Extends the graphics class to provide better control over geometry,
        // corddinates, layout and etc
        // Change the graphics class to graphics2d class
        Graphics2D g2 = (Graphics2D)g;

        //we need to add g2 or else nothing would draw here
        player.draw(g2);


        // Get rid of the graphics and release any system resources that it is using
        g2.dispose();

    }

}
