package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.ProgramasDialogController;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.domain.Programa;
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

public class ListaProgramasController implements Initializable {

    
    @FXML
    private TableView<Programa> tbViewPrograma;

    @FXML
    private TableColumn<Programa, Integer> tbColProgramaId;

    @FXML
    private TableColumn<Programa, String> tbColProgramaPrograma;

    @FXML
    private Label lbProgramaId;

    @FXML
    private Label lbProgramaNome;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnRemover;
    
    private List<Programa> listProgramas;
    
    private ObservableList<Programa> observableListProgramas;
    
    
    //Atributos para manipulação de Banco de Dados
    private final ProgramaDAO programaDAO = new ProgramaDAO();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        programaDAO.getConnection();
        carregarTableViewProgramas();
    
     // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewPrograma.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewPrograma(newValue));
 }
        
    
    public void carregarTableViewProgramas(){
        tbColProgramaId.setCellValueFactory(new PropertyValueFactory<>("id"));  
        tbColProgramaPrograma.setCellValueFactory(new PropertyValueFactory<>("programa"));
        
        listProgramas = programaDAO.listar();
        
        observableListProgramas = FXCollections.observableArrayList(listProgramas);
        tbViewPrograma.setItems(observableListProgramas);
        
    }
    public void selecionarItemTbViewPrograma(Programa programa){
        if (programa != null) {
            lbProgramaId.setText(String.valueOf(programa.getId()));
            lbProgramaNome.setText(programa.getPrograma());
            
        } else {
            lbProgramaId.setText("");
            lbProgramaNome.setText("");
        }
    }
    
    @FXML
    public void handleBtnInserir() throws IOException {
        Programa programa = new Programa();
        boolean buttonConfirmarClicked = showProgramasDialog(programa);
        if (buttonConfirmarClicked) {
            programaDAO.inserir(programa);
            carregarTableViewProgramas();
        }
    }

    @FXML
    public void handleBtnAlterar() throws IOException {
        Programa programa = tbViewPrograma.getSelectionModel().getSelectedItem();
        if (programa != null) {
            boolean buttonConfirmarClicked = showProgramasDialog(programa);
            if (buttonConfirmarClicked) {
                programaDAO.alterar(programa);
                carregarTableViewProgramas();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnRemover() throws IOException {
        Programa programa = tbViewPrograma.getSelectionModel().getSelectedItem();
        if (programa != null) {
            programaDAO.remover(programa);
            carregarTableViewProgramas();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
    public boolean showProgramasDialog(Programa programa) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProgramasDialogController.class.getResource("/gestaorecursos/views/programas/ProgramasDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Programas");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ProgramasDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPrograma(programa);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
