package gestaorecursos.model.domain;

/**
 *
 * @author mgonc
 */
public class EstadoCivil {

    private int id;
    private String estadocivil;

    public EstadoCivil() {

    }

    public EstadoCivil(int id, String estadocivil) {
        this.id = id;
        this.estadocivil = estadocivil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    @Override
    public String toString() {
        return estadocivil;
    }

}
