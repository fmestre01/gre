package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Uf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mgonc
 */


public class UfDAO {
    
    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public UfDAO(){
        
        con = ConnectionFactory.getConnection();
        
    }
    
    public boolean alterar(Uf uf) {
        String sql = "UPDATE tb_uf SET uf=?, estado=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, uf.getUf());
            stmt.setString(2, uf.getEstado());
            stmt.setInt(3, uf.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Uf> listar() {
        String sql = "SELECT * FROM tb_uf";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Uf> ufs = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Uf uf = new Uf();
                uf.setId(rs.getInt("id"));
                uf.setUf(rs.getString("uf"));
                uf.setEstado(rs.getString("estado"));
                ufs.add(uf);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ufs;
    }


}
