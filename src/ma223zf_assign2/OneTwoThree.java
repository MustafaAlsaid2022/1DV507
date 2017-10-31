package ma223zf_assign2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OneTwoThree extends Application {

	BorderPane borderPane = new BorderPane(); //Container for the app//

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("OneTwoThree javafx");

		primaryStage.setScene(new Scene(borderPane, 300, 300));
		primaryStage.show();
	}

	//Setup UI elements here//
	Label topLbl = new Label("One");
	Label centerLbl = new Label("Two");
	Label bottomLbl = new Label("Three");

	//Using a VBox (Veritcal Box) to hold UI elements//
	VBox top = new VBox();
	VBox center = new VBox();
	VBox bottom = new VBox();

	@Override
	public void init() { //Use the init method to configure widgets//
		//Set fonts for all labels using CSS//
		topLbl.setFont(Font.font("Roman", FontWeight.BOLD, 15));
		centerLbl.setFont(Font.font("Roman", FontWeight.BOLD, 15));
		bottomLbl.setFont(Font.font("Roman", FontWeight.BOLD, 15));

		//Configure the VBoxes//
		top.getChildren().add(topLbl);
		top.setAlignment(Pos.TOP_LEFT);
		top.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 2 0;-fx-border-color: black; -fx-background-color:red ");
		top.setPrefHeight(100);
		top.prefWidth(100);

		center.getChildren().add(centerLbl);
		center.setAlignment(Pos.CENTER);
		center.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 2 0; -fx-border-color:black; -fx-background-color:blue ");
		center.setPrefHeight(100);
		center.prefWidth(100);

		bottom.getChildren().add(bottomLbl);
		bottom.setAlignment(Pos.BOTTOM_RIGHT);
		bottom.setStyle("-fx-background-color:yellow ");
		bottom.setPrefHeight(100);
		bottom.setPrefWidth(100);

		//Add VBoxes to Pane//
		borderPane.setTop(top);
		borderPane.setCenter(center);
		borderPane.setBottom(bottom);

	}

}

