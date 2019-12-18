package fx_painting;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FirstController implements Initializable {
	private PaintingQueries queries = new PaintingQueries();
	@FXML
	private TextArea taShow;
	@FXML
	private TextArea taAdd;
	@FXML
	private TextField tfAdd;
	@FXML
	private Button btnShow;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnShwImage;
	@FXML
	private TextField tfAdd2;
	@FXML
	private TextField tfAdd3;
	   @FXML
	    private ImageView imageView;
	   @FXML
	    private Label lblAdd;
	   @FXML
	    private Label lblImage;
	   
	   
	@FXML
	private void showButtonAction(ActionEvent event) {
		System.out.println("Clicked show button!!");
		List<Painting> paintings = queries.getAllPaintings();
		//System.out.println(tfFind.getText());
		if(paintings.size() > 0) {
			taShow.setText(paintings.toString());
		}else {
			taShow.setText("no entries were found");
		}
	}
	@FXML
	private void addButtonAction(ActionEvent event) {
		System.out.println("You clicked add button!");
	
		int year = Integer.parseInt(tfAdd3.getText());
		int result = queries.addPainting(tfAdd.getText(), tfAdd2.getText(), year);
		System.out.println("Added " + result +"row(s).");
		List<Painting> paintings = queries.getAllPaintings();
		if(paintings.size() > 0) {
		taAdd.setText(paintings.toString());}
		else {
			taShow.setText("no entries were found");
		}
		
	}
	@FXML
	private void imageButtonAction(ActionEvent event) {
		System.out.println("You clicked image button!");
		File file = new File("/src/img/image.jpg");
       // Image image = new Image(getClass().getResourceAsStream("/src/image.jpg"));
		Image image = new Image(file.toURI().toString());
        //Image image = new Image(file);
        imageView.setImage(image);
        imageView.setCache(true);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		File file = new File("src/image.jpg");
	        Image image = new Image(file.toURI().toString());
	        //Image image = new Image(file);
	        imageView.setImage(image);
	        imageView.setCache(true);
	}
	public void passQueriesObject(PaintingQueries queries) {
		this.queries = queries;
		
	}
}
