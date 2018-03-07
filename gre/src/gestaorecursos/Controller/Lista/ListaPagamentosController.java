package gestaorecursos.Controller.Lista;

import gestaorecursos.Controller.Dialog.ConsultaPgDialogController;
import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.ContaDAO;
import gestaorecursos.model.DAO.FornecedorDAO;
import gestaorecursos.model.DAO.HistoricoDAO;
import gestaorecursos.model.DAO.PagamentosDAO;
import gestaorecursos.model.DAO.ProgramaDAO;
import gestaorecursos.model.DAO.TipoDocDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Pagamentos;
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
public class ListaPagamentosController implements Initializable {

    @FXML
    private Button btnFiltrar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

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
    private TableView<Pagamentos> tbViewPagamentos;

    @FXML
    private TableColumn<Pagamentos, String> tbColId;

    @FXML
    private TableColumn<Pagamentos, String> tbColEmissao;

    @FXML
    private TableColumn<Pagamentos, String> tbColNum;

    @FXML
    private TableColumn<Pagamentos, String> tbColFornecedor;

    @FXML
    private TableColumn<Pagamentos, String> tbColValor;

    @FXML
    private TableColumn<Pagamentos, String> tbColUex;

    private List<Pagamentos> listPagamentos;

    private ObservableList<Pagamentos> observableListPagamentos;

    @FXML
    private Label lbPrograma;

    @FXML
    private Label lbUex;

    @FXML
    private Label lbFornecedor;

    @FXML
    private Label lbHistorico;

    @FXML
    private Label lbConta;

    @FXML
    private Label lbDataEmissao;

    @FXML
    private Label lbDataPagto;

    @FXML
    private Label lbNumDoc;

    @FXML
    private Label lbCheque;

    @FXML
    private Label lbDataCheque;

    @FXML
    private Label lbAno;

    @FXML
    private Label lbTrimestre;

    @FXML
    private Label lbValor;

    @FXML
    private Label lbInss;

    @FXML
    private Label lbPis;

    @FXML
    private Label lbIr;

    @FXML
    private Label lbIss;

    @FXML
    private Label lbVlrLiquido;

    @FXML
    private Label lbOutras;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Pagamentos pagamentos;

    //Atributos para manipulação de Banco de Dados
    private final PagamentosDAO pagamentosDao = new PagamentosDAO();
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

        pagamentosDao.getConnection();

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tbViewPagamentos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTbViewPagamentos(newValue));

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

    //*************** TABLEVIEW  ********************************************
    public void carregarTableViewPagamentos(String uexsearch, String trisearch, String anosearch) {
        tbColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbColEmissao.setCellValueFactory(new PropertyValueFactory<>("data_emissao"));
        tbColNum.setCellValueFactory(new PropertyValueFactory<>("nr_docto"));
        tbColFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tbColValor.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_liquido()));
        tbColUex.setCellValueFactory(new PropertyValueFactory<>("Uex"));

        listPagamentos = pagamentosDao.filtrar(uexsearch, trisearch, anosearch);

        observableListPagamentos = FXCollections.observableArrayList(listPagamentos);
        tbViewPagamentos.setItems(observableListPagamentos);

    }

    public void selecionarItemTbViewPagamentos(Pagamentos pagamentos) {
        if (pagamentos != null) {

            //*********Tratamento da inserção de valores ********
            NumberFormat nf = NumberFormat.getNumberInstance();

            lbPrograma.setText(String.valueOf(pagamentos.getPrograma()));
            lbUex.setText(String.valueOf(pagamentos.getUex()));
            lbFornecedor.setText(String.valueOf(pagamentos.getFornecedor()));
            lbHistorico.setText(pagamentos.getHistorico());
            lbConta.setText(String.valueOf(pagamentos.getConta()));
            lbCheque.setText(pagamentos.getCheque());
            lbDataEmissao.setText(String.valueOf(pagamentos.getData_emissao()));
            lbDataPagto.setText(String.valueOf(pagamentos.getData_emissao()));
            lbNumDoc.setText(pagamentos.getNr_docto());
            lbDataCheque.setText(String.valueOf(pagamentos.getDt_cheque()));
            lbAno.setText(String.valueOf(pagamentos.getAno()));
            lbTrimestre.setText((String.valueOf(pagamentos.getTrimestre())));
            lbValor.setText(String.valueOf(pagamentos.getValor()));
            lbInss.setText(String.valueOf(pagamentos.getVlr_inss()));
            lbPis.setText(String.valueOf(pagamentos.getVlr_piscofins()));
            lbIr.setText(String.valueOf(pagamentos.getVlr_ir())); 
            lbIss.setText(String.valueOf(pagamentos.getVlr_iss()));
            lbOutras.setText(String.valueOf(pagamentos.getVlr_adeduzir()));
            lbVlrLiquido.setText(String.valueOf(pagamentos.getVlr_liquido()));

        } else {
            lbPrograma.setText("");
            lbUex.setText("");
            lbFornecedor.setText("");
            lbHistorico.setText("");
            lbCheque.setText("");
            lbDataEmissao.setText("");
            lbDataPagto.setText("");
            lbNumDoc.setText("");
            lbDataCheque.setText("");
            lbAno.setText("");
            lbTrimestre.setText("");
            lbValor.setText("");
            lbInss.setText("");
            lbPis.setText("");
            lbIr.setText(""); 
            lbIss.setText("");
            lbOutras.setText("");
            lbVlrLiquido.setText("");
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

        carregarTableViewPagamentos((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
    }

    @FXML
    public void handleBtnAlterar(ActionEvent event) throws IOException, Exception {
        Pagamentos p = tbViewPagamentos.getSelectionModel().getSelectedItem();
        if (p != null) {
            boolean buttonConfirmarClicked = showConsultaPgDialog(p);
            if (buttonConfirmarClicked) {
                pagamentosDao.alterar(p);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um item na Tabela!");
            alert.show();
        }

    }

    @FXML
    public void handleBtnExcluir(ActionEvent event) throws IOException {
        Pagamentos p = tbViewPagamentos.getSelectionModel().getSelectedItem();
        if (p != null) {
            pagamentosDao.remover(p);
            carregarTableViewPagamentos((cbxUex.getValue().getUex()), (cbxTrimestre.getValue().getTrimestre()), (cbxAno.getValue().getAno()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    //******************* EXIBIR DIALOG ***********************************
    public boolean showConsultaPgDialog(Pagamentos p) throws IOException, ParseException, Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ListaPagamentosController.class.getResource("/gestaorecursos/views/pagamentos/ConsultaPgDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Alterar Pagamentos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ConsultaPgDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPagamentos(p);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

}

