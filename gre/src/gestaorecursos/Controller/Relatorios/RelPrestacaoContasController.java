package gestaorecursos.Controller.Relatorios;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.DAO.PagamentosDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.DAO.relatorios.RelPContasCtaEscolaDAO;
import gestaorecursos.model.database.ConexaoDB;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.component.Imprimir;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class RelPrestacaoContasController implements Initializable {

    @FXML
    private Label lbSdoInicial;

    @FXML
    private Label lbRepasse;

    @FXML
    private Label lbOutras;

    @FXML
    private Label lbTotalRec;

    @FXML
    private Label lbDespesas;

    @FXML
    private Label lbSdoFinal;

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

    @FXML
    private TableView<Pagamentos> tbViewPCO;

    @FXML
    private TableColumn<Pagamentos, Integer> tbColItem;

    @FXML
    private TableColumn<Pagamentos, Date> tbColData;

    @FXML
    private TableColumn<Pagamentos, String> tbColNumDoc;

    @FXML
    private TableColumn<Pagamentos, Integer> tbColFornecedor;

    @FXML
    private TableColumn<Pagamentos, String> tbColDocFornecedor;

    @FXML
    private TableColumn<Pagamentos, String> tbColCheque;

    @FXML
    private TableColumn<Pagamentos, String> tbColValor;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnImprimir;

    private List<Pagamentos> listPagamentos;

    private ObservableList<Pagamentos> observableListPagamentos;

    @FXML
    private Label lbDB;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Pagamentos pagamentos;

    //Atributos para manipulação de Banco de Dados
    private final PagamentosDAO pagamentosDao = new PagamentosDAO();
    private final UexDAO uexDao = new UexDAO();
    private final FornecedorDAO fornecedorDao = new FornecedorDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final RelPContasCtaEscolaDAO relpcontasCtaEscolaDao = new RelPContasCtaEscolaDAO();
    private final Imprimir imprimir = new Imprimir();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarUex();
        carregarAno();
        carregarTrimestre();
        carregarTableViewFornecedor();

        ConexaoDB con = new ConexaoDB();

        if (con != null) {
            lbDB.setText(".");
        } else {
            lbDB.setText("x");
        }

    }

    public void carregarTableViewFornecedor() {

        tbColItem.setCellValueFactory(new PropertyValueFactory<>("idcpag"));
        tbColData.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDoc.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColDocFornecedor.setCellValueFactory(new PropertyValueFactory<>("doc_fornecedor"));
        tbColCheque.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValor.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));

        listPagamentos = relpcontasCtaEscolaDao.listar();

        observableListPagamentos = FXCollections.observableArrayList(listPagamentos);
        tbViewPCO.setItems(observableListPagamentos);

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

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void carregarTableViewPorUex(String uexsearch, String trisearch, String anosearch) {

        tbColItem.setCellValueFactory(new PropertyValueFactory<>("idcpag"));
        tbColData.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDoc.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColDocFornecedor.setCellValueFactory(new PropertyValueFactory<>("doc_fornecedor"));
        tbColCheque.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValor.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));

        listPagamentos = relpcontasCtaEscolaDao.buscarUex(uexsearch, trisearch, anosearch);

        observableListPagamentos = FXCollections.observableArrayList(listPagamentos);
        tbViewPCO.setItems(observableListPagamentos);

    }

    public void handleBtnBuscar()  {
        try{
        carregarTableViewPorUex((cbxUex.getValue().getUex()),(cbxTrimestre.getValue().getTrimestre()),(cbxAno.getValue().getAno()));
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }

    @FXML
    public void handleBtnImprimir() {
        
       
            imprimir.ImprimirPagamentosCE();
        }
    

    @FXML
    public void handleBtnCancelar() {

    }
}
