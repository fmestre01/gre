package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.SaldosDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Recebimentos;
import gestaorecursos.model.domain.Saldos;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.component.ConversorData;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.NumberFormat;
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
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class SaldosDialogController implements Initializable {

    @FXML
    private Label lbData;

    @FXML
    private DatePicker inputData;

    @FXML
    private TextField txtFieldSdoInicial;

    @FXML
    private TextField txtFieldVlrRepasse;

    @FXML
    private TextField txtFieldVlrAplicacao;

    @FXML
    private TextField txtFieldVlrRendAplicacao;

    @FXML
    private TextField txtFieldVlrPoupanca;

    @FXML
    private TextField txtFieldSdoInvestimentos;

    @FXML
    private TextField txtFieldSdoFinal;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

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
    private ComboBox<Conta> cbxConta;
    private List<Conta> listConta = new ArrayList<>();
    private ObservableList<Conta> obsConta;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Saldos saldos;

    //Atributos para manipulação de Banco de Dados
    private final ProgramaDAO programaDao = new ProgramaDAO();
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final SaldosDAO saldosDAO = new SaldosDAO();
    private final ContaDAO contaDao = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarProgramas();
        carregarUex();
        carregarAno();
        carregarTrimestre();
        carregarConta();
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

    public void carregarConta() {
        Conta conta = new Conta();
        listConta = contaDao.listar();
        obsConta = FXCollections.observableArrayList(listConta);

        cbxConta.setItems(obsConta);
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

    public Saldos getSaldos() {
        return saldos;
    }

    public void setSaldos(Saldos saldos) {
        this.saldos = saldos;
    }

    public void handleBtnConfirmar() throws IOException, SQLException, Exception {
        Saldos s = new Saldos();

        //*********Tratamento da inserção de valores ********
        NumberFormat nf = NumberFormat.getNumberInstance();

        //*********Tratamento da inserção de data ********
        lbData.setTextFill(Paint.valueOf("#333333"));

        boolean erro = false;
        try {
            s.setData(ConversorData.converter(inputData.getValue()));
        } catch (Exception e) {
            lbData.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        s.setSdo_inicial(nf.parse(txtFieldSdoInicial.getText()).doubleValue());
        s.setVlr_repasse(nf.parse(txtFieldVlrRepasse.getText()).doubleValue());
        s.setVlr_aplicacao(nf.parse(txtFieldVlrAplicacao.getText()).doubleValue());
        s.setVlr_renAplicacao(nf.parse(txtFieldVlrRendAplicacao.getText()).doubleValue());
        s.setVlr_poupanca(nf.parse(txtFieldVlrPoupanca.getText()).doubleValue());
        s.setSdo_investimentos(nf.parse(txtFieldSdoInvestimentos.getText()).doubleValue());
        s.setPrograma(cbxPrograma.getValue());
        s.setUex(cbxUex.getValue());
        s.setAno(cbxAno.getValue());
        s.setTrimestre(cbxTrimestre.getValue());
        s.setConta(cbxConta.getValue());

        saldosDAO.inserir(s);

        dialogStage.close();
    }

    public void handleBtnCancelar() {

        dialogStage.close();
    }

}
