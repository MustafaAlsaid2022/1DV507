package ma223zf_assign2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorDisplayMain extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage stage) throws Exception {
		ColorDisplay color = new ColorDisplay(); //object of ColorDisplay class//
		Scene scene = new Scene(color.getRoot(), 600, 400);
		stage.setScene(scene);
		stage.show();
	}
}
