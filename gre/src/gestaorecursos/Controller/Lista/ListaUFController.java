package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.UfDialogController;
import gestaorecursos.model.DAO.UfDAO;
import gestaorecursos.model.domain.Uf;
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
public class ListaUFController implements Initializable {

    @FXML
    private TableView<Uf> tbViewUf;

    @FXML
    private TableColumn<Uf, String> tbColEstado;

    @FXML
    private TableColumn<Uf, String> tbColUf;
    
    @FXML
    private Label lbUfId;

    @FXML
    private Label lbUfEstado;

    @FXML
    private Label lbUFuf;

    @FXML
    private Button btnAlterar;
    
    
    private List<Uf> listUf;
    
    private ObservableList<Uf> observableListUf;
    
    
    //Atributos para manipulação de Banco de Dados
    private final UfDAO ufDAO = new UfDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ufDAO.getConnection();
        carregarTableViewUf();
        
        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewUf.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewUf(newValue));

    }    
    public void carregarTableViewUf(){
        tbColUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
        tbColEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        listUf = ufDAO.listar();
        
        observableListUf = FXCollections.observableArrayList(listUf);
        tbViewUf.setItems(observableListUf);
        
    }
    public void selecionarItemTbViewUf(Uf uf){
        if (uf != null) {
            lbUfId.setText(String.valueOf(uf.getId()));
            lbUfEstado.setText(uf.getEstado());
            lbUFuf.setText(uf.getUf());
            
        } else {
            lbUfId.setText("");
            lbUfEstado.setText("");
            lbUFuf.setText("");
        }
    }
    
    @FXML
    public void handleButtonAlterar() throws IOException {
        Uf uf = tbViewUf.getSelectionModel().getSelectedItem();
        if (uf != null) {
            boolean buttonConfirmarClicked = showUfDialog(uf);
            if (buttonConfirmarClicked) {
                ufDAO.alterar(uf);
                carregarTableViewUf();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    public boolean showUfDialog(Uf uf) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UfDialogController.class.getResource("/gestaorecursos/views/uf/UfDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de UEx");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        UfDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setUf(uf);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

        
    }
}
