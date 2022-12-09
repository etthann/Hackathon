package src;
// This class makes a game window

//JFrame provides a game window
import javax.swing.JFrame;

class Window extends JFrame {

    public Window() {

        //Set the title of the game
        setTitle("2D Horror Game");

        //Allows us to exit the game
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the dimension of the game window
        setContentPane(new GamePanel(1280, 720));

        // Condense the window to a jpanel
        pack();

        //Center the window to the center of your screen
        setLocationRelativeTo(null);

        //Allows us to actually see the game...
        setVisible(true);
    }
}