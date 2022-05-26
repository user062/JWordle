import javafx.geometry.Insets; 
import javafx.scene.layout.HBox; 
import java.util.ArrayList;

class Word extends HBox {
    private ArrayList<Letter> word = new ArrayList<Letter>();

    public Word(Letter[] letters) {
       this.setPadding(new Insets(5, 5, 5, 5));

       for (Letter l: letters)
           this.getChildren().addAll(l);
    } 

    public Word(int wordLength) {
        
        this.setPadding(new Insets(0, 5, 0, 5));
        this.setSpacing(5);

        for (int i = 0; i < wordLength; i++)
            word.add(new Letter());
        
        this.getChildren().addAll(word);
    } 

    public Letter getLetter(int i) {
        return this.word.get(i);
    }

}
