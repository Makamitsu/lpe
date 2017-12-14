package lpe_soft.model;

import java.sql.ResultSet;
import java.sql.Connection ;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public boolean addNewClient(Client client){
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
            PreparedStatement preparedStmt = connection.prepareStatement(query);
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
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return true;
    }
    
    
}
