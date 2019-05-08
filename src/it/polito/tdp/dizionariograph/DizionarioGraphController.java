package it.polito.tdp.dizionariograph;
/**
 * Sample Skeleton for 'DizionarioGraph.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	private Model model=new Model();

	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="numLettere"
    private TextField numLettere; // Value injected by FXMLLoader

    @FXML // fx:id="parola"
    private TextField parola; // Value injected by FXMLLoader

    @FXML // fx:id="result"
    private TextArea result; // Value injected by FXMLLoader

    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	model.createGraph(Integer.parseInt(numLettere.getText()));
    	result.appendText(model.getG().toString());
    	

    }

    @FXML
    void doGradoMax(ActionEvent event) {
    	result.appendText("\n Grado massimo: "+model.findMaxDegree());
    	result.appendText("\n Vertici con il grado massimo: "+model.vertici());

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTrovaVicini(ActionEvent event) {
    	result.appendText("\n"+model.displayNeighbours(parola.getText()).toString());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert numLettere != null : "fx:id=\"numLettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert parola != null : "fx:id=\"parola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
}



