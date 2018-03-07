package gestaorecursos.model.domain.sr;

import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Conta;
import gestaorecursos.model.domain.Fornecedor;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.TipoContratacao;
import gestaorecursos.model.domain.TipoDespesa;
import gestaorecursos.model.domain.TipoDoc;
import gestaorecursos.model.domain.TipoPessoa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.text.NumberFormat;
import java.time.LocalDate;

/**
 *
 * @author mgonc
 */
public class PagamentosSR {

    private int id;
    private LocalDate data_emissao;
    private String nr_docto;
    private LocalDate data_pg;
    private String historico;
    private double valor;
    private double vlr_inss;
    private double vlr_ir;
    private double vlr_iss;
    private double vlr_piscofins;
    private double vlr_adeduzir;
    private double vlr_liquido;
    private String cheque;
    private LocalDate dt_cheque;
    private boolean conciliado;
    private String contmatic;
    private String apelido;
    private boolean salaDeRecursos;
    private TipoDespesa tipo_despesa;
    private TipoContratacao tipo_contratacao;
    private TipoDoc tipo_doc;
    private TipoPessoa tipo_pessoa;
    private Fornecedor fornecedor;
    private Conta conta;
    private Ano ano;
    private Trimestre trimestre;
    private Programa programa;
    private Uex uex;

    public PagamentosSR() {

    }

    public PagamentosSR(int id, LocalDate data_emissao, String nr_docto, LocalDate data_pg, String historico, double valor, double vlr_inss, double vlr_ir, double vlr_iss, double vlr_piscofins, double vlr_adeduzir, double vlr_liquido, String cheque, LocalDate dt_cheque, boolean conciliado, String contmatic, String apelido, boolean salaDeRecursos, TipoDespesa tipo_despesa, TipoContratacao tipo_contratacao, TipoDoc tipo_doc, TipoPessoa tipo_pessoa, Fornecedor fornecedor, Conta conta, Ano ano, Trimestre trimestre, Programa programa, Uex uex) {
        this.id = id;
        this.data_emissao = data_emissao;
        this.nr_docto = nr_docto;
        this.data_pg = data_pg;
        this.historico = historico;
        this.valor = valor;
        this.vlr_inss = vlr_inss;
        this.vlr_ir = vlr_ir;
        this.vlr_iss = vlr_iss;
        this.vlr_piscofins = vlr_piscofins;
        this.vlr_adeduzir = vlr_adeduzir;
        this.vlr_liquido = vlr_liquido;
        this.cheque = cheque;
        this.dt_cheque = dt_cheque;
        this.conciliado = conciliado;
        this.contmatic = contmatic;
        this.apelido = apelido;
        this.salaDeRecursos = salaDeRecursos;
        this.tipo_despesa = tipo_despesa;
        this.tipo_contratacao = tipo_contratacao;
        this.tipo_doc = tipo_doc;
        this.tipo_pessoa = tipo_pessoa;
        this.fornecedor = fornecedor;
        this.conta = conta;
        this.ano = ano;
        this.trimestre = trimestre;
        this.programa = programa;
        this.uex = uex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(LocalDate data_emissao) {
        this.data_emissao = data_emissao;
    }

    

    public String getNr_docto() {
        return nr_docto;
    }

    public void setNr_docto(String nr_docto) {
        this.nr_docto = nr_docto;
    }

    public LocalDate getData_pg() {
        return data_pg;
    }

    public void setData_pg(LocalDate data_pg) {
        this.data_pg = data_pg;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public double getValor() {
        return valor;
    }
    
    public String getValorFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(valor);
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setValor(String valor) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setValor(nf.parse(valor).doubleValue());
    }

    public double getVlr_inss() {
        return vlr_inss;
    }

    public void setVlr_inss(double vlr_inss) {
        this.vlr_inss = vlr_inss;
    }

    public double getVlr_ir() {
        return vlr_ir;
    }

    public void setVlr_ir(double vlr_ir) {
        this.vlr_ir = vlr_ir;
    }

    public double getVlr_iss() {
        return vlr_iss;
    }

    public void setVlr_iss(double vlr_iss) {
        this.vlr_iss = vlr_iss;
    }

    public double getVlr_piscofins() {
        return vlr_piscofins;
    }

    public void setVlr_piscofins(double vlr_piscofins) {
        this.vlr_piscofins = vlr_piscofins;
    }

    public double getVlr_adeduzir() {
        return vlr_adeduzir;
    }

    public void setVlr_adeduzir(double vlr_adeduzir) {
        this.vlr_adeduzir = vlr_adeduzir;
    }

    public double getVlr_liquido() {
        return vlr_liquido;
    }
    
    public String getVlr_liquidoFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_liquido);
    }

    public void setVlr_liquido(double vlr_liquido) {
        this.vlr_liquido = vlr_liquido;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public LocalDate getDt_cheque() {
        return dt_cheque;
    }

    public void setDt_cheque(LocalDate dt_cheque) {
        this.dt_cheque = dt_cheque;
    }

    public boolean getConciliado() {
        return conciliado;
    }

    public void setConciliado(boolean conciliado) {
        this.conciliado = conciliado;
    }

    public String getContmatic() {
        return contmatic;
    }

    public void setContmatic(String contmatic) {
        this.contmatic = contmatic;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public boolean getSalaDeRecursos() {
        return salaDeRecursos;
    }

    public void setSalaDeRecursos(boolean salaDeRecursos) {
        this.salaDeRecursos = salaDeRecursos;
    }

    public TipoDespesa getTipo_despesa() {
        return tipo_despesa;
    }

    public void setTipo_despesa(TipoDespesa tipo_despesa) {
        this.tipo_despesa = tipo_despesa;
    }

    public TipoContratacao getTipo_contratacao() {
        return tipo_contratacao;
    }

    public void setTipo_contratacao(TipoContratacao tipo_contratacao) {
        this.tipo_contratacao = tipo_contratacao;
    }

    public TipoDoc getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(TipoDoc tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public TipoPessoa getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(TipoPessoa tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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

    
}
