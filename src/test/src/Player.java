package src;


import java.awt.*;

//Extends to the character file and we import the info from there
public class Player extends Characters{

    //Call the other classes and set them as variable??
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        //call the function setDefaultValues which calls the variables
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 1;

    }

// This is where we draw the character
    public void draw(Graphics2D g2) {
    //Replace all of this code with the character this is just place holder

    // Set the color of the objects you draw
    g2.setColor(Color.white);

    // Make the rectangle (x pos, y pos, width, height)
    g2.fillRect(x, y, 10, 10);
        }

//Updates the characters position
    public void update() {
        if (keyH.upPressed) {
            y -= speed;

        }

        if (keyH.downPressed) {
            y += speed;
        }

        if (keyH.leftPressed) {
            x -= speed;
        }

        if (keyH.rightPressed) {
            x += speed;
        }
    }
}
