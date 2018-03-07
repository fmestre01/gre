package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Historico;
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

public class HistoricoDAO {
    
        private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public HistoricoDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(Historico h)  {
        String sql = "INSERT INTO tb_historico(historico, cta_deb, cta_cred) VALUES(?,?,?)";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, h.getHistorico());
            stmt.setString(2, h.getContadeb());
            stmt.setString(3, h.getContacred());
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

    public boolean alterar(Historico historico) {
        String sql = "UPDATE tb_historico SET historico=?, cta_deb=?, cta_cred=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, historico.getHistorico());
            stmt.setString(2, historico.getContadeb());
            stmt.setString(3, historico.getContacred());
            stmt.setInt(4, historico.getId());
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

    public boolean remover(Historico historico) {
        
        String sql = "DELETE FROM tb_historico WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, historico.getId());
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

    public List<Historico> listar() {
        String sql = "SELECT * FROM tb_historico";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Historico> historicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Historico historico = new Historico();
                historico.setId(rs.getInt("id"));
                historico.setHistorico(rs.getString("historico"));
                historico.setContadeb(rs.getString("cta_deb"));
                historico.setContacred(rs.getString("cta_cred"));
                historicos.add(historico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return historicos;
    }

    public Historico buscar(Historico historico) {
        String sql = "SELECT * FROM tb_historico WHERE id=?";
        Historico retorno = new Historico();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, historico.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                historico.setHistorico(resultado.getString("historico"));
                retorno = historico;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    

    
}
