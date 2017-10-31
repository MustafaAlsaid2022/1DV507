package ma223zf_assign3;

//package ma223zf_assign3;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 


public class CreatureMain extends Application {

	public static void main(String[] args) {
		Application.launch(args); 

	}
	
	@Override 
	 	public void start(Stage stage) { 

	 
		/*Call the constructor and set the stage*/ 
		Creature creature = new Creature(); 

	 
			Scene scene = new Scene(creature.getRoot()); 
		stage.setScene(scene); 
		stage.setTitle("Catch the Creature"); 
		stage.setWidth(850); 
			stage.setHeight(700); 
		stage.show(); 
	} 
	 
	 
	


}
