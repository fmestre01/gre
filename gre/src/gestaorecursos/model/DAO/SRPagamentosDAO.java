package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.sr.PagamentosSR;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author mgonc
 */
public class SRPagamentosDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public SRPagamentosDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(PagamentosSR p) throws SQLException {

        String sql = "INSERT INTO tb_srcpag(data_emissao,nr_docto,data_pg,historico,valor,vlr_inss,vlr_ir,vlr_iss,vlr_piscofins,vlr_adeduzir,vlr_liquido,cheque,dt_cheque,conciliado,contmatic,id_ano,id_conta,id_programa, id_uex,id_tipodoc, id_fornecedor, id_trimestre) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(p.getData_emissao()));
            stmt.setString(2, p.getNr_docto());
            stmt.setDate(3, Date.valueOf(p.getData_pg()));
            stmt.setString(4, p.getHistorico());
            stmt.setDouble(5, p.getValor());
            stmt.setDouble(6, p.getVlr_inss());
            stmt.setDouble(7, p.getVlr_ir());
            stmt.setDouble(8, p.getVlr_iss());
            stmt.setDouble(9, p.getVlr_piscofins());
            stmt.setDouble(10, p.getVlr_adeduzir());
            stmt.setDouble(11, p.getVlr_liquido());
            stmt.setString(12, p.getCheque());
            stmt.setDate(13, Date.valueOf(p.getDt_cheque()));
            stmt.setBoolean(14, p.getConciliado());
            stmt.setString(15, p.getContmatic());
            stmt.setInt(16, p.getAno().getId());
            stmt.setInt(17, p.getConta().getId());
            stmt.setInt(18, p.getPrograma().getId());
            stmt.setInt(19, p.getUex().getId());
            stmt.setInt(20, p.getTipo_doc().getId());
            stmt.setInt(21, p.getFornecedor().getId());
            stmt.setInt(22, p.getTrimestre().getId());
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Inserido com sucesso!");
            alert.showAndWait();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SRPagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    /*
    public boolean alterar(PagamentosSR p) {
        String sql = "UPDATE tb_srcpag SET data_emissao=?,nr_docto=?,data_pg=?,historico=?,valor=?,vlr_inss=?,vlr_ir=?,vlr_iss=?,vlr_piscofins=?,vlr_adeduzir=?,vlr_liquido=?,cheque=?,dt_cheque=?,conciliado=?,contmatic=?,apelido=?,salaDeRecursos=?,id_tipocontratacao=?,id_tipodespesa=?,id_tipodoc=?,id_tipopessoa=?,id_fornecedor=?,id_numconta=?,id_ano=?,id_trimestre=?,id_programa=?,id_uex=? WHERE id=?"; 
                
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
            alert.showAndWait();            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(PagamentosSR p) {
        String sql = "DELETE FROM tb_srcpag WHERE id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SRPagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Pagamentos> listar() {
        String sql = "SELECT * FROM tb_srcpag";
        List<Pagamentos> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PagamentosSR pagamentosSR = new PagamentosSR();
                pagamentos.setId(rs.getInt("id"));
                retorno.add(pagamentosSR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SRPagamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
