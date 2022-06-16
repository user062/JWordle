package client;

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
import java.net.*;
import java.io.*;

public class Main extends Application { 
    private static Matrix matrix;
    private static boolean gameOver = false;
    private static Socket socket    = null;
    private static DataInputStream in = null;

    @Override 
    public void start(Stage stage) {      
        try
        {
            socket = new Socket("localhost", 2001);
            System.out.println("Connected");
 
            in     = new DataInputStream(socket.getInputStream());
            matrix = new Matrix(in.readUTF(), 5);
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        Alert winPopup = new Alert(AlertType.INFORMATION);
        winPopup.setTitle("game finished!");
        winPopup.setContentText("Congragulations! You guessed the correct word");
        Alert losePopup = new Alert(AlertType.INFORMATION);
        losePopup.setTitle("game finished!");
        losePopup.setContentText("good luck next time! The correct word is " + matrix.getSolution());

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
