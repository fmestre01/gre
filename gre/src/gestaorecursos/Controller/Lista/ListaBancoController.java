package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.BancoDialogController;
import gestaorecursos.model.DAO.BancoDAO;
import gestaorecursos.model.domain.Banco;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class ListaBancoController implements Initializable {
    @FXML
    private TableView<Banco> tbViewBanco;

    @FXML
    private TableColumn<Banco, String> tbColNumBanco;

    @FXML
    private TableColumn<Banco, String> tbColBanco;

    @FXML
    private Label lbID;

    @FXML
    private Label lbNumBanco;

    @FXML
    private Label lbBanco;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    private List<Banco> listBancos;
    private ObservableList<Banco> observableListBancos;
    
    //Atributos para manipulação de Banco de Dados
    private final BancoDAO bancoDAO = new BancoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bancoDAO.getConnection();
        carregarTableViewBancos();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewBanco.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewBanco(newValue));
    }

    public void carregarTableViewBancos() {
        tbColNumBanco.setCellValueFactory(new PropertyValueFactory<>("numBanco"));
        tbColBanco.setCellValueFactory(new PropertyValueFactory<>("banco"));

        listBancos = bancoDAO.listar();

        observableListBancos = FXCollections.observableArrayList(listBancos);
        tbViewBanco.setItems(observableListBancos);

    }

    public void selecionarItemTbViewBanco(Banco banco) {
        if (banco != null) {
            lbID.setText(String.valueOf(banco.getId()));
            lbNumBanco.setText(String.valueOf(banco.getNumBanco()));
            lbBanco.setText(banco.getBanco());

        } else {
            lbID.setText("");
            lbNumBanco.setText("");
            lbBanco.setText("");
        }
    }

    @FXML
    public void handleBtnInserir() throws IOException {
        Banco banco = new Banco();
        boolean buttonConfirmarClicked = showBancosDialog(banco);
        if (buttonConfirmarClicked) {
            bancoDAO.inserir(banco);
            carregarTableViewBancos();
        }
    }

    @FXML
    public void handleBtnAlterar() throws IOException {
        Banco banco = tbViewBanco.getSelectionModel().getSelectedItem();
        if (banco != null) {
            boolean buttonConfirmarClicked = showBancosDialog(banco);
            if (buttonConfirmarClicked) {
                bancoDAO.alterar(banco);
                carregarTableViewBancos();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnExcluir() throws IOException {
        Banco banco = tbViewBanco.getSelectionModel().getSelectedItem();
        if (banco != null) {
            bancoDAO.remover(banco);
            carregarTableViewBancos();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    public boolean showBancosDialog(Banco banco) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(BancoDialogController.class.getResource("/gestaorecursos/views/banco/BancoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Bancos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        BancoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setBanco(banco);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
