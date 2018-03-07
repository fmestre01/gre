package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.domain.Programa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */



public class ProgramasDialogController implements Initializable {

    @FXML
    private Label lbPrograma;

    @FXML
    private TextField txtFieldPrograma;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Programa programa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    /**
     * @return the dialogStage
     */
    public Stage getDialogStage() {
        return dialogStage;
    }

    /**
     * @param dialogStage the dialogStage to set
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * @return the buttonConfirmarClicked
     */
    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    /**
     * @param buttonConfirmarClicked the buttonConfirmarClicked to set
     */
    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    /**
     * @return the programa
     */
    public Programa getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(Programa programa) {
        this.programa = programa;
        this.txtFieldPrograma.setText(programa.getPrograma());
    }
    
    @FXML
    public void handleBtnConfirmar(){
        programa.setPrograma(txtFieldPrograma.getText());
        
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

        if (txtFieldPrograma.getText() == null || txtFieldPrograma.getText().length() == 0) {
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
