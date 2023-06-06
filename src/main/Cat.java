package main;

import java.io.Serializable;

/**
 * Class to represent a cat type pet.
 */
public class Cat extends Pet implements Serializable {
    public Cat(String name) {
        super(name);
    }

    public void feed() {
        // postcondition: The cat's mood is improved.
        System.out.println(name + " is eating cat food.");
        mood += 5;
    }

    /**
     * Activity specific to the cat pet type.
     * Improves mood and prints message to screen.
     */
    public void cleanLitterBox() {
        // postcondition: the cat's mood is improved.
        System.out.println("You cleaned " + name + "'s litter box. No gratitude was shown.");
        mood += 5;
    }
}