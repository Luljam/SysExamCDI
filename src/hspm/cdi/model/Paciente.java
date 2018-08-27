package hspm.cdi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

//	public Paciente() {
//		this.rh = 0;
//		this.rf = 0;
//		this.nome = "";
//		this.sexo = 0;
//		this.telefone = "";
//		this.dt_nascimento = null;
//		this.ativo = false;
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "reg_hospitalar", nullable=false ,updatable=false)
	private Integer rh;

	@Column(name = "reg_funcional")
	private Integer rf;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sexo")
	private Integer sexo;

	@Column(name = "dt_nascimento")
	private Date dt_nascimento;

	@Column(name = "telefone")
	private String telefone;
	
	
	@Column(name="dt_cadastro", updatable=false)
	private Date dt_cadastro;

	@Column(name = "ativo")
	private boolean ativo;
	
	@OneToMany(mappedBy="paciente")
	private List<Consulta> consultas;
	
	
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

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((consultas == null) ? 0 : consultas.hashCode());
		result = prime * result + ((dt_cadastro == null) ? 0 : dt_cadastro.hashCode());
		result = prime * result + ((dt_nascimento == null) ? 0 : dt_nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rf == null) ? 0 : rf.hashCode());
		result = prime * result + ((rh == null) ? 0 : rh.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Paciente other = (Paciente) obj;
		if (ativo != other.ativo)
			return false;
		if (consultas == null) {
			if (other.consultas != null)
				return false;
		} else if (!consultas.equals(other.consultas))
			return false;
		if (dt_cadastro == null) {
			if (other.dt_cadastro != null)
				return false;
		} else if (!dt_cadastro.equals(other.dt_cadastro))
			return false;
		if (dt_nascimento == null) {
			if (other.dt_nascimento != null)
				return false;
		} else if (!dt_nascimento.equals(other.dt_nascimento))
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
		if (rh == null) {
			if (other.rh != null)
				return false;
		} else if (!rh.equals(other.rh))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
