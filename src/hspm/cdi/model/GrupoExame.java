package hspm.cdi.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="grupo_exame")
public class GrupoExame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="cod_grupo_exame")
	private Integer codigo;
	@Column(name="des_grupo_exame")
	private String descricao;
		
	
	@OneToMany(mappedBy="grupo")
	private List<Exame> exames;
		
	@Override
	public String toString() {
	    return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}
	
	@OneToMany(mappedBy="grupo")
	private List<Grade> grades;
	
	@OneToMany(mappedBy="grupo")
	private List<Agenda> agendas;
	
	@OneToMany(mappedBy="profissional")
	private List<Agenda> profissionais;
	
	
	
	public List<Agenda> getGrupos() {
		return agendas;
	}
	public void setGrupos(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	public List<Agenda> getProfissionais() {
		return profissionais;
	}
	public void setProfissionais(List<Agenda> profissionais) {
		this.profissionais = profissionais;
	}
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public List<Exame> getExames() {
		return exames;
	}
	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((exames == null) ? 0 : exames.hashCode());
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((agendas == null) ? 0 : agendas.hashCode());
		result = prime * result + ((profissionais == null) ? 0 : profissionais.hashCode());
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
		GrupoExame other = (GrupoExame) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (exames == null) {
			if (other.exames != null)
				return false;
		} else if (!exames.equals(other.exames))
			return false;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (agendas == null) {
			if (other.agendas != null)
				return false;
		} else if (!agendas.equals(other.agendas))
			return false;
		if (profissionais == null) {
			if (other.profissionais != null)
				return false;
		} else if (!profissionais.equals(other.profissionais))
			return false;
		return true;
	}
	
	

}
