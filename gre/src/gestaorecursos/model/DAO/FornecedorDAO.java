package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Pais;
import gestaorecursos.model.domain.TipoPessoa;
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



public class FornecedorDAO {

    

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public FornecedorDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(Fornecedor fornecedor)  {
        String sql = "INSERT INTO tb_pessoa(nome, nomeFantasia, doc_fornecedor, ccm, inscEstadual, identidade, endereco, endNum, endCompl, cep, id_bairro, id_cidade, id_uf, id_pais, id_tipopessoa, telFixo, telCel, email, site) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNomeFantasia());
            stmt.setString(3, fornecedor.getDoc_fornecedor());
            stmt.setString(4, fornecedor.getCcm());
            stmt.setString(5, fornecedor.getInscrEstadual());
            stmt.setString(6, fornecedor.getIdentidade());
            stmt.setString(7, fornecedor.getEndRua());
            stmt.setString(8, fornecedor.getEndNum());
            stmt.setString(9, fornecedor.getEndCompl());
            stmt.setString(10, fornecedor.getCep());
            stmt.setInt(11, fornecedor.getBairro().getId());
            stmt.setInt(12, fornecedor.getCidade().getId());
            stmt.setInt(13, fornecedor.getUf().getId());
            stmt.setInt(14, fornecedor.getPais().getId());
            stmt.setInt(15, fornecedor.getTipoPessoa().getId());
            stmt.setString(16, fornecedor.getTelFixo());
            stmt.setString(17, fornecedor.getTelCel());
            stmt.setString(18, fornecedor.getEmail());
            stmt.setString(19, fornecedor.getSite());
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

    public boolean alterar(Fornecedor fornecedor) {
        String sql = "UPDATE tb_pessoa SET nome=?, nomeFantasia=?, doc_fornecedor=?, ccm=?, inscEstadual=?, identidade=?, endereco=?, endNum=?, cep=?, telFixo=?, telCel=?, email=?, site=?, id_bairro=?, id_cidade=?,id_uf=?, id_pais=?, id_tipopessoa=?, endCompl=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNomeFantasia());
            stmt.setString(3, fornecedor.getDoc_fornecedor());
            stmt.setString(4, fornecedor.getCcm());
            stmt.setString(5, fornecedor.getInscrEstadual());
            stmt.setString(6, fornecedor.getIdentidade());
            stmt.setString(7, fornecedor.getEndRua());
            stmt.setString(8, fornecedor.getEndNum());
            stmt.setString(9, fornecedor.getCep());
            stmt.setString(10, fornecedor.getTelFixo());
            stmt.setString(11, fornecedor.getTelCel());
            stmt.setString(12, fornecedor.getEmail());
            stmt.setString(13, fornecedor.getSite());
            stmt.setInt(14, fornecedor.getBairro().getId());
            stmt.setInt(15, fornecedor.getCidade().getId());
            stmt.setInt(16, fornecedor.getUf().getId());
            stmt.setInt(17, fornecedor.getPais().getId());
            stmt.setInt(18, fornecedor.getTipoPessoa().getId());
            stmt.setString(19, fornecedor.getEndCompl());
            stmt.setInt(20, fornecedor.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Alterado com sucesso!");
            alert.showAndWait();
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Fornecedor fornecedor) {
        
        String sql = "DELETE FROM tb_pessoa WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Excluído com sucesso!");
            alert.showAndWait();
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Fornecedor> listar() {
  
        String sql = "SELECT * FROM tb_pessoa ORDER BY nome";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Fornecedor> fornecedors = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                fornecedor.setCcm(rs.getString("ccm"));
                fornecedor.setInscrEstadual(rs.getString("inscEstadual"));
                fornecedor.setIdentidade(rs.getString("identidade"));
                fornecedor.setEndRua(rs.getString("endereco"));
                fornecedor.setEndNum(rs.getString("endNum"));
                fornecedor.setEndCompl(rs.getString("endCompl"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setTelFixo(rs.getString("telFixo"));
                fornecedor.setTelCel(rs.getString("telCel"));
                fornecedor.setEmail("email");
                fornecedor.setSite("site");
                
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id_bairro"));
                fornecedor.setBairro(bairro);
                
                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                fornecedor.setCidade(municipio);
                
                Uf uf = new Uf();
                uf.setId(rs.getInt("id_uf"));
                fornecedor.setUf(uf);

                Pais pais = new Pais();
                pais.setId(rs.getInt("id_pais"));
                fornecedor.setPais(pais);
                
                TipoPessoa tipopessoa = new TipoPessoa();
                tipopessoa.setId(rs.getInt("id_tipopessoa"));
                fornecedor.setTipoPessoa(tipopessoa);
                
                fornecedors.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return fornecedors;
    }

    
    
    public List<Fornecedor> listarpj() {
  
        String sql = "SELECT * FROM tb_pessoa WHERE id_tipopessoa=2";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Fornecedor> fornecedorpj = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                fornecedor.setCcm(rs.getString("ccm"));
                fornecedor.setInscrEstadual(rs.getString("inscEstadual"));
                fornecedor.setIdentidade(rs.getString("identidade"));
                fornecedor.setEndRua(rs.getString("endereco"));
                fornecedor.setEndNum(rs.getString("endNum"));
                fornecedor.setEndCompl(rs.getString("endCompl"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setTelFixo(rs.getString("telFixo"));
                fornecedor.setTelCel(rs.getString("telCel"));
                fornecedor.setEmail("email");
                fornecedor.setSite("site");
                
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id_bairro"));
                fornecedor.setBairro(bairro);
                
                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                fornecedor.setCidade(municipio);
                
                Uf uf = new Uf();
                uf.setId(rs.getInt("id_uf"));
                fornecedor.setUf(uf);

                Pais pais = new Pais();
                pais.setId(rs.getInt("id_pais"));
                fornecedor.setPais(pais);
                
                TipoPessoa tipopessoa = new TipoPessoa();
                tipopessoa.setId(rs.getInt("id_tipopessoa"));
                fornecedor.setTipoPessoa(tipopessoa);
                
                fornecedorpj.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return fornecedorpj;
    }

    
    public List<Fornecedor> listarpf() {
  
        String sql = "SELECT * FROM tb_pessoa WHERE id_tipopessoa=1";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Fornecedor> fornecedorpf = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                fornecedor.setCcm(rs.getString("ccm"));
                fornecedor.setInscrEstadual(rs.getString("inscEstadual"));
                fornecedor.setIdentidade(rs.getString("identidade"));
                fornecedor.setEndRua(rs.getString("endereco"));
                fornecedor.setEndNum(rs.getString("endNum"));
                fornecedor.setEndCompl(rs.getString("endCompl"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setTelFixo(rs.getString("telFixo"));
                fornecedor.setTelCel(rs.getString("telCel"));
                fornecedor.setEmail("email");
                fornecedor.setSite("site");
                
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id_bairro"));
                fornecedor.setBairro(bairro);
                
                Municipio municipio = new Municipio();
                municipio.setId(rs.getInt("id_cidade"));
                fornecedor.setCidade(municipio);
                
                Uf uf = new Uf();
                uf.setId(rs.getInt("id_uf"));
                fornecedor.setUf(uf);

                Pais pais = new Pais();
                pais.setId(rs.getInt("id_pais"));
                fornecedor.setPais(pais);
                
                TipoPessoa tipopessoa = new TipoPessoa();
                tipopessoa.setId(rs.getInt("id_tipopessoa"));
                fornecedor.setTipoPessoa(tipopessoa);
                
                fornecedorpf.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return fornecedorpf;
    }
    
    public Fornecedor buscar(Fornecedor fornecedor) {
        String sql = "SELECT * FROM tb_pessoa WHERE id=?";
        Fornecedor retorno = new Fornecedor();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                fornecedor.setNome(resultado.getString("nome"));
                retorno = fornecedor;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    
 
}
