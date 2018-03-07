package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.domain.TipoEntidade;
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
public class TipoEntidadeDialogController implements Initializable {

    @FXML
    private TextField txtFieldTipoEntidade;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private TipoEntidade tipoentidade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public TextField getTxtFieldTipoEntidade() {
        return txtFieldTipoEntidade;
    }

    public void setTxtFieldTipoEntidade(TextField txtFieldTipoEntidade) {
        this.txtFieldTipoEntidade = txtFieldTipoEntidade;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public TipoEntidade getTipoentidade() {
        return tipoentidade;
    }

    public void setTipoentidade(TipoEntidade tipoentidade) {
        this.tipoentidade = tipoentidade;
        this.txtFieldTipoEntidade.setText(tipoentidade.getTipoEntidade());
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    @FXML
    public void handleBtnConfirmar() {
        tipoentidade.setTipoEntidade(txtFieldTipoEntidade.getText());

        buttonConfirmarClicked = true;
        dialogStage.close();
    }

    @FXML
    public void handleBtnCancelar() {
        dialogStage.close();
    }

    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (txtFieldTipoEntidade.getText() == null || txtFieldTipoEntidade.getText().length() == 0) {
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
