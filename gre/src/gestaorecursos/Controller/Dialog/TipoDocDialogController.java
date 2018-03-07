package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.domain.TipoDoc;
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
public class TipoDocDialogController implements Initializable {

    @FXML
    private TextField txtFieldTipoDoc;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private TipoDoc tipodoc;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        public TextField getTxtFieldTipoDoc() {
        return txtFieldTipoDoc;
    }

    public void setTxtFieldTipoDoc(TextField txtFieldTipoDoc) {
        this.txtFieldTipoDoc = txtFieldTipoDoc;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public TipoDoc getTipoDoc() {
        return tipodoc;
    }

    public void setTipoDoc(TipoDoc tipodoc) {
        this.tipodoc = tipodoc;
        this.txtFieldTipoDoc.setText(tipodoc.getTipo_doc());
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    @FXML
    public void handleBtnConfirmar() {
        tipodoc.setTipo_doc(txtFieldTipoDoc.getText());

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

        if (txtFieldTipoDoc.getText() == null || txtFieldTipoDoc.getText().length() == 0) {
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
