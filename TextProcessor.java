import java.util.ArrayList;

/**
 * Analyzes and processes text
 */
public class TextProcessor {

  private String filename;              // The file containing the text
  private ArrayList<String> textList;   // The ArrayList of text, each line in txt file is an element

  /**
   * Constructor to create a TextProcessor with the specified filename
   */
  public TextProcessor(String filename) {
    this.filename = filename;
    textList = FileReader.toStringList(filename);
  }

  /**
   * Accessor Method for fileName
   * @return fileName the name of the txt file
   */
  public String getFileName() {
    return filename;
  }

  /**
   * Accessor Method for textList
   * @return textList the ArrayList of lines read from the txt file
   */
  public ArrayList<String> getTextList() {
    return textList;
  }

  /**
   * Changes the file to analyze and process and updates the textList
   * @param filename new filename to set
   */
  public void changeFile(String filename) {
    this.filename = filename;
    textList = FileReader.toStringList(filename);
  }

  /**
   * Returns an ArrayList containing the individual words from textList
   * @return list of individual words
   */
  public ArrayList<String> textToWords() {
    ArrayList<String> wordList = new ArrayList<String>();

    for (int index = 0; index < textList.size(); index++) {
      String currentLine = textList.get(index);
      int location = currentLine.indexOf(" ");

      while (location != -1) {
        String currentWord = currentLine.substring(0, location);
        wordList.add(currentWord);
        currentLine = currentLine.substring(location + 1);
        location = currentLine.indexOf(" ");
      }

      wordList.add(currentLine);
    }
    
    return wordList;
  }

  /**
   * toString Method Override
   * @return string representation of the textList
   */
  public String toString() {
    String text = "";

    for (String value : textList) {
      text += value + "\n";
    }

    return text;
  }
  
}