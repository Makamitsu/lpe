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
import javafx.scene.control.ComboBox;
import lpe_soft.model.DataClient;
import lpe_soft.model.UserBean;

public class CommandeController implements Initializable {

    @FXML private Button btnNext;
    @FXML private Button btnBack;
    @FXML private ComboBox comboClient;
    
    @FXML
    private void handleBack (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = (Scene) ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
    
    @FXML
    private void handleNext(ActionEvent event) throws IOException {
        if (comboClient.getValue() != null){            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CommandeProduit.fxml"));
            loader.load();
            CommandeProduitController controller = loader.getController();
            controller.setClient((DataClient) comboClient.getValue());
            Parent root = loader.getRoot();
            Scene scene = btnNext.getScene();
            scene.setRoot(root);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateComboBox();
    }    
    
    private void updateComboBox(){
        UserBean ub = new UserBean();
        this.comboClient.setItems(ub.getAllClient());
    }
    
    
}
