package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 *
 * @author mgonc
 */
public class TipoPessoa implements Serializable{
    
    private int id;
    private String tipoPessoa;
    
    public TipoPessoa(){
        
    }
    public TipoPessoa(int id, String tipoPessoa){
        this.id = id;
        this.tipoPessoa = tipoPessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return tipoPessoa;
    }
    
    
}
