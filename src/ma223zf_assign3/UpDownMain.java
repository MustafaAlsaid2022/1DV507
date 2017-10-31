package ma223zf_assign3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpDownMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		UpDownPane upDown = new UpDownPane();
		Scene scene = new Scene(upDown.getRoot(), 600, 600);
		upDown.setScenceSettings(scene);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
}
