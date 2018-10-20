/**
 * Sample Skeleton for 'Dizionario.fxml' Controller Class
 */

package it.dizionario.marco;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.dizionario.marco.Model.Model;
import it.dizionario.marco.Model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="display"
    private TextArea display; // Value injected by FXMLLoader

    @FXML // fx:id="txtSearch"
    private TextField txtSearch; // Value injected by FXMLLoader

    @FXML
    void handleSearch(ActionEvent event) {
    	
    	
    	List<Parola> lista = model.search(txtSearch.getText());
    	display.clear();
    	for (Parola p : lista) {
    		display.appendText(p.toString()+"\n");
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'Dizionario.fxml'.";
        assert txtSearch != null : "fx:id=\"txtSearch\" was not injected: check your FXML file 'Dizionario.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
    
}
