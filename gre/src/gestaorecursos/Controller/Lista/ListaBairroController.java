package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.BairroDialogController;
import gestaorecursos.model.DAO.BairroDAO;
import gestaorecursos.model.domain.Bairro;
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
public class ListaBairroController implements Initializable {

     @FXML
    private TableView<Bairro> tbViewBairro;

    @FXML
    private TableColumn<Bairro, String> tbColBairro;

    @FXML
    private TableColumn<Bairro, String> tbColMunicipio;

    @FXML
    private TableColumn<Bairro, String> tbColUf;

    @FXML
    private Label lbBairro;

    @FXML
    private Label lbMunicipio;

    @FXML
    private Label lbUF;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnInserir;

    private List<Bairro> listBairros;
    
    private ObservableList<Bairro> observableListBairros;
    
    
    //Atributos para manipulação de Banco de Dados
    private final BairroDAO bairroDAO = new BairroDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bairroDAO.getConnection();
        carregarTableViewBairros();
        
        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewBairro.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewBairro(newValue));
    }
    
    
    
    @FXML
    public void handleBtnInserir(ActionEvent event) throws IOException{
            Bairro bairro = new Bairro();
            boolean buttonConfirmarClicked = showBairrosDialog(bairro);
            if (buttonConfirmarClicked) {
                bairroDAO.inserir(bairro);
                carregarTableViewBairros();
            }
    
    }
    
    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException{
        Bairro bairro = tbViewBairro.getSelectionModel().getSelectedItem();
        if (bairro != null) {
            boolean buttonConfirmarClicked = showBairrosDialog(bairro);
            if (buttonConfirmarClicked) {
                bairroDAO.alterar(bairro);
                carregarTableViewBairros();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }

    }

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException{
        Bairro bairro = tbViewBairro.getSelectionModel().getSelectedItem();
        if (bairro != null) {
            bairroDAO.remover(bairro);
            carregarTableViewBairros();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    
    public void carregarTableViewBairros(){
        tbColBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));  
        tbColMunicipio.setCellValueFactory(new PropertyValueFactory<>("municipio"));
        tbColUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
        listBairros = bairroDAO.listar();
        
        observableListBairros = FXCollections.observableArrayList(listBairros);
        tbViewBairro.setItems(observableListBairros);
        
    }
        public void selecionarItemTbViewBairro(Bairro bairro){
        if (bairro != null) {
            lbBairro.setText(String.valueOf(bairro.getBairro()));
            lbMunicipio.setText(bairro.getMunicipio().getCidade());
            lbUF.setText(bairro.getUf().getUf());
            
        } else {
            lbBairro.setText("");
            lbMunicipio.setText("");
            lbUF.setText("");
        }
    }
        public boolean showBairrosDialog(Bairro bairro) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(BairroDialogController.class.getResource("/gestaorecursos/views/bairro/BairroDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Bairros");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        BairroDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setBairro(bairro);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
