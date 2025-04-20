import org.code.theater.Scene;

public class FishTankAnimation {
    public static void main(String[] args) {
        /*
         * Create a new scene for animation
         * The scene is where the fish tank will be displayed
         */
        Scene scene = new Scene();

        /*
         * Set the dimensions of the fish tank
         * tankWidth is the width and tankHeight is the height
         */
        int tankWidth = 20;  // Width of the tank
        int tankHeight = 10; // Height of the tank

        /*
         * Create a new FishTank object with the specified dimensions and scene
         * This object will handle the fish and their movements
         */
        FishTank fishTank = new FishTank(tankWidth, tankHeight, scene);

        /*
         * Create and add multiple fish to the tank
         * Each fish has a name, starting position, and an image file for display
         */
        fishTank.addFish(new Fish("Trout", 5, 5, "trout1.jpg"));
        fishTank.addFish(new Fish("Clownfish", 10, 6, "clownfish1.jpg"));
        fishTank.addFish(new Fish("Goldfish", 15, 7, "goldfish1.jpg"));

        /*
         * Main animation loop for the fish tank
         * This loop will run for 100 frames, updating the tank and fish positions
         */
        for (int frame = 0; frame < 100; frame++) {
            /*
             * Move all fish within the tank and check their happiness
             * Each fish is moved within the tank boundaries
             */
            for (Fish fish : fishTank.getFishTank()) {
                fish.swim(tankWidth);  // Move the fish within the tank
                fish.checkHappiness(); // Check if the fish is happy
            }

            /*
             * Simulate food appearing randomly in the tank
             * If food appears, fish will eat it
             */
            fishTank.foodAppearsAndFishEat();

            /*
             * Clear the scene to prepare for the next frame
             * Set the background color to blue (simulating a fish tank)
             */
            scene.clear("blue");

            /*
             * Draw all fish in the tank at their updated positions
             * This displays the fish on the screen
             */
            fishTank.drawTank();
        }

        /*
         * Print a message when the animation is complete
         * Indicates that the fish tank animation has finished running
         */
        System.out.println("Fish tank animation complete!");
    }
}
