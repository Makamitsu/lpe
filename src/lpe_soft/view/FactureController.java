package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FactureController implements Initializable {

    @FXML private Button btnSave;
    @FXML private Button btnBack;
    @FXML private Label Nom;
    @FXML private Label Message;
    @FXML private TextArea AdrFacturation;
    @FXML private TextArea AdrLivraison;
    @FXML private ComboBox NCommande;
    @FXML private RadioButton rbtnPalette;        
    @FXML private RadioButton rbtnCarton;
    @FXML private TextField Tdj;
    @FXML private TextField Reglement;
    @FXML private TextField TransportNom;
    @FXML private TextField TransportMode;
    @FXML private TextField NbrColis;
    @FXML private TextField Volume;
    @FXML private DatePicker DateEd;
    
    
    @FXML
    private void ButtonFacturation(ActionEvent event) throws IOException{
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
        final String[] AF = new String[] {"Adresse Facturation SGame", "Adresse Facturation Sorhea", "Adresse Facturation addax", "Adresse Facturation noalia"};
        final String[] AL = new String[] {"Adresse Livraison SGame", "Adresse Livraison Sorhea", "Adresse Livraison addax", "Adresse Livraison noalia"};
        final String[] RE = new String[] {"CB", "Cheque", "Liquide", "autre"};
        final String[] TN = new String[] {"Jean", "Janne", "Paul", "Mark"};
        final String[] TM = new String[] {"Camion", "Avion", "Bateau", "Voiture"};
        
        NCommande.getSelectionModel().selectedIndexProperty().addListener(new
        ChangeListener<Number>(){
            public void changed(ObservableValue ov, 
                    Number value, Number new_value){
                    Nom.setText(NC[new_value.intValue()]);
                    AdrFacturation.setText(AF[new_value.intValue()]);
                    AdrLivraison.setText(AL[new_value.intValue()]);
                    Reglement.setText(RE[new_value.intValue()]);
                    TransportNom.setText(TN[new_value.intValue()]);
                    TransportMode.setText(TM[new_value.intValue()]);
                    Message.setText("");
            }
        });
        DateEd.setValue(NOW_LOCAL_DATE());
    }
// Date Now  ### "To Date Picker"
    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }    
}
