package gestaorecursos.model.domain.sr;

import gestaorecursos.model.domain.Ano;
import gestaorecursos.model.domain.Programa;
import gestaorecursos.model.domain.Trimestre;
import gestaorecursos.model.domain.Uex;
import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author mgonc
 */
public class AdicoesSR {

    private int id;
    private Date data_adicao;
    private String num_doc;
    private String historico_adicao;
    private Double vlr_adicao;
    private Programa programa;
    private Uex uex;
    private Ano ano;
    private Trimestre trimestre;

    public AdicoesSR() {

    }

    public AdicoesSR(int id, Date data_adicao, String num_doc, String historico_adicao, Double vlr_adicao, Programa programa, Uex uex, Ano ano, Trimestre trimestre) {
        this.id = id;
        this.data_adicao = data_adicao;
        this.num_doc = num_doc;
        this.historico_adicao = historico_adicao;
        this.vlr_adicao = vlr_adicao;
        this.programa = programa;
        this.uex = uex;
        this.ano = ano;
        this.trimestre = trimestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_adicao() {
        return data_adicao;
    }

    public void setData_adicao(Date data_adicao) {
        this.data_adicao = data_adicao;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getHistorico_adicao() {
        return historico_adicao;
    }

    public void setHistorico_adicao(String historico_adicao) {
        this.historico_adicao = historico_adicao;
    }

    public Double getVlr_adicao() {
        return vlr_adicao;
    }

    public String getVlr_adicaoFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_adicao);
    }

    public void setVlr_adicao(Double vlr_adicao) throws Exception {
        if (vlr_adicao < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_adicao = vlr_adicao;
    }

    public void setVlr_adicao(String vlr_adicao) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_adicao(nf.parse(vlr_adicao).doubleValue());
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
    
}
