package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.DirigenteDialogController;
import gestaorecursos.model.DAO.DirigenteDAO;
import gestaorecursos.model.domain.Dirigente;
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
public class ListaDirigenteController implements Initializable {

    @FXML
    private TableView<Dirigente> tbViewDirigente;

    @FXML
    private TableColumn<Dirigente, Integer> tbColEscola;

    @FXML
    private TableColumn<Dirigente, String> tbColDirigente;

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

    private List<Dirigente> listDirigente;

    private ObservableList<Dirigente> observableListDirigente;

    //Atributos para manipulação de Banco de Dados
    private final DirigenteDAO dirigenteDAO = new DirigenteDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dirigenteDAO.getConnection();
        carregarTableViewDirigente();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewDirigente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewDirigente(newValue));

    }

        public void carregarTableViewDirigente() {
        tbColEscola.setCellValueFactory(new PropertyValueFactory<>("uex"));
        tbColDirigente.setCellValueFactory(new PropertyValueFactory<>("nome"));

        listDirigente = dirigenteDAO.listarpf();

        observableListDirigente = FXCollections.observableArrayList(listDirigente);
        tbViewDirigente.setItems(observableListDirigente);

    }

    public void selecionarItemTbViewDirigente(Dirigente dirigente) {
        if (dirigente != null) {
            lbID.setText(String.valueOf(dirigente.getId()));
            lbNome.setText(dirigente.getNome());
            lbCnpj.setText(dirigente.getDoc_fornecedor());
            lbIdentidade.setText(dirigente.getIdentidade());
            lbEndereco.setText(dirigente.getEndRua());
            lbEndNum.setText(dirigente.getEndNum());
            lbEndCompl.setText(dirigente.getEndCompl());
            lbCep.setText(dirigente.getCep());
            lbBairro.setText(String.valueOf(dirigente.getBairro().getId()));
            lbCidade.setText(String.valueOf(dirigente.getMunicipio().getId()));
            lbUf.setText(String.valueOf(dirigente.getUf().getId()));

            lbTelefone.setText(dirigente.getTelFixo());
            lbCelular.setText(dirigente.getTelCel());
            lbEmail.setText(dirigente.getEmail());
            lbSite.setText(dirigente.getSite());

        } else {
            lbID.setText("");
            lbNome.setText("");
            lbNomeFantasia.setText("");
            lbCnpj.setText("");
            lbCcm.setText("");
            lbCnpj.setText("");
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
    public void handleBtnAlterar(ActionEvent event) throws IOException {
        Dirigente dirigente = tbViewDirigente.getSelectionModel().getSelectedItem();
        if (dirigente != null) {
            boolean buttonConfirmarClicked = showDirigenteDialog(dirigente);
            if (buttonConfirmarClicked) {
                dirigenteDAO.alterar(dirigente);
                carregarTableViewDirigente();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException {
        Dirigente dirigente = tbViewDirigente.getSelectionModel().getSelectedItem();
        if (dirigente != null) {
            dirigenteDAO.remover(dirigente);
            carregarTableViewDirigente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnInserir(ActionEvent event) throws IOException {
        Dirigente dirigente = new Dirigente();
        boolean buttonConfirmarClicked = showDirigenteDialog(dirigente);
        if (buttonConfirmarClicked) {
            dirigenteDAO.inserir(dirigente);
            carregarTableViewDirigente();
        }

    }

    public boolean showDirigenteDialog(Dirigente dirigente) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DirigenteDialogController.class.getResource("/gestaorecursos/views/dirigente/DirigenteDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Dirigentes");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        DirigenteDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setDirigente(dirigente);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }

    
}
