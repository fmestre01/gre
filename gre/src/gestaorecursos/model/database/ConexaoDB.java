package gestaorecursos.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mgonc
 */
public class ConexaoDB {
    public static Connection con;
    public Statement stmt;
    public ResultSet rs;
    
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/gre";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {

            System.setProperty("jdbc.Drivers", DRIVER );
            con = DriverManager.getConnection(URL, USER, PASS);
            
        } catch (SQLException ex) {
            System.out.println("Erro na Conexão " +ex);
        }
       return con;
    }
    
}
