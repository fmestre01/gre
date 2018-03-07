package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.MunicipioDAO;
import gestaorecursos.model.DAO.UfDAO;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Uf;
import gestaorecursos.model.domain.component.AutoCompleteComboBoxListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class MunicipiosDialogController implements Initializable {
    
    @FXML
    private TextField txtFieldMunicipio;

    @FXML
    private ComboBox<Uf> cbxUf;
    private List<Uf> listUf = new ArrayList<>();
    private ObservableList<Uf> obsUf;



    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Municipio municipio;
    
    //Atributos para manipulação de Banco de Dados
    private final MunicipioDAO municipioDao = new MunicipioDAO();
    private final UfDAO ufDao = new UfDAO();
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarUf();
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

    
    public Municipio getMunicipio() {
        return municipio;
    }

    
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
        this.txtFieldMunicipio.setText(municipio.getCidade());
        
        
    }
    
        public void carregarUf(){
            new AutoCompleteComboBoxListener(cbxUf);
            Uf cbt = new Uf();
            listUf = ufDao.listar();
            obsUf = FXCollections.observableArrayList(listUf);

            cbxUf.setItems(obsUf);
    }

    
    @FXML
    public void handleBtnConfirmar(){
        municipio.setCidade(txtFieldMunicipio.getText());
        municipio.setUf(cbxUf.getValue());
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

        if (txtFieldMunicipio.getText() == null || txtFieldMunicipio.getText().length() == 0) {
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
