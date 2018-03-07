package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 *
 * @author mgonc
 */
public class Ano implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String ano;

    public Ano() {
    }

    public Ano(int id, String ano) {
        this.id = id;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return ano;
    }

    

}
