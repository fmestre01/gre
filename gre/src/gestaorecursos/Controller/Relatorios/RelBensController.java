package gestaorecursos.Controller.Relatorios;

import gestaorecursos.model.DAO.AnoDAO;
import gestaorecursos.model.DAO.TrimestreDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.DAO.relatorios.RelBensCeDAO;
import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Bem;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.component.Imprimir;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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
public class RelBensController implements Initializable {

    @FXML
    private Button btnImprimir;

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
    private TableView<Bem> tbViewBens;

    @FXML
    private TableColumn<Bem, String> tbColItem;

    @FXML
    private TableColumn<Bem, String> tbColDescricao;

    @FXML
    private TableColumn<Bem, Integer> tbColQtd;

    @FXML
    private TableColumn<Bem, String> tbColVlr_Unit;

    @FXML
    private TableColumn<Bem, Double> tbColVlr_total;

    private List<Bem> listBens;

    private ObservableList<Bem> observableListBens;

    @FXML
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Bem bem;

    //Atributos para manipulação de Banco de Dados
    private final UexDAO uexDao = new UexDAO();
    private final AnoDAO anoDao = new AnoDAO();
    private final TrimestreDAO trimestreDao = new TrimestreDAO();
    private final RelBensCeDAO relBensCeDao = new RelBensCeDAO();
    private final Imprimir imprimir = new Imprimir();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarUex();
        carregarAno();
        carregarTrimestre();
        carregarTableViewBens();

    }

    public void carregarTableViewBens() {
        tbColItem.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbColDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbColQtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tbColVlr_Unit.setCellValueFactory(cellData -> Bindings.format("%.2f", cellData.getValue().getVlr_unit()));
        
        tbColVlr_total.setCellValueFactory(new PropertyValueFactory<>("vlr_total"));

        listBens = relBensCeDao.listar();

        observableListBens = FXCollections.observableArrayList(listBens);
        tbViewBens.setItems(observableListBens);

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

    public Bem getBem() {
        return bem;
    }

    public void setBem(Bem bem) {
        this.bem = bem;
    }

    @FXML
    public void handleBtnImprimir()  {
          imprimir.ImprimirBens();
                
       
    }

    @FXML
    public void handleBtnCancelar() throws IOException {
        dialogStage.close();
    }

}
