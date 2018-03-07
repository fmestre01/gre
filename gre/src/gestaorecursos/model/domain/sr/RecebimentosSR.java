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
public class RecebimentosSR {

    private int id;
    private Date data_entrada;
    private String num_doc;
    private Double vlr_receita;
    private String historico;
    private boolean conciliado;
    private Programa programa;
    private Uex uex;
    private Ano ano;
    private Trimestre trimestre;
    private Conta conta;

    public RecebimentosSR() {

    }

    public RecebimentosSR(int id, Date data_entrada, String num_doc, Double vlr_receita, String historico, boolean conciliado, Programa programa, Uex uex, Ano ano, Trimestre trimestre, Conta conta) {
        this.id = id;
        this.data_entrada = data_entrada;
        this.num_doc = num_doc;
        this.vlr_receita = vlr_receita;
        this.historico = historico;
        this.conciliado = conciliado;
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

    public String getVlr_adicaoFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_receita);
    }

    public void setVlr_receita(Double vlr_receita) throws Exception {
        if (vlr_receita < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_receita = vlr_receita;
    }

    public void setVlr_receita(String vlr_receita) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_receita(nf.parse(vlr_receita).doubleValue());
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public boolean isConciliado() {
        return conciliado;
    }

    public void setConciliado(boolean conciliado) {
        this.conciliado = conciliado;
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
