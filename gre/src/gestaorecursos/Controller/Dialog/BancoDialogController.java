package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.domain.Banco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class BancoDialogController implements Initializable {

    @FXML
    private TextField txtFieldNumBanco;

    @FXML
    private TextField txtFieldBanco;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Banco banco;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
        this.txtFieldBanco.setText(banco.getBanco());
        this.txtFieldNumBanco.setText(banco.getNumBanco());
    }
    @FXML
    public void handleBtnConfirmar(){
        banco.setBanco(txtFieldBanco.getText());
        banco.setNumBanco(txtFieldNumBanco.getText());
        buttonConfirmarClicked = true;
        dialogStage.close();    
    }
    
    @FXML
    public void handleBtnCancelar(){
        dialogStage.close();
    }


    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (txtFieldBanco.getText() == null || txtFieldBanco.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
