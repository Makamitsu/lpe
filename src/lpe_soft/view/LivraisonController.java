package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LivraisonController implements Initializable {

    @FXML private Button btnSave;
    @FXML private Button btnBack;
    @FXML private Label Nom;
    @FXML private Label Message;
    @FXML private ComboBox NCommande;
    @FXML private DatePicker expe;
    @FXML private TextField NbColis;
    @FXML private TextField QteFacture;
    @FXML private TextField QteLivre;
    @FXML private TextField tfControle;
    @FXML private RadioButton rbtnVisu;        
    @FXML private RadioButton rbtnElec;
    @FXML private RadioButton rbtnAOI;        
    @FXML private RadioButton rbtnLibre;
    @FXML private RadioButton rbtnOui;        
    @FXML private RadioButton rbtnNon;
    @FXML private RadioButton rbtnS;        
    @FXML private RadioButton rbtnNS;
    
    @FXML
    private void ButtonLivraison(ActionEvent event) throws IOException{
     if(event.getSource()==btnBack){
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
    public void initialize(URL url, ResourceBundle rb) {
        NCommande.setItems(FXCollections.observableArrayList(
                "CF521686", "CF852412", "CF789456", "CF159357")
        );
        final String[] NC = new String[] {"SGame", "Sorhea", "addax", "noalia"};
        
        NCommande.getSelectionModel().selectedIndexProperty().addListener(new
        ChangeListener<Number>(){
            public void changed(ObservableValue ov, 
                    Number value, Number new_value){
                    Nom.setText(NC[new_value.intValue()]);
                    Message.setText("");
            }
        });
    }    
}
