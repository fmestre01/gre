package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.PlanoDeContas;
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



public class PlanoDeContasDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public PlanoDeContasDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(PlanoDeContas p)  {
        String sql = "INSERT INTO tb_plancontas(nome_conta, cod_reduzido, natureza, classe, grupo) VALUES(?,?,?,?,?);";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome_conta());
            stmt.setString(2, p.getCod_reduzido());
            stmt.setString(3, p.getNatureza());
            stmt.setString(4, p.getClasse());
            stmt.setString(5, p.getGrupo());
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

    public boolean alterar(PlanoDeContas p) {
        String sql = "UPDATE tb_plancontas SET nome_conta=?, cod_reduzido=?, natureza=?, classe=?, grupo=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome_conta());
            stmt.setString(2, p.getCod_reduzido());
            stmt.setString(3, p.getNatureza());
            stmt.setString(4, p.getClasse());
            stmt.setString(5, p.getGrupo());
            stmt.setInt(6, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(PlanoDeContas p) {
        
        String sql = "DELETE FROM tb_plancontas WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<PlanoDeContas> listar() {
        String sql = "SELECT * FROM tb_plancontas";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<PlanoDeContas> pcontas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PlanoDeContas p = new PlanoDeContas();
                p.setId(rs.getInt("id"));
                p.setNome_conta(rs.getString("nome_conta"));
                p.setCod_reduzido(rs.getString("cod_reduzido"));
                p.setNatureza(rs.getString("natureza"));
                p.setClasse(rs.getString("classe"));
                p.setGrupo(rs.getString("grupo"));
                pcontas.add(p);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pcontas;
    }

    public PlanoDeContas buscar(PlanoDeContas p) {
        String sql = "SELECT * FROM tb_plancontas WHERE id=?";
        PlanoDeContas retorno = new PlanoDeContas();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                p.setCod_reduzido(resultado.getString("cod_reduzido"));
                retorno = p;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    
    
}
