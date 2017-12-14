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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lpe_soft.model.Client;
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
            Client tempClient = new Client();
            tempClient.setCodeClient(f_codeClient.getText());
            tempClient.setNom(f_nom.getText());
            tempClient.setTelephone(f_telephone.getText());
            tempClient.setFax(f_fax.getText());
            tempClient.setEmail(f_email.getText());
            tempClient.setCorrespondant(f_correspondant.getText());
            tempClient.setIncoterm(f_incoterm.getText());
            tempClient.setEori(f_eori.getText());
            tempClient.setReglement(f_reglement.getText());
            tempClient.setTransport(f_transport.getText());
            tempClient.setAutorisationPP(f_autorisationPP.getText());
            tempClient.setNumeroOF(f_numeroOF.getText());
            tempClient.setAdresseFacturation(f_adresseFacturation.getText());
            tempClient.setAdresseLivraison(f_adresseLivraison.getText());
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
