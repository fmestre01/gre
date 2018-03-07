package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mgonc
 */

public class AnoDAO {
    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }
    public AnoDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public List<Ano> listar() {
        String sql = "SELECT * FROM tb_ano";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Ano> anos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ano ano = new Ano();
                ano.setId(rs.getInt("id"));
                ano.setAno(rs.getString("ano"));
                anos.add(ano);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return anos;
    }

}
