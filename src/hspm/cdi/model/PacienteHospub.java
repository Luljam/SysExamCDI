package hspm.cdi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="intb6")
public class PacienteHospub implements Serializable {

	private static final long serialVersionUID = -5750401333165238620L;
	private Integer rh;
	private Integer rf;
	private String nome;
	private Integer sexo;
	private String nascimento;
	private String natural;
	private String nacionalidade;
	private String tipoDoc;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String uf;
	private String cef;
	private String telefone;
	private String ultAtendimento;
	private String obito;
	private String codmun;
	private String cpf;
	private String codCidade;
	private String codLogra;
	private Integer dependente;
	
	
	public Integer getRh() {
		return rh;
	}
	public void setRh(Integer rh) {
		this.rh = rh;
	}
	public Integer getRf() {
		return rf;
	}
	public void setRf(Integer rf) {
		this.rf = rf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getSexo() {
		return sexo;
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getNatural() {
		return natural;
	}
	public void setNatural(String natural) {
		this.natural = natural;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCef() {
		return cef;
	}
	public void setCef(String cef) {
		this.cef = cef;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getUltAtendimento() {
		return ultAtendimento;
	}
	public void setUltAtendimento(String ultAtendimento) {
		this.ultAtendimento = ultAtendimento;
	}
	public String getObito() {
		return obito;
	}
	public void setObito(String obito) {
		this.obito = obito;
	}
	public String getCodmun() {
		return codmun;
	}
	public void setCodmun(String codmun) {
		this.codmun = codmun;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCodCidade() {
		return codCidade;
	}
	public void setCodCidade(String codCidade) {
		this.codCidade = codCidade;
	}
	public String getCodLogra() {
		return codLogra;
	}
	public void setCodLogra(String codLogra) {
		this.codLogra = codLogra;
	}
	public Integer getDependente() {
		return dependente;
	}
	public void setDependente(Integer dependente) {
		this.dependente = dependente;
	}
	
	
}
