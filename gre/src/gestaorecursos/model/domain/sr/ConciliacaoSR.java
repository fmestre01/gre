/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaorecursos.model.domain.sr;

import java.util.Date;

/**
 *
 * @author mgonc
 */
public class ConciliacaoSR {

        private int id;
    private Date data_emissao;
    private String nr_docto;
    private String fornecedor;
    private int doc_fornecedor;
    private String cheque;
    private double vlr_liquido;
    private int conciliado;
   
    public ConciliacaoSR(){
        
        
    }

    public ConciliacaoSR(int id, Date data_emissao, String nr_docto, String fornecedor, int doc_fornecedor, String cheque, double vlr_liquido, int conciliado) {
        this.id = id;
        this.data_emissao = data_emissao;
        this.nr_docto = nr_docto;
        this.fornecedor = fornecedor;
        this.doc_fornecedor = doc_fornecedor;
        this.cheque = cheque;
        this.vlr_liquido = vlr_liquido;
        this.conciliado = conciliado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getNr_docto() {
        return nr_docto;
    }

    public void setNr_docto(String nr_docto) {
        this.nr_docto = nr_docto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getDoc_fornecedor() {
        return doc_fornecedor;
    }

    public void setDoc_fornecedor(int doc_fornecedor) {
        this.doc_fornecedor = doc_fornecedor;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public double getVlr_liquido() {
        return vlr_liquido;
    }

    public void setVlr_liquido(double vlr_liquido) {
        this.vlr_liquido = vlr_liquido;
    }

    public int getConciliado() {
        return conciliado;
    }

    public void setConciliado(int conciliado) {
        this.conciliado = conciliado;
    }

    @Override
    public String toString() {
        return "Conciliacao{" + "id=" + id + ", data_emissao=" + data_emissao + ", nr_docto=" + nr_docto + ", fornecedor=" + fornecedor + ", doc_fornecedor=" + doc_fornecedor + ", cheque=" + cheque + ", vlr_liquido=" + vlr_liquido + ", conciliado=" + conciliado + '}';
    }
    

    

    
}
