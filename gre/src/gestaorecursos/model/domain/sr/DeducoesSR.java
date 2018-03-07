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
public class DeducoesSR {


    private int id;
    private Date data_deducao;
    private String num_doc;
    private String historico;
    private Double vlr_deducao;
    private Ano ano;
    private Trimestre trimestre;
    private Uex uex;
    private Programa programa;

    public DeducoesSR() {

    }

    public DeducoesSR(int id, Date data_deducao, String num_doc, String historico, Double vlr_deducao, Ano ano, Trimestre trimestre, Uex uex, Programa programa) {
        this.id = id;
        this.data_deducao = data_deducao;
        this.num_doc = num_doc;
        this.historico = historico;
        this.vlr_deducao = vlr_deducao;
        this.ano = ano;
        this.trimestre = trimestre;
        this.uex = uex;
        this.programa = programa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_deducao() {
        return data_deducao;
    }

    public void setData_deducao(Date data_deducao) {
        this.data_deducao = data_deducao;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getVlr_deducao() {
        return vlr_deducao;
    }

    public String getVlr_deducaoFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_deducao);
    }

    public void setVlr_deducao(Double vlr_deducao) throws Exception {
        if (vlr_deducao < 0) {
            throw new Exception("Valor de dedução inválido!");
        }
        this.vlr_deducao = vlr_deducao;
    }

    public void setVlr_deducao(String vlr_deducao) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_deducao(nf.parse(vlr_deducao).doubleValue());
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

    public Uex getUex() {
        return uex;
    }

    public void setUex(Uex uex) {
        this.uex = uex;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
    
}
