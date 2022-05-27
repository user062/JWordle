import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class Main extends Application { 
    @Override 
    public void start(Stage stage) {      
        Matrix matrix = new Matrix("hello", 5);
        
        Scene scene = new Scene(matrix);  

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().isLetterKey())
                        matrix.writeLetter(event.getCode().getName());

                    else if(event.getCode() == KeyCode.ENTER)
                        matrix.checkWord();

                    else if(event.getCode() == KeyCode.BACK_SPACE)
                        matrix.removeCurrentLetter();
                }
            }
            );
        
        stage.setTitle("JWordle"); 
        
        stage.setScene(scene); 
        
        stage.show(); 
   } 

    public static void main(String args[]){ 
        launch(args); 
   } 
    
}
