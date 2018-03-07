package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.sr.SaldosSR;
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
public class SRSaldosDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public SRSaldosDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean inserir(SaldosSR s) {
        String sql = "INSERT INTO tb_srsaldos(data, sdo_inicial,vlr_repasse,vlr_aplicacao,vlr_rendAplicacao,vlr_poupanca,sdo_investimentos,id_conta,id_programa, id_uex, id_ano, id_trimestre) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(s.getData().getTime()));
            stmt.setDouble(2, s.getSdo_inicial());
            stmt.setDouble(3, s.getVlr_repasse());
            stmt.setDouble(4, s.getVlr_aplicacao());
            stmt.setDouble(5, s.getVlr_renAplicacao());
            stmt.setDouble(6, s.getVlr_poupanca());
            stmt.setDouble(7, s.getSdo_investimentos());
            stmt.setInt(8, s.getConta().getId());
            stmt.setInt(9, s.getPrograma().getId());
            stmt.setInt(10, s.getUex().getId());
            stmt.setInt(11, s.getAno().getId());
            stmt.setInt(12, s.getTrimestre().getId());
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

    public boolean alterar(SaldosSR s) {
        String sql = "UPDATE tb_srsaldos SET data=?, sdo_inicial=?, vlr_repasse=?, vlr_aplicacao=?,vlr_rendAplicacao=?,vlr_poupanca=?,sdo_investimentos=?, id_conta=?, id_programa=?, id_uex=?, id_ano=?, id_trimestre=? WHERE id=?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, new Date(s.getData().getTime()));
            stmt.setDouble(2, s.getSdo_inicial());
            stmt.setDouble(3, s.getVlr_repasse());
            stmt.setDouble(4, s.getVlr_aplicacao());
            stmt.setDouble(5, s.getVlr_renAplicacao());
            stmt.setDouble(6, s.getVlr_poupanca());
            stmt.setDouble(7, s.getSdo_investimentos());
            stmt.setInt(8, s.getConta().getId());
            stmt.setInt(9, s.getPrograma().getId());
            stmt.setInt(10, s.getUex().getId());
            stmt.setInt(11, s.getAno().getId());
            stmt.setInt(12, s.getTrimestre().getId());
            stmt.setInt(13, s.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            //}finally{
            //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(SaldosSR s) {

        String sql = "DELETE FROM tb_srsaldos WHERE id=?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, s.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:" + ex);
            return false;
            // }finally{
            //   ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<SaldosSR> listar() throws Exception {
        String sql = "SELECT * FROM tb_srsaldos";

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<SaldosSR> saldoss = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SaldosSR s = new SaldosSR();
                s.setId(rs.getInt("id"));
                s.setData(rs.getDate("data"));

                s.setSdo_inicial(rs.getDouble("vlr_deducao"));
                s.setVlr_repasse(rs.getDouble("vlr_repasse"));
                s.setVlr_aplicacao(rs.getDouble("vlr_aplicacao"));
                s.setVlr_renAplicacao(rs.getDouble("vlr_rendAplicao"));
                s.setVlr_poupanca(rs.getDouble("vlr_poupanca"));
                s.setSdo_investimentos(rs.getDouble("sdo_investimentos"));

                Conta c = new Conta();
                c.setId(rs.getInt("id_conta"));
                s.setConta(c);

                Programa p = new Programa();
                p.setId(rs.getInt("id_programa"));
                s.setPrograma(p);

                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                s.setUex(u);

                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                s.setAno(a);

                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                s.setTrimestre(t);

                saldoss.add(s);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
//        } finally {
            //          ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return saldoss;
    }

}
