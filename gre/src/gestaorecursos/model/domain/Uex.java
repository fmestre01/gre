package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */
public class Uex implements Serializable {

    private int id;
    private String Uexf; /* Significa Unidade Executora Nome Fantasia*/
    private String Uex; /* Significa Unidade Executora */
    private String apelido;
    private String CNPJ;
    private String endRua;
    private String endNum;
    private String endCompl;
    private String CEP;
    private Bairro bairro;
    private Municipio municipio;
    private Uf uf;
    private String cxPostal;
    private String ddd;
    private String telefone;
    private String fax;
    private String email;
    private TipoEntidade tipoEntidade;
    private String telEntidade;
    private String faxEntidade;       
    private String undGestoraOrgFed;
    private String GestorOrgFederal;
    private String CNAS;
    private String codCenso;
    private String nomeEscola;
    private String contmatic;
    
    public Uex() {

    }

    public Uex(int id, String Uexf, String uex, String apelido, String CNPJ, String endRua, String endNum, 
            String endCompl, String CEP, Bairro bairro, Municipio municipio, Uf uf, String cxPostal, String ddd, 
            String telefone, String fax, String email, TipoEntidade tipoEntidade, String telEntidade, String faxEntidade, 
            String undGestoraOrgFed, String GestorOrgFederal, String CNAS, String codCenso, String nomeEscola, String contmatic) {
        this.id = id;
        this.Uexf = Uexf;
        this.Uex = uex;
        this.apelido = apelido;
        this.CNPJ = CNPJ;
        this.endRua = endRua;
        this.endNum = endNum;
        this.endCompl = endCompl;
        this.CEP = CEP;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.cxPostal = cxPostal;
        this.ddd = ddd;
        this.telefone = telefone;
        this.fax = fax;
        this.email = email;
        this.tipoEntidade = tipoEntidade;
        this.telEntidade = telEntidade;
        this.faxEntidade = faxEntidade;
        this.undGestoraOrgFed = undGestoraOrgFed;
        this.GestorOrgFederal = GestorOrgFederal;
        this.CNAS = CNAS;
        this.codCenso = codCenso;
        this.nomeEscola = nomeEscola;
        this.contmatic = contmatic;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUexf() {
        return Uexf;
    }

    public void setUexf(String Uexf) {
        this.Uexf = Uexf;
    }

    public String getUex() {
        return Uex;
    }

    public void setUex(String uex) {
        this.Uex = uex;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public String getEndCompl() {
        return endCompl;
    }

    public void setEndCompl(String endCompl) {
        this.endCompl = endCompl;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
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


    public String getCxPostal() {
        return cxPostal;
    }

    public void setCxPostal(String cxPostal) {
        this.cxPostal = cxPostal;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoEntidade getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(TipoEntidade tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    

    public String getTelEntidade() {
        return telEntidade;
    }

    public void setTelEntidade(String telEntidade) {
        this.telEntidade = telEntidade;
    }

    public String getFaxEntidade() {
        return faxEntidade;
    }

    public void setFaxEntidade(String faxEntidade) {
        this.faxEntidade = faxEntidade;
    }

    public String getUndGestoraOrgFed() {
        return undGestoraOrgFed;
    }

    public void setUndGestoraOrgFed(String undGestoraOrgFed) {
        this.undGestoraOrgFed = undGestoraOrgFed;
    }

    public String getGestorOrgFederal() {
        return GestorOrgFederal;
    }

    public void setGestorOrgFederal(String GestorOrgFederal) {
        this.GestorOrgFederal = GestorOrgFederal;
    }

    public String getCNAS() {
        return CNAS;
    }

    public void setCNAS(String CNAS) {
        this.CNAS = CNAS;
    }

    public String getCodCenso() {
        return codCenso;
    }

    public void setCodCenso(String codCenso) {
        this.codCenso = codCenso;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getContmatic() {
        return contmatic;
    }

    public void setContmatic(String contmatic) {
        this.contmatic = contmatic;
    }
    
    

    @Override
    public String toString() {
        return Uex;
    }

    
    
}
