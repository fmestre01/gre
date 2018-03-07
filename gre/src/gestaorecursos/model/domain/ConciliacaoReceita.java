package gestaorecursos.model.domain;

import java.util.Date;

/**
 *
 * @author mgonc
 */
public class ConciliacaoReceita {

    private int id;
    private Date data_entrada;
    private String num_doc;
    private Double vlr_receita;
    private String historico;
    private String conciliado;
    private Conta conta;
    private Trimestre trimestre;
    private Ano ano;
    private Programa programa;
    private Uex uex;

    public ConciliacaoReceita(){
        
    }

    public ConciliacaoReceita(int id, Date data_entrada, String num_doc, Double vlr_receita, String historico, String conciliado, Conta conta, Trimestre trimestre, Ano ano, Programa programa, Uex uex) {
        this.id = id;
        this.data_entrada = data_entrada;
        this.num_doc = num_doc;
        this.vlr_receita = vlr_receita;
        this.historico = historico;
        this.conciliado = conciliado;
        this.conta = conta;
        this.trimestre = trimestre;
        this.ano = ano;
        this.programa = programa;
        this.uex = uex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public Double getVlr_receita() {
        return vlr_receita;
    }

    public void setVlr_receita(Double vlr_receita) {
        this.vlr_receita = vlr_receita;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getConciliado() {
        return conciliado;
    }

    public void setConciliado(String conciliado) {
        this.conciliado = conciliado;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    public Ano getAno() {
        return ano;
    }

    public void setAno(Ano ano) {
        this.ano = ano;
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
