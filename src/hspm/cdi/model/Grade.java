package hspm.cdi.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="grade")
public class Grade implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5738369604308484313L;

	@Id
	@GeneratedValue
	@Column(name="cod_grade")
	private Integer codigo;
	
	@Column(name="data_atendimento", nullable=false, updatable=false)
	private Date dataConsulta;

	@Column(name="tipo_atendimento")
	private Integer tipo;
	
	@Column(name="tempo_atendimento")
	private Integer tempo;
	
	@ManyToOne
	@JoinColumn(name="status")
	private StatusGrade status;
	
	@ManyToOne
	@JoinColumn(name="cod_grupo_agenda")
	private GrupoExame grupo;
	
	@ManyToOne
	@JoinColumn(name="cod_agenda")
	private Agenda agenda;
//	@ManyToOne
//	@JoinColumn(name="cod_exame")
//	private Exame exame;
	
	@ManyToOne
	@JoinColumn(name="cpf_profissional",nullable=false, updatable=false)
	private Profissional profissional;
	
	
	@OneToMany(mappedBy="cod_consulta")
	private List<Consulta> consultas;
	
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Integer getTipo() {
		
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public StatusGrade getStatus() {
		return status;
	}

	public void setStatus(StatusGrade status) {
		this.status = status;
	}
	
//	public Exame getExame() {
//		return exame;
//	}
//
//	public void setExame(Exame exame) {
//		this.exame = exame;
//	}

	public GrupoExame getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoExame grupo) {
		this.grupo = grupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agenda == null) ? 0 : agenda.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((consultas == null) ? 0 : consultas.hashCode());
		result = prime * result + ((dataConsulta == null) ? 0 : dataConsulta.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((profissional == null) ? 0 : profissional.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Grade other = (Grade) obj;
		if (agenda == null) {
			if (other.agenda != null)
				return false;
		} else if (!agenda.equals(other.agenda))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (consultas == null) {
			if (other.consultas != null)
				return false;
		} else if (!consultas.equals(other.consultas))
			return false;
		if (dataConsulta == null) {
			if (other.dataConsulta != null)
				return false;
		} else if (!dataConsulta.equals(other.dataConsulta))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (profissional == null) {
			if (other.profissional != null)
				return false;
		} else if (!profissional.equals(other.profissional))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	


}
