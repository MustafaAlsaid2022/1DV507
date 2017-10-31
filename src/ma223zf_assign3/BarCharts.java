package ma223zf_assign3;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BarCharts extends Application {
	
	public static void main(String[]args){
		launch(args);
	}

	Histogram histogram = new Histogram();
	private Text text = new Text("You selected an invalid file");
	private int[] array = histogram.getValue();
	private String[] arr = histogram.getFormat();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		/* Make panel and button */
		Group root = new Group();
		Button button = new Button("Select File");

		/* Set button on action */
		button.setOnAction((event) -> {
			text.setVisible(false);

			/* Create file chooser and set extensions */
			FileChooser selector = new FileChooser();
			FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			selector.getExtensionFilters().add(extension);
			File file = selector.showOpenDialog(primaryStage);

			/* Set path */
			histogram.setPath(file.getAbsolutePath());

			/* Check if file have correct data */
			try {
				if (histogram.check() == true) {
					text.setVisible(true);
					text.setFont(Font.font(20));
					HBox box = new HBox();
					box.getChildren().add(text);
					primaryStage.setScene(new Scene(box, 200, 200));
					primaryStage.show();

				}
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}

			/* Run this, If data is correct */
			try {
				histogram.readFileText();

				/* Set Data */
				primaryStage.setTitle("Histogram");
				CategoryAxis xAxis = new CategoryAxis();
				NumberAxis yAxis = new NumberAxis();
				BarChart<String, Number> bar = new BarChart<>(xAxis, yAxis);
				bar.setTitle("Numbers 1-100");
				xAxis.setLabel("Numbers groups");
				yAxis.setLabel("How many numbers from each numbers group");

				XYChart.Series<String, Number> histogram = new XYChart.Series<>();
				for (int i = 0; i < array.length; i++) {
					histogram.getData().add(new XYChart.Data<String, Number>(arr[i], array[i]));
				}

				bar.getData().addAll(histogram);
				Scene s = new Scene(bar, 500, 500);
				primaryStage.setScene(s);
				primaryStage.setResizable(false);
				primaryStage.show();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		});
		   /* Layout */
		button.setLayoutX(70);
		button.setLayoutY(170);
		root.getChildren().add(button);
		
		primaryStage.setScene(new Scene(root, 200, 200));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
