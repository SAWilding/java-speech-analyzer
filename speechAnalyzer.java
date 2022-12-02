import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class speechAnalyzer {
// Program that counts how many times a word is used in a speech and is displayed in the results.txt file
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // An array of three speeches to analyze
        String[] arrayOfSpeeches = new String[]{"./jesus-christ-is-the-strength-of-youth.txt", 
        "what-is-true.txt", "in-partnership-with-the-lord.txt"};

        // Pass the array into the analyzer
        Analyzer counter = new Analyzer(arrayOfSpeeches);

    }

}
 
public class Analyzer {
    // Member hashmap for words and their counts
    private static HashMap<String, Integer> word_dict = new HashMap<>();

    // Constructor 
    public Analyzer(String[] fileNameArray) throws FileNotFoundException, IOException{
        // Create scanner to recieve user input
        Scanner myScanner = new Scanner(System.in);
        // For each file in fileNameArray
        for (String file : fileNameArray) {
            this.countWords(file);
            HashMap<String, Integer> sortedMap = this.sortHashMap();
            this.writeResultsToFile(sortedMap);
            System.out.println("Enter to continue");
            String input = myScanner.nextLine(); // Pause the program until user hits enter
        }
    }

    public void countWord(String word) {
        // Adds a word to the hashmap and increments its count
        word = word.toLowerCase();
        word = word.replaceAll("[^a-zA-Z]", "");
        if (word_dict.containsKey(word)) {

            word_dict.put(word, word_dict.get(word) + 1);
            
        } else {
            
            word_dict.put(word, 1);

        }
    }

    public void countWords(String fileName) throws FileNotFoundException {
        // Reads each line in a text file and counts the words
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        //read line by line
        while(scanner.hasNextLine()){
            //process each line
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                this.countWord(words[i]);
            }
        }
        scanner.close();
 
    }

    public void writeResultsToFile(HashMap<String, Integer> hmap) throws IOException{
        // Write the hashmap to the results.txt file
        try {
            FileWriter myWriter = new FileWriter("./results.txt");
            Iterator hmapIterator = hmap.entrySet().iterator();

            while (hmapIterator.hasNext()) {
                Map.Entry mapItem = (Map.Entry)hmapIterator.next();
                myWriter.write(mapItem.getKey() + ": " + mapItem.getValue() + "\n");

            }
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> sortHashMap() {
        // Sorts the hashmap and returns a hashmap with the most used words first and least used words last
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(word_dict.entrySet());
 
        Collections.sort(list, (i1, i2) -> i2.getValue().compareTo(i1.getValue()));
 
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> item : list) {
            temp.put(item.getKey(), item.getValue());
        }
        return temp;
    }
}