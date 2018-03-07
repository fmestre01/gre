package gestaorecursos.model.domain;

import java.io.Serializable;

/**
 * @author mgonc
 */
public class Fornecedor implements Serializable {
    
    private int id;
    private String nome;
    private String nomeFantasia;
    private String doc_fornecedor;
    private String ccm;
    private String inscrEstadual;
    private String cpf;
    private String identidade;
    private String endRua;
    private String endNum;
    private String endCompl;
    private Bairro bairros;
    private String cep;
    private Municipio cidade;
    private Uf uf;
    private Pais pais;
    private String telFixo;
    private String telCel;
    private String email;
    private String site;
    private TipoPessoa tipoPessoa;
    
    public Fornecedor(){
        
    }

    public Fornecedor(int id, String nome, String nomeFantasia, String doc_fornecedor, String ccm, String inscrEstadual, 
            String cpf, String identidade, String endRua, String endNum, String endCompl, Bairro bairros, 
            String cep, Municipio cidade, Uf uf, Pais pais, String telFixo, String telCel, String email, 
            String site, TipoPessoa tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.doc_fornecedor = doc_fornecedor;
        this.ccm = ccm;
        this.inscrEstadual = inscrEstadual;
        this.cpf = cpf;
        this.identidade = identidade;
        this.endRua = endRua;
        this.endNum = endNum;
        this.endCompl = endCompl;
        this.bairros = bairros;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
        this.telFixo = telFixo;
        this.telCel = telCel;
        this.email = email;
        this.site = site;
        this.tipoPessoa = tipoPessoa;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoc_fornecedor() {
        return doc_fornecedor;
    }

    public void setDoc_fornecedor(String doc_fornecedor) {
        this.doc_fornecedor = doc_fornecedor;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCcm() {
        return ccm;
    }

    public void setCcm(String ccm) {
        this.ccm = ccm;
    }

    public String getInscrEstadual() {
        return inscrEstadual;
    }

    public void setInscrEstadual(String inscrEstadual) {
        this.inscrEstadual = inscrEstadual;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
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

    public Bairro getBairro() {
        return bairros;
    }

    public void setBairro(Bairro bairro) {
        this.bairros = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Municipio getCidade() {
        return cidade;
    }

    public void setCidade(Municipio cidade) {
        this.cidade = cidade;
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

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Bairro getBairros() {
        return bairros;
    }

    public void setBairros(Bairro bairros) {
        this.bairros = bairros;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return nome;
    }

    

    
}
