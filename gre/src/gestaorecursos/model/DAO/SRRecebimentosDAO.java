package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.sr.RecebimentosSR;
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
public class SRRecebimentosDAO {


 private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public SRRecebimentosDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(RecebimentosSR d) {
        String sql = "INSERT INTO tb_srcrec(data_entrada,num_doc,historico,vlr_receita,id_programa,id_uex,id_ano,id_trimestre,id_conta) VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(d.getData_entrada().getTime()));
            stmt.setString(2, d.getNum_doc());
            stmt.setString(3, d.getHistorico());
            stmt.setDouble(4, d.getVlr_receita());
            stmt.setInt(5, d.getPrograma().getId());
            stmt.setInt(6, d.getUex().getId());
            stmt.setInt(7, d.getAno().getId());
            stmt.setInt(8, d.getTrimestre().getId());
            stmt.setInt(9, d.getConta().getId());
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

    public boolean alterar(RecebimentosSR d) {
        String sql = "UPDATE tb_srcrec SET data_entrada=?, num_doc=?, historico=?, vlr_receita=?, id_programa=?, id_uex=?, id_ano=?, id_trimestre=?, id_conta=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(d.getData_entrada().getTime()));
            stmt.setString(2, d.getNum_doc());
            stmt.setString(3, d.getHistorico());
            stmt.setDouble(4, d.getVlr_receita());
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

    public boolean remover(RecebimentosSR recebimentos) {

        String sql = "DELETE FROM tb_srcrec WHERE id=?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, recebimentos.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            // }finally{
            //   ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<RecebimentosSR> listar() throws Exception {
        String sql = "SELECT * FROM tb_srcrec";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<RecebimentosSR> recebimentoss = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                RecebimentosSR d = new RecebimentosSR();
                d.setId(rs.getInt("id"));
                d.setData_entrada(rs.getDate("data_entrada"));
                d.setNum_doc(rs.getString("num_doc"));
                d.setHistorico(rs.getString("historico"));
                d.setVlr_receita(rs.getDouble("vlr_deducao"));

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

                recebimentoss.add(d);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
//        } finally {
            //          ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return recebimentoss;
    }

    
}
