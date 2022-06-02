package src.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage; 
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.util.Duration;
import javafx.animation.PauseTransition;  

public class Main extends Application { 
    private static Matrix matrix = new Matrix("hello", 5);
    private  static boolean gameOver = false;

    @Override 
    public void start(Stage stage) {      
        
        Alert winPopup = new Alert(AlertType.INFORMATION);
        winPopup.setTitle("game finished!");
        winPopup.setContentText("Congragulations! You guessed the correct word, the word is Hello !");
        Alert losePopup = new Alert(AlertType.INFORMATION);
        losePopup.setTitle("game finished!");
        losePopup.setContentText("good luck next time! The correct is Hello !");

        PauseTransition pause = new PauseTransition(Duration.millis(700));  
        Scene scene = new Scene(matrix); 

        scene.setOnKeyReleased((KeyEvent event) -> {
                    if (event.getCode().isLetterKey() && gameOver == false)
                        matrix.writeLetter(event.getCode().getName());

                    else if(event.getCode() == KeyCode.ENTER && gameOver == false) {
                        matrix.checkWord();
                        if (matrix.gameOver() == 1 && gameOver == false) {
                            pause.setOnFinished(e -> {winPopup.show();});
                            pause.play(); 
                            setgameOver();
                        }

                        else if (matrix.gameOver() == 0 && gameOver == false) {
                            pause.setOnFinished(e -> {losePopup.show();});
                            pause.play(); 
                            setgameOver();
                        }
                    }

                    else if(event.getCode() == KeyCode.BACK_SPACE && gameOver == false)
                        matrix.removeCurrentLetter();
            });

        stage.setTitle("JWordle"); 
        
        stage.setScene(scene); 
        
        stage.show(); 
   } 

    public static void setgameOver() {
        gameOver = true;
    }

    public static void main(String[] args){
        launch(args); 
   } 
    
}
