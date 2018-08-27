package hspm.cdi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import hspm.cdi.model.Clinica;
import hspm.cdi.model.rn.ClinicaRN;

@RequestScoped
@ManagedBean(name="clinicaBean")
public class ClinicaBean {
	private String codigo;
	private String descricao;
	
	private Clinica clinica = new Clinica();
	private String destinoSalvar;
	private List<Clinica> clinicas;
	
	
	public String editar() {
		return "/administrativoCDI/cadastroclinica";
	}
	
	public String salvar() {
		this.destinoSalvar = "/administrativoCDI/cadastroclinica";
		@SuppressWarnings("unused")
		FacesContext context = FacesContext.getCurrentInstance();
		ClinicaRN clinicaRN = new ClinicaRN();
		clinicaRN.salvar(clinica);
		return this.destinoSalvar;
	}

	public String excluir() {
		ClinicaRN clinicaRN = new ClinicaRN();
		clinicaRN.excluir(clinica);
		this.clinicas = null;
		return null;
	}
	
	public List<Clinica> getClinicas(){
		if (this.clinicas == null){
			ClinicaRN clinicaRN = new ClinicaRN();
			this.clinicas = clinicaRN.listar();
		}
		return this.clinicas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public void setLista(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}
	
	
}
