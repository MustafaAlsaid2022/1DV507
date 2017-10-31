package ma223zf_assign3;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class UpDownPane {
	// fields//
	private Image image;
	private ImageView view;
	private GridPane root;
	private int x;
	private int y;

	public UpDownPane() {

		root = new GridPane(); //create a grid//
		root.setPrefSize(600, 600); //set size//
		root.setGridLinesVisible(true);

		image = new Image(getClass().getResourceAsStream("java.jpg")); //to reach the image//
		view = new ImageView(); // create view for the image//
		view.setImage(image); //view holds the image//

		//size of image when it is viewed//
		view.setFitHeight(85); 
		view.setFitWidth(85);

		addRowsAndColumn(); //add rows and columns to grid//
		root.getChildren().add(view); //add view to grid//

		x = 0; //start point for x//
		y = 0; //start point for y//
	}

	public GridPane getRoot() { //return the grid with all its children//
		return root;
	}

	public void setScenceSettings(Scene scene) { //events when we press on keyboard keys//
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				if (y == 0) {
					y = 6;
				} else
					y--;
			}

			else if (e.getCode() == KeyCode.DOWN) {
				if (y == 6) {
					y = 0;
				} else
					y++;
			}

			else if (e.getCode() == KeyCode.LEFT) {
				if (x == 0) {
					x = 6;
				} else
					x--;
			}

			else if (e.getCode() == KeyCode.RIGHT) {
				if (x == 6) {
					x = 0;
				} else
					x++;
			}

			GridPane.setRowIndex(view, y);
			GridPane.setColumnIndex(view, x);
			root.getChildren().removeAll(view);
			root.getChildren().add(view);
		});
	}

	private void addRowsAndColumn() { //to add rows and columns//
		for (int i = 0; i < 7; i++) {
			ColumnConstraints column = new ColumnConstraints();
			column.setMinWidth(10);
			column.setPrefWidth(100);
			column.setHgrow(Priority.SOMETIMES);

			RowConstraints row = new RowConstraints();
			row.setMinHeight(10);
			row.setPrefHeight(30);
			row.setVgrow(Priority.SOMETIMES);

			root.getColumnConstraints().add(column);
			root.getRowConstraints().add(row);
		}
	}
}