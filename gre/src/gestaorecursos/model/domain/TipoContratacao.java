package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 *
 * @author mgonc
 */


public class TipoContratacao implements Serializable        {

    private int id;
    private String tipo_contratacao;
    
    public TipoContratacao(){
    }
    
    public TipoContratacao(int id, String tipo_contratacao){
        this.id = id;
        this.tipo_contratacao = tipo_contratacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_contratacao() {
        return tipo_contratacao;
    }

    public void setTipo_contratacao(String tipo_contratacao) {
        this.tipo_contratacao = tipo_contratacao;
    }
    
}
