//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Toy Saga Toy Class
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

import processing.core.PImage;

import java.io.File;

/**
 * This is the toy class used for the toy objects in ToySaga
 *
 * @author Winston Chan
 */
public class Toy {
    public final PImage IMAGE;

    private int x;
    private int y;
    private boolean isDragging;
    private int rotations = 0;

    /**
     * This represents the Toy constructor that takes in the parameters and sets the
     * corresponding instance variables.
     *
     * @param name
     * @param x
     * @param y
     */
    public Toy(String name, int x, int y) {
        this.x = x;
        this.y = y;
        this.isDragging = false;
        this.rotations = 0;
        this.IMAGE = Utility.loadImage("images" + File.separator + name + ".png");
    }

    /**
     * This constructor centers the toy in the center of the screen, while having the
     * same functions as the previous constructor.
     *
     * @param name
     */
    public Toy(String name) {
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
     * The setter method for the x position.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
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
     * The setter method for the y position.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * The getter method for the number of rotations made on the toy.
     *
     * @return this.x
     */
    public int getRotationsCount() {
        return this.rotations;
    }

    /**
     * This method returns the status of the toy if it is dragging or not.
     *
     * @return
     */
    public boolean isDragging() {
        return this.isDragging;
    }

    /**
     * This method sets the status of the toy if it is dragging to be true.
     *
     * @return
     */
    public void startDragging() {
        this.isDragging = true;
    }

    /**
     * This method sets the status of the toy if it is dragging to be false.
     *
     * @return
     */
    public void stopDragging() {
        this.isDragging = false;
    }

    /**
     * This method counts the number of rotations that have been made to the toy.
     *
     * @return
     */
    public void rotate() {
        this.rotations++;
    }

    /**
     * This method changes the x and y direction of the toy. If the x and y coordinate exceed
     * the width and height, then it sets it to the furthest width and height distance.
     *
     * @param dx
     * @param dy
     */
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;

        if (this.x < 0) {
            this.x = 0;
        } else if (this.x > Utility.width()) {
            this.x = Utility.width();
        }

        if (this.y < 0) {
            this.y = 0;
        } else if (y > Utility.height()) {
            this.y = Utility.height();
        }
    }

    /**
     * This method draws the updated image from its original position to its final position.
     */
    public void draw() {
        if (isDragging) {
            int dx = Utility.mouseX() - Utility.pmouseX();
            int dy = Utility.mouseY() - Utility.pmouseY();
            move(dx, dy);
        }
        drawToyImage();
    }

    /**
     * Helper method to draw an image accounting for any rotations to the screen.
     * The implementation of this method is fully provided in the write-up.
     */
    private void drawToyImage() {
        Utility.pushMatrix();
        Utility.translate(x, y);
        Utility.rotate(this.rotations * Utility.PI / 2);
        Utility.image(IMAGE, 0.0f, 0.0f);
        Utility.popMatrix();
    }

    /**
     * This method detects whether if the toy is over the x and y coordinate. It also takes
     * into account the toy's rotation.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isOver(int x, int y) {

        int leftA, rightA, topA, bottomA;

        if (rotations % 2 == 0) {
            leftA = getX() - this.IMAGE.width / 2;
            rightA = getX() + this.IMAGE.width / 2;
            topA = getY() - this.IMAGE.height / 2;
            bottomA = getY() + this.IMAGE.height / 2;
        } else {
            leftA = getX() - this.IMAGE.height / 2;
            rightA = getX() + this.IMAGE.height / 2;
            topA = getY() - this.IMAGE.width / 2;
            bottomA = getY() + this.IMAGE.width / 2;
        }
        return x >= leftA && x <= rightA && y >= topA && y <= bottomA;
    }

    /**
     * This method detects whether if the toy is over a furniture object. It also takes
     * into account the toy's rotation.
     *
     * @param other
     * @return
     */
    public boolean isOver(Furniture other) {
        int leftA, rightA, topA, bottomA;

        if (rotations % 2 == 0) {
            leftA = this.x - this.IMAGE.width / 2;
            rightA = this.x + this.IMAGE.width / 2;
            topA = this.y - this.IMAGE.height / 2;
            bottomA = this.y + this.IMAGE.height / 2;
        } else {
            leftA = this.x - this.IMAGE.height / 2;
            rightA = this.x + this.IMAGE.height / 2;
            topA = this.y - this.IMAGE.width / 2;
            bottomA = this.y + this.IMAGE.width / 2;
        }

        int leftB = other.getX() - other.IMAGE.width / 2;
        int rightB = other.getX() + other.IMAGE.width / 2;
        int topB = other.getY() - other.IMAGE.height / 2;
        int bottomB = other.getY() + other.IMAGE.height / 2;

        return rightA >= leftB && leftA <= rightB && bottomA >= topB && topA <= bottomB;
    }

}
