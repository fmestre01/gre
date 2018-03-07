package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */
public class Banco implements Serializable {

    private int id;
    private String banco;
    private String numBanco;

    public Banco() {
    }
    
    public Banco(int id, String banco, String numBanco){
        this.id = id;
        this.banco = banco;
        this.numBanco = numBanco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(String numBanco) {
        this.numBanco = numBanco;
    }

    @Override
    public String toString() {
        return banco;
    }
    
}
