package teaproject;

import teaproject.Teapot.TeapotStateMachine;

public class TeaProject {

    public static void main(String[] args) {
        System.out.println("=== Tea Maker State Machine Test ===\n");
        
        // Create the state machine
        TeapotStateMachine teapot = new TeapotStateMachine();
        
        try {
            // Test 1: Try to start when empty (should show warning)
            System.out.println("\n--- Test 1: Try to start when empty ---");
            teapot.onStartButtonPressed();
            Thread.sleep(1000);
            
            // Test 2: Fill the teapot
            System.out.println("\n--- Test 2: Fill teapot with 3 cups ---");
            teapot.onFilledButtonPressed(3);
            Thread.sleep(1000);
            
            // Test 3: Start making tea
            System.out.println("\n--- Test 3: Start making tea ---");
            teapot.onStartButtonPressed();
            
            // Wait for tea to finish brewing and check state periodically
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                teapot.update(); // Check if timer expired
                if (teapot.getCurrentStateType() == teaproject.StateMachine.States.DONE) {
                    break;
                }
            }
            
            // Test 4: Reset
            System.out.println("\n--- Test 4: Reset teapot ---");
            Thread.sleep(1000);
            teapot.onResetButtonPressed();
            
            // Test 5: Fill and boil water
            System.out.println("\n--- Test 5: Fill and boil water ---");
            Thread.sleep(1000);
            teapot.onFilledButtonPressed(5);
            Thread.sleep(1000);
            teapot.onBoilWaterButtonPressed();
            
            // Wait for boiling to complete
            for (int i = 0; i < 15; i++) {
                Thread.sleep(1000);
                teapot.update(); // Check if timer expired
                if (teapot.getCurrentStateType() == teaproject.StateMachine.States.DONE) {
                    break;
                }
            }
            
            System.out.println("\n--- Test 6: Reset again ---");
            Thread.sleep(1000);
            teapot.onResetButtonPressed();
            
            System.out.println("\n=== All tests completed! ===");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
