import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main Simulation class for the SIMPET Pet simulator program.
 */
public class PetSimulation {
    private static User currentUser;
    private static final Scanner inputScanner = new Scanner(System.in);

    /**
     * Function to ask the user for a name to initialize the user.
     */
    private static void initializeUser() {
        String userName = "";

        while (userName == "") {
            System.out.println("Please enter your name: ");
            userName = inputScanner.nextLine();
            currentUser = new User(userName);
        }

        System.out.println("Welcome " + currentUser.getUserName());
    }

    /**
     * Function to ask the user for pets they want to make.
     */
    private static void initializePets() {
        String petName = "";
        String petType = "";
        String continuePrompt = "y";

        while (!continuePrompt.equals("n")) {
            System.out.println("Would you like to adopt a pet? [y/n]");
            continuePrompt = inputScanner.nextLine();
            if (continuePrompt.equals("n")) {
                break;
            }
            System.out.println("Would you like to adopt a dog or a cat?");
            petType = inputScanner.nextLine();
            System.out.println("What would you like to name your pet?");
            petName = inputScanner.nextLine();
            if (petType.equals("dog")) {
                // Upcasting Example
                Pet newPet = new Dog(petName);
                currentUser.addPet(newPet);
            } else if (petType.equals("cat")) {
                // Upcasting Example
                Pet newPet = new Cat(petName);
                currentUser.addPet(newPet);
            } else {
                System.out.println("I'm sorry, you can only adopt a dog or a cat for now.");
            }
        }
    }

    private static void saveReportCard() {
        try {
            FileWriter fileWriter = new FileWriter("petReportCard.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(currentUser.getUserName() + " today you played with: ");
            for (Pet pet : currentUser.getPets()) {
                // Polymorphism example
                printWriter.println(pet.toString());
            }

            printWriter.close();
            System.out.println("Pet report card has been saved to petReportCard.txt");
        } catch(IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Function to interact with the user's pets.
     */
    private static void interactWithPets() {
        while(true) {
            System.out.print("Which pet would you like to interact with? (Enter pet number or Exit): ");
            String input = inputScanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else {
                try {
                    int petIndex = Integer.parseInt(input) - 1;
                    if (petIndex < 0 || petIndex >= currentUser.getPets().size()) {
                        System.out.println("Invalid input. Please enter a valid pet number or Exit.");
                        continue;
                    }

                    Pet pet = currentUser.getPets().get(petIndex);
                    System.out.print("How would you like to interact with " + pet.getName() + "? (Feed/Play/Train/Sleep): ");
                    String action = inputScanner.nextLine();

                    if (action.equalsIgnoreCase("feed")) {
                        // Polymorphism example
                        pet.feed();
                    } else if (action.equalsIgnoreCase("play")) {
                        // Polymorphism example
                        pet.play();
                    } else if (action.equalsIgnoreCase("train")) {
                        System.out.print("What trick would you like to train " + pet.getName() + " to do? ");
                        String trick = inputScanner.nextLine();
                        // Downcasting example
                        if (pet instanceof Dog) {
                            Dog dogPet = (Dog) pet;
                            dogPet.train(trick);
                        } else {
                            Cat catPet = (Cat) pet;
                            catPet.train(trick);
                        }
                    } else if (action.equalsIgnoreCase("sleep")) {
                        // Polymorphism example
                        pet.sleep();
                    } else {
                        System.out.println("Invalid input. Please enter Feed, Play, Train, Sleep, or Exit.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid pet number or Exit.");
                }
            }
        }
        System.out.println("Thanks for using SIMPET!");
        saveReportCard();
    }

    /**
     * Main function for the SIMPET Pet Simulator Program
     * @param args Standard Java Main class args
     */
    public static void main(String[] args) {
        System.out.println("Hello User, welcome to SIMPET. We will now create 2 pets for you, a dog and a cat.");
        initializeUser();
        initializePets();

        System.out.println("Your Pets are:");

        for (Pet pet : currentUser.getPets()) {
            System.out.println(pet);
        }

        System.out.println("Let's spend some time with your pets");
        interactWithPets();
    }
}
