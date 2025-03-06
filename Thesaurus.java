import java.util.ArrayList;

/**
 * The Thesaurus class provides functionality to find synonyms for a given word.
 * It reads data from files containing word stems and their corresponding synonyms.
 */
public class Thesaurus {

    private String userInput;
    private ArrayList<String> stems;
    private ArrayList<String> synonyms;

    /**
     * Constructor for Thesaurus.
     * Initializes user input, and loads stems and synonyms from files.
     * 
     * @param userInput        The word input by the user.
     * @param stemsFilename    The filename containing word stems.
     * @param synonymsFilename The filename containing synonyms.
     */
    public Thesaurus(String userInput, String stemsFilename, String synonymsFilename) {
        this.userInput = userInput;
        stems = FileReader.toStringList(stemsFilename);
        synonyms = FileReader.toStringList(synonymsFilename);
    }

    /**
     * Runs the synonym-finding process by checking the input word
     * against known stems and searching for synonyms.
     */
    public void run() {
        String checked = checkInput();

        if (!(checked.equals("String Not Found"))) {
            // Find synonyms for the checked root word
            String[] found = findSynonyms(checked);

            if (!(found[0].equals("Empty"))) {
            int randomIndex = (int) (Math.random() * (found.length - 1)) + 1;
              System.out.println(found[randomIndex]);
            } else {
                System.out.println("Checked but not Found");
            }
        } else {
            System.out.println("Check Failed");
        }
    }

    /**
     * Checks if the user's input exists in the list of stems.
     * If found, returns the root word; otherwise, returns an error message.
     *
     * @return The root word if found, otherwise "String Not Found".
     */
    public String checkInput() {
        // Iterate through the list of stems
        for (int i = 0; i < stems.size(); i++) {
            String currentLine = stems.get(i);
            String[] options = currentLine.split(" -> ");
            String[] versions = options[0].split(" ");
            String root = options[1].substring(options[1].indexOf("-") + 1);
            
            // Check if the userInput matches any version of the word
            for (int j = 0; j < versions.length; j++) {
                if (versions[j].equals(userInput)) {
                    return root;
                }
            }
            // Check if userInput is already the root word
            if (root.equals(userInput)) {
                return root;
            }
        }
        return "String Not Found";
    }

    /**
     * Finds synonyms for the given root word.
     * If synonyms exist, returns them; otherwise, returns an empty array.
     *
     * @param userWord The root word to search synonyms for.
     * @return An array of synonyms or an empty array if none are found.
     */
    public String[] findSynonyms(String userWord) {
        // Default return if no synonyms are found
        String[] empty = new String[1];
        empty[0] = "Empty";
        
        // Iterate through the synonyms list
        for (int i = 0; i < synonyms.size(); i++) {
            String row = synonyms.get(i);
            String[] choices = row.split(", ");
            
            // Check if userWord matches any word in the synonym list
            for (int j = 0; j < choices.length; j++) {
                if (userWord.equals(choices[j])) {
                    return choices;
                }
            }
        }
        return empty;
    }
}
