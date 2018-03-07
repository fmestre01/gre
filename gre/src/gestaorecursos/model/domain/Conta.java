package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */
public class Conta implements Serializable {

    private int id;
    private String conta;
    private String numAgencia;
    private Banco banco;
    private Programa programa;
    private Uex uex;

    public Conta() {

    }

    public Conta(int id, String conta, String numAgencia, Banco banco, Programa programa, Uex uex) {
        this.id = id;
        this.conta = conta;
        this.numAgencia = numAgencia;
        this.banco = banco;
        this.programa = programa;
        this.uex = uex;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(String numAgencia) {
        this.numAgencia = numAgencia;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Uex getUex() {
        return uex;
    }

    public void setUex(Uex uex) {
        this.uex = uex;
    }

    @Override
    public String toString() {
        return conta;
    }

    
    
}
