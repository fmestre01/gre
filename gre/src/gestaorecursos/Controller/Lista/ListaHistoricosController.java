package gestaorecursos.Controller.Lista;


import gestaorecursos.Controller.Dialog.HistoricosDialogController;
import gestaorecursos.model.DAO.HistoricoDAO;
import gestaorecursos.model.domain.Historico;
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
public class ListaHistoricosController implements Initializable {

     @FXML
    private TableView<Historico> tbViewHistoricos;

    @FXML
    private TableColumn<Historico, String> tbColHistorico;

    @FXML
    private TableColumn<Historico, String> tbColContaDeb;

    @FXML
    private TableColumn<Historico, String> tbColContaCred;

    @FXML
    private Label lbHistorico;

    @FXML
    private Label lbCtaDeb;

    @FXML
    private Label lbCtaCred;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;
    
    private List<Historico> listHistoricos;
    
    private ObservableList<Historico> observableListHistoricos;
 
    //Atributos para manipulação de Banco de Dados
    private final HistoricoDAO historicoDao = new HistoricoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        historicoDao.getConnection();
        carregarTableViewHistoricos();
        
        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewHistoricos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewHistoricos(newValue));
 
    }    
    
       public void carregarTableViewHistoricos(){
        tbColHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));  
        tbColContaDeb.setCellValueFactory(new PropertyValueFactory<>("contadeb"));
        tbColContaCred.setCellValueFactory(new PropertyValueFactory<>("contacred"));
        listHistoricos = historicoDao.listar();
        
        observableListHistoricos = FXCollections.observableArrayList(listHistoricos);
        tbViewHistoricos.setItems(observableListHistoricos);
        
    }
        public void selecionarItemTbViewHistoricos(Historico historico){
        if (historico != null) {
            lbHistorico.setText(historico.getHistorico());
            lbCtaDeb.setText(historico.getContadeb());
            lbCtaCred.setText(historico.getContacred());
            
        } else {
            lbHistorico.setText("");
            lbCtaDeb.setText("");
            lbCtaCred.setText("");
            
        }
    }
        public boolean showHistoricosDialog(Historico historico) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HistoricosDialogController.class.getResource("/gestaorecursos/views/historicos/HistoricosDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Históricos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        HistoricosDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setHistorico(historico);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
        
    @FXML
    public void handleBtnInserir(ActionEvent event) throws IOException{
            Historico historico = new Historico();
            boolean buttonConfirmarClicked = showHistoricosDialog(historico);
            if (buttonConfirmarClicked) {
                
                historicoDao.inserir(historico);
                carregarTableViewHistoricos();
            }
    
    }
    
    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException{
        Historico historico = tbViewHistoricos.getSelectionModel().getSelectedItem();
        if (historico != null) {
            boolean buttonConfirmarClicked = showHistoricosDialog(historico);
            if (buttonConfirmarClicked) {
                historicoDao.alterar(historico);
                carregarTableViewHistoricos();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }

    }

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException{
        Historico historico = tbViewHistoricos.getSelectionModel().getSelectedItem();
        if (historico != null) {
            historicoDao.remover(historico);
            carregarTableViewHistoricos();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
}
