package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;


/**
 * @author mgonc
 */

public class PaisDAO {

    
    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public PaisDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(Pais p)  {
        String sql = "INSERT INTO tb_pais(pais) VALUES(?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getPais());
            stmt.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean alterar(Pais pais) {
        String sql = "UPDATE tb_pais SET pais=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pais.getPais());
            stmt.setInt(2, pais.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Pais pais) {
        
        String sql = "DELETE FROM tb_pais WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pais.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Pais> listar() {
        String sql = "SELECT * FROM tb_pais";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Pais> paiss = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setId(rs.getInt("id"));
                pais.setPais(rs.getString("pais"));
                paiss.add(pais);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return paiss;
    }

    public Pais buscar(Pais pais) {
        String sql = "SELECT * FROM tb_pais WHERE id=?";
        Pais retorno = new Pais();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pais.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                pais.setPais(resultado.getString("pais"));
                retorno = pais;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    

}
