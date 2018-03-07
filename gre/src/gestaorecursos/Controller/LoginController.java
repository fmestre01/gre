package gestaorecursos.Controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class LoginController implements Initializable {

    @FXML
    private Label labelUsuario;

    @FXML
    private TextField txtFieldUsuario;

    @FXML
    private Label labelSenha;

    @FXML
    private PasswordField passwordFieldSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSair;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}
