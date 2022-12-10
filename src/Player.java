package src;

import java.awt.image.BufferedImage;

import java.awt.*;
import java.io.IOException;


import javax.imageio.ImageIO;

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
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 1;
        setDirection = "up";
    }

    public void getPlayerImage () {
        // Load the player images
            try {
                //Load images
                up1 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_up_1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_up_2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_down_1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_down_2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_left_1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_left_2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_right_1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("pictures/boy_right_2.png"));
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                // CATCH ERRORS
                e.printStackTrace();
            }


    }

// This is where we draw the character
    public void draw(Graphics2D g2) {

    BufferedImage image = null;

    
//I thikn we can use a foor loop to do animation but I don't know if it'll work
    //Determine what picture we use it's essentially an if statemnet
    if (spriteNumber == 1) {
        switch (setDirection) {
            case ("up"):
            image = up1;
            break;

            case ("down"):
            image = down1;
            break;

            case ("left"):
            image = left1;
            break;

            case ("right"):
            image = right1;
            break;
            }
        }
    else if (spriteNumber == 2) {
        //This is where the second photos are
    }
    
    // Draws the pictures
    g2.drawImage(image,x,y, 50,50, null);

    }

//Updates the characters position
    public void update() {
        if (keyH.upPressed) {
            setDirection = "up";
            y -= speed;
        }

        if (keyH.downPressed) {
            setDirection = "down";
            y += speed;
        }

        if (keyH.leftPressed) {
            setDirection = "left";
            x -= speed;
        }

        if (keyH.rightPressed) {
            setDirection = "right";
            x += speed;
        }
    }
}
