package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */

public class Programa implements Serializable{
    
    private int id;
    private String programa;
    
    public Programa(){
    }

    public Programa(int id, String programa) {
        this.id = id;
        this.programa = programa;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return programa ;
    }
    
    
    

    
}
