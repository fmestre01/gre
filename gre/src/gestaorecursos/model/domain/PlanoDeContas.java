package gestaorecursos.model.domain;

/**
 *
 * @author mgonc
 */
public class PlanoDeContas {
    private int id;
    private String nome_conta;
    private String cod_reduzido;
    private String natureza;
    private String classe;
    private String grupo;
    
    public PlanoDeContas(){
        
    }

    public PlanoDeContas(int id, String nome_conta, String cod_reduzido, String natureza, String classe, String grupo) {
        this.id = id;
        this.nome_conta = nome_conta;
        this.cod_reduzido = cod_reduzido;
        this.natureza = natureza;
        this.classe = classe;
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_conta() {
        return nome_conta;
    }

    public void setNome_conta(String nome_conta) {
        this.nome_conta = nome_conta;
    }

    public String getCod_reduzido() {
        return cod_reduzido;
    }

    public void setCod_reduzido(String cod_reduzido) {
        this.cod_reduzido = cod_reduzido;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return  nome_conta;
    }

    
    
}
