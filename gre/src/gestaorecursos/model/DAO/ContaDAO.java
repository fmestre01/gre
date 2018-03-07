package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Banco;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Uex;
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
public class ContaDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public ContaDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(Conta p) {
        String sql = "INSERT INTO tb_conta(numConta, numAgencia, id_banco, id_programa, id_uex) VALUES(?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getConta());
            stmt.setString(2, p.getNumAgencia());
            stmt.setInt(3, p.getBanco().getId());
            stmt.setInt(4, p.getPrograma().getId());
            stmt.setInt(5, p.getUex().getId());
            stmt.executeUpdate();
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

    public boolean alterar(Conta conta) {
        String sql = "UPDATE tb_conta SET numConta=?, numAgencia=?, id_uex=?, id_programa=?, id_banco=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, conta.getConta());
            stmt.setString(2, conta.getNumAgencia());
            stmt.setInt(3, conta.getUex().getId());
            stmt.setInt(4, conta.getPrograma().getId());
            stmt.setInt(5, conta.getBanco().getId());
            stmt.setInt(6, conta.getId());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Alterado com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Conta conta) {

        String sql = "DELETE FROM tb_conta WHERE id=?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, conta.getId());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Excluído com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Conta> listar() {
        String sql = "select * from vw_contabancouex";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Conta> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta conta = new Conta();
                conta.setId(rs.getInt("idconta"));
                conta.setConta(rs.getString("conta"));
                conta.setNumAgencia(rs.getString("agencia"));

                Banco banco = new Banco();
                banco.setId(rs.getInt("idbanco"));
                banco.setBanco(rs.getString("banco"));
                conta.setBanco(banco);

                Uex uex = new Uex();
                uex.setId(rs.getInt("id_uex"));
                uex.setUex(rs.getString("uexlabel"));
                conta.setUex(uex);

                contas.add(conta);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
            //}finally{
            //   ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return contas;
    }

    public Conta buscar(Conta conta) {
        String sql = "SELECT * FROM tb_conta WHERE id=?";
        Conta retorno = new Conta();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, conta.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                conta.setConta(resultado.getString("conta"));
                retorno = conta;
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        }
        return retorno;
    }

}
