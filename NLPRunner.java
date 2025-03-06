import java.util.Scanner;

/**
 * The NLPRunner class serves as the entry point for the Thesaurus program.
 * It allows users to input words and receive synonyms through the Thesaurus class.
 */
public class NLPRunner {
    public static void main(String[] args) {
        
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        String user = "";
        
        // Loop to repeatedly ask the user for words until they type "end"
        while (!(user.equals("end"))) {
            System.out.println("What word would you like to see synonyms for: ");
            user = input.nextLine();
            
            // Create a Thesaurus object using the user's input and predefined files
            Thesaurus ian = new Thesaurus(user, "stems.txt", "synonyms.txt");
            
            // Run the Thesaurus to find and display synonyms
            ian.run();
        }
        
        // Close the scanner to prevent resource leaks
        input.close();
    }
}
