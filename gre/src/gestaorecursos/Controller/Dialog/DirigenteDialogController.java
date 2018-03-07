package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.BairroDAO;
import gestaorecursos.model.DAO.DirigenteDAO;
import gestaorecursos.model.DAO.EstadoCivilDAO;
import gestaorecursos.model.DAO.MunicipioDAO;
import gestaorecursos.model.DAO.PaisDAO;
import gestaorecursos.model.DAO.SexoDAO;
import gestaorecursos.model.DAO.TipoPessoaDAO;
import gestaorecursos.model.DAO.UexDAO;
import gestaorecursos.model.DAO.UfDAO;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Dirigente;
import gestaorecursos.model.domain.EstadoCivil;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Pais;
import gestaorecursos.model.domain.Sexo;
import gestaorecursos.model.domain.TipoPessoa;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.Uf;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class DirigenteDialogController implements Initializable {

    @FXML
    private TextField txtFieldCpf;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtFieldNacionalidade;

    @FXML
    private ComboBox<Sexo> cbxSexo;
    private List<Sexo> listSexo = new ArrayList<>();
    private ObservableList<Sexo> obsSexo;

    @FXML
    private ComboBox<EstadoCivil> cbxECivil;
    private List<EstadoCivil> listEstadoCivil = new ArrayList<>();
    private ObservableList<EstadoCivil> obsEstadoCivil;

    @FXML
    private TextField txtFieldEndRua;

    @FXML
    private TextField txtFieldEndNum;

    @FXML
    private TextField txtFieldEndCompl;

    @FXML
    private TextField txtFieldCep;

    @FXML
    private ComboBox<Bairro> cbxBairro;
    private List<Bairro> listBairros = new ArrayList<>();
    private ObservableList<Bairro> obsBairro;

    @FXML
    private ComboBox<Municipio> cbxMunicipio;
    private List<Municipio> listMunicipios = new ArrayList<>();
    private ObservableList<Municipio> obsMunicipios;

    @FXML
    private ComboBox<Uf> cbxUf;
    private List<Uf> listUf = new ArrayList<>();
    private ObservableList<Uf> obsUf;

    @FXML
    private ComboBox<Uex> cbxUex;
    private List<Uex> listUex = new ArrayList<>();
    private ObservableList<Uex> obsUex;

    @FXML
    private ComboBox<Pais> cbxPais;
    private List<Pais> listPais = new ArrayList<>();
    private ObservableList<Pais> obsPais;

    @FXML
    private ComboBox<TipoPessoa> cbxTipoPessoa;
    private List<TipoPessoa> listTipoPessoa = new ArrayList<>();
    private ObservableList<TipoPessoa> obsTipoPessoa;

    @FXML
    private TextField txtFieldDdd;

    @FXML
    private TextField txtFieldTel;

    @FXML
    private TextField txtFieldFax;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFieldCargo;

    @FXML
    private TextField txtFieldIdentidade;

    @FXML
    private DatePicker datePickerEmissao;

    @FXML
    private TextField txtFieldOrgaoExp;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Dirigente dirigente;

    //Atributos para manipulação de Banco de Dados
    private final BairroDAO bairroDao = new BairroDAO();
    private final MunicipioDAO municipioDao = new MunicipioDAO();
    private final UfDAO ufDao = new UfDAO();
    private final PaisDAO paisDao = new PaisDAO();
    private final UexDAO uexDao = new UexDAO();
    private final SexoDAO sexoDao = new SexoDAO();
    private final EstadoCivilDAO estadocivilDao = new EstadoCivilDAO();
    private final TipoPessoaDAO tipopessoaDao = new TipoPessoaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTipoPessoa();
        carregarBairro();
        carregarMunicipio();
        carregarUf();
        carregarPais();
        carregarUex();
        carregarSexo();
        carregarEstadoCivil();
    }

    public void carregarBairro() {

        Bairro cbt = new Bairro();
        listBairros = bairroDao.listar();
        obsBairro = FXCollections.observableArrayList(listBairros);

        cbxBairro.setItems(obsBairro);
    }

    public void carregarMunicipio() {

        Municipio cbt = new Municipio();
        listMunicipios = municipioDao.listar();
        obsMunicipios = FXCollections.observableArrayList(listMunicipios);

        cbxMunicipio.setItems(obsMunicipios);
    }

    public void carregarUf() {

        Uf cbt = new Uf();
        listUf = ufDao.listar();
        obsUf = FXCollections.observableArrayList(listUf);

        cbxUf.setItems(obsUf);
    }

    public void carregarPais() {
        Pais cbt = new Pais();
        listPais = paisDao.listar();
        obsPais = FXCollections.observableArrayList(listPais);

        cbxPais.setItems(obsPais);
    }

    public void carregarUex() {
        Uex cbt = new Uex();
        listUex = uexDao.listar();
        obsUex = FXCollections.observableArrayList(listUex);

        cbxUex.setItems(obsUex);
    }

    public void carregarSexo() {

        Sexo cbt = new Sexo();
        listSexo = sexoDao.listar();
        obsSexo = FXCollections.observableArrayList(listSexo);

        cbxSexo.setItems(obsSexo);
    }

    public void carregarEstadoCivil() {

        EstadoCivil cbt = new EstadoCivil();
        listEstadoCivil = estadocivilDao.listar();
        obsEstadoCivil = FXCollections.observableArrayList(listEstadoCivil);

        cbxECivil.setItems(obsEstadoCivil);
    }

    public void carregarTipoPessoa() {

        TipoPessoa tpp = new TipoPessoa();
        listTipoPessoa = tipopessoaDao.listar();
        obsTipoPessoa = FXCollections.observableArrayList(listTipoPessoa);

        cbxTipoPessoa.setItems(obsTipoPessoa);
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

    public Dirigente getDirigente() {
        return dirigente;
    }

    public void setDirigente(Dirigente dirigente) {
        this.dirigente = dirigente;
        this.cbxTipoPessoa.setValue(dirigente.getTipopessoa());
        this.txtNome.setText(dirigente.getNome());
        this.txtFieldCpf.setText(dirigente.getDoc_fornecedor());
        this.txtFieldNacionalidade.setText(dirigente.getNacionalidade());
        this.cbxSexo.setValue(dirigente.getSexo());
        this.cbxECivil.setValue(dirigente.getEstadocivil());
        this.txtFieldEndRua.setText(dirigente.getEndRua());
        this.txtFieldEndNum.setText(dirigente.getEndNum());
        this.txtFieldEndCompl.setText(dirigente.getEndCompl());
        this.txtFieldCep.setText(dirigente.getCep());
        this.cbxBairro.setValue(dirigente.getBairro());
        this.cbxMunicipio.setValue(dirigente.getMunicipio());
        this.cbxUf.setValue(dirigente.getUf());
        this.cbxPais.setValue(dirigente.getPais());
        this.txtFieldDdd.setText(dirigente.getDdd());
        this.txtFieldTel.setText(dirigente.getTelFixo());
        this.txtFieldFax.setText(dirigente.getTelCel());
        this.txtFieldEmail.setText(dirigente.getEmail());
        this.txtFieldCargo.setText(dirigente.getCargo());
        this.txtFieldIdentidade.setText(dirigente.getIdentidade());
        this.datePickerEmissao.setValue(dirigente.getEmissao());
        this.txtFieldOrgaoExp.setText(dirigente.getOrgemissor());
        this.cbxUex.setValue(dirigente.getUex());
    }

    public void handleBtnConfirmar() throws SQLException, Exception {
        dirigente.setTipopessoa(cbxTipoPessoa.getValue());
        dirigente.setDoc_fornecedor(txtFieldCpf.getText());
        dirigente.setNome(txtNome.getText());
        dirigente.setNacionalidade(txtFieldNacionalidade.getText());
        dirigente.setSexo(cbxSexo.getValue());
        dirigente.setEstadocivil(cbxECivil.getValue());
        dirigente.setEndRua(txtFieldEndRua.getText());
        dirigente.setEndNum(txtFieldEndNum.getText());
        dirigente.setEndCompl(txtFieldEndCompl.getText());
        dirigente.setCep(txtFieldCep.getText());
        dirigente.setBairro(cbxBairro.getValue());
        dirigente.setMunicipio(cbxMunicipio.getValue());
        dirigente.setUf(cbxUf.getValue());
        dirigente.setPais(cbxPais.getValue());
        dirigente.setDdd(txtFieldDdd.getText());
        dirigente.setTelFixo(txtFieldTel.getText());
        dirigente.setTelCel(txtFieldFax.getText());
        dirigente.setEmail(txtFieldEmail.getText());
        dirigente.setCargo(txtFieldCargo.getText());
        dirigente.setIdentidade(txtFieldIdentidade.getText());
        dirigente.setEmissao(datePickerEmissao.getValue());
        dirigente.setOrgemissor(txtFieldOrgaoExp.getText());
        dirigente.setUex(cbxUex.getValue());

        buttonConfirmarClicked = true;
        dialogStage.close();
    }

    @FXML
    public void handleBtnCancelar() {
        dialogStage.close();
    }

}
