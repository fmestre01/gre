package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.UExDialogController;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Uex;
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
public class ListaUexController implements Initializable {

@FXML
    private TableView<Uex> tbViewUex;

    @FXML
    private TableColumn<Uex, String> tbColApelido;

    @FXML
    private TableColumn<Uex, String> tbColUex;

    @FXML
    private Label lbId;

    @FXML
    private Label lbApelido;

    @FXML
    private Label lbUexF;

    @FXML
    private Label lbUex;

    @FXML
    private Label lbCNPJ;

    @FXML
    private Label lbEndereco;

    @FXML
    private Label lbEndNum;

    @FXML
    private Label lbEndCompl;

    @FXML
    private Label lbCEP;

    @FXML
    private Label lbBairro;

    @FXML
    private Label lbMunicipio;

    @FXML
    private Label lbUf;

    @FXML
    private Label lbCxPostal;

    @FXML
    private Label lbDDD;

    @FXML
    private Label lbTelefone;

    @FXML
    private Label lbFax;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbTipoEntidade;

    @FXML
    private Label lbTelEntidade;

    @FXML
    private Label lbFaxEntidade;

    @FXML
    private Label lbUndGestFed;

    @FXML
    private Label lbGestorOrgFed;

    @FXML
    private Label lbCNAS;

    @FXML
    private Label lbCodCenso;
    
    @FXML
    private Label lbContmatic;


    @FXML
    private Label lbNomeEscola;
    
     @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;
    
    private List<Uex> listUex;
    
    private ObservableList<Uex> observableListUex;
    
   
    //Atributos para manipulação de Banco de Dados
    private final UexDAO uexDAO = new UexDAO();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uexDAO.getConnection();
        carregarTableViewUex();
        
        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewUex.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewUex(newValue));
    }    
    public void carregarTableViewUex(){
        tbColApelido.setCellValueFactory(new PropertyValueFactory<>("apelido"));  
        tbColUex.setCellValueFactory(new PropertyValueFactory<>("uex"));
        
        listUex = uexDAO.listar();
        
        observableListUex = FXCollections.observableArrayList(listUex);
        tbViewUex.setItems(observableListUex);
        
    }
    public void selecionarItemTbViewUex(Uex uex){
        if (uex != null) {
            lbId.setText(String.valueOf(uex.getId()));
            lbApelido.setText(uex.getApelido());
            lbUexF.setText(uex.getUexf());
            lbUex.setText(uex.getUex());
            lbCNPJ.setText(uex.getCNPJ());
            lbEndereco.setText(uex.getEndRua());
            lbEndNum.setText(uex.getEndNum());
            lbEndCompl.setText(uex.getEndCompl());
            lbCEP.setText(uex.getCEP());
            lbCxPostal.setText(uex.getCxPostal());
            lbDDD.setText(uex.getDdd());
            lbTelefone.setText(uex.getTelefone());
            lbFax.setText(uex.getFax());
            lbEmail.setText(uex.getEmail());
            lbTelEntidade.setText(uex.getTelEntidade());
            lbFaxEntidade.setText(uex.getFaxEntidade());
            lbUndGestFed.setText(uex.getUndGestoraOrgFed());
            lbGestorOrgFed.setText(uex.getGestorOrgFederal());
            lbCNAS.setText(uex.getCNAS());
            lbContmatic.setText(uex.getContmatic());
            lbCodCenso.setText(uex.getCodCenso());
            lbNomeEscola.setText(uex.getNomeEscola());
                    
            
        } else {
            lbId.setText("");
            lbApelido.setText("");
            lbUexF.setText("");
            lbUex.setText("");
            lbCNPJ.setText("");
            lbEndereco.setText("");
            lbEndNum.setText("");
            lbEndCompl.setText("");
            lbCEP.setText("");
            lbCxPostal.setText("");
            lbDDD.setText("");
            lbTelefone.setText("");
            lbFax.setText("");
            lbEmail.setText("");
            lbTelEntidade.setText("");
            lbFaxEntidade.setText("");
            lbUndGestFed.setText("");
            lbGestorOrgFed.setText("");
            lbCNAS.setText("");
            lbCodCenso.setText("");
            lbContmatic.setText("");
            lbNomeEscola.setText("");

        }
    }
    @FXML
    public void handleButtonInserir() throws IOException {
        Uex uex = new Uex();
        boolean buttonConfirmarClicked = showUexDialog(uex);
        if (buttonConfirmarClicked) {
            uexDAO.inserir(uex);
            carregarTableViewUex();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Uex uex = tbViewUex.getSelectionModel().getSelectedItem();
        if (uex != null) {
            boolean buttonConfirmarClicked = showUexDialog(uex);  
            if (buttonConfirmarClicked) {
                uexDAO.alterar(uex);
                carregarTableViewUex();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Uex uex = tbViewUex.getSelectionModel().getSelectedItem();
        if (uex != null) {
            uexDAO.remover(uex);
            carregarTableViewUex();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    public boolean showUexDialog(Uex uex) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UExDialogController.class.getResource("/gestaorecursos/views/uex/UExDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de UExs");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        UExDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setUex(uex);
        

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
