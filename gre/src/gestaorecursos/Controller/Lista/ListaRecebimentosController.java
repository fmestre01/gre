package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.ConsultaRecDialogController;
import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.DAO.HistoricoDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.RecebimentosDAO;
import gestaorecursos.model.DAO.TipoDocDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Recebimentos;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class ListaRecebimentosController implements Initializable {

    @FXML
    private Label lbPrograma;

    @FXML
    private Label lbUex;

    @FXML
    private Label lbFornecedor;

    @FXML
    private Label lbHistorico;

    @FXML
    private Label lbCheque;

    @FXML
    private Label lbDataEmissao;

    @FXML
    private Label lbDataPagto;

    @FXML
    private Label lbNumDoc;

    @FXML
    private Label lbDataCheque;

    @FXML
    private Label lbAno;

    @FXML
    private Label lbTrimestre;

    @FXML
    private Label lbValor;

    @FXML
    private Label lbVlrLiquido;

    @FXML
    private Button btnFiltrar;

    @FXML
    private ComboBox<Uex> cbxUex;
    private List<Uex> listUex = new ArrayList<>();
    private ObservableList<Uex> obsUex;

    @FXML
    private ComboBox<Trimestre> cbxTrimestre;
    private List<Trimestre> listTrimestre = new ArrayList<>();
    private ObservableList<Trimestre> obsTrimestre;

    @FXML
    private ComboBox<Ano> cbxAno;
    private List<Ano> listAno = new ArrayList<>();
    private ObservableList<Ano> obsAno;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableView<Recebimentos> tbViewRecebimentos;

    @FXML
    private TableColumn<Recebimentos, String> tbColId;

    @FXML
    private TableColumn<Recebimentos, String> tbColData;

    @FXML
    private TableColumn<Recebimentos, String> tbColNumDoc;

    @FXML
    private TableColumn<Recebimentos, String> tbColHistorico;

    @FXML
    private TableColumn<Recebimentos, String> tbColValor;

    @FXML
    private TableColumn<Recebimentos, String> tbColUex;

    private List<Recebimentos> listRecebimentos;

    private ObservableList<Recebimentos> observableListRecebimentos;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Recebimentos recebimentos;

    //Atributos para manipulação de Banco de Dados
    private final RecebimentosDAO recebimentosDao = new RecebimentosDAO();
    private final ProgramaDAO programaDao = new ProgramaDAO();
    private final UexDAO uexDao = new UexDAO();
    private final FornecedorDAO fornecedorDao = new FornecedorDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final TipoDocDAO tipodocDao = new TipoDocDAO();
    private final HistoricoDAO historicoDao = new HistoricoDAO();
    private final ContaDAO contaDao = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarUex();
        carregarAno();
        carregarTrimestre();

        recebimentosDao.getConnection();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewRecebimentos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewRecebimentos(newValue));

    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public Recebimentos getRecebimentos() {
        return recebimentos;
    }

    public void setRecebimentos(Recebimentos recebimentos) {
        this.recebimentos = recebimentos;
    }

        //*************** TABLEVIEW  ********************************************
    public void carregarTableViewRecebimentos(String uexsearch, String trisearch, String anosearch) {
        tbColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbColData.setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        tbColNumDoc.setCellValueFactory(new PropertyValueFactory<>("num_doc"));
        tbColHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));
        tbColValor.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_receita()));
        tbColUex.setCellValueFactory(new PropertyValueFactory<>("Uex"));

        listRecebimentos = recebimentosDao.filtrar(uexsearch, trisearch, anosearch);

        observableListRecebimentos = FXCollections.observableArrayList(listRecebimentos);
        tbViewRecebimentos.setItems(observableListRecebimentos);

    }

    public void selecionarItemTbViewRecebimentos(Recebimentos recebimentos) {
        if (recebimentos != null) {

            //*********Tratamento da inserção de valores ********
            NumberFormat nf = NumberFormat.getNumberInstance();

            lbPrograma.setText(String.valueOf(recebimentos.getPrograma()));
            lbUex.setText(String.valueOf(recebimentos.getUex()));//
            lbHistorico.setText(recebimentos.getHistorico());//
            lbDataEmissao.setText(String.valueOf(recebimentos.getData_entrada())); //
            lbNumDoc.setText(recebimentos.getNum_doc());//
            lbAno.setText(String.valueOf(recebimentos.getAno()));//
            lbTrimestre.setText((String.valueOf(recebimentos.getTrimestre())));//
            lbValor.setText(String.valueOf(recebimentos.getVlr_receita()));
        } else {
            lbPrograma.setText("");
            lbUex.setText("");
            lbHistorico.setText("");
            lbDataEmissao.setText("");
            lbNumDoc.setText("");
            lbAno.setText("");
            lbTrimestre.setText("");
            lbValor.setText("");
        }
    }

    //*******************COMBOBOX ************************************
    public void carregarUex() {
        //new AutoCompleteComboBoxListener(cbxUEx);
        Uex cbu = new Uex();
        listUex = uexDao.listar();
        obsUex = FXCollections.observableArrayList(listUex);

        cbxUex.setItems(obsUex);
    }

    public void carregarAno() {
        Ano cba = new Ano();
        listAno = anoDao.listar();
        obsAno = FXCollections.observableArrayList(listAno);

        cbxAno.setItems(obsAno);
    }

    public void carregarTrimestre() {
        Trimestre cbt = new Trimestre();
        listTrimestre = trimestreDao.listar();
        obsTrimestre = FXCollections.observableArrayList(listTrimestre);

        cbxTrimestre.setItems(obsTrimestre);
    }

    //******************* BOTÔES ***********************************
    public void handleBtnFiltrar() {
        
        carregarTableViewRecebimentos((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
    }

    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException, ParseException, Exception {
        Recebimentos r = tbViewRecebimentos.getSelectionModel().getSelectedItem();
        if (r != null) {
            boolean buttonConfirmarClicked = showConsultaRecDialog(r);
            if (buttonConfirmarClicked) {
                recebimentosDao.alterar(r);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um item na Tabela!");
            alert.show();
    }
}

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException {
        Recebimentos r = tbViewRecebimentos.getSelectionModel().getSelectedItem();
        if (r != null) {
            recebimentosDao.remover(r);
            carregarTableViewRecebimentos((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um item na Tabela!");
            alert.show();
        }
    }

    //*************************** TELAS *********************************
    public boolean showConsultaRecDialog(Recebimentos r) throws IOException, ParseException, Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ListaRecebimentosController.class.getResource("/gestaorecursos/views/recebimentos/ConsultaRecDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Alterar Recebimentos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ConsultaRecDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setR(r);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButonConfirmarClicked();
    }

    
    
}
