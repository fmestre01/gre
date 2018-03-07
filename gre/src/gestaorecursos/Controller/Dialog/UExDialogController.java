package gestaorecursos.Controller.Dialog;

import gestaorecursos.model.DAO.BairroDAO;
import gestaorecursos.model.DAO.MunicipioDAO;
import gestaorecursos.model.DAO.TipoEntidadeDAO;
import gestaorecursos.model.DAO.UfDAO;
import gestaorecursos.model.domain.Bairro;
import gestaorecursos.model.domain.Municipio;
import gestaorecursos.model.domain.Uex;
import gestaorecursos.model.domain.Uf;
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
public class UExDialogController implements Initializable {

    @FXML
    private TextField txtFieldApelido;

    @FXML
    private TextField txtFieldUexF;

    @FXML
    private TextField txtFieldCNPJ;

    @FXML
    private TextField txtFieldEndRua;

    @FXML
    private TextField txtFieldEndNum;

    @FXML
    private TextField txtFieldCxPostal;

    @FXML
    private TextField txtFieldUndGestOrgFederal;

    @FXML
    private TextField txtFieldUex;

    @FXML
    private TextField txtFieldDDD;

    @FXML
    private TextField txtFieldTelEntidade;

    @FXML
    private TextField txtFieldGestorOrgFederal;

    @FXML
    private TextField txtFieldEndCompl;

    @FXML
    private TextField txtFieldTelefone;

    @FXML
    private TextField txtFieldFaxEntidade;

    @FXML
    private TextField txtFieldCNAS;

    @FXML
    private TextField txtFieldCEP;

    @FXML
    private TextField txtFieldFax;

    @FXML
    private TextField txtFieldNomeEscola;

    @FXML
    private TextField txtFieldCodCenso;
    
    @FXML
    private TextField txtFieldContmatic;


    @FXML
    private TextField txtFieldEmail;

    @FXML
    private ComboBox<Bairro> cbxBairro;
    private List<Bairro> listBairros = new ArrayList<>();
    private ObservableList<Bairro> obsBairro;

    @FXML
    private ComboBox<Municipio> cbxCidade;
    private List<Municipio> listMunicipios = new ArrayList<>();
    private ObservableList<Municipio> obsMunicipios;

    @FXML
    private ComboBox<Uf> cbxUf;
    private List<Uf> listUf = new ArrayList<>();
    private ObservableList<Uf> obsUf;


    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Uex uex;

    //Atributos para manipulação de Banco de Dados
    private final BairroDAO bairroDao = new BairroDAO();
    private final MunicipioDAO municipioDao = new MunicipioDAO();
    private final UfDAO ufDao = new UfDAO();
    private final TipoEntidadeDAO tipoentidadeDao = new TipoEntidadeDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarBairro();
        carregarMunicipio();
        carregarUf();

    }

    /**
     * @return the dialogStage
     */
    public Stage getDialogStage() {
        return dialogStage;
    }

    /**
     * @param dialogStage the dialogStage to set
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * @return the buttonConfirmarClicked
     */
    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    /**
     * @param buttonConfirmarClicked the buttonConfirmarClicked to set
     */
    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    /**
     * @return the uex
     */
    public Uex getUex() {
        return uex;
    }

    /**
     * @param uex the uex to set
     */
    public void setUex(Uex uex) {
        this.uex = uex;
        this.txtFieldApelido.setText(uex.getApelido());
        this.txtFieldUexF.setText(uex.getUexf());
        this.txtFieldUex.setText(uex.getUex());
        this.txtFieldCNPJ.setText(uex.getCNPJ());
        this.txtFieldEndRua.setText(uex.getEndRua());
        this.txtFieldEndNum.setText(uex.getEndNum());
        this.txtFieldEndCompl.setText(uex.getEndCompl());
        this.txtFieldCEP.setText(uex.getCEP());
        this.txtFieldCxPostal.setText(uex.getCxPostal());
        this.txtFieldDDD.setText(uex.getDdd());
        this.txtFieldTelefone.setText(uex.getTelefone());
        this.txtFieldFax.setText(uex.getFax());
        this.txtFieldEmail.setText(uex.getEmail());
        this.txtFieldTelEntidade.setText(uex.getTelEntidade());
        this.txtFieldFaxEntidade.setText(uex.getFaxEntidade());
        this.txtFieldUndGestOrgFederal.setText(uex.getUndGestoraOrgFed());
        this.txtFieldGestorOrgFederal.setText(uex.getGestorOrgFederal());
        this.txtFieldCNAS.setText(uex.getCNAS());
        this.txtFieldCodCenso.setText(uex.getCodCenso());
        this.txtFieldContmatic.setText(uex.getContmatic());
        this.txtFieldNomeEscola.setText(uex.getNomeEscola());
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

        cbxCidade.setItems(obsMunicipios);
    }

    public void carregarUf() {

        Uf cbt = new Uf();
        listUf = ufDao.listar();
        obsUf = FXCollections.observableArrayList(listUf);

        cbxUf.setItems(obsUf);
    }

    
    @FXML
    public void handleBtnConfirmar() {
        uex.setUex(txtFieldUex.getText());
        uex.setApelido(txtFieldApelido.getText());
        uex.setUexf(txtFieldUexF.getText());
        uex.setCNPJ(txtFieldCNPJ.getText());
        uex.setEndRua(txtFieldEndRua.getText());
        uex.setEndNum(txtFieldEndNum.getText());
        uex.setCEP(txtFieldCEP.getText());
        uex.setCxPostal(txtFieldCxPostal.getText());
        uex.setUndGestoraOrgFed(txtFieldUndGestOrgFederal.getText());
        uex.setDdd(txtFieldDDD.getText());
        uex.setTelEntidade(txtFieldTelEntidade.getText());
        uex.setTelEntidade(txtFieldTelefone.getText());
        uex.setFaxEntidade(txtFieldFaxEntidade.getText());
        uex.setCNAS(txtFieldCNAS.getText());
        uex.setFax(txtFieldFax.getText());
        uex.setNomeEscola(txtFieldNomeEscola.getText());
        uex.setCodCenso(txtFieldCodCenso.getText());
        uex.setEmail(txtFieldEmail.getText());
        uex.setBairro(cbxBairro.getValue());
        uex.setMunicipio(cbxCidade.getValue());
        uex.setUf(cbxUf.getValue());
        uex.setContmatic(txtFieldContmatic.getText());
        buttonConfirmarClicked = true;
        dialogStage.close();
    }

    @FXML
    public void handleBtnCancelar() {
        dialogStage.close();
    }

    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (txtFieldUex.getText() == null || txtFieldUex.getText().length() == 0) {
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
}
