/**
 *A program to parse and display available food items from a txt file
 */

import java.util.Scanner;

public class Main {

    /**
     * The main method prompts the user to enter a file name and reads the food data.
     * if the file does not exist, it repeatedly asks for a valid file name.
     */
    public static void main(String[] args) {

        FoodReader foodReader = new FoodReader();
        Scanner inputScanner = new Scanner(System.in);

        //keep asking for a valid file until it is successfully loaded.
        while(true){
            // Read user input for file name
            System.out.print("Enter the file name: ");
            String fileName = inputScanner.nextLine();

            if(foodReader.readFile(fileName)){
                break;
            }
        }
        inputScanner.close(); //close scanner
        foodReader.displayAvailableFoods(); //display available food items.
    }
}