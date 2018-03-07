package gestaorecursos.Controller.SR;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.SRDeducoesDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.component.ConversorData;
import gestaorecursos.model.domain.sr.DeducoesSR;
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
public class DeducoesSRController implements Initializable {

    @FXML
    private Label lbData;
    @FXML
    private DatePicker inputData;

    @FXML
    private TextField txtFieldNumDoc;

    @FXML
    private TextField txtFieldValor;

    @FXML
    private TextField txtFieldHistorico;

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
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private DeducoesSR deducoesSR;

    //Atributos para manipulação de Banco de Dados
    private final ProgramaDAO programaDao = new ProgramaDAO();
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final SRDeducoesDAO srdeducoesDao = new SRDeducoesDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarProgramas();
        carregarUex();
        carregarAno();
        carregarTrimestre();
    }

    public void handleBtnConfirmar() throws IOException, SQLException, Exception {
        DeducoesSR a = new DeducoesSR();
        
        //*********Tratamento da inserção de valores ********
        NumberFormat nf = NumberFormat.getNumberInstance();
        
        //*********Tratamento da inserção de data ********
        lbData.setTextFill(Paint.valueOf("#333333"));

        boolean erro = false;
        try {
            a.setData_deducao(ConversorData.converter(inputData.getValue()));
        } catch (Exception e) {
            lbData.setTextFill(Paint.valueOf("red"));
            erro = true;
        }
        
        a.setNum_doc(txtFieldNumDoc.getText());
        a.setHistorico(txtFieldHistorico.getText());
        a.setVlr_deducao(nf.parse(txtFieldValor.getText()).doubleValue());
        a.setPrograma(cbxPrograma.getValue());
        a.setUex(cbxUex.getValue());
        a.setAno(cbxAno.getValue());
        a.setTrimestre(cbxTrimestre.getValue());

        srdeducoesDao.inserir(a);

        dialogStage.close();
    }

    public void handleBtnCancelar() {

        dialogStage.close();
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

    public DeducoesSR getDeducoes() {
        return deducoesSR;
    }

    public void setDeducoes(DeducoesSR deducoesSR) {
        this.deducoesSR = deducoesSR;
    }
    
}
