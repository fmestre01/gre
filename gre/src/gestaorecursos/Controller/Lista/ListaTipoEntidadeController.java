package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.TipoEntidadeDialogController;
import gestaorecursos.model.DAO.TipoEntidadeDAO;
import gestaorecursos.model.domain.TipoEntidade;
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
public class ListaTipoEntidadeController implements Initializable {

    @FXML
    private TableView<TipoEntidade> tbViewTipoEntidade;

    @FXML
    private TableColumn<TipoEntidade, Integer> tbColId;

    @FXML
    private TableColumn<TipoEntidade, String> tbColTipoEntidade;

    @FXML
    private Label lbId;

    @FXML
    private Label lbTipoEntidade;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    private List<TipoEntidade> listTipoEntidade;

    private ObservableList<TipoEntidade> observableListTipoEntidade;
    
    //Atributos para manipulação de Banco de Dados
    private final TipoEntidadeDAO tipoentidadeDao = new TipoEntidadeDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipoentidadeDao.getConnection();
        carregarTableViewTipoEntidade();
    
     // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewTipoEntidade.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewTipoEntidade(newValue));
 }
        
    
    public void carregarTableViewTipoEntidade(){
        tbColId.setCellValueFactory(new PropertyValueFactory<>("id"));  
        tbColTipoEntidade.setCellValueFactory(new PropertyValueFactory<>("tipoEntidade"));
        
        listTipoEntidade = tipoentidadeDao.listar();
        
        observableListTipoEntidade = FXCollections.observableArrayList(listTipoEntidade);
        tbViewTipoEntidade.setItems(observableListTipoEntidade);
        
    }
    public void selecionarItemTbViewTipoEntidade(TipoEntidade t){
        if (t != null) {
            lbId.setText(String.valueOf(t.getId()));
            lbTipoEntidade.setText(t.getTipoEntidade());
            
        } else {
            lbId.setText("");
            lbTipoEntidade.setText("");
        }
    }
    @FXML
    public void handleBtnInserir() throws IOException {
        TipoEntidade tipoentidade = new TipoEntidade();
        boolean buttonConfirmarClicked = showTipoEntidadeDialog(tipoentidade);
        if (buttonConfirmarClicked) {
            tipoentidadeDao.inserir(tipoentidade);
            carregarTableViewTipoEntidade();
        }
    }

    @FXML
    public void handleBtnAlterar() throws IOException {
        TipoEntidade tipoentidade = tbViewTipoEntidade.getSelectionModel().getSelectedItem();
        if (tipoentidade != null) {
            boolean buttonConfirmarClicked = showTipoEntidadeDialog(tipoentidade);
            if (buttonConfirmarClicked) {
                tipoentidadeDao.alterar(tipoentidade);
                carregarTableViewTipoEntidade();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnExcluir() throws IOException {
        TipoEntidade tipoentidade = tbViewTipoEntidade.getSelectionModel().getSelectedItem();
        if (tipoentidade != null) {
            tipoentidadeDao.remover(tipoentidade);
            carregarTableViewTipoEntidade();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
    public boolean showTipoEntidadeDialog(TipoEntidade tipoentidade) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TipoEntidadeDialogController.class.getResource("/gestaorecursos/views/tipoentidade/TipoEntidadeDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Tipo de Entidade");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        TipoEntidadeDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setTipoentidade(tipoentidade);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
    
        
}
