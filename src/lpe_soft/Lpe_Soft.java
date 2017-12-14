package lpe_soft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Lpe_Soft extends Application {
    
    public static Connection connection = null;    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //BDD
        CreateConnection();
        
        //IHM
        Parent root = FXMLLoader.load(getClass().getResource("view/Connexion.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Facturation");
        stage.getIcons().add(new Image("file:src/resources/logo.png"));
        stage.setScene(scene);
        stage.show();
        Platform.setImplicitExit(false);
        
        //Message sortie
        stage.setOnCloseRequest((WindowEvent event) -> {
            final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(stage);
            alert.setTitle("Demande de confirmation");
            alert.setHeaderText("Voulez êtes sur le point de quitter l'application");
            alert.setContentText("Voulez vous quitter ?");
            final Optional<ButtonType> result = alert.showAndWait();
            result.ifPresent(button -> {
                if (button == ButtonType.OK) { 
                    Platform.exit();
                    System.exit(0);
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Lpe_Soft.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    event.consume();
                }
            });
        });
    }
    
    public void CreateConnection() {
        String url = "jdbc:mysql://mysql-hugom.alwaysdata.net/hugom_lpe_bdd";
        String user = "hugom";
        String password = "Hugo1704";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.err.println(ex.getMessage());
        } 
    }
    
    public Connection getConnection() {
        //CreateConnection();
        return connection;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}