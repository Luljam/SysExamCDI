package hspm.cdi.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="profissional")
public class Profissional implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601930976228726978L;

	@Id
	@GeneratedValue
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cr")
	private Integer cr;
	
	@ManyToOne
	@JoinColumn(name="cod_conselho")
	private Conselho conselho;
	
	
	@Column(name="tel_celular")
	private String celular;
	
	@Column(name="tel_residencial")
	private String tel_residencial;
	
	@Column(name="email")
	private String email; 
	
	@Column(name="ativo")
	private boolean ativo;
	
	@Column(name="matricula")
	private Integer rf;
	
	@ManyToOne
	@JoinColumn(name="cod_atividade")
	private Atividade atividade;
	
	@OneToMany(mappedBy="profissional")
	private List<Grade> grades;

	@OneToMany(mappedBy="profissional")
	private List<Agenda> agendas;
	
	@OneToMany(mappedBy="solicitante")
	private List<Consulta> consultas;
	
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Integer getRf() {
		return rf;
	}

	public void setRf(Integer rf) {
		this.rf = rf;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCr() {
		return cr;
	}

	public void setCr(Integer cr) {
		this.cr = cr;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTel_residencial() {
		return tel_residencial;
	}

	public void setTel_residencial(String tel_residencial) {
		this.tel_residencial = tel_residencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendas == null) ? 0 : agendas.hashCode());
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((conselho == null) ? 0 : conselho.hashCode());
		result = prime * result + ((consultas == null) ? 0 : consultas.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((cr == null) ? 0 : cr.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rf == null) ? 0 : rf.hashCode());
		result = prime * result + ((tel_residencial == null) ? 0 : tel_residencial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		if (agendas == null) {
			if (other.agendas != null)
				return false;
		} else if (!agendas.equals(other.agendas))
			return false;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (ativo != other.ativo)
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (conselho == null) {
			if (other.conselho != null)
				return false;
		} else if (!conselho.equals(other.conselho))
			return false;
		if (consultas == null) {
			if (other.consultas != null)
				return false;
		} else if (!consultas.equals(other.consultas))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (cr == null) {
			if (other.cr != null)
				return false;
		} else if (!cr.equals(other.cr))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rf == null) {
			if (other.rf != null)
				return false;
		} else if (!rf.equals(other.rf))
			return false;
		if (tel_residencial == null) {
			if (other.tel_residencial != null)
				return false;
		} else if (!tel_residencial.equals(other.tel_residencial))
			return false;
		return true;
	}
	
	

}
