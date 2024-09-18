//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Toy Saga Tester
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

/**
 * This class implements tester methods to ensure the correctness of the implementation of Furniture
 * and Toy classes in p03 Toy Saga I program.
 *
 * @author Winston Chan
 */
public class ToySagaTester {

    /**
     * This tester ensures the Furniture constructor which takes a String as input Furniture(String
     * name) correctly constructs a new Furniture object located at the center of the display window,
     * and assigned it a PImage and the name passed as input to the method call.
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testFurnitureConstructor1Getters() {
        // Create at least one new Furniture object by called the constructor Furniture(String). The
        // String passed as input to the constructor call should be either "bed", "box", "nightstand",
        // or "rug".
        Furniture furniture = new Furniture("bed");
        // Ensure that the call of getX() on that Furniture object equals Utility.width() / 2
        if (furniture.getX() != Utility.width() / 2) {
            return false;
        }
        // Ensure that the call of getY() on that Furniture object equals Utility.height() / 2
        if (furniture.getY() != Utility.height() / 2) {
            return false;
        }
        // Ensure that the call of name() on that Furniture object returns the name passed as input to
        // the constructor call
        if (!furniture.name().equals("bed")) {
            return false;
        }
        // Ensure that the value of the image field on that Furniture object returns a NON-null reference.
        if (furniture.IMAGE == null) {
            return false;
        }

        return true;
    }

    /**
     * This tester ensures the Furniture constructor which takes a String, and two integers as input
     * Furniture(String name, int x, int y) correctly constructs a new Furniture object located at the
     * (x,y) input position, assigned it the name passed as input to the method call, and an image.
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testFurnitureConstructor2Getters() {
        // Create at least one new Furniture object by called the constructor Furniture(String, int,
        // int). The String passed as input to the constructor call should be either "bed", "box",
        // "nightstand", or "rug".
        Furniture furniture = new Furniture("bed", 520, 270);
        // Ensure that the call of getX() on that Furniture object equals the input x
        if (furniture.getX() != 520) {
            return false;
        }
        // Ensure that the call of getY() on that Furniture object equals the input y
        if (furniture.getY() != 270) {
            return false;
        }
        // Ensure that the call of name() on that Furniture object returns the name passed as input to
        // the constructor call
        if (!furniture.name().equals("bed")) {
            return false;
        }
        // Ensure that the value of the image field on that Furniture object returns a NON-null reference.
        if (furniture.IMAGE == null) {
            return false;
        }

        return true;
    }

    /**
     * This tester ensures the Toy constructors, getters and setters of the x and y positions, and the
     * image field.
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testToyConstructorsGettersSetters() {
        // This tester should check for the correctness of BOTH Toy(String) and Toy(String, int, int)
        // constructors, and the following setter and getter methods:
        Toy carToy = new Toy("car");
        // for Toy(String)
        if (carToy.getX() != Utility.width() / 2) {
            return false;
        }
        if (carToy.getY() != Utility.height() / 2) {
            return false;
        }
        if (carToy.IMAGE == null) {
            return false;
        }
        if (carToy.isDragging()) {
            return false;
        }
        // for Toy(String, int, int)
        Toy bearToy = new Toy("teddyBear", 300, 400);
        if (bearToy.getX() != 300) {
            return false;
        }
        if (bearToy.getY() != 400) {
            return false;
        }
        if (bearToy.IMAGE == null) {
            return false;
        }
        if (bearToy.isDragging()) {
            return false;
        }

        bearToy.setX(200);
        if (bearToy.getX() != 200) {
            return false;
        }
        bearToy.setY(250);
        if (bearToy.getY() != 250) {
            return false;
        }

        return true;
    }

    /**
     * This tester ensures the correctness of Toy.startDragging() and Toy.stopDragging instance
     * methods
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testToyStartStopDragging() {
        // This tester should construct at least one Toy object and call startDragging() and
        // stopDragging() methods on that object.
        Toy toy = new Toy("car");
        // This tester should construct at least one Toy object and call startDragging() and
        // stopDragging() methods on that object.
        if (toy.isDragging()) {
            return false;
        }
        // Ensure the isDragging() method call returns true after every call of the startDragging()
        // method on the Toy object
        toy.startDragging();
        if (!toy.isDragging()) {
            return false;
        }
        // Ensure the isDragging() method call returns false after every call of the stopDragging()
        // method on the Toy object
        toy.stopDragging();
        if (toy.isDragging()) {
            return false;
        }
        return true;
    }

    /**
     * This tester ensures the correctness of Toy.move() method
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testToyMove() {
        // This tester should construct at least one Toy object at a given x,y position
        Toy toy = new Toy("car", 100, 100);
        // Every call on move(int dx, int dy) method should add dx and dy to the current x and y
        // position of the Toy object, respectively.

        // Positive inputs
        toy.move(10, 10);
        if (toy.getX() != 110 || toy.getY() != 110) {
            return false;
        }
        // Negative inputs
        toy.move(-10, -10);
        if (toy.getX() != 100 || toy.getY() != 100) {
            return false;
        }
        // 0 as an input
        toy.move(0, 0);
        if (toy.getX() != 100 || toy.getY() != 100) {
            return false;
        }

        // Out of bounds input
        toy.move(10000, 10000);
        if (toy.getX() > Utility.width() || toy.getY() > Utility.height()) {
            return false;
        }

        return true;
    }

    /**
     * This tester ensures the correctness of Toy.rotate() method.
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     * @author Mouna
     */
    public static boolean testToyRotate() {
        // This method's implementation is entirely provided to you
        // Create two Toy objects
        Toy car1 = new Toy("car");
        Toy car2 = new Toy("car");

        // Ensures getRotationsCount() returns zero when called on newly constructed Toy objects
        if (car1.getRotationsCount() != 0) {
            System.out.println(
                    "Toy.getRotationsCount() should return zero when called on a new created Toy object.");
            return false;
        }

        if (car2.getRotationsCount() != 0) {
            System.out.println(
                    "Toy.getRotationsCount() should return zero when called on a new created Toy object.");
            return false;
        }
        // rotate car1 5 times
        for (int i = 0; i < 5; i++) {
            car1.rotate();
        }
        // Ensure the getRotationsCount returns the expected output
        if (car1.getRotationsCount() != 5) {
            System.out.println(
                    "Toy.getRotationsCount() did not return the expected output after calling the rotate() "
                            + "method multiple times.");
            return false;
        }
        // rotate car2 3 times
        for (int i = 0; i < 3; i++) {
            car2.rotate();
        }
        // Ensure the getRotationsCount returns the expected output
        if (car2.getRotationsCount() != 3) {
            System.out.println(
                    "Toy.getRotationsCount() did not return the expected output after calling the rotate() "
                            + "method multiple times.");
            return false;
        }
        return true; // Test passes with no errors
    }

    /**
     * This tester checks the correctness of Toy.isOver(int, int) method
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testToyIsOverPoint() {
        // This tester should check for the correctness of Toy.isOver(int x, int y) method
        // This tester should construct at least one Toy object at a given (x,y) position
        // At least 4 scenarios should be considered.
        Toy toy = new Toy("car", 100, 100);
        // (1) Calling the isOver(int, int) method on that Toy object passing it a point defined by x
        // and y coordinates defined inside the area of the image of the toy should return true
        if (!toy.isOver(110, 105)) {
            return false;
        }
        // (2) Calling the isOver(int, int) method with a point (x,y) defined outside of the area of the
        // image of the toy should return false.
        if (toy.isOver(200, 200)) {
            return false;
        }
        // Call the rotate() method one time or an odd number of times on the toy. This should
        // rotate the image of the Toy object PI/2 clockwise so that the width and height of the toy are
        // expected to be switched.
        toy.rotate();
        // (3) Call the isOver(int, int) method with a point (x,y) inside the area of the Toy,
        // considering this change on the width and height dimensions, should return true.
        if (!toy.isOver(105, 110)) {
            return false;
        }
        // (4) Call the isOver(int, int) method with a point (x,y) outside the area of the Toy,
        // considering this change on the width and height dimensions, should return false.
        if (toy.isOver(200, 100)) {
            return false;
        }
        return true;
    }

    /**
     * This tester checks the correctness of Toy.isOver(Furniture) method
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean testToyIsOverFurniture() {
        // This tester should check for the correctness of Toy.isOver(Furniture other) method
        // Create a Furniture object at a given (x, y) position.
        Furniture bed = new Furniture("nightstand", Utility.width() / 2, Utility.height() / 2);
        // You can then create at least three Toy objects:
        // (1) one intersecting with the Furniture object,
        Toy car1 = new Toy("car", Utility.width() / 2 + 1, Utility.height() / 2 + 1);
        if (!car1.isOver(bed)) {
            return false;
        }
        // (2) one enclosed by it,
        Toy car2 = new Toy("car", Utility.width() / 2, Utility.height() / 2);
        if (!car2.isOver(bed)) {
            return false;
        }
        // (3) one not overlapping with the Furniture.
        Toy teddyBear = new Toy("car", Utility.width(), Utility.height());
        if (teddyBear.isOver(bed)) {
            return false;
        }
        // Calling the isOver(Furniture) on each of the Toy objects should return the expected output.

        return true; // default return statement
    }

    /**
     * Runs all the tester methods defined in this class
     *
     * @return true when this test verifies a correct functionality (ALL test scenarios PASS), and
     * false otherwise
     */
    public static boolean runAllTests() {
        System.out.println("Class Furniture Testers:");
        boolean test1Result = testFurnitureConstructor1Getters();
        System.out.println("testFurnitureConstructor1Getters: " + (test1Result ? "PASS" : "FAIL"));

        boolean test2Result = testFurnitureConstructor2Getters();
        System.out.println("testFurnitureConstructor2Getters: " + (test2Result ? "PASS" : "FAIL"));

        System.out.println();
        System.out.println("Class Toy Testers:");
        boolean test3Result = testToyConstructorsGettersSetters();
        System.out.println("testToyConstructorsGettersSetters: " + (test3Result ? "PASS" : "FAIL"));

        boolean test4Result = testToyStartStopDragging();
        System.out.println("testToyStartStopDragging: " + (test4Result ? "PASS" : "FAIL"));

        boolean testToyMove = testToyMove();
        System.out.println("testToyMove: " + (testToyMove ? "PASS" : "FAIL"));

        boolean testToyRotate = testToyRotate();
        System.out.println("testToyRotate: " + (testToyRotate ? "PASS" : "FAIL"));

        boolean testToyIsOverPoint = testToyIsOverPoint();
        System.out.println("testToyIsOverPoint: " + (testToyIsOverPoint ? "PASS" : "FAIL"));

        boolean testToyIsOverFurniture = testToyIsOverFurniture();
        System.out.println("testToyIsOverFurniture: " + (testToyIsOverFurniture ? "PASS" : "FAIL"));

        return test1Result && test2Result && test3Result && test4Result && testToyMove && testToyRotate
                && testToyIsOverPoint && testToyIsOverFurniture;
    }

    /**
     * Driver method to run all the tests defined in this class
     *
     * @param args list of command-line input arguments if any.
     */
    public static void main(String[] args) {
        // DO NOT MAKE ANY CHANGES TO THE IMPLEMENTATION OF THIS METHOD
        Utility.runTester();
    }

}
