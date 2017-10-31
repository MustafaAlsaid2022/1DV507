package ma223zf_assign3;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
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


public class PieCharts extends Application {
	
	public static void main(String[]args){
		launch(args);
	}

	Histogram histogram = new Histogram();
	private Text text = new Text("You selected an invalid file");
	private int[] array = histogram.getValue();
	private String[] arr = histogram.getFormat();

	
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
				ObservableList<PieChart.Data> myPieChart =FXCollections.observableArrayList();
				
				for (int i = 0; i < array.length; i++) {
					System.out.println("content of arr"+arr[i]);
					System.out.println("content of array"+array[i]);
					myPieChart.add(new PieChart.Data(arr[i], array[i]));
				}
				
			                
			        final PieChart chart = new PieChart(myPieChart);
			        chart.setTitle("Numbers 1-100");
			        Scene s = new Scene(chart, 500, 500);
					primaryStage.setScene(s);
			        primaryStage.show();
			    } catch (FileNotFoundException e) {

					e.printStackTrace();
				}

			});

		button.setLayoutX(70);
		button.setLayoutY(170);
		root.getChildren().add(button);
		
		primaryStage.setScene(new Scene(root, 200, 200));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
