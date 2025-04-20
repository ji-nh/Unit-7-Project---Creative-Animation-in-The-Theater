import org.code.theater.Scene;
import java.util.ArrayList;

public class FishTank {
    private int width;
    private int height;
    private ArrayList<Fish> fishTank;
    private Scene scene;  

    /*
     * Constructor for FishTank
     * Initializes the tank dimensions, fish list, and the scene 
     */
    public FishTank(int width, int height, Scene scene) {
        this.width = width;
        this.height = height;
        this.fishTank = new ArrayList<>();
        this.scene = scene;
    }

    /*
     * Add a fish to the tank
     * This method adds a new Fish object to the list of fish in the tank
     */
    public void addFish(Fish fish) {
        fishTank.add(fish);
    }

    /*
     * Draw the tank with all fish in their current positions
     * Clears the scene and then draws each fish based on its position
     */
    public void drawTank() {
        /*
         * Clear the scene and set a blue background to simulate the fish tank
         */
        scene.clear("blue");

        /*
         * Loop through all fish in the tank and display them at their current positions
         */
        for (Fish fish : fishTank) {
            fish.display(scene);  // Display each fish
        }
    }

    /*
     * Simulate food appearing randomly in the tank
     * If food appears, the fish will try to eat it if they are close enough
     */
    public void foodAppearsAndFishEat() {
        if (Math.random() < 0.1) {  // 10% chance that food will appear
            /*
             * Randomly generate the food's position in the tank
             */
            int foodPositionX = (int) (Math.random() * width);
            int foodPositionY = (int) (Math.random() * height);
            System.out.println("Food appears at (" + foodPositionX + ", " + foodPositionY + ")!");

            /*
             * Let each fish eat the food if it is near enough to the food's position
             */
            for (Fish fish : fishTank) {
                fish.eat(foodPositionX, foodPositionY);  // Fish attempts to eat the food
            }
        }
    }

    /*
     * Get the list of all fish in the tank
     * Returns the current list of fish
     */
    public ArrayList<Fish> getFishTank() {
        return fishTank;
    }
}
