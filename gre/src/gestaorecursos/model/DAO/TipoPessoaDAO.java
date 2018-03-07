package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.TipoPessoa;
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
public class TipoPessoaDAO {
    
        private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public TipoPessoaDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(TipoPessoa p)  {
        String sql = "INSERT INTO tb_tipopessoa(tipoPessoa) VALUES(?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getTipoPessoa());
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

    public boolean alterar(TipoPessoa tipoPessoa) {
        String sql = "UPDATE tb_tipopessoa SET tipoPessoa=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipoPessoa.getTipoPessoa());
            stmt.setInt(2, tipoPessoa.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(TipoPessoa tipoPessoa) {
        
        String sql = "DELETE FROM tb_tipopessoa WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipoPessoa.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<TipoPessoa> listar() {
        String sql = "SELECT * FROM tb_tipopessoa";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<TipoPessoa> tipoPessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TipoPessoa tipoPessoa = new TipoPessoa();
                tipoPessoa.setId(rs.getInt("id"));
                tipoPessoa.setTipoPessoa(rs.getString("tipoPessoa"));
                tipoPessoas.add(tipoPessoa);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipoPessoas;
    }

    public TipoPessoa buscar(TipoPessoa tipoPessoa) {
        String sql = "SELECT * FROM tb_tipopessoa WHERE id=?";
        TipoPessoa retorno = new TipoPessoa();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipoPessoa.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                tipoPessoa.setTipoPessoa(resultado.getString("tipoPessoa"));
                retorno = tipoPessoa;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }
    
}
