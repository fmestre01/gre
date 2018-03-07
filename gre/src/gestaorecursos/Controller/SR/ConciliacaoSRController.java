package gestaorecursos.Controller.SR;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.SRConciliacaoDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.sr.ConciliacaoSR;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class ConciliacaoSRController implements Initializable {

    // ** ÁREA DAS DESPESAS
    @FXML
    private Button btnTransfConciliado;

    @FXML
    private Button btnTransfNaoConciliado;

    @FXML
    private TableView<ConciliacaoSR> tbViewNaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, Date> tbColEmissaoNaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColNumDocNaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColFornecedorNaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, Integer> tbColDocFornecedorNaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColChequeNaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, Double> tbColValorNaoConciliado;

    @FXML
    private TableView<ConciliacaoSR> tbViewConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, Date> tbColEmissaoConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColNumDocConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColFornecedorConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, Integer> tbColDocFornecedorConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColChequeConciliado;

    @FXML
    private TableColumn<ConciliacaoSR, Double> tbColValorConciliado;

    private List<ConciliacaoSR> listNaoConciliados;
    private ObservableList<ConciliacaoSR> observableListNaoConciliados;

    private List<ConciliacaoSR> listConciliados;
    private ObservableList<ConciliacaoSR> observableListConciliados;

    // ** ÁREA DAS RECEITAS
    @FXML
    private TableView<ConciliacaoSR> tbViewReceitaNaoConc;

    @FXML
    private TableColumn<ConciliacaoSR, LocalDate> tbColEmissaoRNao;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColNumDocRNao;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColFornecedorRNao;

    @FXML
    private TableColumn<ConciliacaoSR, Double> tbColValorRNao;

    private ObservableList<ConciliacaoSR> obsRecNaoConc;
    private List<ConciliacaoSR> listRecNaoConc;

    @FXML
    private TableView<ConciliacaoSR> tbViewReceitaConc;

    @FXML
    private TableColumn<ConciliacaoSR, LocalDate> tbColEmissaoConciliado1;

    @FXML
    private TableColumn<ConciliacaoSR, String> tbColNumDocConciliado1;

    @FXML
    private TableColumn<ConciliacaoSR, Integer> tbColFornecedorConciliado1;

    @FXML
    private TableColumn<ConciliacaoSR, Double> tbColValorConciliado1;

    @FXML
    private Button btnReceitaConc;

    @FXML
    private Button btnReceitaNaoConc;

    // ** ÁREA DE COMBOBOX GERAL
    @FXML
    private ComboBox<Uex> cbxUex;
    private List<Uex> listUex;
    private ObservableList<Uex> observableListUex;

    @FXML
    private ComboBox<Ano> cbxAno;
    private List<Ano> listAno;
    private ObservableList<Ano> observableListAno;

    @FXML
    private ComboBox<Trimestre> cbxTrimestre;
    private List<Trimestre> listTrimestre;
    private ObservableList<Trimestre> observableListTrimestre;

    @FXML
    private ComboBox<Conta> cbxConta;
    private List<Conta> listConta;
    private ObservableList<Conta> observableListConta;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private ConciliacaoSR conciliacaoSR;

    //Atributos para manipulação de Banco de Dados
    private final SRConciliacaoDAO srconciliacaoDAO = new SRConciliacaoDAO();
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final ContaDAO contaDao = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        carregarTableViewNaoConciliados();
        carregarTableViewConciliados();
        carregartbViewReceitaNaoConc();
        carregarUex();
        carregarAno();
        carregarTrimestre();
        carregarConta();
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

    public ConciliacaoSR getConciliacaoSR() {
        return conciliacaoSR;
    }

    public void setConciliacaoSR(ConciliacaoSR conciliacaoSR) {
        this.conciliacaoSR = conciliacaoSR;
    }

    public void carregarUex() {
        Uex cbu = new Uex();
        listUex = uexDao.listar();
        observableListUex = FXCollections.observableArrayList(listUex);

        cbxUex.setItems(observableListUex);
    }

    public void carregarAno() {
        Ano cbu = new Ano();
        listAno = anoDao.listar();
        observableListAno = FXCollections.observableArrayList(listAno);

        cbxAno.setItems(observableListAno);
    }

    public void carregarTrimestre() {
        Trimestre cbu = new Trimestre();
        listTrimestre = trimestreDao.listar();
        observableListTrimestre = FXCollections.observableArrayList(listTrimestre);

        cbxTrimestre.setItems(observableListTrimestre);
    }

    public void carregarConta() {
        Conta cbu = new Conta();
        listConta = contaDao.listar();
        observableListConta = FXCollections.observableArrayList(listConta);

        cbxConta.setItems(observableListConta);
    }

    public void carregarTableViewNaoConciliados() {
        tbColEmissaoNaoConciliado.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDocNaoConciliado.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedorNaoConciliado.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColDocFornecedorNaoConciliado.setCellValueFactory(new PropertyValueFactory<>("doc_fornecedor"));
        tbColChequeNaoConciliado.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValorNaoConciliado.setCellValueFactory(new PropertyValueFactory<>("vlr_liquido"));

        listNaoConciliados = srconciliacaoDAO.listarNaoConciliados();

        observableListNaoConciliados = FXCollections.observableArrayList(listNaoConciliados);
        tbViewNaoConciliado.setItems(observableListNaoConciliados);
    }

    public void handleButtonTransfConciliado() {

    }

    public void handleButtonTransfNaoConciliado() {

    }

    public void handleBtnReceitaConc() {

    }

    public void handleBtnReceitaNaoConc() {

    }

    public void carregarTableViewConciliados() {
        tbColEmissaoConciliado.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDocConciliado.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedorConciliado.setCellValueFactory(new PropertyValueFactory<>("id_fornecedor"));
        tbColDocFornecedorConciliado.setCellValueFactory(new PropertyValueFactory<>("doc_fornecedor"));
        tbColChequeConciliado.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValorConciliado.setCellValueFactory(new PropertyValueFactory<>("vlr_liquido"));

        listConciliados = srconciliacaoDAO.listarConciliados();

        observableListConciliados = FXCollections.observableArrayList(listConciliados);
        tbViewConciliado.setItems(observableListConciliados);
    }

    @FXML
    public void handleBtnConfirmar() {

        buttonConfirmarClicked = true;
        dialogStage.close();
    }

    @FXML
    public void handleBtnCancelar() {
        dialogStage.close();
    }

    public void carregartbViewReceitaNaoConc() {
        tbColEmissaoRNao.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDocRNao.setCellValueFactory(new PropertyValueFactory<>("nr_doc"));
        tbColFornecedorRNao.setCellValueFactory(new PropertyValueFactory<>("id_fornecedor"));
        tbColValorRNao.setCellValueFactory(new PropertyValueFactory<>("vlr_liquido"));

        listRecNaoConc = srconciliacaoDAO.listarRec();
        obsRecNaoConc = FXCollections.observableArrayList(listRecNaoConc);
        tbViewConciliado.setItems(observableListConciliados);

    }
    
}
