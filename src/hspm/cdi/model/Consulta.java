package hspm.cdi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hspm.usuario.Usuario;

@Entity
@Table(name="consulta")
public class Consulta {
	
	@Id
	@GeneratedValue
	@Column(name="cod_consulta")
	private Integer cod_consulta;
	
	@ManyToOne
	@JoinColumn(name="num_consulta")
	private Grade num_consulta;
	
	@ManyToOne
	@JoinColumn(name="rh_paciente")
	private Paciente paciente;
	
	@Column(name="dt_consulta")
	private Date dt_consulta;
	
	@Column(name="termino_consulta")
	private Date fim_Consulta;
		
	
	
	@ManyToOne
	@JoinColumn(name="cod_exame")
	private Exame exame;
	
	@ManyToOne
	@JoinColumn(name="cod_especialidade")
	private Especialidade especialidade;
	
	@ManyToOne
	@JoinColumn(name="cpf_solicitante")
	private Profissional solicitante;
	
	@ManyToOne
	@JoinColumn(name="status")
	private StatusGrade status;//1-marcada, 2-realizada, 3-falta, 4-bloqueada
	
	@Column(name="dt_cadastro")
	private Date dt_cadastro;
	
	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;
		
	public Integer getCod_consulta() {
		return cod_consulta;
	}
	public void setCod_consulta(Integer cod_consulta) {
		this.cod_consulta = cod_consulta;
	}	
	
	public Grade getNum_consulta() {
		return num_consulta;
	}
	public void setNum_consulta(Grade num_consulta) {
		this.num_consulta = num_consulta;
	}
		
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Date getDt_consulta() {
		return dt_consulta;
	}
	public void setDt_consulta(Date dt_consulta) {
		this.dt_consulta = dt_consulta;
	}
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public Profissional getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Profissional solicitante) {
		this.solicitante = solicitante;
	}
	
	public StatusGrade getStatus() {
		return status;
	}
	public void setStatus(StatusGrade status) {
		this.status = status;
	}
	public Date getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Date getFim_Consulta() {
		return fim_Consulta;
	}
	public void setFim_Consulta(Date fim_Consulta) {
		this.fim_Consulta = fim_Consulta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_consulta == null) ? 0 : cod_consulta.hashCode());
		result = prime * result + ((dt_cadastro == null) ? 0 : dt_cadastro.hashCode());
		result = prime * result + ((dt_consulta == null) ? 0 : dt_consulta.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((exame == null) ? 0 : exame.hashCode());
		result = prime * result + ((num_consulta == null) ? 0 : num_consulta.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((solicitante == null) ? 0 : solicitante.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Consulta other = (Consulta) obj;
		if (cod_consulta == null) {
			if (other.cod_consulta != null)
				return false;
		} else if (!cod_consulta.equals(other.cod_consulta))
			return false;
		if (dt_cadastro == null) {
			if (other.dt_cadastro != null)
				return false;
		} else if (!dt_cadastro.equals(other.dt_cadastro))
			return false;
		if (dt_consulta == null) {
			if (other.dt_consulta != null)
				return false;
		} else if (!dt_consulta.equals(other.dt_consulta))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (exame == null) {
			if (other.exame != null)
				return false;
		} else if (!exame.equals(other.exame))
			return false;
		if (num_consulta == null) {
			if (other.num_consulta != null)
				return false;
		} else if (!num_consulta.equals(other.num_consulta))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (solicitante == null) {
			if (other.solicitante != null)
				return false;
		} else if (!solicitante.equals(other.solicitante))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	

}
