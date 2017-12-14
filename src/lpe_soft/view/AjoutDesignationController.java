package lpe_soft.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutDesignationController implements Initializable {

    @FXML private Button btnBack;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private TextField Designation;
    private Stage dialogStage;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    @FXML
    private void handleDelete() {
        //Ajouter suppression
    }
    @FXML
    private void ButtonAddDesignation (ActionEvent event) throws IOException{
        //Ajouter enregistrement Designation
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
