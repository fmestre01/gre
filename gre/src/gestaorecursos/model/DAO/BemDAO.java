package gestaorecursos.model.DAO;

import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Bem;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 * @author mgonc
 */
public class BemDAO {

    private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    
    public BemDAO(){
        
        con = ConnectionFactory.getConnection();
        
        
    }
    
    public boolean inserir(Bem b)  {
        String sql = "INSERT INTO tb_bem(descricao,vlr_unit,qtd,id_uex,id_ano,id_trimestre) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement stmt=null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, b.getDescricao());
            stmt.setDouble(2, b.getVlr_unit());
            stmt.setInt(3, b.getQuantidade());
            stmt.setInt(4, b.getUex().getId());
            stmt.setInt(5, b.getAno().getId());
            stmt.setInt(6, b.getTrimestre().getId());
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
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean alterar(Bem b) {
        String sql = "UPDATE tb_bem SET descricao=?, vlr_unit=?, qtd=?, id_uex=?, id_ano=?, id_trimestre=? WHERE id=?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, b.getDescricao());
            stmt.setDouble(2, b.getVlr_unit());
            stmt.setInt(3, b.getQuantidade());
            stmt.setInt(4, b.getUex().getId());
            stmt.setInt(5, b.getAno().getId());
            stmt.setInt(6, b.getTrimestre().getId());
            stmt.setInt(7, b.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
        //}finally{
        //    ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean remover(Bem bem) {
        
        String sql = "DELETE FROM tb_bem WHERE id=?";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, bem.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro:"+ex);
            return false;
       // }finally{
       //   ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Bem> listar() {
        String sql = "SELECT * FROM tb_bem";

        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Bem> bems = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Bem b = new Bem();
                b.setId(rs.getInt("id"));
                b.setDescricao(rs.getString("descricao"));
                b.setVlr_unit(rs.getDouble("vlr_unit"));
                b.setQuantidade(rs.getInt("qtd"));
                
                Uex u = new Uex();
                u.setId(rs.getInt("id_uex"));
                b.setUex(u);
                
                Ano a = new Ano();
                a.setId(rs.getInt("id_ano"));
                b.setAno(a);
                
                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id_trimestre"));
                b.setTrimestre(t);
                
                bems.add(b);
            }
        } catch (SQLException ex) {
            System.err.println("Erro :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return bems;
    }

    public Bem buscar(Bem bem) {
        String sql = "SELECT * FROM tb_bem WHERE =?";
        Bem retorno = new Bem();
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, bem.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                bem.setDescricao(resultado.getString("descricao"));
                retorno = bem;
            }
        } catch (SQLException ex) {
             System.err.println("Erro :"+ex);
        }
        return retorno;
    }    

}
