package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */


public class Trimestre implements Serializable{
    
    private int id;
    private String trimestre;
    
    public Trimestre(){
        
    }
    public Trimestre(int id, String trimestre){
        this.id = id;
        this.trimestre = trimestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    @Override
    public String toString() {
        return trimestre;
    }
        
}
