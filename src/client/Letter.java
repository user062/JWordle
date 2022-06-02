package src.client;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.scene.text.FontWeight; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.geometry.Insets; 

class Letter extends StackPane{
    private Rectangle rectangle = new Rectangle();
    private Text text = new Text();

    public Letter() {
        //Setting the properties of the rectangle 
        rectangle.setWidth(50.0f); 
        rectangle.setHeight(50.0f); 
        rectangle.setArcWidth(20.0); 
        rectangle.setArcHeight(20.0);  
        rectangle.setFill(Color.web("#d3d6da"));
        

        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        this.setMargin(rectangle, new Insets(5, 2, 5, 2));
        this.getChildren().addAll(rectangle, text);
    }

    public void changeColor(String color) {
        rectangle.setFill(Color.web(color));
    }

    public String getText() {
        return this.text.getText();
    }

    public void setText(String s) {
        this.text.setText(s);
    }

    public void changeTextColor(String color) {
        this.text.setFill(Color.web(color));
    }

    public void clearLetter() {
        this.text.setText("");
        this.rectangle.setFill(Color.web("#d3d6da"));
    }

}
