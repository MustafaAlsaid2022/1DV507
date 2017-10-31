package ma223zf_assign2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		RandomPanel randompanel = new RandomPanel(); //object of RandomPanel class//
		Scene scene = new Scene(randompanel, 250,250 );
		stage.setScene(scene);
		stage.show();
		
	}

}
