package gestaorecursos.model.domain;

/**
 *
 * @author mgonc
 */


public class TipoEntidade {
    
    private int id;
    private String tipoEntidade;
    
    public TipoEntidade(){
        
    }

    public TipoEntidade(int id, String tipoEntidade) {
        this.id = id;
        this.tipoEntidade = tipoEntidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    @Override
    public String toString() {
        return tipoEntidade;
    }
    
    
}
