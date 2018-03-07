package gestaorecursos.Controller.Lista;


import gestaorecursos.Controller.Dialog.PlanoDeContasDialogController;
import gestaorecursos.model.DAO.PlanoDeContasDAO;
import gestaorecursos.model.domain.PlanoDeContas;
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
public class ListaPlanoDeContasController implements Initializable {

    @FXML
    private TableView<PlanoDeContas> tbViewPlanContas;

    @FXML
    private TableColumn<PlanoDeContas, String> tbColConta;

    @FXML
    private TableColumn<PlanoDeContas, String> tbColNome;

    @FXML
    private TableColumn<PlanoDeContas, String> tbColNatureza;

    @FXML
    private TableColumn<PlanoDeContas, String> tbColClasse;

    @FXML
    private TableColumn<PlanoDeContas, String> tbColGrupo;

    @FXML
    private Label lbConta;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbNatureza;

    @FXML
    private Label lbClasse;

    @FXML
    private Label lbGrupo;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    private List<PlanoDeContas> listPlanoContas;

    private ObservableList<PlanoDeContas> observableListPlanoContas;
    
    //Atributos para manipulação de Banco de Dados
    private final PlanoDeContasDAO pcontasDao = new PlanoDeContasDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pcontasDao.getConnection();
        carregarTableViewPlanContas();
        
        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewPlanContas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewPlanContas(newValue));
    }
public void carregarTableViewPlanContas(){
        tbColConta.setCellValueFactory(new PropertyValueFactory<>("cod_reduzido"));  
        tbColNome.setCellValueFactory(new PropertyValueFactory<>("nome_conta"));
        tbColNatureza.setCellValueFactory(new PropertyValueFactory<>("natureza"));
        tbColClasse.setCellValueFactory(new PropertyValueFactory<>("classe"));
        tbColGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        
        listPlanoContas = pcontasDao.listar();
        
        observableListPlanoContas = FXCollections.observableArrayList(listPlanoContas);
        tbViewPlanContas.setItems(observableListPlanoContas);
        
    }
    public void selecionarItemTbViewPlanContas(PlanoDeContas p){
        if (p != null) {
            lbConta.setText(String.valueOf(p.getCod_reduzido()));
            lbNome.setText(p.getNome_conta());
            lbNatureza.setText(p.getNatureza());
            lbClasse.setText(p.getClasse());
            lbGrupo.setText(p.getGrupo());
        } else {
            lbConta.setText("");
            lbNome.setText("");
            lbNatureza.setText("");
            lbClasse.setText("");
            lbGrupo.setText("");
        }
    }
    
    @FXML
    public void handleBtnInserir() throws IOException {
        PlanoDeContas p = new PlanoDeContas();
        boolean buttonConfirmarClicked = showPlanoDeContasDialog(p);
        if (buttonConfirmarClicked) {
            pcontasDao.inserir(p);
            carregarTableViewPlanContas();
        }
    }

    @FXML
    public void handleBtnAlterar() throws IOException {
        PlanoDeContas p = tbViewPlanContas.getSelectionModel().getSelectedItem();
        if (p != null) {
            boolean buttonConfirmarClicked = showPlanoDeContasDialog(p);
            if (buttonConfirmarClicked) {
                pcontasDao.alterar(p);
                carregarTableViewPlanContas();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnExcluir() throws IOException {
        PlanoDeContas p = tbViewPlanContas.getSelectionModel().getSelectedItem();
        if (p != null) {
            pcontasDao.remover(p);
            carregarTableViewPlanContas();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
    public boolean showPlanoDeContasDialog(PlanoDeContas p) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PlanoDeContasDialogController.class.getResource("/gestaorecursos/views/plancontas/PlanoDeContasDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Programas");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        PlanoDeContasDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setpContas(p);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
