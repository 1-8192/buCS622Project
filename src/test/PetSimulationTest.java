package test;

import main.PetSimulation;
import main.SimpetInputException;
import main.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the PetSimulation class.
 */
public class PetSimulationTest {
    public static final PetSimulation petSim = new PetSimulation();

    /**
     * Testing the method to initialize pet info from an input file.
     */
//    @Test
//    public void testInitializePetFromFile() {
//        // Initializing useful variables
//        String goodFileName = "petInput.csv";
//        String badFileName = "text.gfd";
//        User testUser = new User("Tom");
//        petSim.setCurrentUser(testUser);
//
//        // Testing the input exception.
//        assertDoesNotThrow(()-> petSim.initializePetsFromFile(goodFileName));
//        assertThrows(SimpetInputException.class, ()-> petSim.initializePetsFromFile(badFileName));
//    }
}
