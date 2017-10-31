package ma223zf_assign2;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RandomPanel extends BorderPane {
	
	Random rand = new Random(100); //create a random object//
	Button bt = new Button("New Random"); //create button//
	Text text = new Text(); //create text object//
	StackPane top = new StackPane();
	StackPane bottom = new StackPane();
	public RandomPanel() {
		top.getChildren().add(text); //add text to top stackpane//
		bottom.getChildren().add(bt); //add button to bottom stackpane//
		top.setPrefHeight(100); 
		top.setPrefWidth(100);
		bottom.setPrefHeight(100);
		bottom.setPrefWidth(100);
		BorderPane.setAlignment(text, Pos.TOP_CENTER); //text alignment//
		BorderPane.setAlignment(bt, Pos.BOTTOM_CENTER); //button alignment//
		bt.setOnAction(e -> displayNumber()); // when a user press the button//
		this.setTop(top);
		this.setBottom(bottom);
	}
	
	private void displayNumber() {
		int num = rand.nextInt(100) + 1; //random integer number between 1 to 100//
		text.setFont(Font.font(num)); //the size of text determine by the random number//
		text.setText("" + num); //the random number will be the content of the text//
	}
}
