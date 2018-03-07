package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */

public class Bairro implements Serializable{
    
    private int id;
    private String bairro;
    private Municipio municipio;
    private Uf uf;
    private Pais pais;
    
    public Bairro(){
        
    }

    public Bairro(int id, String bairro, Municipio municipio, Uf uf, Pais pais) {
        this.id = id;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return bairro;
    }
    
    
    
}
