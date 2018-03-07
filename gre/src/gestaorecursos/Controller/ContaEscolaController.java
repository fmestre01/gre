package gestaorecursos.Controller;

import gestaorecursos.Controller.Dialog.AdicoesDialogController;
import gestaorecursos.Controller.Dialog.BairroDialogController;
import gestaorecursos.Controller.Dialog.BemDialogController;
import gestaorecursos.Controller.Dialog.DeducoesDialogController;
import gestaorecursos.Controller.Dialog.SaldosDialogController;
import gestaorecursos.Controller.Lista.ListaPagamentosController;
import gestaorecursos.Controller.Lista.ListaRecebimentosController;
import gestaorecursos.Controller.Relatorios.ImprimirBensCEController;
import gestaorecursos.Controller.Relatorios.ImprimirConcCEController;
import gestaorecursos.Controller.Relatorios.ImprimirPagCEController;
import gestaorecursos.Controller.Relatorios.RelPrestacaoContasController;
import gestaorecursos.Controller.SR.AdicoesSRController;
import gestaorecursos.Controller.SR.ConciliacaoSRController;
import gestaorecursos.Controller.SR.DeducoesSRController;
import gestaorecursos.Controller.SR.PagamentosSRController;
import gestaorecursos.Controller.SR.RecebimentosSRController;
import gestaorecursos.Controller.SR.SaldosSRController;
import static gestaorecursos.model.database.ConexaoDB.con;
import gestaorecursos.model.domain.Adicoes;
import gestaorecursos.model.domain.Bem;
import gestaorecursos.model.domain.Deducoes;
import gestaorecursos.model.domain.Pagamentos;
import gestaorecursos.model.domain.Recebimentos;
import gestaorecursos.model.domain.Saldos;
import gestaorecursos.model.domain.sr.AdicoesSR;
import gestaorecursos.model.domain.sr.ConciliacaoSR;
import gestaorecursos.model.domain.sr.DeducoesSR;
import gestaorecursos.model.domain.sr.PagamentosSR;
import gestaorecursos.model.domain.sr.RecebimentosSR;
import gestaorecursos.model.domain.sr.SaldosSR;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mgonc
 */
public class ContaEscolaController implements Initializable {

    @FXML
    private Button btnPagamentos;

    @FXML
    private Button btnConsultarPg;
    
    @FXML
    private Button btnConsultarRec;

    @FXML
    private Button btnDeducao;

    @FXML
    private Button btnRecebimentos;

    @FXML
    private Button btnAdicao;

    @FXML
    private Button btnSaldos;

    @FXML
    private Button btnInserirBens;

    @FXML
    private Button btnConciliacao;

    @FXML
    private Button btnSRPagamentos;

    @FXML
    private Button btnSRRecebimentos;

    @FXML
    private Button btnSRSaldos;

    @FXML
    private Button btnSRConciliacao;

    @FXML
    private Button btnSRAdicao;

    @FXML
    private Button btnSRDeducao;

    @FXML
    private Button btnRelPrestContas;

    @FXML
    private Button btnRelConciliacao;

    @FXML
    private Button btnRelBens;
    
    @FXML
    private Button btnImprimirPagCE;

    @FXML
    private Label lbDB;

    @FXML
    private AnchorPane AnchorPane;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (con != null) {
            lbDB.setText(".");
        } else {
            lbDB.setText("x");
        }

      
    }

    /*   *** ÁREA DE BOTÕES DE PAGAMENTOS ***   */
    @FXML
    public void handleOpenPagamentos(ActionEvent event) throws IOException {
        Pagamentos pagamentos = new Pagamentos();
        boolean buttonConfirmarClicked = showPagamentos(pagamentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showPagamentos(Pagamentos pagamentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(BairroDialogController.class.getResource("/gestaorecursos/views/Pagamentos.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Pagamentos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        PagamentosController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPagamentos(pagamentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleOpenDeducao(ActionEvent event) throws IOException {
        Deducoes deducoes = new Deducoes();
        boolean buttonConfirmarClicked = showDeducao(deducoes);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showDeducao(Deducoes deducoes) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DeducoesDialogController.class.getResource("/gestaorecursos/views/deducoes/DeducoesDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Deduções");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        DeducoesDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setDeducoes(deducoes);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnConsultarPg(ActionEvent event) throws IOException, ParseException {
        Pagamentos pagamentos = new Pagamentos();
        boolean buttonConfirmarClicked = showConsultaPg(pagamentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showConsultaPg(Pagamentos pagamentos) throws IOException, ParseException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ListaPagamentosController.class.getResource("/gestaorecursos/views/pagamentos/listaPagamentos.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Alterar Pagamentos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ListaPagamentosController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPagamentos(pagamentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        
        return controller.isButtonConfirmarClicked();
    }

    /*   *** RECEBIMENTOS ***   */
    @FXML
    public void handleOpenRecebimentos(ActionEvent event) throws IOException {
        Recebimentos recebimentos = new Recebimentos();
        boolean buttonConfirmarClicked = showRecebimentos(recebimentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showRecebimentos(Recebimentos recebimentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RecebimentosController.class.getResource("/gestaorecursos/views/Recebimentos.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Recebimentos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        RecebimentosController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setRecebimentos(recebimentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleOpenAdicao(ActionEvent event) throws IOException {
        Adicoes adicoes = new Adicoes();
        boolean buttonConfirmarClicked = showAdicao(adicoes);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showAdicao(Adicoes adicoes) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AdicoesDialogController.class.getResource("/gestaorecursos/views/adicoes/AdicoesDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Adições");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        AdicoesDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setAdicoes(adicoes);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }
    
    @FXML
    public void handleBtnConsultarRec(ActionEvent event) throws IOException {
        Recebimentos recebimentos = new Recebimentos();
        boolean buttonConfirmarClicked = showConsultaRec(recebimentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showConsultaRec(Recebimentos recebimentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ListaRecebimentosController.class.getResource("/gestaorecursos/views/recebimentos/listaRecebimentos.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Alterar de Recebimentos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ListaRecebimentosController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setRecebimentos(recebimentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }


    /*   *** SALDOS ***   */
    @FXML
    public void handleBtnSaldos(ActionEvent event) throws IOException {
        Saldos saldos = new Saldos();
        boolean buttonConfirmarClicked = showSaldos(saldos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showSaldos(Saldos saldos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SaldosDialogController.class.getResource("/gestaorecursos/views/saldos/SaldosDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Saldos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        SaldosDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setSaldos(saldos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    /*   *** BENS ***   */
    @FXML
    public void handleOpenInserirBens(ActionEvent event) throws IOException {
        Bem bem = new Bem();
        boolean buttonConfirmarClicked = showBem(bem);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showBem(Bem bem) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(BemDialogController.class.getResource("/gestaorecursos/views/bem/BemDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Bens");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        BemDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setBem(bem);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    /*   *** CONCILIAÇÃO ***   */
    @FXML
    public void handleBtnConciliacao(ActionEvent event) throws IOException {
        Pagamentos pagamentos = new Pagamentos();
        boolean buttonConfirmarClicked = showConciliacao(pagamentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showConciliacao(Pagamentos pagamentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PainelConciliacaoController.class.getResource("/gestaorecursos/views/PainelConciliacao.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Conciliar Conta Bancária");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        PainelConciliacaoController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPagamentos(pagamentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    /* ************************ SALA DE RECURSOS************************   */
    @FXML
    public void handleBtnSRPagamentos(ActionEvent event) throws IOException {
        PagamentosSR pagamentosSR = new PagamentosSR();
        boolean buttonConfirmarClicked = showPagamentosSR(pagamentosSR);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showPagamentosSR(PagamentosSR pagamentosSR) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PagamentosSRController.class.getResource("/gestaorecursos/views/sr/PagamentosSR.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Pagamentos - Sala de Recursos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        PagamentosSRController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPagamentosSR(pagamentosSR);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnSRDeducao(ActionEvent event) throws IOException {
        DeducoesSR deducoesSR = new DeducoesSR();
        boolean buttonConfirmarClicked = showDeducaoSR(deducoesSR);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showDeducaoSR(DeducoesSR deducoesSR) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DeducoesSRController.class.getResource("/gestaorecursos/views/sr/DeducoesSR.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Deduções - Sala de Recursos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        DeducoesSRController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setDeducoes(deducoesSR);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnSRRecebimentos(ActionEvent event) throws IOException {
        RecebimentosSR recebimentosSR = new RecebimentosSR();
        boolean buttonConfirmarClicked = showRecebimentosSR(recebimentosSR);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showRecebimentosSR(RecebimentosSR recebimentosSR) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RecebimentosSRController.class.getResource("/gestaorecursos/views/sr/RecebimentosSR.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Recebimentos - Sala de Recursos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        RecebimentosSRController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setRecebimentosSR(recebimentosSR);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnSRAdicao(ActionEvent event) throws IOException {
        AdicoesSR adicoesSR = new AdicoesSR();
        boolean buttonConfirmarClicked = showAdicaoSR(adicoesSR);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showAdicaoSR(AdicoesSR adicoesSR) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AdicoesSRController.class.getResource("/gestaorecursos/views/sr/AdicoesSR.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Adições - Sala de Recursos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        AdicoesSRController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setAdicoesSR(adicoesSR);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnSRSaldos(ActionEvent event) throws IOException {
        SaldosSR saldosSR = new SaldosSR();
        boolean buttonConfirmarClicked = showSaldosSR(saldosSR);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showSaldosSR(SaldosSR saldosSR) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SaldosSRController.class.getResource("/gestaorecursos/views/sr/SaldosSR.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Saldos - Sala de Recursos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        SaldosSRController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setSaldosSR(saldosSR);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnSRConciliacao(ActionEvent event) throws IOException {
        ConciliacaoSR conciliacaoSR = new ConciliacaoSR();
        boolean buttonConfirmarClicked = showConciliacaoSR(conciliacaoSR);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showConciliacaoSR(ConciliacaoSR conciliacaoSR) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ConciliacaoSRController.class.getResource("/gestaorecursos/views/sr/ConciliacaoSR.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Conciliar Conta Bancária - Sala de Recursos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ConciliacaoSRController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setConciliacaoSR(conciliacaoSR);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }


    /*  ************ FIM SALA DE RECURSOS *******************  */

 /*  ********************** RELATÓRIOS *******************  */
    @FXML
    public void handleBtnRelConciliacao(ActionEvent event) throws IOException {
        Pagamentos pagamentos = new Pagamentos();
        boolean buttonConfirmarClicked = showRelConciliacao(pagamentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showRelConciliacao(Pagamentos pagamentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ImprimirConcCEController.class.getResource("/gestaorecursos/views/relatorios/ImprimirConcCE.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Conciliação Bancária");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ImprimirConcCEController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPag(pagamentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnRelPrestContas(ActionEvent event) throws IOException {
        Pagamentos pagamentos = new Pagamentos();
        boolean buttonConfirmarClicked = showRelPrestContas(pagamentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showRelPrestContas(Pagamentos pagamentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RelPrestacaoContasController.class.getResource("/gestaorecursos/views/relatorios/relPrestacaoContas.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Prestação de Contas");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        RelPrestacaoContasController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPagamentos(pagamentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    @FXML
    public void handleBtnImprimirPagCE(ActionEvent event) throws IOException {
        Pagamentos pagamentos = new Pagamentos();
        boolean buttonConfirmarClicked = showImprimirPagCE(pagamentos);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showImprimirPagCE(Pagamentos pagamentos) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ImprimirPagCEController.class.getResource("/gestaorecursos/views/relatorios/ImprimirPagCE.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Pagamentos Conta Escola");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ImprimirPagCEController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPag(pagamentos);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

    
    @FXML
    public void handleBtnImprimirBensCE(ActionEvent event) throws IOException {
        Bem bem = new Bem();
        boolean buttonConfirmarClicked = showRelBensCE(bem);
        if (buttonConfirmarClicked) {
        }
    }

    public boolean showRelBensCE(Bem bem) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ImprimirBensCEController.class.getResource("/gestaorecursos/views/relatorios/ImprimirBensCE.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Relação de Bens");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        ImprimirBensCEController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setBem(bem);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }
}
