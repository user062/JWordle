package src.client;

import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class Matrix extends VBox { 
    private String correctColor = "#6aaa64", notQuietColor = "#c9b458",
        wrongColor = "#787c7e", checkedLetterColor = "#ffffff", solution;
    private ArrayList<Word> words = new ArrayList<Word>();
    private int tries, currentLetter = -1, currentWord = 0;
    private boolean solved = false;

    public Matrix(String solution, int tries) {
        this.solution = solution.toUpperCase();
        this.tries = tries;

        for (int i = 0; i < tries; i++) {
            this.words.add(new Word(5));
        }

        this.getChildren().addAll(words);
    }

    public void checkWord() {

        if (this.currentLetter < this.solution.length() - 1)
            return;

        Letter current; 
        int correctLetters = 0;
        // todo: credit calculation
        // todo: should we lookup word in an actual dictionary or not
        for (int i = 0; i < solution.length(); i++) {
            current = this.words.get(this.currentWord).getLetter(i);
            current.changeTextColor(checkedLetterColor);

            if (current.getText().equals(solution.substring(i, i+1))) {
                current.changeColor(correctColor);
                correctLetters++;
            }

            else if (solution.contains(current.getText()))
                current.changeColor(notQuietColor);

            else
                current.changeColor(wrongColor);
        }

        this.currentWord++;
        this.tries--;

        if (correctLetters == solution.length())
            this.solved = true;

        this.currentLetter = -1;
    }

    public void writeLetter(String c) {
        if(this.currentLetter >= this.solution.length() - 1)
            return;
        this.words.get(this.currentWord).getLetter(++this.currentLetter).setText(c);
    }

    public void removeCurrentLetter() {
        if (this.currentLetter < 0)
            return;
        this.words.get(this.currentWord).getLetter(this.currentLetter--).setText("");
    }

    public int gameOver() {
        if (this.solved)
            return 1;
        if (this.tries != 0)
            return -1;
        else
            return 0;
    }

    public void clearMatrix() {
        for (Word w : words)
            w.clearWord();
    }
} 
