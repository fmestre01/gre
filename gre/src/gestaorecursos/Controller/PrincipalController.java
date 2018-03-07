package gestaorecursos.Controller;

import static gestaorecursos.model.database.ConexaoDB.con;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class PrincipalController implements Initializable {

    @FXML
    private MenuItem menuItemCadBem;

    @FXML
    private MenuItem menuCadConta;

    @FXML
    private MenuItem menuCadDirigente;

    @FXML
    private MenuItem menuCadFornecedor;

    @FXML
    private MenuItem menuCadFornecedorPf;

    @FXML
    private MenuItem menuItemCadProgramas;

    @FXML
    private MenuItem menuItemCadUEx;

    @FXML
    private MenuItem menuItemCadHistoricos;

    @FXML
    private MenuItem menuItemCadTipoDoc;
    @FXML
    private MenuItem menuItemCadTipoEntidade;

    @FXML
    private MenuItem menuItemCadPlano;

    @FXML
    private MenuItem menuItemInserirRecebto;

    @FXML
    private MenuItem menuItemDespInserirDespesa;

    @FXML
    private MenuItem menuItemConciliarBanco;

    @FXML
    private MenuItem menuItemRelatoriosConciliacao;

    @FXML
    private MenuItem menuItemRelatoriosPagamentos;

    @FXML
    private MenuItem menuItemRelatoriosPrestContas;

    @FXML
    private MenuItem menuItemRelatoriosRelBens;

    @FXML
    private MenuItem menuItemRelatoriosTermoDoacao;

    @FXML
    private AnchorPane anchorPanePrincipal;

    @FXML
    private Label lbDB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (con != null) {
            lbDB.setText(".");
        } else {
        lbDB.setText("x");
        }
    }

    @FXML
    public void handleMenuItemCadUEx() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/uex/listaUex.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadDirigente() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/dirigente/listaDirigente.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadFornecedor() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/fornecedor/listaFornecedor.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadFornecedorPf() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/fornecedor/listaFornecedorPf.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadBancos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/banco/listaBanco.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadContas() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/conta/listaConta.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadProgramas() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/programas/listaProgramas.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    /*  ****    Início Sub Menu Cadastros Básicos *** */
    @FXML
    public void handleMenuItemCadBairros() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/bairro/listaBairro.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadCidades() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/municipios/listaMunicipios.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadUf() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/uf/listaUF.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadHistoricos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/historicos/listaHistoricos.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadTipoDoc() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/tipodoc/listaTipoDoc.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadTipoEntidade() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/tipoentidade/listaTipoEntidade.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    /*  ****    Fim Sub Menu Cadastros Básicos *** */
    @FXML
    public void handleMenuItemCadPlano() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/plancontas/listaPlanoDeContas.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemInserir() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/ContaEscola.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    public void handleMenuItemInserirRecebtos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/Recebimentos.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemConciliarBanco() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestaorecursos/views/Conciliacao.fxml"));
        anchorPanePrincipal.getChildren().setAll(a);
    }

}
