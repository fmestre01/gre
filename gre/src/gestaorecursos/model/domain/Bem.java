package gestaorecursos.model.domain;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * @author mgonc
 */


public class Bem implements Serializable{

    private int id;
    private String descricao;
    private double vlr_unit;
    private int quantidade;
    private Uex uex;
    private Ano ano;
    private Trimestre trimestre;
    
    public Bem(){
        
    }

    public Bem(int id, String descricao, double vlr_unit, int quantidade, Uex uex, Ano ano, Trimestre trimestre) {
        this.id = id;
        this.descricao = descricao;
        this.vlr_unit = vlr_unit;
        this.quantidade = quantidade;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getVlr_unit() {
        return vlr_unit;
    }

    public void setVlr_unit(double vlr_unit) {
        this.vlr_unit = vlr_unit;
    }
    
    public String getValorFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(vlr_unit);
    }
    
    public void setVlr_unit(String vlr_unit) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setVlr_unit(nf.parse(vlr_unit).doubleValue());
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getQuantidadeFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(0);
        return nf.format(quantidade);
    }
    
    public void setQuantidade(String quantidade) throws Exception {
        NumberFormat nf = NumberFormat.getNumberInstance();
        setQuantidade(nf.parse(quantidade).intValue());
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
