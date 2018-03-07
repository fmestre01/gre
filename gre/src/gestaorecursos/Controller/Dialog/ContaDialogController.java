package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.BancoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Banco;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Uex;
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
public class ContaDialogController implements Initializable {

    @FXML
    private TextField txtFieldConta;

    @FXML
    private TextField txtFieldAgencia;

    @FXML
    private ComboBox<Banco> cbxBanco;
    private List<Banco> listBanco = new ArrayList<>();
    private ObservableList<Banco> obsBanco;

    @FXML
    private ComboBox<Uex> cbxUex;
    private List<Uex> listUex = new ArrayList<>();
    private ObservableList<Uex> obsUex;

    @FXML
    private ComboBox<Programa> cbxPrograma;
    private List<Programa> listPrograma = new ArrayList<>();
    private ObservableList<Programa> obsPrograma;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Conta conta;

    //Atributos para manipulação de Banco de Dados
    private final BancoDAO bancoDao = new BancoDAO();
    private final ContaDAO contaDao = new ContaDAO();
    private final ProgramaDAO programaDao = new ProgramaDAO();
    private final UexDAO uexDao = new UexDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarBanco();
        carregarPrograma();
        carregarUex();
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
        this.txtFieldConta.setText(conta.getConta());
        this.txtFieldAgencia.setText(conta.getNumAgencia());
    }

    public void carregarBanco() {
        Banco cbt = new Banco();
        listBanco = bancoDao.listar();
        obsBanco = FXCollections.observableArrayList(listBanco);

        cbxBanco.setItems(obsBanco);
    }

    public void carregarPrograma() {
        Programa cbt = new Programa();
        listPrograma = programaDao.listar();
        obsPrograma = FXCollections.observableArrayList(listPrograma);

        cbxPrograma.setItems(obsPrograma);
    }

    public void carregarUex() {
        Uex cbt = new Uex();
        listUex = uexDao.listar();
        obsUex = FXCollections.observableArrayList(listUex);

        cbxUex.setItems(obsUex);
    }

    @FXML
    public void handleBtnConfirmar() {
        conta.setConta(txtFieldConta.getText());
        conta.setNumAgencia(txtFieldAgencia.getText());
        conta.setBanco(cbxBanco.getValue());
        conta.setPrograma(cbxPrograma.getValue());
        conta.setUex(cbxUex.getValue());
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
