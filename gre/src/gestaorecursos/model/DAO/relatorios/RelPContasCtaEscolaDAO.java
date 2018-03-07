package gestaorecursos.model.DAO.relatorios;

import gestaorecursos.model.DAO.PagamentosDAO;
import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgonc
 */
public class RelPContasCtaEscolaDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public RelPContasCtaEscolaDAO() {

        con = ConnectionFactory.getConnection();

    }

    public List<Pagamentos> listar() {
        String sql = "SELECT * FROM vw_cpagpessoa";
        List<Pagamentos> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamentos pagamentos = new Pagamentos();
                pagamentos.setId(rs.getInt("idcpag"));
                pagamentos.setData_emissao(rs.getDate("data_emissao"));
                pagamentos.setNr_docto(rs.getString("nr_docto"));
                pagamentos.setCheque(rs.getString("cheque"));
                pagamentos.setVlr_liquido(rs.getDouble("vlr_liquido"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("pid"));
                fornecedor.setNome(rs.getString("nomelabel"));
                pagamentos.setFornecedor(fornecedor);

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("pid"));
                f.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                pagamentos.setDoc_fornecedor(f);

                Uex u = new Uex();
                u.setId(rs.getInt("uid"));
                u.setUex("uex");

                retorno.add(pagamentos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Pagamentos> buscarUex(String uexsearch, String trisearch, String anosearch) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pagamentos> retorno = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM vw_cpagpessoa WHERE uex LIKE ? AND trimestre LIKE ? AND ano LIKE ?");
            stmt.setString(1, "%" + uexsearch + "%");
            stmt.setString(2, "%" + trisearch + "%");
            stmt.setString(3, "%" + anosearch + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pagamentos pagamentos = new Pagamentos();
                pagamentos.setId(rs.getInt("idcpag"));
                pagamentos.setData_emissao(rs.getDate("data_emissao"));
                pagamentos.setNr_docto(rs.getString("nr_docto"));
                pagamentos.setCheque(rs.getString("cheque"));
                pagamentos.setVlr_liquido(rs.getDouble("vlr_liquido"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("pid"));
                fornecedor.setNome(rs.getString("nomelabel"));
                pagamentos.setFornecedor(fornecedor);

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("uid"));
                f.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                pagamentos.setDoc_fornecedor(f);

                Uex u = new Uex();
                u.setId(rs.getInt("uid"));
                u.setUex("uex");
                pagamentos.setUex(u);

                Ano a = new Ano();
                a.setId(rs.getInt("aid"));
                a.setAno("ano");
                pagamentos.setAno(a);

                Trimestre t = new Trimestre();
                t.setId(rs.getInt("trid"));
                t.setTrimestre("trimestre");
                pagamentos.setTrimestre(t);

                retorno.add(pagamentos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    /*    
    public Cliente buscar(Cliente cliente) {

        String sql = "SELECT * FROM clientes WHERE cdCliente=?";
        Cliente retorno = new Cliente();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCdCliente());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setTelefone(resultado.getString("telefone"));
                retorno = cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
     */
}
