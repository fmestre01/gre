package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.FornecedorDialogController;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.domain.Fornecedor;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class ListaFornecedorController implements Initializable {

    @FXML
    private TableView<Fornecedor> tbViewFornecedor;

    @FXML
    private TableColumn<Fornecedor, String> tbColFornecedor;

    @FXML
    private TableColumn<Fornecedor, String> tbColCnpj;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Label lbID;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbNomeFantasia;

    @FXML
    private Label lbCnpj;

    @FXML
    private Label lbCcm;

    @FXML
    private Label lbIEstadual;

    @FXML
    private Label lbCpf;

    @FXML
    private Label lbIdentidade;

    @FXML
    private Label lbEndereco;

    @FXML
    private Label lbEndNum;

    @FXML
    private Label lbEndCompl;

    @FXML
    private Label lbCep;

    @FXML
    private Label lbBairro;

    @FXML
    private Label lbCidade;

    @FXML
    private Label lbUf;

    @FXML
    private Label lbPais;

    @FXML
    private Label lbTelefone;

    @FXML
    private Label lbCelular;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbSite;

    private List<Fornecedor> listFornecedor;

    private ObservableList<Fornecedor> observableListFornecedor;

    //Atributos para manipulação de Banco de Dados
    private final FornecedorDAO fornecedorDAO = new FornecedorDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fornecedorDAO.getConnection();
        carregarTableViewFornecedor();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewFornecedor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewFornecedor(newValue));

    }

    public void carregarTableViewFornecedor() {
        tbColCnpj.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
        tbColFornecedor.setCellValueFactory(new PropertyValueFactory<>("nome"));

        listFornecedor = fornecedorDAO.listarpj();

        observableListFornecedor = FXCollections.observableArrayList(listFornecedor);
        tbViewFornecedor.setItems(observableListFornecedor);

    }

    public void selecionarItemTbViewFornecedor(Fornecedor fornecedor) {
        if (fornecedor != null) {
            lbID.setText(String.valueOf(fornecedor.getId()));
            lbNome.setText(fornecedor.getNome());
            lbNomeFantasia.setText(fornecedor.getNomeFantasia());
            lbCnpj.setText(fornecedor.getDoc_fornecedor());
            lbCcm.setText(fornecedor.getCcm());
            lbIEstadual.setText(fornecedor.getInscrEstadual());
            lbCpf.setText(fornecedor.getCpf());
            lbIdentidade.setText(fornecedor.getIdentidade());
            lbEndereco.setText(fornecedor.getEndRua());
            lbEndNum.setText(fornecedor.getEndNum());
            lbEndCompl.setText(fornecedor.getEndCompl());
            lbCep.setText(fornecedor.getCep());
            lbBairro.setText(String.valueOf(fornecedor.getBairro().getId()));
            lbCidade.setText(String.valueOf(fornecedor.getCidade().getId()));
            lbUf.setText(String.valueOf(fornecedor.getUf().getId()));
            lbPais.setText(String.valueOf(fornecedor.getPais().getId()));
            lbTelefone.setText(fornecedor.getTelFixo());
            lbCelular.setText(fornecedor.getTelCel());
            lbEmail.setText(fornecedor.getEmail());
            lbSite.setText(fornecedor.getSite());

        } else {
            lbID.setText("");
            lbNome.setText("");
            lbNomeFantasia.setText("");
            lbCnpj.setText("");
            lbCcm.setText("");
            lbIEstadual.setText("");
            lbCpf.setText("");
            lbIdentidade.setText("");
            lbEndereco.setText("");
            lbEndNum.setText("");
            lbEndCompl.setText("");
            lbCep.setText("");
            lbBairro.setText("");
            lbCidade.setText("");
            lbUf.setText("");
            lbPais.setText("");
            lbTelefone.setText("");
            lbCelular.setText("");
            lbEmail.setText("");
            lbSite.setText("");
        }
    }


    @FXML
    public void handleBtnInserir(ActionEvent event) throws IOException {
        Fornecedor fornecedor = new Fornecedor();
        boolean buttonConfirmarClicked = showFornecedorDialog(fornecedor);
        if (buttonConfirmarClicked) {
            fornecedorDAO.inserir(fornecedor);
            carregarTableViewFornecedor();
        }

    }

    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException {
        Fornecedor fornecedor = tbViewFornecedor.getSelectionModel().getSelectedItem();
        if (fornecedor != null) {
            boolean buttonConfirmarClicked = showFornecedorDialog(fornecedor);
            if (buttonConfirmarClicked) {
                fornecedorDAO.alterar(fornecedor);
                carregarTableViewFornecedor();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException {
        Fornecedor fornecedor = tbViewFornecedor.getSelectionModel().getSelectedItem();
        if (fornecedor != null) {
            fornecedorDAO.remover(fornecedor);
            carregarTableViewFornecedor();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    public boolean showFornecedorDialog(Fornecedor fornecedor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FornecedorDialogController.class.getResource("/gestaorecursos/views/fornecedor/FornecedorDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Fornecedores");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        FornecedorDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setFornecedor(fornecedor);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
