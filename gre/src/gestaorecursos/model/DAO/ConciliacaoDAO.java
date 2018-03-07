package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.ConciliacaoDespesa;
import gestaorecursos.model.domain.ConciliacaoReceita;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mgonc
 */


public class ConciliacaoDAO {
    
    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }
    public ConciliacaoDAO(){
        
        con = ConnectionFactory.getConnection();
    }

    public List<ConciliacaoDespesa> listarDespesaNaoConciliada() {
        String sql = "select c.data_emissao as data_emissao,c.nr_docto,c. id_fornecedor, pes.nome as nome_fornecedor, pes.doc_fornecedor as doc_fornecedor, c.cheque,c.vlr_liquido, c.id_ano,a.id,a.ano, c.conciliado, c.id_numconta,ct.numConta, c.id_uex, u.id as uid, u.uex from(tb_cpag c join tb_pessoa pes on(pes.id=c.id_fornecedor))join tb_uex u on(u.id = c.id_uex)join tb_ano a on(a.id = c.id_ano)join tb_trimestre t on(t.id= c.id_trimestre)join tb_conta ct on(ct.id = c.id_numconta)join tb_programa p on(p.id= c.id_programa) where c.conciliado=0 and c.id_programa=1";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoDespesa> nconc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConciliacaoDespesa cd = new ConciliacaoDespesa();
                
                cd.setData_emissao(rs.getDate("data_emissao"));
                cd.setNr_docto(rs.getString("nr_docto"));
                
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome_fornecedor"));
                f.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                cd.setFornecedor(f);
                
                
                
                cd.setCheque(rs.getString("cheque"));
                cd.setVlr_liquido(rs.getDouble("vlr_liquido"));
                cd.setConciliado(rs.getInt("conciliado"));
                
                nconc.add(cd);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nconc;
    }
   
    public List<ConciliacaoDespesa> listarDespesaConciliada() {
        String sql = "select c.data_emissao as data_emissao,c.nr_docto,c. id_fornecedor, pes.nome as nome_fornecedor, pes.doc_fornecedor as doc_fornecedor, c.cheque,c.vlr_liquido, c.id_ano,a.id,a.ano, c.conciliado, c.id_numconta,ct.numConta, c.id_uex, u.id as uid, u.uex from(tb_cpag c join tb_pessoa pes on(pes.id=c.id_fornecedor))join tb_uex u on(u.id = c.id_uex)join tb_ano a on(a.id = c.id_ano)join tb_trimestre t on(t.id= c.id_trimestre)join tb_conta ct on(ct.id = c.id_numconta)join tb_programa p on(p.id= c.id_programa) where c.conciliado=1 and c.id_programa=1";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoDespesa> conc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                        ConciliacaoDespesa cd = new ConciliacaoDespesa();
                
                cd.setData_emissao(rs.getDate("data_emissao"));
                cd.setNr_docto(rs.getString("nr_docto"));
                
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome_fornecedor"));
                f.setDoc_fornecedor(rs.getString("doc_fornecedor"));
                cd.setFornecedor(f);
                
                
                
                cd.setCheque(rs.getString("cheque"));
                cd.setVlr_liquido(rs.getDouble("vlr_liquido"));
                cd.setConciliado(rs.getInt("conciliado"));
                
                conc.add(cd);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return conc;
    }

    public List<ConciliacaoReceita> listarReceitaNaoConciliada() {
        String sql = "select c.data_entrada,c.num_doc,c.vlr_receita, c.historico, c.conciliado, c.id_conta, ct.numConta as conta, c.id_programa, p.id, p.programa AS programa, c.id_uex, u.id as uid, u.uex AS uex, c.id_trimestre, t.id, t.trimestre AS trimestre,c.id_ano, a.id, a.ano from(tb_crec c join tb_uex u on(u.id = c.id_uex)join tb_ano a on(a.id = c.id_ano)join tb_trimestre t on(t.id= c.id_trimestre)join tb_conta ct on(ct.id = c.id_conta)join tb_programa p on(p.id= c.id_programa)) where c.conciliado=0 and c.id_programa=1";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoReceita> nconc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConciliacaoReceita cr = new ConciliacaoReceita();
                
                cr.setData_entrada(rs.getDate("data_entrada"));
                cr.setNum_doc(rs.getString("num_doc"));
                cr.setVlr_receita(rs.getDouble("vlr_receita"));
                cr.setHistorico(rs.getString("historico"));
                cr.setConciliado(rs.getString("conciliado"));
                
                Conta conta = new Conta();
                conta.setId(rs.getInt("id_conta"));
                conta.setConta(rs.getString("conta"));
                cr.setConta(conta);
                
                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                conta.setConta(rs.getString("trimestre"));
                cr.setConta(conta);
                
                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                a.setAno(rs.getString("ano"));
                cr.setAno(a);
                
                Programa p = new Programa();
                p.setId(rs.getInt("id_programa"));
                p.setPrograma("programa");
                cr.setPrograma(p);
                
                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                u.setUex("uex");
                cr.setUex(u);
                
                
                nconc.add(cr);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nconc;
    }
   
    public List<ConciliacaoReceita> listarReceitaConciliada() {
        String sql = "select c.data_entrada,c.num_doc,c.vlr_receita, c.historico, c.conciliado, c.id_conta, ct.numConta as conta, c.id_programa, p.id, p.programa AS programa, c.id_uex, u.id as uid, u.uex AS uex, c.id_trimestre, t.id, t.trimestre AS trimestre,c.id_ano, a.id, a.ano from(tb_crec c join tb_uex u on(u.id = c.id_uex)join tb_ano a on(a.id = c.id_ano)join tb_trimestre t on(t.id= c.id_trimestre)join tb_conta ct on(ct.id = c.id_conta)join tb_programa p on(p.id= c.id_programa)) where c.conciliado=1 and c.id_programa=1";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoReceita> nconc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConciliacaoReceita cr = new ConciliacaoReceita();
                
                cr.setData_entrada(rs.getDate("data_entrada"));
                cr.setNum_doc(rs.getString("num_doc"));
                cr.setVlr_receita(rs.getDouble("vlr_receita"));
                cr.setHistorico(rs.getString("historico"));
                cr.setConciliado(rs.getString("conciliado"));
                
                Conta conta = new Conta();
                conta.setId(rs.getInt("id_conta"));
                conta.setConta(rs.getString("conta"));
                cr.setConta(conta);
                
                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                conta.setConta(rs.getString("trimestre"));
                cr.setConta(conta);
                
                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                a.setAno(rs.getString("ano"));
                cr.setAno(a);
                
                Programa p = new Programa();
                p.setId(rs.getInt("id_programa"));
                p.setPrograma("programa");
                cr.setPrograma(p);
                
                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                u.setUex("uex");
                cr.setUex(u);
                
                nconc.add(cr);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nconc;
    }
   

}    
