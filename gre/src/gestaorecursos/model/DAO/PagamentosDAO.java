package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.sql.Connection;
import java.sql.Date;
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
public class PagamentosDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public PagamentosDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(Pagamentos p) throws SQLException {

        String sql = "INSERT INTO tb_cpag(data_emissao, nr_docto, data_pg, historico, valor, vlr_inss, vlr_ir, vlr_iss, vlr_piscofins, vlr_adeduzir, vlr_liquido, cheque, dt_cheque, contmatic, apelido, salaDeRecursos, id_tipodoc, id_fornecedor, id_conta, id_ano, id_trimestre, id_programa, id_uex, conciliado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement stmt = con.prepareStatement(sql);

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(p.getData_emissao().getTime()));
            stmt.setString(2, p.getNr_docto());
            stmt.setDate(3, new Date(p.getData_pg().getTime()));
            stmt.setString(4, p.getHistorico());
            stmt.setDouble(5, p.getValor());
            stmt.setDouble(6, p.getVlr_inss());
            stmt.setDouble(7, p.getVlr_ir());
            stmt.setDouble(8, p.getVlr_iss());
            stmt.setDouble(9, p.getVlr_piscofins());
            stmt.setDouble(10, p.getVlr_adeduzir());
            stmt.setDouble(11, p.getVlr_liquido());
            stmt.setString(12, p.getCheque());
            stmt.setDate(13, new Date(p.getDt_cheque().getTime()));
            stmt.setString(14, p.getContmatic());
            stmt.setString(15, p.getApelido());
            stmt.setBoolean(16, p.getSalaDeRecursos());
            stmt.setInt(17, p.getTipo_doc().getId());
            stmt.setInt(18, p.getFornecedor().getId());
            stmt.setInt(19, p.getConta().getId());
            stmt.setInt(20, p.getAno().getId());
            stmt.setInt(21, p.getTrimestre().getId());
            stmt.setInt(22, p.getPrograma().getId());
            stmt.setInt(23, p.getUex().getId());
//            stmt.setInt(18, p.getTipo_contratacao().getId());
//            stmt.setInt(19, p.getTipo_despesa().getId());
//            stmt.setInt(21, p.getTipo_pessoa().getId());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
      //} finally {
      //  ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Pagamentos> listar() {
        String sql = "SELECT * FROM tb_cpag";

        List<Pagamentos> retorno = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamentos pagamentos = new Pagamentos();
                pagamentos.setId(rs.getInt("id"));
                pagamentos.setData_emissao(rs.getDate("data_emissao"));
                pagamentos.setNr_docto(rs.getString("nr_docto"));
                pagamentos.setCheque(rs.getString("cheque"));

                pagamentos.setVlr_liquido(rs.getDouble("vlr_liquido"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("uid"));
                fornecedor.setNome(rs.getString("nomelabel"));
                pagamentos.setFornecedor(fornecedor);

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("uid"));
                f.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                pagamentos.setDoc_fornecedor(f);

                retorno.add(pagamentos);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return retorno;
    }

    
    public boolean alterar(Pagamentos p) {
        String sql = "UPDATE tb_cpag SET data_emissao=?,nr_docto=?,data_pg=?,historico=?,valor=?,vlr_inss=?,vlr_ir=?,vlr_iss=?,vlr_piscofins=?,vlr_adeduzir=?,vlr_liquido=?,cheque=?,dt_cheque=?,conciliado=?,contmatic=?,apelido=?,salaDeRecursos=?,id_tipocontratacao=?,id_tipodespesa=?,id_tipodoc=?,id_tipopessoa=?,id_fornecedor=?,id_numconta=?,id_ano=?,id_trimestre=?,id_programa=?,id_uex=? WHERE id=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(p.getData_emissao().getTime()));
            stmt.setString(2, p.getNr_docto());
            stmt.setDate(3, new Date(p.getData_pg().getTime()));
            stmt.setString(4, p.getHistorico());
            stmt.setDouble(5, p.getValor());
            stmt.setDouble(6, p.getVlr_inss());
            stmt.setDouble(7, p.getVlr_ir());
            stmt.setDouble(8, p.getVlr_iss());
            stmt.setDouble(9, p.getVlr_piscofins());
            stmt.setDouble(10, p.getVlr_adeduzir());
            stmt.setDouble(11, p.getVlr_liquido());
            stmt.setString(12, p.getCheque());
            stmt.setDate(13, new Date(p.getDt_cheque().getTime()));
            stmt.setBoolean(14, p.getConciliado());
            stmt.setString(15, p.getContmatic());
            stmt.setString(16, p.getApelido());
            stmt.setBoolean(17, p.getSalaDeRecursos());
            stmt.setInt(18, p.getTipo_contratacao().getId());
            stmt.setInt(19, p.getTipo_despesa().getId());
            stmt.setInt(20, p.getTipo_doc().getId());
            stmt.setInt(21, p.getTipo_pessoa().getId());
            stmt.setInt(22, p.getFornecedor().getId());
            stmt.setInt(23, p.getConta().getId());
            stmt.setInt(24, p.getAno().getId());
            stmt.setInt(25, p.getTrimestre().getId());
            stmt.setInt(26, p.getPrograma().getId());
            stmt.setInt(27, p.getUex().getId());
            stmt.setInt(28, p.getId());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Pagamentos p) {
        String sql = "DELETE FROM tb_cpag WHERE id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //################### CONCILIAÇÃO ########################
    //#
    //#
    public boolean alterarParaConciliado(Pagamentos p) {
        String sql = "UPDATE tb_cpag SET conciliado=1 WHERE id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterarParaNaoConciliado(Pagamentos p) {
        String sql = "UPDATE tb_cpag SET conciliado=0 WHERE id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Pagamentos> filtrar(String uexsearch, String trisearch, String anosearch) {
    
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pagamentos> retorno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM gre.vw_cpagpessoa WHERE uex LIKE ? AND trimestre LIKE ? AND ano LIKE ?");
            stmt.setString(1, "%" + uexsearch + "%");
            stmt.setString(2, "%" + trisearch + "%");
            stmt.setString(3, "%" + anosearch + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamentos p = new Pagamentos();

                p.setId(rs.getInt("idcpag"));
                p.setData_emissao(rs.getDate("data_emissao"));
                p.setNr_docto(rs.getString("nr_docto"));
                p.setData_pg(rs.getDate("data_pg"));
                p.setHistorico(rs.getString("historico"));
                p.setValor(rs.getDouble("valor"));
                p.setVlr_inss(rs.getDouble("vlr_inss"));
                p.setVlr_piscofins(rs.getDouble("vlr_piscofins"));
                p.setVlr_ir(rs.getDouble("vlr_ir"));
                p.setVlr_iss(rs.getDouble("vlr_iss"));
                p.setVlr_adeduzir(rs.getDouble("vlr_adeduzir"));
                p.setVlr_liquido(rs.getDouble("vlr_liquido"));
                p.setCheque(rs.getString("cheque"));
                p.setDt_cheque(rs.getDate("dt_cheque"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id_fornecedor"));
                fornecedor.setNome(rs.getString("nomelabel"));
                p.setFornecedor(fornecedor);

                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                a.setAno(rs.getString("ano"));
                p.setAno(a);

                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                t.setTrimestre(rs.getString("trimestre"));
                p.setTrimestre(t);

                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                u.setUex(rs.getString("uEx"));
                p.setUex(u);

                Programa pr = new Programa();
                pr.setId(rs.getInt("prid"));
                pr.setPrograma(rs.getString("programa"));
                p.setPrograma(pr);
                
                Conta ct = new Conta();
                ct.setId(rs.getInt("id_conta"));
                ct.setConta(rs.getString("conta"));
                p.setConta(ct);

                retorno.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return retorno;

    }

    
    public List<Pagamentos> listarDespesaConciliada(String uexsearch, String trisearch, String anosearch) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pagamentos> retorno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cpag cp join tb_pessoa pe on(pe.id=cp.id_fornecedor)join tb_uex u on(u.id=cp.id_uex)join tb_programa pr on(pr.id=cp.id_programa)join tb_ano an on(an.id=cp.id_ano)join tb_trimestre tri on(tri.id=cp.id_trimestre) WHERE conciliado=1 AND uex LIKE ? AND trimestre LIKE ? AND ano LIKE ?");
            stmt.setString(1, "%" + uexsearch + "%");
            stmt.setString(2, "%" + trisearch + "%");
            stmt.setString(3, "%" + anosearch + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamentos p = new Pagamentos();

                p.setId(rs.getInt("id"));
                p.setData_emissao(rs.getDate("data_emissao"));
                p.setNr_docto(rs.getString("nr_docto"));
                p.setData_pg(rs.getDate("data_pg"));
                p.setHistorico(rs.getString("historico"));
                p.setValor(rs.getDouble("valor"));
                p.setVlr_liquido(rs.getDouble("vlr_liquido"));
                p.setCheque(rs.getString("cheque"));
                p.setDt_cheque(rs.getDate("dt_cheque"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id_fornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                p.setFornecedor(fornecedor);

                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                a.setAno(rs.getString("ano"));
                p.setAno(a);

                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                t.setTrimestre(rs.getString("trimestre"));
                p.setTrimestre(t);

                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                u.setUex(rs.getString("uEx"));
                p.setUex(u);

                Programa pr = new Programa();
                pr.setId(rs.getInt("id_programa"));
                pr.setPrograma(rs.getString("programa"));
                p.setPrograma(pr);

                retorno.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return retorno;

    }

    public List<Pagamentos> listarDespesaNaoConciliada(String uexsearch, String trisearch, String anosearch) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pagamentos> retorno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cpag cp join tb_pessoa pe on(pe.id=cp.id_fornecedor)join tb_uex u on(u.id=cp.id_uex)join tb_programa pr on(pr.id=cp.id_programa)join tb_ano an on(an.id=cp.id_ano)join tb_trimestre tri on(tri.id=cp.id_trimestre) WHERE conciliado=0 AND uex LIKE ? AND trimestre LIKE ? AND ano LIKE ?");
            stmt.setString(1, "%" + uexsearch + "%");
            stmt.setString(2, "%" + trisearch + "%");
            stmt.setString(3, "%" + anosearch + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pagamentos p = new Pagamentos();

                p.setId(rs.getInt("id"));
                p.setData_emissao(rs.getDate("data_emissao"));
                p.setNr_docto(rs.getString("nr_docto"));
                p.setData_pg(rs.getDate("data_pg"));
                p.setHistorico(rs.getString("historico"));
                p.setValor(rs.getDouble("valor"));
                p.setVlr_liquido(rs.getDouble("vlr_liquido"));
                p.setCheque(rs.getString("cheque"));
                p.setDt_cheque(rs.getDate("dt_cheque"));

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id_fornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                p.setFornecedor(fornecedor);

                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                a.setAno(rs.getString("ano"));
                p.setAno(a);

                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                t.setTrimestre(rs.getString("trimestre"));
                p.setTrimestre(t);

                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                u.setUex(rs.getString("uEx"));
                p.setUex(u);

                Programa pr = new Programa();
                pr.setId(rs.getInt("id_programa"));
                pr.setPrograma(rs.getString("programa"));
                p.setPrograma(pr);

                retorno.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
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
