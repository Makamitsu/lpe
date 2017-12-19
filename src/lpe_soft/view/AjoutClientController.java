package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lpe_soft.model.DataClient;
import lpe_soft.model.UserBean;

/**
 *
 * @author hugob
 */
public class AjoutClientController implements Initializable {

    @FXML private Button btnBack;
    @FXML private Button btnEnregistrer;
    @FXML private TextField f_codeClient;
    @FXML private TextField f_nom;
    @FXML private TextField f_telephone;
    @FXML private TextField f_fax;
    @FXML private TextField f_email;
    @FXML private TextField f_correspondant;
    @FXML private TextField f_incoterm;
    @FXML private TextField f_eori;
    @FXML private TextField f_reglement;
    @FXML private TextField f_transport;
    @FXML private TextField f_autorisationPP;
    @FXML private TextField f_numeroOF;
    @FXML private TextArea f_adresseFacturation;
    @FXML private TextArea f_adresseLivraison;

    @FXML
    private void ButtonAddClient(ActionEvent event) throws IOException {
        if (event.getSource() == btnBack) {
            Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
            Scene scene = (Scene) ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        } else {
            DataClient tempClient = new DataClient();
            tempClient.setCodeClient(new SimpleStringProperty(f_codeClient.getText()));
            tempClient.setNom(new SimpleStringProperty(f_nom.getText()));
            tempClient.setTelephone(new SimpleStringProperty(f_telephone.getText()));
            tempClient.setFax(new SimpleStringProperty(f_fax.getText()));
            tempClient.setEmail(new SimpleStringProperty(f_email.getText()));
            tempClient.setCorrespondant(new SimpleStringProperty(f_correspondant.getText()));
            tempClient.setIncoterm(new SimpleStringProperty(f_incoterm.getText()));
            tempClient.setEori(new SimpleStringProperty(f_eori.getText()));
            tempClient.setReglement(new SimpleStringProperty(f_reglement.getText()));
            tempClient.setTransport(new SimpleStringProperty(f_transport.getText()));
            tempClient.setAutorisationPP(new SimpleStringProperty(f_autorisationPP.getText()));
            tempClient.setNumeroOF(new SimpleStringProperty(f_numeroOF.getText()));
            tempClient.setAdresseFacturation(new SimpleStringProperty(f_adresseFacturation.getText()));
            tempClient.setAdresseLivraison(new SimpleStringProperty(f_adresseLivraison.getText()));
            UserBean ubean = new UserBean();
            
            boolean done = ubean.addNewClient(tempClient);
            

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
