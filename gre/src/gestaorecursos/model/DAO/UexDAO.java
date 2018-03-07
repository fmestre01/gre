package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.Uf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 * @author mgonc
 */
public class UexDAO {

    private Connection con = null;

    public Connection getConnection() {

        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public UexDAO() {

        con = ConnectionFactory.getConnection();
    }

    public boolean inserir(Uex uex) {

        String sql = "INSERT INTO tb_uex(uExF, uEx, apelido, CNPJ, endRua, endNum, endCompl, CEP, cxPostal, ddd, telefone, fax, email, telEntidade, faxEntidade, undGestoraOrgFed, CNAS, codCenso, nomeEscola, idBairro, idCidade, idUf, contmatic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, uex.getUexf());
            stmt.setString(2, uex.getUex());
            stmt.setString(3, uex.getApelido());
            stmt.setString(4, uex.getCNPJ());
            stmt.setString(5, uex.getEndRua());
            stmt.setString(6, uex.getEndNum());
            stmt.setString(7, uex.getEndCompl());
            stmt.setString(8, uex.getCEP());
            stmt.setString(9, uex.getCxPostal());
            stmt.setString(10, uex.getDdd());
            stmt.setString(11, uex.getTelefone());
            stmt.setString(12, uex.getFax());
            stmt.setString(13, uex.getEmail());
            stmt.setString(14, uex.getTelEntidade());
            stmt.setString(15, uex.getFaxEntidade());
            stmt.setString(16, uex.getUndGestoraOrgFed());
            stmt.setString(17, uex.getCNAS());
            stmt.setString(18, uex.getCodCenso());
            stmt.setString(19, uex.getNomeEscola());
            stmt.setInt(20, uex.getBairro().getId());
            stmt.setInt(21, uex.getMunicipio().getId());
            stmt.setInt(22, uex.getUf().getId());
            stmt.setString(23, uex.getContmatic());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();

        } catch (SQLException ex) {
            Logger.getLogger(UexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean alterar(Uex uex) {

        String sql = "UPDATE tb_uex SET uExF=?, uEx=?, apelido=?, CNPJ=?, endRua=?, endNum=?, endCompl=?, CEP=?, cxPostal=?, ddd=?, telefone=?, fax=?, email=?, telEntidade=?, faxEntidade=?, undGestoraOrgFed=?, CNAS=?, codCenso=?, nomeEscola=?, idBairro=?, idCidade=?, idUf=?, contmatic=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, uex.getUexf());
            stmt.setString(2, uex.getUex());
            stmt.setString(3, uex.getApelido());
            stmt.setString(4, uex.getCNPJ());
            stmt.setString(5, uex.getEndRua());
            stmt.setString(6, uex.getEndNum());
            stmt.setString(7, uex.getEndCompl());
            stmt.setString(8, uex.getCEP());
            stmt.setString(9, uex.getCxPostal());
            stmt.setString(10, uex.getDdd());
            stmt.setString(11, uex.getTelefone());
            stmt.setString(12, uex.getFax());
            stmt.setString(13, uex.getEmail());
            stmt.setString(14, uex.getTelEntidade());
            stmt.setString(15, uex.getFaxEntidade());
            stmt.setString(16, uex.getUndGestoraOrgFed());
            stmt.setString(17, uex.getCNAS());
            stmt.setString(18, uex.getCodCenso());
            stmt.setString(19, uex.getNomeEscola());
            stmt.setInt(20, uex.getBairro().getId());
            stmt.setInt(21, uex.getMunicipio().getId());
            stmt.setInt(22, uex.getUf().getId());
            stmt.setString(23, uex.getContmatic());
            stmt.setInt(24, uex.getId());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Alterado com sucesso!");
            alert.showAndWait();

        } catch (SQLException ex) {
            Logger.getLogger(UexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean remover(Uex uex) {

        String sql = "DELETE FROM tb_uex WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, uex.getId());

            stmt.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Excluido com sucesso!");
            alert.showAndWait();

        } catch (SQLException ex) {
            Logger.getLogger(UexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public List<Uex> listar() {

        String sql = "SELECT * FROM tb_uex";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Uex> uexs = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Uex uex = new Uex();
                uex.setId(rs.getInt("id"));
                uex.setUexf(rs.getString("uExF"));
                uex.setUex(rs.getString("uEx"));
                uex.setApelido(rs.getString("apelido"));
                uex.setCNPJ(rs.getString("CNPJ"));
                uex.setEndRua(rs.getString("endRua"));
                uex.setEndNum(rs.getString("endNum"));
                uex.setEndCompl(rs.getString("endCompl"));
                uex.setCEP(rs.getString("CEP"));

                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("idBairro"));
                uex.setBairro(bairro);

                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("idCidade"));
                uex.setMunicipio(municipio);

                Uf uf = new Uf();
                uf.setId(rs.getInt("idUf"));
                uex.setUf(uf);

                
                uex.setCxPostal(rs.getString("cxPostal"));
                uex.setDdd(rs.getString("ddd"));
                uex.setTelefone(rs.getString("telefone"));
                uex.setFax(rs.getString("fax"));
                uex.setEmail(rs.getString("email"));

                uex.setTelEntidade(rs.getString("telEntidade"));
                uex.setFaxEntidade(rs.getString("faxEntidade"));
                uex.setUndGestoraOrgFed(rs.getString("undGestoraOrgFed"));
                uex.setCNAS(rs.getString("CNAS"));
                uex.setCodCenso(rs.getString("codCenso"));
                uex.setContmatic(rs.getString("contmatic"));
                uex.setNomeEscola(rs.getString("nomeEscola"));
                
                uexs.add(uex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UexDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uexs;

    }

    public Uex buscar(Uex uex) {
        String sql = "SELECT * FROM tb_uex WHERE id=?";
        Uex retorno = new Uex();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, uex.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                uex.setUexf(resultado.getString("uExF"));
                uex.setUex(resultado.getString("uEx"));
                uex.setApelido(resultado.getString("apelido"));
                retorno = uex;
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        }
        return retorno;
    }
}
