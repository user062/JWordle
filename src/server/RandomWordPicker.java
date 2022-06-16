package server;

import java.util.*;
import java.io.*;

public class RandomWordPicker {
    private Random rng = new Random();
    private String wordsFileName = "words";
    private File wordsFile = new File(wordsFileName);
    private ArrayList<String> words = new ArrayList<String>();

    public RandomWordPicker(){
        Scanner scanner = null;
        try {scanner = new Scanner(wordsFile);}

        catch (FileNotFoundException e) {
            
        }
        while (scanner.hasNextLine())
            words.add(scanner.nextLine());

    }

    public String pickWord() {
        return this.words.get(rng.nextInt(words.size()));
    }

    public void addWord(String word) {
        this.words.add(word);
    } 

    /*
    public void writeToFile() {
        BufferedWriter writer = new BufferedWriter(new FileWriter(wordsFileName));
        writer.write(String.join(new StringBuilder(1).append('\n'), Arrays.asList(this.words)));
        writer.close();
        
    }
    */
}
