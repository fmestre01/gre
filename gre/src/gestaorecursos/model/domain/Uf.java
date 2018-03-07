package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */


public class Uf implements Serializable {
    
    private int id;
    private String uf;
    private String estado;
    
    
    public Uf(){
        
    }

    public Uf(int id, String uf, String estado) {
        this.id = id;
        this.uf = uf;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return uf;
    }
    
}
    