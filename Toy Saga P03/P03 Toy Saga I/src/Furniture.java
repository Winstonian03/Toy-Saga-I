//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Toy Saga Furniture Class
// Course:   CS 300 Spring 2024
//
// Author:   Winston Chan
// Email:    wchan35@wisc.edu
// Lecturer: Andrew Kuemmel
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (partners are not allowed)
// Partner Email:   (partners are not allowed)
// Partner Lecturer's Name: (partners are not allowed)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Online Sources:  https://piazza.com/class/lw5frsrfih8uv/post/116
//                  P02 Dorm Draw
//                  P03 JavaDocs (Utility + ToySaga)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

import processing.core.PImage;

/**
 * This is the furniture class used for the furniture objects in ToySaga
 *
 * @author Winston Chan
 */
public class Furniture {
    public final PImage IMAGE;
    private String name;
    private int x;
    private int y;

    /**
     * This represents the Furniture constructor that takes in the parameters and sets the
     * corresponding instance variables.
     *
     * @param name
     * @param x
     * @param y
     */
    public Furniture(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.IMAGE = Utility.loadImage("images" + File.separator + name + ".png");
    }

    /**
     * This constructor centers the furniture in the center of the screen, while having the
     * same functions as the previous constructor.
     *
     * @param name
     */
    public Furniture(String name) {
        this(name, Utility.width() / 2, Utility.height() / 2);
    }

    /**
     * The getter method for the x position.
     *
     * @return this.x
     */
    public int getX() {
        return this.x;
    }

    /**
     * The getter method for the y position.
     *
     * @return this.y
     */
    public int getY() {
        return this.y;
    }

    /**
     * The getter method for the name.
     *
     * @return this.name
     */
    public String name() {
        return this.name;
    }

    /**
     * The setter method for the name.
     *
     * @param name
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * This method draws the image given the x and y coordinates.
     */
    public void draw() {
        Utility.image(IMAGE, this.x, this.y);
    }
}
