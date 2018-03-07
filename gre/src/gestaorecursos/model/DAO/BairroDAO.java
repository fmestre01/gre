package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Bairro;
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
public class BairroDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public BairroDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(Bairro p) {
        String sql = "INSERT INTO tb_bairro(bairro,id_cidade, id_uf) VALUES(?,?,?);";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getBairro());
            stmt.setInt(2, p.getMunicipio().getId());
            stmt.setInt(3, p.getUf().getId());
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

    public boolean alterar(Bairro bairro) {
        String sql = "UPDATE tb_bairro SET bairro=?, id_cidade=?, id_uf=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, bairro.getBairro());
            stmt.setInt(2, bairro.getMunicipio().getId());
            stmt.setInt(3, bairro.getUf().getId());
            stmt.setInt(4, bairro.getId());
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

    public boolean remover(Bairro bairro) {

        String sql = "DELETE FROM tb_bairro WHERE id=?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, bairro.getId());
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

    public List<Bairro> listar() {
        String sql = "SELECT * FROM vw_bairrocidadeuf";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Bairro> bairros = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("idbairro"));
                bairro.setBairro(rs.getString("bairro"));

                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                municipio.setCidade(rs.getString("cidadelabel"));
                bairro.setMunicipio(municipio);

                Uf uf = new Uf();
                uf.setId(rs.getInt("uid"));
                uf.setUf(rs.getString("uflabel"));
                bairro.setUf(uf);
                

                bairros.add(bairro);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
//        }finally{
//           ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return bairros;
    }

    public Bairro buscar(Bairro bairro) {
        String sql = "SELECT * FROM tb_bairro WHERE id=?";
        Bairro retorno = new Bairro();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, bairro.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                bairro.setBairro(resultado.getString("bairro"));
                retorno = bairro;
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        }
        return retorno;
    }

}
