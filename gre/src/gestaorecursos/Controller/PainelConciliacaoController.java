package gestaorecursos.Controller;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.PagamentosDAO;
import gestaorecursos.model.DAO.RecebimentosDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Recebimentos;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class PainelConciliacaoController implements Initializable {

    @FXML
    private Button btnAlterarParaConciliado;

    @FXML
    private Button btnAlterarParaNaoConciliado;
    @FXML
    private Button btnFiltrar;
    
    @FXML
    private TableView<Pagamentos> tbViewDespesaNaoConciliada;

    @FXML
    private TableColumn<Pagamentos, String> tbColData;

    @FXML
    private TableColumn<Pagamentos, String> tbColFornecedor;

    @FXML
    private TableColumn<Pagamentos, String> tbColCheque;

    @FXML
    private TableColumn<Pagamentos, String> tbColValor;

    private List<Pagamentos> listDespesaNaoConciliada;
    private ObservableList<Pagamentos> obsDespesaNaoConciliada;

    @FXML
    private TableView<Pagamentos> tbViewDespesaConciliada;

    @FXML
    private TableColumn<Pagamentos, String> tbColDataConc;

    @FXML
    private TableColumn<Pagamentos, String> tbColFornecedorConc;

    @FXML
    private TableColumn<Pagamentos, String> tbColChequeConc;

    @FXML
    private TableColumn<Pagamentos, String> tbColValorConc;

    private List<Pagamentos> listDespesaConciliada;
    private ObservableList<Pagamentos> obsDespesaConciliada;

    //*********** RECEITAS ************
    @FXML
    private TableView<Recebimentos> tbViewReceitaNaoConciliada;

    @FXML
    private TableColumn<Recebimentos, String> tbColRData;

    @FXML
    private TableColumn<Recebimentos, String> tbColRHistorico;

    @FXML
    private TableColumn<Recebimentos, String> tbColRNumDoc;

    @FXML
    private TableColumn<Recebimentos, String> tbColRValor;

    private List<Recebimentos> listReceitaNaoConciliada;
    private ObservableList<Recebimentos> obsReceitaNaoConciliada;

    @FXML
    private TableView<Recebimentos> tbViewReceitaConciliada;

    @FXML
    private TableColumn<Recebimentos, String> tbColRDataConc;

    @FXML
    private TableColumn<Recebimentos, String> tbColRHistoricoConc;

    @FXML
    private TableColumn<Recebimentos, String> tbColRNumDocConc;

    @FXML
    private TableColumn<Recebimentos, String> tbColRValorConc;

    private List<Recebimentos> listReceitaConciliada;
    private ObservableList<Recebimentos> obsReceitaConciliada;

    @FXML
    private ComboBox<Uex> cbxUex;
    private List<Uex> listUex = new ArrayList<>();
    private ObservableList<Uex> obsUex;

    @FXML
    private ComboBox<Ano> cbxAno;
    private List<Ano> listAno = new ArrayList<>();
    private ObservableList<Ano> obsAno;

    @FXML
    private Label labelTrimestre;

    @FXML
    private ComboBox<Trimestre> cbxTrimestre;
    private List<Trimestre> listTrimestre = new ArrayList<>();
    private ObservableList<Trimestre> obsTrimestre;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    Pagamentos pagamentos;

    //Atributos para manipulação de Banco de Dados
    private final PagamentosDAO pagamentosDAO = new PagamentosDAO();
    private final RecebimentosDAO recebimentosDAO = new RecebimentosDAO();
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pagamentosDAO.getConnection();
        carregarUex();
        carregarAno();
        carregarTrimestre();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewDespesaNaoConciliada.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewDespesaNaoConciliada(newValue));

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewDespesaConciliada.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewDespesaConciliada(newValue));

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewReceitaNaoConciliada.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewReceitaNaoConciliada(newValue));

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewReceitaConciliada.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewReceitaConciliada(newValue));

    }

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

    @FXML
    public void handleBtnFiltrar() {

            CarregarTbViewDespesaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewDespesaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
        
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

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }

    //
    //#############   DESPESAS   ##############
    //
    public void CarregarTbViewDespesaNaoConciliada(String uexsearch, String trisearch, String anosearch) {
        tbColData.setCellValueFactory(new PropertyValueFactory<>("data_pg"));
        tbColFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColCheque.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValor.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));

        listDespesaNaoConciliada = pagamentosDAO.listarDespesaNaoConciliada(uexsearch, trisearch, anosearch);

        obsDespesaNaoConciliada = FXCollections.observableArrayList(listDespesaNaoConciliada);
        tbViewDespesaNaoConciliada.setItems(obsDespesaNaoConciliada);

    }

    public void selecionarItemTbViewDespesaNaoConciliada(Pagamentos pagamentos) {

    }

    @FXML
    public void handleBtnDespAlterarParaConciliado(ActionEvent event) throws IOException {
        Pagamentos pagamentos = tbViewDespesaNaoConciliada.getSelectionModel().getSelectedItem();
        if (pagamentos != null) {
            pagamentosDAO.alterarParaConciliado(pagamentos);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um item na Tabela!");
            alert.show();
        }
            CarregarTbViewDespesaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewDespesaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
    }

    public void CarregarTbViewDespesaConciliada(String uexsearch, String trisearch, String anosearch) {
        tbColDataConc.setCellValueFactory(new PropertyValueFactory<>("data_pg"));
        tbColFornecedorConc.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColChequeConc.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValorConc.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));

        listDespesaConciliada = pagamentosDAO.listarDespesaConciliada(uexsearch, trisearch, anosearch);

        obsDespesaConciliada = FXCollections.observableArrayList(listDespesaConciliada);
        tbViewDespesaConciliada.setItems(obsDespesaConciliada);

    }

    public void selecionarItemTbViewDespesaConciliada(Pagamentos pagamentos) {

    }

    @FXML
    public void handleBtnDespAlterarParaNaoConciliado(ActionEvent event) throws IOException {
        Pagamentos pagamentos = tbViewDespesaConciliada.getSelectionModel().getSelectedItem();
        if (pagamentos != null) {
            pagamentosDAO.alterarParaNaoConciliado(pagamentos);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um ítem na Tabela!");
            alert.show();
        }
        
            CarregarTbViewDespesaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewDespesaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));

    }

    //
    //#############   RECEITAS   ##############
    //
    public void CarregarTbViewReceitaNaoConciliada(String uexsearch, String trisearch, String anosearch) {
        tbColRData.setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        tbColRHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));
        tbColRNumDoc.setCellValueFactory(new PropertyValueFactory<>("num_doc"));
        tbColRValor.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_receita()));

        listReceitaNaoConciliada = recebimentosDAO.listarReceitaNaoConciliada(uexsearch, trisearch, anosearch);

        obsReceitaNaoConciliada = FXCollections.observableArrayList(listReceitaNaoConciliada);
        tbViewReceitaNaoConciliada.setItems(obsReceitaNaoConciliada);

    }

    public void selecionarItemTbViewReceitaNaoConciliada(Recebimentos recebimentos) {

    }

    @FXML
    public void handleBtnRecAlterarParaConciliado(ActionEvent event) throws IOException {
        Recebimentos recebimentos = tbViewReceitaNaoConciliada.getSelectionModel().getSelectedItem();
        if (recebimentos != null) {
            recebimentosDAO.alterarParaConciliado(recebimentos);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um item na Tabela!");
            alert.show();
        }
        
            CarregarTbViewDespesaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewDespesaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));

    }

    public void CarregarTbViewReceitaConciliada(String uexsearch, String trisearch, String anosearch) {
        tbColRDataConc.setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        tbColRHistoricoConc.setCellValueFactory(new PropertyValueFactory<>("historico"));
        tbColRNumDocConc.setCellValueFactory(new PropertyValueFactory<>("num_doc"));
        tbColRValorConc.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_receita()));

        listReceitaConciliada = recebimentosDAO.listarReceitaConciliada(uexsearch, trisearch, anosearch);

        obsReceitaConciliada = FXCollections.observableArrayList(listReceitaConciliada);
        tbViewReceitaConciliada.setItems(obsReceitaConciliada);
    }

    public void selecionarItemTbViewReceitaConciliada(Recebimentos recebimentos) {

    }

    @FXML
    public void handleBtnRecAlterarParaNaoConciliado(ActionEvent event) throws IOException {
        Recebimentos recebimentos = tbViewReceitaConciliada.getSelectionModel().getSelectedItem();
        if (recebimentos != null) {
            recebimentosDAO.alterarParaNaoConciliado(recebimentos);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um item na Tabela!");
            alert.show();
        }
        
            CarregarTbViewDespesaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewDespesaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaNaoConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
            CarregarTbViewReceitaConciliada((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));

    }

}
