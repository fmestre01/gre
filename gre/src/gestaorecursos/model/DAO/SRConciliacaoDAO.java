package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.sr.ConciliacaoSR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mgonc
 */
public class SRConciliacaoDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }
    public SRConciliacaoDAO(){
        
        con = ConnectionFactory.getConnection();
    }

    public List<ConciliacaoSR> listarNaoConciliados() {
        String sql = "SELECT * FROM tb_srcpag WHERE conciliado=0";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoSR> nconc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConciliacaoSR c = new ConciliacaoSR();
                c.setId(rs.getInt("id"));
                c.setData_emissao(rs.getDate("data_emissao"));
                c.setFornecedor(rs.getString("id_fornecedor"));
                
                c.setCheque(rs.getString("cheque"));
                c.setVlr_liquido(rs.getDouble("vlr_liquido"));
                c.setConciliado(rs.getInt("conciliado"));
                
                nconc.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nconc;
    }
   
    public List<ConciliacaoSR> listarConciliados() {
        String sql = "SELECT * FROM tb_srcpag WHERE conciliado=1";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoSR> conc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConciliacaoSR c = new ConciliacaoSR();
                c.setId(rs.getInt("id"));
                c.setData_emissao(rs.getDate("data_emissao"));
                c.setFornecedor(rs.getString("id_fornecedor"));
                
                c.setCheque(rs.getString("cheque"));
                c.setVlr_liquido(rs.getDouble("vlr_liquido"));
                c.setConciliado(rs.getInt("conciliado"));
                
                conc.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return conc;
    }

    public List<ConciliacaoSR> listarRec() {
        String sql = "SELECT * FROM tb_srcpag WHERE conciliado=0";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<ConciliacaoSR> nconc = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConciliacaoSR c = new ConciliacaoSR();
                c.setId(rs.getInt("id"));
                c.setData_emissao(rs.getDate("data_emissao"));
                c.setFornecedor(rs.getString("id_fornecedor"));
                
                c.setCheque(rs.getString("cheque"));
                c.setVlr_liquido(rs.getDouble("vlr_liquido"));
                c.setConciliado(rs.getInt("conciliado"));
                
                nconc.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nconc;
    }
    
}
