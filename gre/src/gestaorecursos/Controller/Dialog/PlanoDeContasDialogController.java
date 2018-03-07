package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.domain.PlanoDeContas;
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
public class PlanoDeContasDialogController implements Initializable {
    
    
    @FXML
    private TextField txtFieldNome;

    @FXML
    private TextField txtFieldConta;

    @FXML
    private TextField txtFieldNatureza;

    @FXML
    private TextField txtFieldClasse;

    @FXML
    private TextField txtFieldGrupo;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private PlanoDeContas pContas;
    
    
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

    public PlanoDeContas getpContas() {
        return pContas;
    }

    public void setpContas(PlanoDeContas pContas) {
        this.pContas = pContas;
        this.txtFieldConta.setText(pContas.getCod_reduzido());
        this.txtFieldNome.setText(pContas.getNome_conta());
        this.txtFieldNatureza.setText(pContas.getNatureza());
        this.txtFieldClasse.setText(pContas.getClasse());
        this.txtFieldGrupo.setText(pContas.getGrupo());
    }
    
    @FXML
    public void handleBtnConfirmar(){
      
        pContas.setCod_reduzido(txtFieldConta.getText());
        pContas.setNome_conta(txtFieldNome.getText());
        pContas.setNatureza(txtFieldNatureza.getText());
        pContas.setClasse(txtFieldClasse.getText());
        pContas.setGrupo(txtFieldGrupo.getText());
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

        if (txtFieldConta.getText() == null || txtFieldConta.getText().length() == 0) {
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
