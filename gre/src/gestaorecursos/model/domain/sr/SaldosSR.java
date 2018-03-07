package gestaorecursos.model.domain.sr;

import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author mgonc
 */

public class SaldosSR {


    private int id;
    private Date data;
    private Double sdo_inicial;
    private Double vlr_repasse;
    private Double vlr_aplicacao;
    private Double vlr_renAplicacao;
    private Double vlr_poupanca;
    private Double sdo_investimentos;
    private Programa programa;
    private Uex uex;
    private Ano ano;
    private Trimestre trimestre;
    private Conta conta;

    public SaldosSR() {

    }

    public SaldosSR(int id, Date data, Double sdo_inicial, Double vlr_repasse, Double vlr_aplicacao, Double vlr_renAplicacao, Double vlr_poupanca, Double sdo_investimentos, Programa programa, Uex uex, Ano ano, Trimestre trimestre, Conta conta) {
        this.id = id;
        this.data = data;
        this.sdo_inicial = sdo_inicial;
        this.vlr_repasse = vlr_repasse;
        this.vlr_aplicacao = vlr_aplicacao;
        this.vlr_renAplicacao = vlr_renAplicacao;
        this.vlr_poupanca = vlr_poupanca;
        this.sdo_investimentos = sdo_investimentos;
        this.programa = programa;
        this.uex = uex;
        this.ano = ano;
        this.trimestre = trimestre;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Grupo Saldo Inicial Formatado *
     */
    public Double getSdo_inicial() {
        return sdo_inicial;
    }

    public String getSdo_inicialFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(sdo_inicial);
    }

    public void setSdo_inicial(Double sdo_inicial) throws Exception {
        if (sdo_inicial < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.sdo_inicial = sdo_inicial;
    }

    public void setSdo_inicial(String sdo_inicial) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setSdo_inicial(nf.parse(sdo_inicial).doubleValue());
    }

    /**
     * Grupo Valor Repasse Formatado *
     */
    public Double getVlr_repasse() {
        return vlr_repasse;
    }

    public String getVlr_repasseFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_repasse);
    }

    public void setVlr_repasse(Double vlr_repasse) throws Exception {
        if (vlr_repasse < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_repasse = vlr_repasse;
    }

    public void setVlr_repasse(String vlr_repasse) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_repasse(nf.parse(vlr_repasse).doubleValue());
    }

    /**
     * Grupo Valor Aplicação Formatado *
     */
    public Double getVlr_aplicacao() {
        return vlr_aplicacao;
    }

    public String getVlr_aplicacaoFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_aplicacao);
    }

    public void setVlr_aplicacao(Double vlr_aplicacao) throws Exception {
        if (vlr_aplicacao < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_aplicacao = vlr_aplicacao;
    }

    public void setVlr_aplicacao(String vlr_aplicacao) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_aplicacao(nf.parse(vlr_aplicacao).doubleValue());
    }

    /**
     * Grupo Valor Rendimento da Aplicação Formatado *
     */
    public Double getVlr_renAplicacao() {
        return vlr_renAplicacao;
    }

    public String getVlr_renAplicacaoFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_renAplicacao);
    }

    public void setVlr_renAplicacao(Double vlr_renAplicacao) throws Exception {
        if (vlr_renAplicacao < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_renAplicacao = vlr_renAplicacao;
    }

    public void setVlr_renAplicacao(String vlr_renAplicacao) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_renAplicacao(nf.parse(vlr_renAplicacao).doubleValue());
    }

    /**
     * Grupo Valor Poupança Formatado *
     */
    public Double getVlr_poupanca() {
        return vlr_poupanca;
    }

    public String getVlr_poupancaFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_poupanca);
    }

    public void setVlr_poupanca(Double vlr_poupanca) throws Exception {
        if (vlr_poupanca < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_poupanca = vlr_poupanca;
    }

    public void setVlr_poupanca(String vlr_poupanca) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_poupanca(nf.parse(vlr_poupanca).doubleValue());
    }

    /**
     * Grupo Valor Saldo de Investimentos Formatado *
     */
    public Double getSdo_investimentos() {
        return sdo_investimentos;
    }

    public String getSdo_investimentosFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(sdo_investimentos);
    }

    public void setSdo_investimentos(Double sdo_investimentos) throws Exception {
        if (sdo_investimentos < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.sdo_investimentos = sdo_investimentos;
    }

    public void setSdo_investimentos(String sdo_investimentos) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setSdo_investimentos(nf.parse(sdo_investimentos).doubleValue());
    }

    /**
     * FIM Grupo valores Formatados *
     */
    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Uex getUex() {
        return uex;
    }

    public void setUex(Uex uex) {
        this.uex = uex;
    }

    public Ano getAno() {
        return ano;
    }

    public void setAno(Ano ano) {
        this.ano = ano;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
}
