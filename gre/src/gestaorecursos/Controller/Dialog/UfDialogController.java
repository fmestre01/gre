package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.domain.Uf;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author mgonc
 */

public class UfDialogController implements Initializable {

    
    @FXML
    private TextField txtFieldEstado;

    @FXML
    private TextField txtFieldUF;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lbEstado;

    @FXML
    private Label lbUf;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Uf uf;

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
    
    public Button getBtnConfirmar() {
        return btnConfirmar;
    }

    public void setBtnConfirmar(Button btnConfirmar) {
        this.btnConfirmar = btnConfirmar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(Button btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    


    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
        this.txtFieldUF.setText(uf.getUf());
        this.txtFieldEstado.setText(uf.getEstado());
    }

    @FXML
    public void handleBtnConfirmar(){
        uf.setUf(txtFieldUF.getText());
        uf.setEstado(txtFieldEstado.getText());
        
        buttonConfirmarClicked = true;
        dialogStage.close();    
    }
    
    @FXML
    public void handleBtnCancelar(){
        dialogStage.close();
    }
}
