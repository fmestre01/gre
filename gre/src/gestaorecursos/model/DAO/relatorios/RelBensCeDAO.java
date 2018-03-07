package gestaorecursos.model.DAO.relatorios;

import gestaorecursos.model.DAO.PagamentosDAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgonc
 */
public class RelBensCeDAO {

  private Connection con = null;

    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection connection) {
        this.con = connection;
    }

    public RelBensCeDAO() {

        con = ConnectionFactory.getConnection();

    }

    public List<Bem> listar() {
        String sql = "SELECT * FROM tb_bem";
        List<Bem> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bem bem = new Bem();
                bem.setId(rs.getInt("id"));
                bem.setDescricao(rs.getString("descricao"));
                bem.setVlr_unit(rs.getDouble("vlr_unit"));
                bem.setQuantidade(rs.getInt("qtd"));
                
                Uex uex = new Uex();
                uex.setId(rs.getInt("id_uex"));
                bem.setUex(uex);
                
                Ano ano = new Ano();
                ano.setId(rs.getInt("id_ano"));
                bem.setAno(ano);
                
                Trimestre t = new Trimestre();
                t.setId(rs.getInt("id"));
                bem.setTrimestre(t);
                retorno.add(bem);
                
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
