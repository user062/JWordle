//package src.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage; 
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;
import java.lang.Thread;
import javafx.concurrent.Task;
import java.util.Optional;
import javafx.animation.AnimationTimer;


public class Main extends Application { 
    private static Matrix matrix = new Matrix("hello", 5);
    private  static boolean gameOver = false;

    @Override 
    public void start(Stage stage) {      
        
        Alert winPopup = new Alert(AlertType.INFORMATION);
        //winPopup.initModality(javafx.stage.Modality.NONE);
        winPopup.setTitle("game finished!");
        winPopup.setContentText("Congragulations! You guessed the correct word, the word is Hello !");
        Alert losePopup = new Alert(AlertType.INFORMATION);
        losePopup.setTitle("game finished!");
        losePopup.setContentText("good luck next time! The correct is Hello !");

        AnimationTimer timer = new AnimationTimer();

        Scene scene = new Scene(matrix);  

        scene.setOnKeyReleased((KeyEvent event) -> {
                    if (event.getCode().isLetterKey())
                        matrix.writeLetter(event.getCode().getName());

                    else if(event.getCode() == KeyCode.ENTER) {
                        matrix.checkWord();
                        if (matrix.gameOver() == 1 && gameOver == false) {
                            winPopup.showAndWait();
                            setgameOver();
                        }

                        else if (matrix.gameOver() == 0 && gameOver == false) {
                            losePopup.showAndWait();
                            setgameOver();
                        }
                    }

                    else if(event.getCode() == KeyCode.BACK_SPACE)
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
