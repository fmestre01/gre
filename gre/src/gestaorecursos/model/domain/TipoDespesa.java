package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 *
 * @author mgonc
 */


public class TipoDespesa implements Serializable{
    private int id;
    private String tipo_despesa;
    
    public TipoDespesa(){
        
    }
    public TipoDespesa(int id, String tipo_despesa){
        this.id = id;
        this.tipo_despesa = tipo_despesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_despesa() {
        return tipo_despesa;
    }

    public void setTipo_despesa(String tipo_despesa) {
        this.tipo_despesa = tipo_despesa;
    }
    
    
}
