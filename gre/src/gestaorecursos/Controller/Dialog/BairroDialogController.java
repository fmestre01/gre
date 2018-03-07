package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.BairroDAO;
import gestaorecursos.model.DAO.MunicipioDAO;
import gestaorecursos.model.DAO.PaisDAO;
import gestaorecursos.model.DAO.TipoPessoaDAO;
import gestaorecursos.model.DAO.UfDAO;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Uf;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class BairroDialogController implements Initializable {

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtFieldBairro;

    @FXML
    private ComboBox<Municipio> cbxCidade;
    private List<Municipio> listMunicipios = new ArrayList<>();
    private ObservableList<Municipio> obsMunicipios;

    @FXML
    private ComboBox<Uf> cbxUf;
    private List<Uf> listUf = new ArrayList<>();
    private ObservableList<Uf> obsUf;

    @FXML
    private Button btnConfirmar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Bairro bairro;

    //Atributos para manipulação de Banco de Dados
    private final BairroDAO bairroDao = new BairroDAO();
    private final MunicipioDAO municipioDao = new MunicipioDAO();
    private final UfDAO ufDao = new UfDAO();
    private final PaisDAO paisDao = new PaisDAO();
    private final TipoPessoaDAO tipoPessoaDao = new TipoPessoaDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMunicipio();
        carregarUf();
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
        this.txtFieldBairro.setText(bairro.getBairro());
        
    }
    
    public void carregarMunicipio(){
            Municipio cbt = new Municipio();
            listMunicipios = municipioDao.listar();
            obsMunicipios = FXCollections.observableArrayList(listMunicipios);

            cbxCidade.setItems(obsMunicipios);
    }

    public void carregarUf(){
            Uf cbt = new Uf();
            listUf = ufDao.listar();
            obsUf = FXCollections.observableArrayList(listUf);

            cbxUf.setItems(obsUf);
    }
    
    @FXML
    public void handleBtnConfirmar(){
        bairro.setBairro(txtFieldBairro.getText());
        bairro.setMunicipio(cbxCidade.getValue());
        bairro.setUf(cbxUf.getValue());

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

        if (txtFieldBairro.getText() == null || txtFieldBairro.getText().length() == 0) {
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
