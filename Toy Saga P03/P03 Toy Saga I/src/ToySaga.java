//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Toy Saga
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

import java.util.ArrayList;
import java.io.File;

import processing.core.PImage;

/**
 * This class allows for the user to place toys in their bedroom, and stowe them away in the toy
 * box.
 *
 * @author Winston Chan
 */
public class ToySaga {
    private static PImage backgroundImage;

    private static ArrayList<Furniture> furnitureList;

    private static ArrayList<Toy> toyList;

    private static final String BOX_NAME = "box";

    private static final int MAX_TOYS_COUNT = 8;

    /**
     * This method creates two array lists, one for furniture and one for toys. It adds furniture
     * to the arrayList and places them at specific coordinates. It also loads the background
     * image.
     */
    public static void setup() {
        backgroundImage = Utility.loadImage("images" + File.separator + "background.png");
        toyList = new ArrayList<Toy>(MAX_TOYS_COUNT);
        furnitureList = new ArrayList<Furniture>();
        furnitureList.add(new Furniture("bed", 520, 270));
        furnitureList.add(new Furniture("rug", 220, 370));
        furnitureList.add(new Furniture("nightstand", 325, 240));
        furnitureList.add(new Furniture(BOX_NAME, 90, 230));
    }

    /**
     * This method draws the arrayLists of furniture and toys into the program. It also
     * deletes the toys when it is over the toy box.
     */
    public static void draw() {
        Utility.image(backgroundImage, Utility.width() / 2, Utility.height() / 2);
        for (int i = 0; i < furnitureList.size(); i++) {
            furnitureList.get(i).draw();
        }
        for (int i = 0; i < toyList.size(); i++) {
            if (toyList.get(i) != null) {
                toyList.get(i).draw();
            }
        }
        for (int i = 0; i < toyList.size(); i++) {
            if (toyList.get(i) != null & toyList.get(i).isOver(getToyBox())) {
                toyList.remove(i);
            }
        }
    }

    /**
     * This method finds the position of the toy box in the furniture arrayList.
     *
     * @return
     */
    public static Furniture getToyBox() {
        for (int i = 0; i < furnitureList.size(); i++) {
            Furniture furniture = furnitureList.get(i);
            if (furniture.name().equals(BOX_NAME)) {
                return furniture;
            }
        }
        return null;
    }

    /**
     * This method returns the toy in the arrayList that is being dragged by the user.
     *
     * @return
     */
    public static Toy getDraggingToy() {
        for (int i = 0; i < toyList.size(); i++) {
            Toy toy = toyList.get(i);
            if (toy != null && toy.isDragging()) {
                return toy;
            }
        }
        return null;
    }

    /**
     * This method detects when the mouse is pressed and allows the user to drag the toys around
     * the screen.
     */
    public static void mousePressed() {
        for (int i = 0; i < toyList.size(); i++) {
            if (toyList.get(i) != null && toyList.get(i).isOver(Utility.mouseX(), Utility.mouseY())) {
                toyList.get(i).startDragging();
            }
        }
    }

    /**
     * This method detects when the mouse is released and holds the object in place.
     */
    public static void mouseReleased() {
        for (int i = 0; i < toyList.size(); i++) {
            if (toyList.get(i) != null) {
                toyList.get(i).stopDragging();
            }
        }
    }

    /**
     * This method detects the specific keybindings that are pressed and conducts their
     * corresponding functions.
     */
    public static void keyPressed() {
        if (toyList.size() < MAX_TOYS_COUNT) {
            switch (Utility.key()) {
                case 'c':
                case 'C':
                    toyList.add(new Toy("car", Utility.mouseX(), Utility.mouseY()));
                    break;
                case 't':
                case 'T':
                    toyList.add(new Toy("teddyBear", Utility.mouseX(), Utility.mouseY()));
                    break;
                case 'r':
                case 'R':
                    rotateHelper();
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * This method helps rotate the toy 90 degrees
     */
    private static void rotateHelper() {
        for (int i = 0; i < toyList.size(); i++) {
            if (toyList.get(i) != null && toyList.get(i).isOver(Utility.mouseX(), Utility.mouseY())) {
                toyList.get(i).rotate();
                break;
            }
        }
    }

    /**
     * This method runs the application, and calls for the methods in the Furniture and Toy class.
     * This creates the room layout alongside its programmed functions.
     *
     * @param args
     */
    public static void main(String[] args) {
        Utility.runApplication();
    }
}
