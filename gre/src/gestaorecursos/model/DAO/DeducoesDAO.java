package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Deducoes;
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
import javafx.scene.control.Alert;

/**
 * @author mgonc
 */
public class DeducoesDAO {
    
    private Connection con = null;
    
    public Connection getConnection() {
        return con;
    }
    
    public void setConnection(Connection connection) {
        this.con = connection;
    }
    
    public DeducoesDAO() {
        
        con = ConnectionFactory.getConnection();
        
    }
    
    public boolean inserir(Deducoes d) {
        String sql = "INSERT INTO tb_deduc(data_deducao, num_doc,historico_deducao,vlr_deducao, id_programa, id_uex, id_ano, id_trimestre) VALUES(?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(d.getData_deducao().getTime()));
            stmt.setString(2, d.getNum_doc());
            stmt.setString(3, d.getHistorico());
            stmt.setDouble(4, d.getVlr_deducao());
            stmt.setInt(5, d.getPrograma().getId());
            stmt.setInt(6, d.getUex().getId());
            stmt.setInt(7, d.getAno().getId());
            stmt.setInt(8, d.getTrimestre().getId());
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
            // } finally {
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean alterar(Deducoes d) {
        String sql = "UPDATE tb_deduc SET data_deducao=?, num_doc=?, historico_deducao=?, vlr_deducao=?, id_programa, id_uex=?, id_ano=?, id_trimestre=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(d.getData_deducao().getTime()));
            stmt.setString(2, d.getNum_doc());
            stmt.setString(3, d.getHistorico());
            stmt.setDouble(4, d.getVlr_deducao());
            stmt.setInt(5, d.getPrograma().getId());
            stmt.setInt(4, d.getUex().getId());
            stmt.setInt(5, d.getAno().getId());
            stmt.setInt(6, d.getTrimestre().getId());
            stmt.setInt(7, d.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean remover(Deducoes deducoes) {
        
        String sql = "DELETE FROM tb_deduc WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, deducoes.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            // }finally{
            //   ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Deducoes> listar() throws Exception {
        String sql = "SELECT * FROM tb_deduc";
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Deducoes> deducoess = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Deducoes d = new Deducoes();
                d.setId(rs.getInt("id"));
                d.setData_deducao(rs.getDate("data_deducao"));
                d.setNum_doc(rs.getString("num_doc"));
                d.setHistorico(rs.getString("historico_deducao"));
                d.setVlr_deducao(rs.getDouble("vlr_deducao"));
                
                Programa p = new Programa();
                p.setId(rs.getInt("id_programa"));
                d.setPrograma(p);
                
                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                d.setUex(u);
                
                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                d.setAno(a);
                
                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                d.setTrimestre(t);
                
                deducoess.add(d);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
//        } finally {
            //          ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return deducoess;
    }
    
}
