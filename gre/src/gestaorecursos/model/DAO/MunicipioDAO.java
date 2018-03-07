package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Uf;
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


public class MunicipioDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public MunicipioDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(Municipio municipio)  {
        String sql = "INSERT INTO tb_cidade(cidade,uf_id) VALUES(?,?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, municipio.getCidade());
            stmt.setInt(2, municipio.getUf().getId());
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
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean alterar(Municipio municipio) {
        String sql = "UPDATE tb_cidade SET cidade=?, uf_id=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, municipio.getCidade());
            stmt.setInt(2, municipio.getUf().getId());
            stmt.setInt(3, municipio.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Alterado com sucesso!");
            alert.showAndWait();
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Municipio municipio) {
        
        String sql = "DELETE FROM tb_cidade WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, municipio.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Excluído com sucesso!");
            alert.showAndWait();
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Municipio> listar() {
        String sql = "SELECT * FROM vw_cidadeuf";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Municipio> municipios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("idcidade"));
                municipio.setCidade(rs.getString("municipio"));

                Uf uf = new Uf();
                uf.setId(rs.getInt("uid"));
                uf.setUf(rs.getString("uflabel"));
                municipio.setUf(uf);
                
                municipios.add(municipio);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return municipios;
    }

    public Municipio buscar(Municipio municipio) {
        String sql = "SELECT * FROM tb_cidade WHERE id=?";
        Municipio retorno = new Municipio();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, municipio.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                municipio.setCidade(resultado.getString("cidade"));
                retorno = municipio;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    
    
}
