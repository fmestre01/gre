package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 *
 * @author mgonc
 */
public class Historico implements Serializable {
    
    private int id;
    private String historico;
    private String contadeb;
    private String contacred;
    
    public Historico(){
        
    }

    public Historico(int id, String historico, String contadeb, String contacred) {
        this.id = id;
        this.historico = historico;
        this.contadeb = contadeb;
        this.contacred = contacred;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getContadeb() {
        return contadeb;
    }

    public void setContadeb(String contadeb) {
        this.contadeb = contadeb;
    }

    public String getContacred() {
        return contacred;
    }

    public void setContacred(String contacred) {
        this.contacred = contacred;
    }

    
    
    @Override
    public String toString() {
        return historico;
    }

    
}
