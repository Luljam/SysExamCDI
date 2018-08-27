package hspm.cdi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log_atendimento")
public class Log_atendimento {
	
	

	@Id
	@GeneratedValue
	@Column(name="cod_log")
	private Integer codigo;
	@Column(name="num_atendimento")
	private Integer num_atendimento;
	@Column(name="data_ocorrencia")
	private Date dt_ocorrencia;
	@Column(name="ocorrencia")
	private String ocorrencia;
	@Column(name="usuario")
	private String usuario;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getNum_atendimento() {
		return num_atendimento;
	}
	public void setNum_atendimento(Integer num_atendimento) {
		this.num_atendimento = num_atendimento;
	}
	public Date getDt_ocorrencia() {
		return dt_ocorrencia;
	}
	public void setDt_ocorrencia(Date dt_ocorrencia) {
		this.dt_ocorrencia = dt_ocorrencia;
	}
	public String getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dt_ocorrencia == null) ? 0 : dt_ocorrencia.hashCode());
		result = prime * result + ((num_atendimento == null) ? 0 : num_atendimento.hashCode());
		result = prime * result + ((ocorrencia == null) ? 0 : ocorrencia.hashCode());
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
		Log_atendimento other = (Log_atendimento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dt_ocorrencia == null) {
			if (other.dt_ocorrencia != null)
				return false;
		} else if (!dt_ocorrencia.equals(other.dt_ocorrencia))
			return false;
		if (num_atendimento == null) {
			if (other.num_atendimento != null)
				return false;
		} else if (!num_atendimento.equals(other.num_atendimento))
			return false;
		if (ocorrencia == null) {
			if (other.ocorrencia != null)
				return false;
		} else if (!ocorrencia.equals(other.ocorrencia))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
