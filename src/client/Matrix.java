import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.StackPane; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.scene.text.FontWeight; 
import javafx.scene.paint.Color; 
import javafx.scene.control.TextField; 
import javafx.scene.control.TextFormatter; 
import javafx.scene.control.TextFormatter.*; 
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle; 
import java.util.function.*;
import java.util.function.*;

public class Matrix extends Application { 
   @Override 
   public void start(Stage stage) {      

       Rectangle rectangle = new Rectangle();
           
       //Setting the properties of the rectangle 
       rectangle.setWidth(50.0f); 
       rectangle.setHeight(50.0f); 
       rectangle.setArcWidth(20.0); 
       rectangle.setArcHeight(20.0);  
       rectangle.setFill(Color.web("#538d4e"));

       Text text = new Text("S");

       text.setFont(Font.font("Verdana", FontWeight.LIGHT, 50));
       text.setFill(Color.web("#acd6e5"));
       StackPane stack = new StackPane();
       stack.getChildren().addAll(rectangle, text);

       //Row for word
       HBox hbox = new HBox();
       hbox.setPadding(new Insets(5, 5, 5, 5));
       hbox.setSpacing(5);
       hbox.getChildren().addAll(stack);
      
       // Holds rows
       VBox vbox = new VBox();
       vbox.setPadding(new Insets(5, 5, 5, 5));
       vbox.setSpacing(5);
       vbox.getChildren().addAll(hbox);

       //Creating a scene object 
       Scene scene = new Scene(vbox);  
      
       //Setting title to the Stage 
       stage.setTitle("Grid Pane Example"); 
         
       //Adding scene to the stage 
       stage.setScene(scene); 
         
       //Displaying the contents of the stage 
       stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
} 
