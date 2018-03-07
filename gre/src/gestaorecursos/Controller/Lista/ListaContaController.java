package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.ContaDialogController;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.domain.Conta;
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
public class ListaContaController implements Initializable {

     @FXML
    private TableView<Conta> tbViewConta;
    
    @FXML
    private TableColumn<Conta, String> tbColConta;

    @FXML
    private TableColumn<Conta, String> tbColBanco;

    @FXML
    private TableColumn<Conta, String> tbColUex;

    @FXML
    private Label lbID;

    @FXML
    private Label lbConta;

    @FXML
    private Label lbAgencia;

    @FXML
    private Label lbBanco;

    @FXML
    private Label lbPrograma;

    @FXML
    private Label lbUex;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;
    
    private List<Conta> listConta;

    private ObservableList<Conta> observableListConta;

    //Atributos para manipulação de Banco de Dados
    private final ContaDAO contaDAO = new ContaDAO();

    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        contaDAO.getConnection();
        carregarTableViewConta();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewConta.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewConta(newValue));
    }

    public void carregarTableViewConta() {
        tbColConta.setCellValueFactory(new PropertyValueFactory<>("conta"));
        tbColBanco.setCellValueFactory(new PropertyValueFactory<>("banco"));
        tbColUex.setCellValueFactory(new PropertyValueFactory<>("uex"));
        
        listConta = contaDAO.listar();

        observableListConta = FXCollections.observableArrayList(listConta);
        tbViewConta.setItems(observableListConta);

    }

    public void selecionarItemTbViewConta(Conta conta) {
        if (conta != null) {
            lbID.setText(String.valueOf(conta.getId()));
            lbConta.setText(conta.getConta());
            lbAgencia.setText(conta.getNumAgencia());
            lbBanco.setText(conta.getBanco().getBanco());
            lbUex.setText(conta.getUex().getUex());
//            lbPrograma.setText(conta.getPrograma().getPrograma());


        } else {
            lbID.setText("");
            lbConta.setText("");
            lbAgencia.setText("");
            lbBanco.setText("");
            lbUex.setText("");
            lbPrograma.setText("");
        }
    }

    
    @FXML
    public void handleBtnInserir(ActionEvent event) throws IOException {
        Conta conta = new Conta();
        boolean buttonConfirmarClicked = showContaDialog(conta);
        if (buttonConfirmarClicked) {
            contaDAO.inserir(conta);
            carregarTableViewConta();
        }

    }
    
    
    
    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException {
        Conta conta = tbViewConta.getSelectionModel().getSelectedItem();
        if (conta != null) {
            boolean buttonConfirmarClicked = showContaDialog(conta);
            if (buttonConfirmarClicked) {
                contaDAO.alterar(conta);
                carregarTableViewConta();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    
    }
    
    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException {
        Conta conta = tbViewConta.getSelectionModel().getSelectedItem();
        if (conta != null) {
            contaDAO.remover(conta);
            carregarTableViewConta();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }

    }


    public boolean showContaDialog(Conta conta) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContaDialogController.class.getResource("/gestaorecursos/views/conta/ContaDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Contaes");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ContaDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setConta(conta);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
