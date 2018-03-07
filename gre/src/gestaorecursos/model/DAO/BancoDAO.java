package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Banco;
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


public class BancoDAO {
        private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public BancoDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(Banco b) {
        String sql = "INSERT INTO tb_banco(banco,numBanco) VALUES(?,?);";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, b.getBanco());
            stmt.setString(2, b.getNumBanco());
            stmt.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean alterar(Banco banco) {
        String sql = "UPDATE tb_banco SET banco=? numBanco=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, banco.getBanco());
            stmt.setString(2, banco.getNumBanco());
            stmt.setInt(3, banco.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Banco banco) {

        String sql = "DELETE FROM tb_banco WHERE id=?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, banco.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Banco> listar() {
        String sql = "SELECT * FROM tb_banco";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Banco> bancos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId(rs.getInt("id"));
                banco.setBanco(rs.getString("banco"));
                banco.setNumBanco(rs.getString("numBanco"));
                bancos.add(banco);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return bancos;
    }

    public Banco buscar(Banco banco) {
        String sql = "SELECT * FROM tb_banco WHERE id=?";
        Banco retorno = new Banco();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, banco.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                banco.setBanco(resultado.getString("banco"));
                retorno = banco;
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        }
        return retorno;
    }

}
