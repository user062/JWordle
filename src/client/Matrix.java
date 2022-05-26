import javafx.scene.layout.VBox; 
import java.util.ArrayList;

public class Matrix extends VBox { 
    private String correctColor, notQuietColor, wrongColor;
    private String solution;
    private ArrayList<Word> words = new ArrayList<Word>();
    private int currentLetter, currentWord;

    public Matrix(String solution, int tries) {
        this.solution = solution;

        for (int i = 0; i < tries; i++) {
            this.words.add(new Word(5));
        }

        this.getChildren().addAll(words);
    }

    public void checkWord() {
        Letter current; 
        // todo: credit calculation
        // todo: what happens if user guessed the correct word
        // todo: should we lookup word in an actual dictionary or not
        for (int i = 0; i < solution.length(); i++) {
            current = this.words.get(this.currentWord).getLetter(i);

            if (current.getText().equals(solution.charAt(i)))
                current.changeColor(correctColor);

            else if (solution.contains(current.getText()))
                current.changeColor(notQuietColor);

            else
                current.changeColor(wrongColor);
        }

        this.currentWord++;
    }

    public void writeLetter(String c) {
        this.words.get(this.currentWord).getLetter(++this.currentLetter).setText(c);
    }

    public void removeCurrentLetter() {
        this.words.get(this.currentWord).getLetter(this.currentLetter--).setText("");
    }
} 
