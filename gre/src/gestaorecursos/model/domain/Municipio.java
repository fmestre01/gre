package gestaorecursos.model.domain;

/**
 * @author mgonc
 */


public class Municipio {
    
    private int id;
    private String cidade;
    private Uf uf;
    
    public Municipio(){
        
    }

    public Municipio(int id, String cidade, Uf uf) {
        this.id = id;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return  cidade;
    }
    
    
}
