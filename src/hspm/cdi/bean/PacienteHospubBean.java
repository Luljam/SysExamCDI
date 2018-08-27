package hspm.cdi.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hspm.cdi.dao.impl.PacienteHospubDAOOpenbase;
import hspm.cdi.model.PacienteHospub;

@ManagedBean
@ViewScoped
public class PacienteHospubBean {
	private PacienteHospub pacHospub;
	
	private Integer rh;
	private String nome;
	

	public PacienteHospub getPacHospub() {
		return pacHospub;
	}

	public void setPacHospub(PacienteHospub pacHospub) {
		this.pacHospub = pacHospub;
	}

	public Integer getRh() {
		return rh;
	}

	public void setRh(Integer rh) {
		this.rh = rh;
	}

	public String buscarRH(Integer rh){
		PacienteHospub pacHospub = new PacienteHospubDAOOpenbase().buscarRH(rh);
		nome = pacHospub.getNome();
		return nome;
	}
}
