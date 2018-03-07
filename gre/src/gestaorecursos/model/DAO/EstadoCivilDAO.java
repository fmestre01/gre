package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.EstadoCivil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author mgonc
 */


public class EstadoCivilDAO {
    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public EstadoCivilDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(EstadoCivil p)  {
        String sql = "INSERT INTO tb_estadocivil(estadocivil) VALUES(?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getEstadocivil());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean alterar(EstadoCivil estadocivil) {
        String sql = "UPDATE tb_estadocivil SET estadocivil=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, estadocivil.getEstadocivil());
            stmt.setInt(2, estadocivil.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(EstadoCivil estadocivil) {
        
        String sql = "DELETE FROM tb_estadocivil WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, estadocivil.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<EstadoCivil> listar() {
        String sql = "SELECT * FROM tb_estadocivil";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<EstadoCivil> estadocivils = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EstadoCivil estadocivil = new EstadoCivil();
                estadocivil.setId(rs.getInt("id"));
                estadocivil.setEstadocivil(rs.getString("estadocivil"));
                estadocivils.add(estadocivil);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estadocivils;
    }

    public EstadoCivil buscar(EstadoCivil estadocivil) {
        String sql = "SELECT * FROM tb_estadocivil WHERE =?";
        EstadoCivil retorno = new EstadoCivil();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, estadocivil.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                estadocivil.setEstadocivil(resultado.getString("estadocivil"));
                retorno = estadocivil;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    


}
