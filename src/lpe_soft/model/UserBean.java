package lpe_soft.model;

import java.sql.ResultSet;
import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lpe_soft.Lpe_Soft;

public class UserBean {
    public boolean Connexion(String login, String password) throws SQLException {
        Connection connection = Lpe_Soft.connection;
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM utilisateur ");
            while (rs.next()) {
                String firstName = rs.getString("Prenom_User");
                String mdp = rs.getString("Mdp");
                if((firstName == null ? login == null : firstName.equals(login)) && (mdp == null ? password == null : mdp.equals(password))){
                    return true;
                }
            }
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean addNewClient(DataClient client){
        Connection connection = Lpe_Soft.connection;
        try {
            String query = "INSERT INTO `client` ("
                    + "`CODE_CLIENT`,"
                    + "`NOM_CLIENT`,"
                    + "`TELEPHONE_CLIENT`,"
                    + "`FAX_CLIENT`,"
                    + "`EMAIL_CLIENT`,"
                    + "`CORRESPONDANT`,"
                    + "`INCOTERM`,"
                    + "`EORI`,"
                    + "`AUTORISATIONPP`,"
                    + "`REGLEMENT`,"
                    + "`NOM_TRANSPORT`"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, client.getCodeClient());
            preparedStmt.setString(2, client.getNom());
            preparedStmt.setString(3, client.getTelephone());
            preparedStmt.setString(4, client.getFax());
            preparedStmt.setString(5, client.getEmail());
            preparedStmt.setString(6, client.getCorrespondant());
            preparedStmt.setString(7, client.getIncoterm());
            preparedStmt.setString(8, client.getEori());
            preparedStmt.setString(9, client.getAutorisationPP());
            preparedStmt.setString(10, client.getReglement());
            preparedStmt.setString(11, client.getTransport());
            preparedStmt.executeUpdate();
            try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        query = "INSERT INTO `adresse` ("
                                + "`ID_CLIENT`,"
                                + "`ADRESSE`,"
                                + "`LIVR_ADRESSE`) VALUES (?, ?, ?)";
                        preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setString(1, ""+generatedKeys.getLong(1));
                        preparedStmt.setString(2, client.getAdresseFacturation());
                        preparedStmt.setString(3, client.getAdresseLivraison());
                        preparedStmt.executeUpdate();
                    }
                    else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return true;
    }
    
    public ObservableList<DataClient> getAllClient(){
        Connection connection = Lpe_Soft.connection;
        ArrayList<DataClient> clients = new ArrayList<>();
        try {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM client JOIN adresse USING (ID_CLIENT) ");
            while (rs.next()) {
                int i = 0;
                clients.add(
                        new DataClient(
                                rs.getLong("ID_CLIENT"),
                                rs.getString("CODE_CLIENT"),
                                rs.getString("NOM_CLIENT"),
                                rs.getString("TELEPHONE_CLIENT"),
                                rs.getString("FAX_CLIENT"),
                                rs.getString("EMAIL_CLIENT"),
                                rs.getString("CORRESPONDANT"),
                                rs.getString("INCOTERM"),
                                rs.getString("EORI"),
                                rs.getString("REGLEMENT"),
                                rs.getString("NOM_TRANSPORT"),
                                rs.getString("AUTORISATIONPP"),
                                "",//rs.getString("NUMERO_OF"), NUMERO OF CLIENT
                                rs.getString("ADRESSE"),
                                rs.getString("LIVR_ADRESSE")
                        ));
            }
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return FXCollections.observableArrayList(clients);
    }    
    
    public ObservableList<DataClient> getAllClientBy(String code, String type){
        Connection connection = Lpe_Soft.connection;
        ArrayList<DataClient> clients = new ArrayList<>();
        try {
            Statement stmnt = connection.createStatement();
            String query = "SELECT * FROM client JOIN adresse USING (ID_CLIENT)";
            if (code.equals("") && !type.equals("")){
                query = "SELECT * from client join adresse USING (ID_CLIENT) WHERE NOM_CLIENT LIKE '%"+type+"%'";
            } else if (!code.equals("") && type.equals("")){
                query = "SELECT * from client join adresse USING (ID_CLIENT) WHERE CODE_CLIENT LIKE '%"+code+"%'";
            } else {
                query = "SELECT * from client join adresse USING (ID_CLIENT) WHERE CODE_CLIENT LIKE '%"+code+"%' AND NOM_CLIENT LIKE '%"+type+"%'";
            }
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                int i = 0;
                clients.add(
                        new DataClient(
                                rs.getLong("ID_CLIENT"),
                                rs.getString("CODE_CLIENT"),
                                rs.getString("NOM_CLIENT"),
                                rs.getString("TELEPHONE_CLIENT"),
                                rs.getString("FAX_CLIENT"),
                                rs.getString("EMAIL_CLIENT"),
                                rs.getString("CORRESPONDANT"),
                                rs.getString("INCOTERM"),
                                rs.getString("EORI"),
                                rs.getString("REGLEMENT"),
                                rs.getString("NOM_TRANSPORT"),
                                rs.getString("AUTORISATIONPP"),
                                "",//rs.getString("NUMERO_OF"), NUMERO OF CLIENT
                                rs.getString("ADRESSE"),
                                rs.getString("LIVR_ADRESSE")
                        ));
            }
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return FXCollections.observableArrayList(clients);
    }

    public boolean updateClient(DataClient client) {
        Connection connection = Lpe_Soft.connection;
        boolean done = true;
        try {
            PreparedStatement ps_client = connection.prepareStatement(
                    "UPDATE client SET CODE_CLIENT = ?,"
                            + " NOM_CLIENT = ?,"
                            + " TELEPHONE_CLIENT = ?,"
                            + " FAX_CLIENT = ?,"
                            + " EMAIL_CLIENT = ?,"
                            + " CORRESPONDANT = ?,"
                            + " INCOTERM = ?,"
                            + " EORI = ?,"
                            + " AUTORISATIONPP = ?,"
                            + " REGLEMENT = ?,"
                            + " NOM_TRANSPORT = ?"
                            + " WHERE ID_CLIENT = ?");
            PreparedStatement ps_adresse = connection.prepareStatement(
                    "UPDATE adresse SET ADRESSE = ?,"
                            + " LIVR_ADRESSE = ?,"
                            + " WHERE ID_CLIENT = ?");
            ps_client.setString(1, client.getCodeClient());
            ps_client.setString(2, client.getNom());
            ps_client.setString(3, client.getTelephone());
            ps_client.setString(4, client.getFax());
            ps_client.setString(5, client.getEmail());
            ps_client.setString(6, client.getCorrespondant());
            ps_client.setString(7, client.getIncoterm());
            ps_client.setString(8, client.getEori());
            ps_client.setString(9, client.getAutorisationPP());
            ps_client.setString(10, client.getReglement());
            ps_client.setString(11, client.getTransport());
            ps_client.setLong(12, client.getID());
            
            ps_adresse.setString(1, client.getAdresseFacturation());
            ps_adresse.setString(2, client.getAdresseLivraison());
            ps_adresse.setLong(3, client.getID());
            
            ps_client.executeUpdate();
            ps_adresse.executeUpdate();
            
        } catch (SQLException ex) {
            done = false;
        }
        return done;
    }
    
    
}
