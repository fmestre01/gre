package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.BairroDAO;
import gestaorecursos.model.DAO.MunicipioDAO;
import gestaorecursos.model.DAO.PaisDAO;
import gestaorecursos.model.DAO.TipoPessoaDAO;
import gestaorecursos.model.DAO.UfDAO;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Pais;
import gestaorecursos.model.domain.TipoPessoa;
import gestaorecursos.model.domain.Uf;
import gestaorecursos.model.domain.component.AutoCompleteComboBoxListener;
import gestaorecursos.model.domain.component.TextFieldFormatter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class FornecedorPfDialogController implements Initializable {

     @FXML
    private TextField txtFieldNome;
    
    @FXML
    private TextField txtFieldNomeFantasia;

    @FXML
    private TextField txtFieldCnpj;

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
    private ComboBox<Pais> cbxPais;
    private List<Pais> listPais = new ArrayList<>();
    private ObservableList<Pais> obsPais;

    @FXML
    private ComboBox<TipoPessoa> cbxTipoPessoa;
    private List<TipoPessoa> listTipoPessoa = new ArrayList<>();
    private ObservableList<TipoPessoa> obsTipoPessoa;

    @FXML
    private TextField txtFieldDDD;

    @FXML
    private TextField txtFieldTelefone;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Fornecedor fornecedor;

    //Atributos para manipulação de Banco de Dados
    private final BairroDAO bairroDao = new BairroDAO();
    private final MunicipioDAO municipioDao = new MunicipioDAO();
    private final UfDAO ufDao = new UfDAO();
    private final PaisDAO paisDao = new PaisDAO();
    private final TipoPessoaDAO tipoPessoaDao = new TipoPessoaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarBairro();
        carregarMunicipio();
        carregarUf();
        carregarPais();
        carregarTipoPessoa();                
    }

    public void carregarBairro() {
    //    new AutoCompleteComboBoxListener(cbxBairro);
        Bairro cbt = new Bairro();
        listBairros = bairroDao.listar();
        obsBairro = FXCollections.observableArrayList(listBairros);

        cbxBairro.setItems(obsBairro);
    }

    public void carregarMunicipio() {
    //    new AutoCompleteComboBoxListener(cbxMunicipio);
        Municipio cbt = new Municipio();
        listMunicipios = municipioDao.listar();
        obsMunicipios = FXCollections.observableArrayList(listMunicipios);

        cbxMunicipio.setItems(obsMunicipios);
    }

    public void carregarUf() {
//        new AutoCompleteComboBoxListener(cbxUf);
        Uf cbt = new Uf();
        listUf = ufDao.listar();
        obsUf = FXCollections.observableArrayList(listUf);

        cbxUf.setItems(obsUf);
    }

    public void carregarPais() {
  //      new AutoCompleteComboBoxListener(cbxPais);
        Pais cbp = new Pais();
        listPais = paisDao.listar();
        obsPais = FXCollections.observableArrayList(listPais);

        cbxPais.setItems(obsPais);
    }

    public void carregarTipoPessoa() {

        TipoPessoa tpp = new TipoPessoa();
        listTipoPessoa = tipoPessoaDao.listar();
        obsTipoPessoa = FXCollections.observableArrayList(listTipoPessoa);

        cbxTipoPessoa.setItems(obsTipoPessoa);
    }
    
/*    @FXML
    private void formatarTelefone(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFieldTelefone);
        tff.formatter();
    }

    @FXML
    private void formatarCep(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFieldCep);
        tff.formatter();
    }

    @FXML
    private void formatarCnpj(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtFieldCnpj);
        tff.formatter();
    }
*/
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
        this.txtFieldNome.setText(fornecedor.getNome());
        this.txtFieldNomeFantasia.setText(fornecedor.getNomeFantasia());
        this.txtFieldCnpj.setText(fornecedor.getDoc_fornecedor());
        this.txtFieldEndRua.setText(fornecedor.getEndRua());
        this.txtFieldEndNum.setText(fornecedor.getEndNum());
        this.txtFieldEndCompl.setText(fornecedor.getEndCompl());
        this.txtFieldCep.setText(fornecedor.getCep());
        
        this.txtFieldTelefone.setText(fornecedor.getTelFixo());
        this.txtFieldEmail.setText(fornecedor.getEmail());
        
    }

    public void handleBtnConfirmar() {
        fornecedor.setNome(txtFieldNome.getText());
        fornecedor.setNomeFantasia(txtFieldNomeFantasia.getText());
        fornecedor.setDoc_fornecedor(txtFieldCnpj.getText());
        fornecedor.setEndRua(txtFieldEndRua.getText());
        fornecedor.setEndNum(txtFieldEndNum.getText());
        fornecedor.setEndCompl(txtFieldEndCompl.getText());
        fornecedor.setCep(txtFieldCep.getText());
        fornecedor.setBairro(cbxBairro.getValue());
        fornecedor.setCidade(cbxMunicipio.getValue());
        fornecedor.setUf(cbxUf.getValue());
        fornecedor.setPais(cbxPais.getValue());
        fornecedor.setTelFixo(txtFieldTelefone.getText());
        fornecedor.setEmail(txtFieldEmail.getText());
        fornecedor.setTipoPessoa(cbxTipoPessoa.getValue());
        
        buttonConfirmarClicked = true;
        dialogStage.close();
    }

    @FXML
    public void handleBtnCancelar() {
        dialogStage.close();
    }

/*    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (txtFieldNome.getText() == null || txtFieldNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }    
*/
}
