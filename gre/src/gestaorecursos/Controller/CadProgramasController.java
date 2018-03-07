package gestaorecursos.Controller;

import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.domain.Programa;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class CadProgramasController implements Initializable {

    @FXML
    private Label labelPrograma;
    
    @FXML
    private TextField txtFieldPrograma;
    
    @FXML
    private Button btnInserir;
    
    
        //Atributos para manipulação de Banco de Dados
    private final ProgramaDAO programaDAO = new ProgramaDAO();

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleBtnInserir() throws IOException {
    
        Programa programa = new Programa();
        ProgramaDAO dao = new ProgramaDAO();
        programa.setPrograma(txtFieldPrograma.getText());
        dao.inserir(programa);
    }

}
