import java.io.*;
import java.util.*;

/**
 * The FoodReader class is responsible for reading food item information from a file
 * and storing it in separate lists for category, name, description, and availability.
 * It also provides a method to display available food items.
 */

public class FoodReader {

    /** list and store food categories */
    private List<String> categories = new ArrayList<>();
    /** list and store food names */
    private List<String> names = new ArrayList<>();
    /** list and store food descriptions */
    private List<String> descriptions = new ArrayList<>();
    /** list and store food availability */
    private List<String> availability = new ArrayList<>();

    /**
     * Reads the food data from a specified file and stores it in four separate lists.
     * @param fileName The name of the file to read.
     * @return true if the file was read successfully, otherwise, returns false.
     */
    public boolean readFile(String fileName)  {
        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){ //try-catch exceptions
            String line;
            while((line = reader.readLine()) != null ){ //while line is not empty, keep reading file.
                String[] parts = line.split("\t"); //split using tab character

                if (parts.length == 4) { //ensure correct format
                    categories.add(parts[0]);
                    names.add(parts[1]);
                    descriptions.add(parts[2]);
                    availability.add(parts[3]);
                }else{
                    System.out.println("Skipping line due to being malformed.");
                }
            }
            return true;
        }catch(FileNotFoundException e){
            System.out.println("File not found. Please try another file name.");
        }catch(IOException e){
            System.out.println("I/O exception. Error reading the file. Please try again.");
        }
        return false;
    }

    /**
     * Display the available food items in the format: name (category) -- description.
     * Only food items marked as available will be displayed.
     */
    public void displayAvailableFoods()  {
        System.out.println("the Available food items are the following:");
        for (int i = 0; i < names.size(); i++) {
            if (availability.get(i).equalsIgnoreCase("Available")) {
                System.out.println(names.get(i) + " (" + categories.get(i) + ") -- " + descriptions.get(i));
            }
        }
    }
}