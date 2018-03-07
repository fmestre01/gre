package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Trimestre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mgonc
 */
public class TrimestreDAO {
   
    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }
    
    public TrimestreDAO(){
        con = ConnectionFactory.getConnection();
}
    public List<Trimestre> listar() {
        String sql = "SELECT * FROM tb_trimestre";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Trimestre> trimestres = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Trimestre trimestre = new Trimestre();
                trimestre.setId(rs.getInt("id"));
                trimestre.setTrimestre(rs.getString("trimestre"));
                trimestres.add(trimestre);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        }
        return trimestres;
    }


    }