package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.TipoDocDialogController;
import gestaorecursos.model.DAO.TipoDocDAO;
import gestaorecursos.model.domain.TipoDoc;
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
public class ListaTipoDocController implements Initializable {

    @FXML
    private TableView<TipoDoc> tbViewTipoDoc;

    @FXML
    private TableColumn<TipoDoc, Integer> tbColId;

    @FXML
    private TableColumn<TipoDoc, String> tbColTipoDoc;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Label lbID;

    @FXML
    private Label lbTipoDoc;

    private List<TipoDoc> listTipoDoc;

    private ObservableList<TipoDoc> observableListTipoDoc;

    //Atributos para manipulação de Banco de Dados
    private final TipoDocDAO tipodocDao = new TipoDocDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipodocDao.getConnection();
        carregarTableViewTipoDoc();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewTipoDoc.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewTipoDoc(newValue));
    }

    public void carregarTableViewTipoDoc() {
        tbColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbColTipoDoc.setCellValueFactory(new PropertyValueFactory<>("tipo_doc"));

        listTipoDoc = tipodocDao.listar();

        observableListTipoDoc = FXCollections.observableArrayList(listTipoDoc);
        tbViewTipoDoc.setItems(observableListTipoDoc);

    }

    public void selecionarItemTbViewTipoDoc(TipoDoc t) {
        if (t != null) {
            lbID.setText(String.valueOf(t.getId()));
            lbTipoDoc.setText(t.getTipo_doc());

        } else {
            lbID.setText("");
            lbTipoDoc.setText("");
        }
    }

    @FXML
    public void handleBtnInserir() throws IOException {
        TipoDoc tipodoc = new TipoDoc();
        boolean buttonConfirmarClicked = showTipoDocDialog(tipodoc);
        if (buttonConfirmarClicked) {
            tipodocDao.inserir(tipodoc);
            carregarTableViewTipoDoc();
        }
    }

    @FXML
    public void handleBtnAlterar()throws IOException{
        TipoDoc tipodoc = tbViewTipoDoc.getSelectionModel().getSelectedItem();
        if (tipodoc != null) {
            boolean buttonConfirmarClicked = showTipoDocDialog(tipodoc);
            if (buttonConfirmarClicked) {
                tipodocDao.alterar(tipodoc);
                carregarTableViewTipoDoc();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
        
    }

    @FXML
    public void handleBtnExcluir() throws IOException {
        TipoDoc tipodoc = tbViewTipoDoc.getSelectionModel().getSelectedItem();
        if (tipodoc != null) {
            tipodocDao.remover(tipodoc);
            carregarTableViewTipoDoc();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    public boolean showTipoDocDialog(TipoDoc tipodoc) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TipoDocDialogController.class.getResource("/gestaorecursos/views/tipodoc/TipoDocDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Tipo de Documento");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        TipoDocDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setTipoDoc(tipodoc);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }

}
