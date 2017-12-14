package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author hugob
 */
public class AjoutProduitController implements Initializable {
    
    @FXML
    private Button btnBack;
    @FXML
    private Button btnEnregistrer;
    @FXML
    RadioButton rbtnOui;        
    @FXML
    RadioButton rbtnNon;
    
    @FXML
    private void ButtonAddClient(ActionEvent event) throws IOException{
     if(event.getSource()==btnBack){
        Parent root = FXMLLoader.load(getClass().getResource("Produit.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root); 
     }
     else
     {
        //Ajouter enregistrement client
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root); 
     }  
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //TODO
    }
}
