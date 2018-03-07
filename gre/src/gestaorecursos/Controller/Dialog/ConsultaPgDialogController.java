package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.component.ConversorData;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class ConsultaPgDialogController implements Initializable {

    @FXML
    private ComboBox<Programa> cbxPrograma;
    private List<Programa> listProgramas = new ArrayList<>();
    private ObservableList<Programa> obsProgramas;

    @FXML
    private ComboBox<Uex> cbxUex;
    private List<Uex> listUex = new ArrayList<>();
    private ObservableList<Uex> obsUex;

    @FXML
    private ComboBox<Ano> cbxAno;
    private List<Ano> listAno = new ArrayList<>();
    private ObservableList<Ano> obsAno;

    @FXML
    private ComboBox<Trimestre> cbxTrimestre;
    private List<Trimestre> listTrimestre = new ArrayList<>();
    private ObservableList<Trimestre> obsTrimestre;

    @FXML
    private ComboBox<Fornecedor> cbxFornecedor;
    private List<Fornecedor> listFornecedor = new ArrayList<>();
    private ObservableList<Fornecedor> obsFornecedor;

    @FXML
    private DatePicker txtDtEmissao;

    @FXML
    private TextField txtNumDoc;

    @FXML
    private DatePicker txtDtPgto;

    @FXML
    private TextField txtHistorico;

    @FXML
    private TextField txtValor;
    
    @FXML
    private TextField txtInss;

    @FXML
    private TextField txtPis;

    @FXML
    private TextField txtIss;

    @FXML
    private TextField txtVlrLiquido;

    @FXML
    private TextField txtCheque;

    @FXML
    private DatePicker txtDtCheque;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private DatePicker txDtEmissao;

    @FXML
    private ComboBox<Conta> cbxDadosBancarios;
    private List<Conta> listConta = new ArrayList<>();
    private ObservableList<Conta> obsConta;

    @FXML
    private Label labelDadosBancarios;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnCancelar;

    @FXML
    private Stage dialogStage;
    private boolean butonConfirmarClicked = false;
    private Pagamentos pagamentos;

    //Atributos para manipulação de Banco de Dados
    private final ProgramaDAO programaDao = new ProgramaDAO();
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final FornecedorDAO fornecedorDao = new FornecedorDAO();
    private final ContaDAO contaDao = new ContaDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarProgramas();
        carregarUex();
        carregarAno();
        carregarTrimestre();
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
        return butonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.butonConfirmarClicked = buttonConfirmarClicked;
    }

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
        //Combobox
        this.cbxPrograma.setValue(pagamentos.getPrograma());
        this.cbxUex.setValue(pagamentos.getUex());
        this.cbxFornecedor.setValue(pagamentos.getFornecedor());
        this.cbxAno.setValue(pagamentos.getAno());
        this.cbxTrimestre.setValue(pagamentos.getTrimestre());
        this.cbxDadosBancarios.setValue(pagamentos.getConta());
        //TextField
        this.txtNumDoc.setText(pagamentos.getNr_docto());
        this.txtHistorico.setText(pagamentos.getHistorico());
        this.txtCheque.setText(pagamentos.getCheque());
        this.txtValor.setText(pagamentos.getValorFormatado());
        this.txtInss.setText(pagamentos.getVlr_inssFormatado());
        this.txtPis.setText(pagamentos.getVlr_piscofinsFormatado());
        this.txtIss.setText(pagamentos.getVlr_issFormatado());
        this.txtVlrLiquido.setText(pagamentos.getVlr_liquidoFormatado());
        
        //DatePicker
        this.txDtEmissao.setValue(ConversorData.converter(pagamentos.getData_emissao()));
        this.txtDtPgto.setValue(ConversorData.converter(pagamentos.getData_emissao()));
        this.txtDtCheque.setValue(ConversorData.converter(pagamentos.getData_emissao()));

    }

    
    
    // *************** ÁREA DAS COMBOBOX *******************
    // **
    // **
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

    public void carregarFornecedor() {
        //new AutoCompleteComboBoxListener(cbxFornecedor);
        Fornecedor cbu = new Fornecedor();
        listFornecedor = fornecedorDao.listar();
        obsFornecedor = FXCollections.observableArrayList(listFornecedor);

        cbxFornecedor.setItems(obsFornecedor);
    }

    public void carregarConta() {
        //new AutoCompleteComboBoxListener(cbxFornecedor);
        Conta cbc = new Conta();
        listConta = contaDao.listar();
        obsConta = FXCollections.observableArrayList(listConta);

        cbxDadosBancarios.setItems(obsConta);
    }

    // *************** ÁREA DOS BOTÕES *******************
    // **
    // **
    @FXML
    void handleBtnCancelar(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    void handleBtnInserir(ActionEvent event) {

    }

}
