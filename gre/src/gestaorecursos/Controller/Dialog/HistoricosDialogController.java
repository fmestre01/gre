package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.HistoricoDAO;
import gestaorecursos.model.domain.Historico;
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



public class HistoricosDialogController implements Initializable {

    @FXML
    private TextField txtFieldHistorico;

    @FXML
    private TextField txtFieldCtaDeb;

    @FXML
    private TextField txtFieldCtaCred;


    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Historico historico;
    
    //Atributos para manipulação de Banco de Dados
    private final HistoricoDAO historicoDao = new HistoricoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
        this.txtFieldHistorico.setText(historico.getHistorico());
        this.txtFieldCtaDeb.setText(historico.getContadeb());
        this.txtFieldCtaCred.setText(historico.getContacred());
    }

    
    @FXML
    public void handleBtnConfirmar(){
        historico.setHistorico(txtFieldHistorico.getText());
        historico.setContadeb(txtFieldCtaDeb.getText());
        historico.setContacred(txtFieldCtaCred.getText());

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

        if (txtFieldHistorico.getText() == null || txtFieldHistorico.getText().length() == 0) {
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
