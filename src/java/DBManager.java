
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugo Jové (sécurité)
 */
public class DBManager {
    private static Connection connect;
    
    private DBManager() {}
    
    private static void initConnexion(String driver, String url, String login, String password) throws SQLException {
            try {
                Class.forName(driver);
                connect = DriverManager.getConnection(url, login, password);
                connect.setAutoCommit(false);
                System.out.println("Connexion reussie");
            } catch (ClassNotFoundException e) {
                System.out.println("erreur chargement pilote JDBC \n");
                System.exit(0);
            } catch (SQLException e) {
                System.out.println("erreur connexion base de données \n" + e.getMessage());
                System.exit(0);
            }
    }
    
    public static Connection getConnect() throws SQLException {
        if (!(connect instanceof Connection)) {
            initConnexion("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/test","test","test");
        }
        return connect;
    }
}