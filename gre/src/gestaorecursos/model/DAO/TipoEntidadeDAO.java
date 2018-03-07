package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.TipoEntidade;
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

public class TipoEntidadeDAO {


    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public TipoEntidadeDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(TipoEntidade p)  {
        String sql = "INSERT INTO tb_tipoentidade(tipo_entidade) VALUES(?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getTipoEntidade());
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

    public boolean alterar(TipoEntidade tipoEntidade) {
        String sql = "UPDATE tb_tipoentidade SET tipo_entidade=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipoEntidade.getTipoEntidade());
            stmt.setInt(2, tipoEntidade.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(TipoEntidade tipoEntidade) {
        
        String sql = "DELETE FROM tb_tipoentidade WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipoEntidade.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<TipoEntidade> listar() {
        String sql = "SELECT * FROM tb_tipoentidade";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<TipoEntidade> tipoEntidades = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TipoEntidade tipoEntidade = new TipoEntidade();
                tipoEntidade.setId(rs.getInt("id"));
                tipoEntidade.setTipoEntidade(rs.getString("tipo_entidade"));
                tipoEntidades.add(tipoEntidade);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
       // }finally{
       //     ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipoEntidades;
    }

    public TipoEntidade buscar(TipoEntidade tipoEntidade) {
        String sql = "SELECT * FROM tb_tipoentidade WHERE id=?";
        TipoEntidade retorno = new TipoEntidade();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipoEntidade.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                tipoEntidade.setTipoEntidade(resultado.getString("tipo_entidade"));
                retorno = tipoEntidade;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    
    
}
