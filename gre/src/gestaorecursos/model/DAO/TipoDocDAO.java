package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.TipoDoc;
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
public class TipoDocDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public TipoDocDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(TipoDoc td) {
        String sql = "INSERT INTO tb_tipodoc(tipoDoc) VALUES(?);";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, td.getTipo_doc());
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

    public boolean alterar(TipoDoc td) {
        String sql = "UPDATE tb_tipodoc SET tipoDoc=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, td.getTipo_doc());
            stmt.setInt(2, td.getId());
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

    public boolean remover(TipoDoc td) {

        String sql = "DELETE FROM tb_tipodoc WHERE id=?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, td.getId());
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

    public List<TipoDoc> listar() {
        String sql = "SELECT * FROM tb_tipodoc";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<TipoDoc> tipodocs = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TipoDoc tipodoc = new TipoDoc();
                tipodoc.setId(rs.getInt("id"));
                tipodoc.setTipo_doc(rs.getString("tipoDoc"));
                tipodocs.add(tipodoc);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
            // }finally{
            //     ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipodocs;
    }

    public TipoDoc buscar(TipoDoc tipodoc) {
        String sql = "SELECT * FROM tb_tipodoc WHERE id=?";
        TipoDoc retorno = new TipoDoc();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipodoc.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                tipodoc.setTipo_doc(resultado.getString("tipo_doc"));
                retorno = tipodoc;
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        }
        return retorno;
    }

}
