package test;

import main.Cat;
import main.Dog;
import main.Pet;
import main.PetStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PetStatisticsTest {

    // Declaring variables we will set up in the setUp() method.
    private Dog dogOne;

    private Dog dogTwo;

    private Cat catOne;

    private Cat catTwo;

    private List<Pet> testPets;

    private PetStatistics<Pet> testPetStatistics;

    @BeforeEach
    public void setUp() {
        dogOne = new Dog("Buddy", "boxer");
        dogTwo = new Dog("Max", "corgi");
        catOne = new Cat("Whiskers");
        catTwo = new Cat("Smokey");
        catOne.setMood(500);
        dogTwo.setAge(12);
        catTwo.setAge(18);
        testPets = Arrays.asList(dogOne, dogTwo, catOne, catTwo);
        testPetStatistics = new PetStatistics<>(testPets);
    }

    /**
     * Tests the getAverageAge method.
     */
    @Test
    public void testGetAverageAge() {
        double averageAge = testPetStatistics.getAverageAge();
        assertEquals(7.5, averageAge);
    }

    /**
     * Tests the getMostCommonType method.
     */
    @Test
    public void testGetMostCommonType() {
        String mostCommonType = testPetStatistics.getMostCommonType();
        assertEquals("Cat", mostCommonType);
    }

    /**
     * Tests the getOldestPet method.
     */
    @Test
    public void testGetOldestPet() {
        Pet oldestPet = testPetStatistics.getOldestPet();
        assertEquals(catTwo, oldestPet);
    }

    /**
     * Tests the getHappiestPet method.
     */
    @Test
    public void testGetHappiestPet() {
        Pet happiestPet = testPetStatistics.getHappiestPet();
        assertEquals(catOne, happiestPet);
    }
}
