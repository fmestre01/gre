package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Sexo;
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


public class SexoDAO {


    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public SexoDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(Sexo p)  {
        String sql = "INSERT INTO tb_sexo(sexo) VALUES(?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getSexo());
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
    //    }finally{
    //        ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean alterar(Sexo sexo) {
        String sql = "UPDATE tb_sexo SET sexo=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sexo.getSexo());
            stmt.setInt(2, sexo.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
       // }finally{
       //     ConnectionFactory.closeConnection(con, stmt);
       }
    }

    public boolean remover(Sexo sexo) {
        
        String sql = "DELETE FROM tb_sexo WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sexo.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
       // }finally{
       //     ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Sexo> listar() {
        String sql = "SELECT * FROM tb_sexo";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Sexo> sexos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Sexo sexo = new Sexo();
                sexo.setId(rs.getInt("id"));
                sexo.setSexo(rs.getString("sexo"));
                sexos.add(sexo);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
       // }finally{
       //     ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return sexos;
    }

    public Sexo buscar(Sexo sexo) {
        String sql = "SELECT * FROM tb_sexo WHERE =?";
        Sexo retorno = new Sexo();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sexo.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                sexo.setSexo(resultado.getString("sexo"));
                retorno = sexo;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    
    
}
