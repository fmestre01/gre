package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 *
 * @author mgonc
 */
public class TipoDoc implements Serializable {

    private int id;
    private String tipo_doc;

    public TipoDoc() {

    }

    public TipoDoc(int id, String tipo_doc) {
        this.id = id;
        this.tipo_doc = tipo_doc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    @Override
    public String toString() {
        return tipo_doc;
    }

}
