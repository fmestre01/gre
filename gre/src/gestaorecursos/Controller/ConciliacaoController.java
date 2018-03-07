package gestaorecursos.Controller;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ConciliacaoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.ConciliacaoDespesa;
import gestaorecursos.model.domain.ConciliacaoReceita;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class ConciliacaoController implements Initializable {

    @FXML
    private Label lbTotalDespesaConciliada;

    @FXML
    private Label lbTotalDespesaNAOConciliada;

    @FXML
    private Label lbTotalReceitaConciliada;

    @FXML
    private Label lbTotalReceitaNAOConciliada;

    // ** ÁREA DAS DESPESAS
    @FXML
    private Button btnDTransferirParaConciliado;

    @FXML
    private Button btnDTransferirParaNaoConciliado;

    @FXML
    private TableView<ConciliacaoDespesa> tbViewDespesaNaoConciliada;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColEmissaoNaoConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColNumDocNaoConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColFornecedorNaoConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColDocFornecedorNaoConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColChequeNaoConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColValorNaoConciliadoD;

    @FXML
    private TableView<ConciliacaoDespesa> tbViewDespesaConciliada;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColEmissaoConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColNumDocConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColFornecedorConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColDocFornecedorConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColChequeConciliadoD;

    @FXML
    private TableColumn<ConciliacaoDespesa, String> tbColValorConciliadoD;

    private List<ConciliacaoDespesa> listNaoConciliadosD;
    private ObservableList<ConciliacaoDespesa> obsNaoConciliadosD;

    private List<ConciliacaoDespesa> listConciliadosD;
    private ObservableList<ConciliacaoDespesa> obsConciliadosD;

    // ** ÁREA DAS RECEITAS
    @FXML
    private TableView<ConciliacaoReceita> tbViewReceitaNaoConciliada;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColDataNaoConciliadoR;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColNumDocNaoConciliadoR;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColHistoricoNaoConciliadoR;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColValorNaoConciliadoR;

    @FXML
    private TableView<ConciliacaoReceita> tbViewReceitaConciliada;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColDataConciliadoR;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColNumDocConciliadoR;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColHistoricoR;

    @FXML
    private TableColumn<ConciliacaoReceita, String> tbColValorConciliadoR;

    @FXML
    private Button btnRTransferirParaConciliado;

    @FXML
    private Button btnRTransferirParaNaoConciliado;

    private List<ConciliacaoReceita> listNaoConciliadosR;
    private ObservableList<ConciliacaoReceita> obsNaoConciliadosR;

    private List<ConciliacaoReceita> listConciliadosR;
    private ObservableList<ConciliacaoReceita> obsConciliadosR;

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
    private ConciliacaoReceita conciliacaoReceita;
    private ConciliacaoDespesa conciliacaoDespesa;
    //Atributos para manipulação de Banco de Dados
    private final ConciliacaoDAO conciliacaoDAO = new ConciliacaoDAO();
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final ContaDAO contaDao = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        conciliacaoDAO.getConnection();
        carregarTableViewDespesasNaoConciliadas();
        carregarTableViewDespesasConciliadas();
        carregartbViewReceitasNaoConciliadas();
        carregartbViewReceitasConciliadas();
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

    public ConciliacaoReceita getConciliacaoReceita() {
        return conciliacaoReceita;
    }

    public void setConciliacaoReceita(ConciliacaoReceita conciliacaoReceita) {
        this.conciliacaoReceita = conciliacaoReceita;
    }

    public ConciliacaoDespesa getConciliacaoDespesa() {
        return conciliacaoDespesa;
    }

    public void setConciliacaoDespesa(ConciliacaoDespesa conciliacaoDespesa) {
        this.conciliacaoDespesa = conciliacaoDespesa;
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

    //  ****** DESPESAS *********
    public void carregarTableViewDespesasNaoConciliadas() {

        tbColEmissaoNaoConciliadoD.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDocNaoConciliadoD.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedorNaoConciliadoD.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColDocFornecedorNaoConciliadoD.setCellValueFactory(new PropertyValueFactory<>("doc_fornecedor"));
        tbColChequeNaoConciliadoD.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValorNaoConciliadoD.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));
        listNaoConciliadosD = conciliacaoDAO.listarDespesaNaoConciliada();

        obsNaoConciliadosD = FXCollections.observableArrayList(listNaoConciliadosD);
        tbViewDespesaNaoConciliada.setItems(obsNaoConciliadosD);
    }
    
    public void carregarTableViewDespesasConciliadas() {
        tbColEmissaoConciliadoD.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNumDocConciliadoD.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedorConciliadoD.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColDocFornecedorConciliadoD.setCellValueFactory(new PropertyValueFactory<>("doc_fornecedor"));
        tbColChequeConciliadoD.setCellValueFactory(new PropertyValueFactory<>("cheque"));
        tbColValorConciliadoD.setCellValueFactory(new PropertyValueFactory<>("vlr_liquido"));
        tbColValorConciliadoD.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));
        listConciliadosD = conciliacaoDAO.listarDespesaConciliada();

        obsConciliadosD = FXCollections.observableArrayList(listConciliadosD);
        tbViewDespesaConciliada.setItems(obsConciliadosD);
    }
    // **** CONCILIAR DESPESAS

    public void handlebtnDTransferirParaNaoConciliado() {

    }

    public void handleBtnDTransferirParaConciliado() {

    }

    // **** CONCILIAR RECEITAS
    public void handleBtnRTransferirParaNaoConciliado() {

    }

    public void handleBtnRTransferirParaConciliado() {

    }

    /*
    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException{
        Bairro bairro = tbViewBairro.getSelectionModel().getSelectedItem();
        if (bairro != null) {
            bairroDAO.remover(bairro);
            carregarTableViewBairros();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
     */
    public void handleBtnReceitaConc() {

    }

    public void handleBtnReceitaNaoConc() {

    }


    public void carregartbViewReceitasNaoConciliadas() {
        tbColDataNaoConciliadoR.setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        tbColNumDocNaoConciliadoR.setCellValueFactory(new PropertyValueFactory<>("num_doc"));
        tbColHistoricoNaoConciliadoR.setCellValueFactory(new PropertyValueFactory<>("historico"));
        tbColValorNaoConciliadoR.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_receita()));

        listNaoConciliadosR = conciliacaoDAO.listarReceitaNaoConciliada();

        obsNaoConciliadosR = FXCollections.observableArrayList(listNaoConciliadosR);
        tbViewReceitaNaoConciliada.setItems(obsNaoConciliadosR);

    }

    public void carregartbViewReceitasConciliadas() {
        tbColDataConciliadoR.setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        tbColNumDocConciliadoR.setCellValueFactory(new PropertyValueFactory<>("num_doc"));
        tbColHistoricoR.setCellValueFactory(new PropertyValueFactory<>("historico"));
        tbColValorConciliadoR.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_receita()));

        listConciliadosR = conciliacaoDAO.listarReceitaConciliada();
        obsConciliadosR = FXCollections.observableArrayList(listConciliadosR);
        tbViewReceitaConciliada.setItems(obsConciliadosR);

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

}
