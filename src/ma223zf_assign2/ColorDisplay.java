package ma223zf_assign2;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class ColorDisplay {

	//Setup UI elements here//
	private AnchorPane root = new AnchorPane();
	private Pane pane = new Pane();
	private Label colorDisplayLabel = new Label();
	private Button btn = new Button("Display Color");
	private TextField red = new TextField();
	private TextField green = new TextField();
	private TextField blue = new TextField();
	private Label redLabel = new Label("Red");
	private Label greenLabel = new Label("Green");
	private Label blueLabel = new Label("Blue");
	private Label label = new Label("Color Display");

	
	
	public ColorDisplay() {
		settings();
		pane.getChildren().add(colorDisplayLabel); //set the label on pane//
		root.getChildren().add(pane); //set pane on anchorpane//
		root.getChildren().add(btn);  //set btn on anchorpane 
		root.getChildren().add(red); //set textfield on anchorpane
		root.getChildren().add(green); //set textfield on anchorpane//
		root.getChildren().add(blue);  //set textfield on anchorpane//
		root.getChildren().add(redLabel); //set label on anchorpane//
		root.getChildren().add(greenLabel); //set label on anchorpane//
		root.getChildren().add(blueLabel); //set label on anchorpane//
		root.getChildren().add(label);     // set label on anchorpane//
		btn.setOnAction(e -> setColor()); //what will be done when button is pressed//
	}
	
	//set the location and aspects of each elements//
	private void settings()  {
		root.setPrefHeight(400);
		root.setPrefWidth(600);
		
		pane.prefHeight(200);
		pane.prefWidth(600);
		
		colorDisplayLabel.setLayoutX(600);
		colorDisplayLabel.setLayoutY(200);

		label.setLayoutX(230);
		label.setLayoutY(100);
		label.setFont(Font.font(20));
		label.setTextFill(Paint.valueOf("White"));
		
		
		btn.setLayoutX(250);
		btn.setLayoutY(351);
		
		red.setPrefSize(80, 27);
		green.setPrefSize(80, 27);
		blue.setPrefSize(80, 27);
		
		red.setLayoutX(23);
		red.setLayoutY(259);
		
		green.setLayoutX(231);
		green.setLayoutY(259);
	
		blue.setLayoutX(459);
		blue.setLayoutY(259);
		
		
		redLabel.setLayoutX(23.0);
		greenLabel.setLayoutX(231.0);
		blueLabel.setLayoutX(459.0);
		
		redLabel.setLayoutY(242.0);
		greenLabel.setLayoutY(242.0);
		blueLabel.setLayoutY(242.0);
	}
	
	//return the anchorpane with all its elements hold on it//
	public AnchorPane getRoot()  { 
		return root;
	}
	//set background for the pane and fill it with color from a user input//
	private void setColor() {
		try {
			pane.setBackground(new Background(new BackgroundFill(Color.rgb(Integer.parseInt(red.getText()),
					Integer.parseInt(green.getText()), Integer.parseInt(blue.getText())), null, null)));
			label.setText("Color Display");
		} catch (Exception e) { //catch exception and handle it// 
			label.setText("Incorrect Value");
			return;
		}
	}
	
}
