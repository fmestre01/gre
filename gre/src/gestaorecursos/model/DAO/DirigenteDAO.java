package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Dirigente;
import gestaorecursos.model.domain.EstadoCivil;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Pais;
import gestaorecursos.model.domain.Sexo;
import gestaorecursos.model.domain.TipoPessoa;
import gestaorecursos.model.domain.Uf;
import java.sql.Connection;
import java.sql.Date;
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
public class DirigenteDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public DirigenteDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(Dirigente dirigente) {
        String sql = "INSERT INTO tb_pessoa(id_tipopessoa, doc_fornecedor, nome, nacionalidade, id_sexo, id_estadocivil, endereco, endNum, endCompl, cep, id_bairro, id_cidade, id_uf, ddd, telFixo, telCel, email, cargo, identidade, emissao_rg, orgemissor, id_uex, id_pais) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, dirigente.getTipopessoa().getId());
            stmt.setString(2, dirigente.getDoc_fornecedor());
            stmt.setString(3, dirigente.getNome());
            stmt.setString(4, dirigente.getNacionalidade());
            stmt.setInt(5, dirigente.getSexo().getId());
            stmt.setInt(6, dirigente.getEstadocivil().getId());
            stmt.setString(7, dirigente.getEndRua());
            stmt.setString(8, dirigente.getEndNum());
            stmt.setString(9, dirigente.getEndCompl());
            stmt.setString(10, dirigente.getCep());
            stmt.setInt(11, dirigente.getBairro().getId());
            stmt.setInt(12, dirigente.getMunicipio().getId());
            stmt.setInt(13, dirigente.getUf().getId());
            stmt.setString(14, dirigente.getDdd());
            stmt.setString(15, dirigente.getTelFixo());
            stmt.setString(16, dirigente.getTelCel());
            stmt.setString(17, dirigente.getEmail());
            stmt.setString(18, dirigente.getIdentidade());
            stmt.setString(19, dirigente.getCargo());
            stmt.setDate(20, Date.valueOf(dirigente.getEmissao()));
            stmt.setString(21, dirigente.getOrgemissor());
            stmt.setInt(22, dirigente.getUex().getId());
            stmt.setInt(23, dirigente.getPais().getId());
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

    public boolean alterar(Dirigente dirigente) {
        
        String sql = "UPDATE tb_pessoa SET nome=?, doc_fornecedor=?, identidade=?, endereco=?, endNum=?, cep=?, ddd=?, telFixo=?, telCel=?,email=?, nacionalidade=?,id_bairro=?, id_cidade=?,id_uf=?, id_tipopessoa=?, id_sexo=?, id_estadocivil=?, id_uex=?, endCompl=?, orgemissor=?, cargo=?, emissao_rg=?, id_pais=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, dirigente.getNome());
            stmt.setString(2, dirigente.getDoc_fornecedor());
            stmt.setString(3, dirigente.getIdentidade());
            stmt.setString(4, dirigente.getEndRua());
            stmt.setString(5, dirigente.getEndNum());
            stmt.setString(6, dirigente.getCep());
            stmt.setString(7, dirigente.getDdd());
            stmt.setString(8, dirigente.getTelFixo());
            stmt.setString(9, dirigente.getTelCel());
            stmt.setString(10, dirigente.getEmail());
            stmt.setString(11, dirigente.getNacionalidade());
            stmt.setInt(12, dirigente.getBairro().getId());
            stmt.setInt(13, dirigente.getMunicipio().getId());
            stmt.setInt(14, dirigente.getUf().getId());
            stmt.setInt(15, dirigente.getTipopessoa().getId());
            stmt.setInt(16, dirigente.getSexo().getId());
            stmt.setInt(17, dirigente.getEstadocivil().getId());
            stmt.setInt(18, dirigente.getUex().getId());
            stmt.setString(19, dirigente.getEndCompl());
            stmt.setString(20, dirigente.getOrgemissor());
            stmt.setString(21, dirigente.getCargo());
            stmt.setDate(22, Date.valueOf(dirigente.getEmissao()));
            stmt.setInt(23, dirigente.getPais().getId());
            stmt.setInt(24, dirigente.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Alterado com sucesso!");
            alert.showAndWait();

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Dirigente dirigente) {

        String sql = "DELETE FROM tb_pessoa WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, dirigente.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Excluído com sucesso!");
            alert.showAndWait();
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Dirigente> listar() {

        String sql = "SELECT * FROM tb_pessoa ORDER BY nome";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Dirigente> dirigentes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Dirigente dirigente = new Dirigente();
                dirigente.setId(rs.getInt("id"));
                dirigente.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                dirigente.setNome(rs.getString("nome"));
                dirigente.setNacionalidade(rs.getString("doc_fornecedor"));
                dirigente.setEndRua(rs.getString("endereco"));
                dirigente.setEndNum(rs.getString("endNum"));
                dirigente.setEndCompl(rs.getString("endCompl"));
                dirigente.setCep(rs.getString("cep"));
                dirigente.setDdd(rs.getString("ddd"));
                dirigente.setTelFixo(rs.getString("telFixo"));
                dirigente.setTelCel(rs.getString("telCel"));
                dirigente.setEmail("email");
                dirigente.setCargo(rs.getString("cargo"));
                dirigente.setIdentidade(rs.getString("identidade"));
                dirigente.setOrgemissor("orgemissor");
//              dirigente.setEmissao(LocalDate(rs));
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id_bairro"));
                dirigente.setBairro(bairro);

                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                dirigente.setMunicipio(municipio);

                Sexo sexo = new Sexo();
                sexo.setId(rs.getInt("id_sexo"));
                dirigente.setSexo(sexo);

                EstadoCivil ec = new EstadoCivil();
                ec.setId(rs.getInt("id_estadocivil"));
                dirigente.setEstadocivil(ec);

                Uf uf = new Uf();
                uf.setId(rs.getInt("id_uf"));
                dirigente.setUf(uf);

                TipoPessoa tipopessoa = new TipoPessoa();
                tipopessoa.setId(rs.getInt("id_tipopessoa"));
                dirigente.setTipopessoa(tipopessoa);

                dirigentes.add(dirigente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dirigentes;
    }

    public List<Dirigente> listarpj() {

        String sql = "SELECT * FROM tb_pessoa WHERE id_tipopessoa=2";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Dirigente> dirigentepj = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Dirigente dirigente = new Dirigente();
                dirigente.setId(rs.getInt("id"));
                dirigente.setNome(rs.getString("nome"));
                dirigente.setIdentidade(rs.getString("identidade"));
                dirigente.setEndRua(rs.getString("endereco"));
                dirigente.setEndNum(rs.getString("endNum"));
                dirigente.setEndCompl(rs.getString("endCompl"));
                dirigente.setCep(rs.getString("cep"));
                dirigente.setTelFixo(rs.getString("telFixo"));
                dirigente.setTelCel(rs.getString("telCel"));
                dirigente.setEmail("email");
                dirigente.setSite("site");

                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id_bairro"));
                dirigente.setBairro(bairro);

                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                dirigente.setMunicipio(municipio);

                Uf uf = new Uf();
                uf.setId(rs.getInt("id_uf"));
                dirigente.setUf(uf);

                Pais pais = new Pais();
                pais.setId(rs.getInt("id_pais"));
                dirigente.setPais(pais);

                TipoPessoa tipopessoa = new TipoPessoa();
                tipopessoa.setId(rs.getInt("id_tipoPessoa"));
                dirigente.setTipopessoa(tipopessoa);

                dirigentepj.add(dirigente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dirigentepj;
    }

    public List<Dirigente> listarpf() {

        String sql = "SELECT * FROM tb_pessoa WHERE id_tipopessoa=1";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Dirigente> dirigentepf = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Dirigente dirigente = new Dirigente();
                dirigente.setId(rs.getInt("id"));
                dirigente.setNome(rs.getString("nome"));
                dirigente.setIdentidade(rs.getString("identidade"));
                dirigente.setEndRua(rs.getString("endereco"));
                dirigente.setEndNum(rs.getString("endNum"));
                dirigente.setEndCompl(rs.getString("endCompl"));
                dirigente.setCep(rs.getString("cep"));
                dirigente.setTelFixo(rs.getString("telFixo"));
                dirigente.setTelCel(rs.getString("telCel"));
                dirigente.setEmail("email");
                dirigente.setSite("site");

                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id_bairro"));
                dirigente.setBairro(bairro);

                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                dirigente.setMunicipio(municipio);

                Uf uf = new Uf();
                uf.setId(rs.getInt("id_uf"));
                dirigente.setUf(uf);

                Pais pais = new Pais();
                pais.setId(rs.getInt("id_pais"));
                dirigente.setPais(pais);

                TipoPessoa tipopessoa = new TipoPessoa();
                tipopessoa.setId(rs.getInt("id_tipopessoa"));
                dirigente.setTipopessoa(tipopessoa);

                dirigentepf.add(dirigente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dirigentepf;
    }

    public Dirigente buscar(Dirigente dirigente) {
        String sql = "SELECT * FROM tb_pessoa WHERE id=?";
        Dirigente retorno = new Dirigente();

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, dirigente.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                dirigente.setNome(resultado.getString("nome"));
                retorno = dirigente;
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        }
        return retorno;
    }

}
