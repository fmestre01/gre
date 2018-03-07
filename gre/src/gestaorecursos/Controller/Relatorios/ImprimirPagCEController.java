package gestaorecursos.Controller.Relatorios;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.DAO.PagamentosDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.database.ConexaoDB;
import gestaorecursos.model.database.ConnectionFactory;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.component.Imprimir;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class ImprimirPagCEController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUex;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtTrimestre;

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
    private Button btnImprimir;

    @FXML
    private Button btnCancelar;

    private List<Pagamentos> listPagamentos;

    private ObservableList<Pagamentos> observableListPagamentos;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Pagamentos pag;

    //Atributos para manipulação de Banco de Dados
    private final PagamentosDAO pagamentosDao = new PagamentosDAO();
    private final UexDAO uexDao = new UexDAO();
    private final FornecedorDAO fornecedorDao = new FornecedorDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final Imprimir imprimir = new Imprimir();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarUex();
        carregarAno();
        carregarTrimestre();

    }

    public void carregarUex() {
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

    public Pagamentos getPag() {
        return pag;
    }

    public void setPag(Pagamentos pag) {
        this.pag = pag;
    }

    public void handleBtnImprimir() throws JRException, IOException {

        Thread t;
        t = new Thread() {

            @Override
            public void run() {
// C:/Users/mgonc/Documents/NetBeansProjects
                try {

                    Connection con = ConexaoDB.getConnection();
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getClassLoader().getResource("gestaorecursos/relatorios/RelPagamentosCE.jasper"));

                    Map filtro = new HashMap();
                    filtro.put("IdUex", (cbxUex.getValue()));
                    filtro.put("IdAno", (cbxAno.getValue()));
                    filtro.put("IdTrimestre", (cbxTrimestre.getValue()));

                    JasperPrint jprint = JasperFillManager.fillReport("RelPagamentosCE.jasper", filtro, con);
                    JasperViewer.viewReport(jprint, false);
                } catch (JRException ex) {
                    System.err.println("Erro " + ex);
                }

            }
        };
        t.start();
    }

    public void handleBtnCancelar() {
        dialogStage.close();
    }

}
