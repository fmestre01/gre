package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */


public class Sexo implements Serializable{

    private int id;
    private String sexo;

    public Sexo() {

    }

    public Sexo(int id, String sexo) {
        this.id = id;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }

}
