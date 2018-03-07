package gestaorecursos.model.domain;

import java.time.LocalDate;
import javafx.scene.control.DatePicker;

/**
 *
 * @author mgonc
 */
public class Dirigente {

    private int id;
    private String nome;
    private String doc_fornecedor;
    private String identidade;
    private String orgemissor;
    private String nacionalidade;
    private Sexo sexo;
    private EstadoCivil estadocivil;
    private String endRua;
    private String endNum;
    private String endCompl;
    private String cep;
    private String ddd;
    private String telFixo;
    private String telCel;
    private String email;
    private String site;
    private String cargo;
    private Bairro bairro;
    private Municipio municipio;
    private Uf uf;
    private Uex uex;
    private Pais pais;
    private TipoPessoa tipopessoa;
    private LocalDate emissao;

    public Dirigente() {

    }

    public Dirigente(int id, String nome, String doc_fornecedor, String identidade, String orgemissor, String nacionalidade, Sexo sexo, EstadoCivil estadocivil, String endRua, String endNum, String endCompl, String cep, String ddd, String telFixo, String telCel, String email, String site, String cargo, Bairro bairro, Municipio municipio, Uf uf, Uex uex, Pais pais, TipoPessoa tipopessoa, LocalDate emissao) {
        this.id = id;
        this.nome = nome;
        this.doc_fornecedor = doc_fornecedor;
        this.identidade = identidade;
        this.emissao = emissao;
        this.orgemissor = orgemissor;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.endRua = endRua;
        this.endNum = endNum;
        this.endCompl = endCompl;
        this.cep = cep;
        this.ddd = ddd;
        this.telFixo = telFixo;
        this.telCel = telCel;
        this.email = email;
        this.site = site;
        this.cargo = cargo;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.uex = uex;
        this.pais = pais;
        this.tipopessoa = tipopessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDoc_fornecedor() {
        return doc_fornecedor;
    }

    public void setDoc_fornecedor(String doc_fornecedor) {
        this.doc_fornecedor = doc_fornecedor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(EstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public String getOrgemissor() {
        return orgemissor;
    }

    public void setOrgemissor(String orgemissor) {
        this.orgemissor = orgemissor;
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

    public Uex getUex() {
        return uex;
    }

    public void setUex(Uex uex) {
        this.uex = uex;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public TipoPessoa getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(TipoPessoa tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    @Override
    public String toString() {
        return nome;
    }

}
