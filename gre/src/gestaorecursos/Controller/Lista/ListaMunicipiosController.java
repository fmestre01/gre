package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.MunicipiosDialogController;
import gestaorecursos.model.DAO.MunicipioDAO;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Uf;
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
public class ListaMunicipiosController implements Initializable {

    @FXML
    private TableView<Municipio> tbViewMunicipio;

    @FXML
    private TableColumn<Municipio, Integer> tbColId;

    @FXML
    private TableColumn<Municipio, String> tbColCidade;

    @FXML
    private TableColumn<Municipio, Uf> tbColUf;

    @FXML
    private Label lbId;

    @FXML
    private Label lbCidade;

    @FXML
    private Label lbUf;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    private List<Municipio> listMunicipios;

    private ObservableList<Municipio> observableListMunicipios;

    //Atributos para manipulação de Banco de Dados
    private final MunicipioDAO municipioDAO = new MunicipioDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        municipioDAO.getConnection();
        carregarTableViewMunicipios();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewMunicipio.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewMunicipio(newValue));
    }

    public void carregarTableViewMunicipios() {
        tbColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbColCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        tbColUf.setCellValueFactory(new PropertyValueFactory<>("uf"));

        listMunicipios = municipioDAO.listar();

        observableListMunicipios = FXCollections.observableArrayList(listMunicipios);
        tbViewMunicipio.setItems(observableListMunicipios);

    }

    public void selecionarItemTbViewMunicipio(Municipio municipio) {

        if (municipio != null) {
            lbId.setText(String.valueOf(municipio.getId()));
            lbCidade.setText(municipio.getCidade());
            lbUf.setText(municipio.getUf().getUf());
            
            
        } else {
            lbId.setText("");
            lbCidade.setText("");
            lbUf.setText("");
        }
    }

    @FXML
    public void handleBtnInserir(ActionEvent event) throws IOException {
        Municipio municipio = new Municipio();
        boolean buttonConfirmarClicked = showMunicipiosDialog(municipio);
        if (buttonConfirmarClicked) {
            municipioDAO.inserir(municipio);
            carregarTableViewMunicipios();
        }
    }

    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException {
        Municipio municipio = tbViewMunicipio.getSelectionModel().getSelectedItem();
        if (municipio != null) {
            boolean buttonConfirmarClicked = showMunicipiosDialog(municipio);
            if (buttonConfirmarClicked) {
                municipioDAO.alterar(municipio);
                carregarTableViewMunicipios();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException {
        Municipio municipio = tbViewMunicipio.getSelectionModel().getSelectedItem();
        if (municipio != null) {
            municipioDAO.remover(municipio);
            carregarTableViewMunicipios();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    public boolean showMunicipiosDialog(Municipio municipio) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MunicipiosDialogController.class.getResource("/gestaorecursos/views/municipios/MunicipiosDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Municipios");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        MunicipiosDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setMunicipio(municipio);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
}
