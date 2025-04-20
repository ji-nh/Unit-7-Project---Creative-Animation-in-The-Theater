import org.code.theater.Scene;
import java.util.Random;
import org.code.theater.*;
import org.code.media.*;

public class Fish {
    private String name;
    private int x;  // Horizontal position
    private int y;  // Vertical position
    private int happiness;  // Fish's happiness level
    private Random random;
    private String imageFile;  // Image for fish (to be displayed in the scene)

    /*
     * Constructor for the Fish class
     * Initializes the fish's name, position, happiness level, and image
     */
    public Fish(String name, int x, int y, String imageFile) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.happiness = 50;  // Default happiness level
        this.random = new Random();
        this.imageFile = imageFile;
    }

    /*
     * Method to make the fish swim (move randomly within the tank)
     * The fish can move left, stay in place, or move right
     */
    public void swim(int tankWidth) {
        /*
         * Randomly determine the direction the fish will move:
         * -1 for left, 0 for stay, +1 for right
         */
        int direction = random.nextInt(3) - 1;  // Random -1, 0, or 1 (left, stay, right)

        /*
         * Update the fish's position
         * Ensure the fish stays within the tank's boundaries
         */
        x += direction;

        // Simulate sound effect when fish reaches the edge
        if (x <= 0) {
            x = 0;  // Keep it at the left edge
        } else if (x >= tankWidth - 1) {
            x = tankWidth - 1;  // Keep it at the right edge
        }
    }

    /*
     * Check the fish's happiness level and print a message
     * Fish can be sad (below 30) or very happy (above 70)
     */
    public void checkHappiness() {
        if (happiness < 30) {
            System.out.println(name + " is sad! (Happiness: " + happiness + ")");
        } else if (happiness > 70) {
            System.out.println(name + " is very happy! (Happiness: " + happiness + ")");
        }
    }

    /*
     * Method to simulate the fish eating the food if it is within reach
     * Eating food increases the fish's happiness
     */
    public void eat(int foodX, int foodY) {
        // Check if the food is close enough (within 1 unit)
        if (Math.abs(foodX - x) <= 1 && Math.abs(foodY - y) <= 1) {
            happiness += 10;  // Eating makes the fish happier
            System.out.println(name + " eats the food! (Happiness: " + happiness + ")");
        }
    }

    /*
     * Display the fish in the scene at its current position
     * The position is multiplied by 20 for scaling in the scene
     */
    public void display(Scene scene) {
        scene.drawImage(imageFile, x * 20, y * 20, 20, 20);  // Fish position and size in the scene
    }

    /*
     * Getter for the fish's horizontal position
     * Returns the x-coordinate of the fish
     */
    public int getX() {
        return x;
    }

    /*
     * Getter for the fish's vertical position
     * Returns the y-coordinate of the fish
     */
    public int getY() {
        return y;
    }

    /*
     * Getter for the fish's name
     * Returns the name of the fish
     */
    public String getName() {
        return name;
    }

    /*
     * Getter for the fish's happiness level
     * Returns the current happiness value of the fish
     */
    public int getHappiness() {
        return happiness;
    }
}
