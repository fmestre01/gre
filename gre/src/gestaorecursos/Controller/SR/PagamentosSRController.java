package gestaorecursos.Controller.SR;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.DAO.HistoricoDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.SRPagamentosDAO;
import gestaorecursos.model.DAO.TipoDocDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.TipoDoc;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.sr.PagamentosSR;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class PagamentosSRController implements Initializable {

    @FXML
    private Label labelPrograma;

    @FXML
    private ComboBox<Programa> cbxPrograma;    
    private List<Programa> listProgramas = new ArrayList<>();
    private ObservableList<Programa> obsProgramas;

    @FXML
    private Label labelUEx;

    @FXML
    private ComboBox<Uex> cbxUEx;
    private List<Uex> listUex = new ArrayList<>();
    private ObservableList<Uex> obsUex;

    @FXML
    private Label labelAno;

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

    @FXML
    private Label labelFornecedor;

    @FXML
    private ComboBox<Fornecedor> cbxFornecedor;
    private List<Fornecedor> listFornecedor = new ArrayList<>();
    private ObservableList<Fornecedor> obsFornecedor;

    @FXML
    private TextField txtFieldHistorico;

    @FXML
    private ToggleGroup tpdespesa;

    @FXML
    private RadioButton rdBtnProduto;

    @FXML
    private RadioButton rdBtnServicos;

    @FXML
    private DatePicker inputEmissao;

    @FXML
    private Label labelEmissao;

    @FXML
    private TextField txtFieldValor;

    @FXML
    private Label labelValor;

    @FXML
    private TextField txtFieldDocumento;

    @FXML
    private Label labelDocumento;

    @FXML
    private ComboBox<TipoDoc> cbxTipoDocumento;
    private List<TipoDoc> listTipo_doc = new ArrayList<>();
    private ObservableList<TipoDoc> obsTipoDoc;

    @FXML
    private Label labelTipoDocumento;

    @FXML
    private TextField txtFieldEmissaoChq;

    @FXML
    private Label labelEmissaoChq;

    @FXML
    private ToggleGroup tpcontratacao;

    @FXML
    private RadioButton rdBtnCusteio;

    @FXML
    private RadioButton rdBtnCapital;

    @FXML
    private Label labelCheque;

    @FXML
    private TextField txtFieldCheque;

    @FXML
    private Label labelHistorico;

    @FXML
    private DatePicker inputDtPagamento;

    @FXML
    private Label labelDtPagamento;

    @FXML
    private ComboBox<Conta> cbxDadosBancarios;
    private List<Conta> listConta = new ArrayList<>();
    private ObservableList<Conta> obsConta;

    @FXML
    private Label labelDadosBancarios;

    @FXML
    private DatePicker inputEmissaoCheque;

    @FXML
    private TextField txtFieldVlrLiquido;

    @FXML
    private Button btnInserir;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private PagamentosSR pagamentosSR;

    //Atributos para manipulação de Banco de Dados
    private final SRPagamentosDAO srpagamentosDao = new SRPagamentosDAO();
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
        carregarProgramas();
        carregarUex();
        carregarAno();
        carregarTrimestre();
        carregarTipoDoc();
        carregarFornecedor();
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

    public PagamentosSR getPagamentosSR() {
        return pagamentosSR;
    }

    public void setPagamentosSR(PagamentosSR pagamentosSR) {
        this.pagamentosSR = pagamentosSR;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public void carregarProgramas() {
        //new AutoCompleteComboBoxListener(cbxPrograma);
        Programa cbp = new Programa();
        listProgramas = programaDao.listar();
        obsProgramas = FXCollections.observableArrayList(listProgramas);

        cbxPrograma.setItems(obsProgramas);
    }

    public void carregarUex() {
        //new AutoCompleteComboBoxListener(cbxUEx);
        Uex cbu = new Uex();
        listUex = uexDao.listar();
        obsUex = FXCollections.observableArrayList(listUex);
    
        cbxUEx.setItems(obsUex);
    }

    public void carregarFornecedor() {
        //new AutoCompleteComboBoxListener(cbxFornecedor);
        Fornecedor cbu = new Fornecedor();
        listFornecedor = fornecedorDao.listar();
        obsFornecedor = FXCollections.observableArrayList(listFornecedor);

        cbxFornecedor.setItems(obsFornecedor);
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

    public void carregarTipoDoc() {
        TipoDoc cbtpdoc = new TipoDoc();
        listTipo_doc = tipodocDao.listar();
        obsTipoDoc = FXCollections.observableArrayList(listTipo_doc);

        cbxTipoDocumento.setItems(obsTipoDoc);
    }

    public void carregarConta() {
        Conta conta = new Conta();
        listConta = contaDao.listar();
        obsConta = FXCollections.observableArrayList(listConta);

        cbxDadosBancarios.setItems(obsConta);
    }

    

    @FXML
    public void handleBtnInserir() throws IOException, SQLException, Exception {
        PagamentosSR p = new PagamentosSR();
        p.setPrograma(cbxPrograma.getValue());
        p.setUex(cbxUEx.getValue());
        p.setAno(cbxAno.getValue());
        p.setTrimestre(cbxTrimestre.getValue());
        p.setData_emissao(inputEmissao.getValue());
        p.setTipo_doc(cbxTipoDocumento.getValue());
        p.setNr_docto(txtFieldDocumento.getText());
        p.setData_pg(inputDtPagamento.getValue());
        p.setFornecedor(cbxFornecedor.getValue());
        p.setHistorico(txtFieldHistorico.getText());
        p.setConta(cbxDadosBancarios.getValue());
        p.setCheque(txtFieldCheque.getText());
        p.setDt_cheque(inputEmissaoCheque.getValue());
        p.setValor(txtFieldValor.getText());

        srpagamentosDao.inserir(p);

        dialogStage.close();
    }

    @FXML
    public void handleBtnCancelar() throws IOException {
        dialogStage.close();
    }
    
}
