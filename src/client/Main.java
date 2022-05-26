import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 

public class Main extends Application { 
    @Override 
    public void start(Stage stage) {      
        // todo: event listener for keypresses 
        Matrix matrix = new Matrix("hello", 5);
        
        Scene scene = new Scene(matrix);  
        
        stage.setTitle("JWordle"); 
        
        stage.setScene(scene); 
        
        stage.show(); 
   } 

    public static void main(String args[]){ 
        launch(args); 
   } 
    
}
