package fx_painting;

import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Driver extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			String fxmlFileName = "FirstWindow.fxml";
	        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		PaintingQueries queries = new PaintingQueries();
		List<Painting> paintings ;
		
		paintings = queries.getAllPaintings();
		 
		 for (Painting painting : paintings) { System.out.println(painting.toString()); }
		  
		// int result = queries.addPainting("Sneha", "Painting1",2019);
		 
		// System.out.println("result of adding  " + result);
		 
		  
paintings = queries.getAllPaintings();
		 
		 for (Painting painting : paintings) { System.out.println(painting.toString()); }
		
		
		}
}
