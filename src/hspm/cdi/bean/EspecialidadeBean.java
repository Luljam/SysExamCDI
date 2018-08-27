package hspm.cdi.bean;



import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.omnifaces.util.Messages;

import hspm.cdi.model.Clinica;
import hspm.cdi.model.Especialidade;
import hspm.cdi.model.rn.ClinicaRN;
import hspm.cdi.model.rn.EspecialidadeRN;

@ManagedBean
@ViewScoped
public class EspecialidadeBean  {

	private Integer codClinica;

	private String destinoSalvar;
	private Especialidade especialidade;
	private Clinica clinica;
	private List<Especialidade> especialidades;
	private List<Clinica> clinicas;
	private List<SelectItem> itensClinicas;
	private List<SelectItem> itensEspecialidades;

	
	public void listar() {
		try {
			especialidade = new Especialidade();
			EspecialidadeRN especialidadeRN = new EspecialidadeRN();
			especialidades = especialidadeRN.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Exames");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EspecialidadeRN especialidadeRN = new EspecialidadeRN();
			especialidadeRN.salvar(especialidade);
			especialidade = new Especialidade();
			especialidades = especialidadeRN.listar();

			Messages.addGlobalInfo("Exame salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Exame");
			erro.printStackTrace();
		}
	}

	public String editar() {
		return "/administrativoCDI/cadespecialidade";
	}

	public String excluir() {
		EspecialidadeRN especialidadeRN = new EspecialidadeRN();
		especialidadeRN.excluir(especialidade);
		this.especialidades = null;
		return null;
	}

	public Integer getCodClinica() {
		return codClinica;
	}

	public void setCodClinica(Integer codClinica) {
		this.codClinica = codClinica;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Especialidade> getEspecialidades() {
		if (this.especialidades == null){
			EspecialidadeRN especialidadeRN = new EspecialidadeRN();
			this.especialidades = especialidadeRN.listar();
		}
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Clinica> getClinicas() {
		if (this.clinicas == null){
			ClinicaRN clinicaRN = new ClinicaRN();
			this.clinicas = clinicaRN.listar();
		}
		return this.clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public List<SelectItem> getItensClinicas() {
		this.itensClinicas = new ArrayList<>();
		ClinicaRN clinicaRN = new ClinicaRN();
		List<Clinica> clinicas = clinicaRN.listar();

		itensClinicas.clear();

		for (Clinica cli : clinicas) {
			SelectItem selectItens = new SelectItem(cli.getCodigo(), cli.getDescricao());
			this.itensClinicas.add(selectItens);
		}
		return itensClinicas;
	}

	public void setItensClinicas(List<SelectItem> itensClinicas) {
		this.itensClinicas = itensClinicas;
	}

	public List<SelectItem> getItensEspecialidades() {
		if (codClinica != null) {
			this.itensEspecialidades = new ArrayList<>();
			EspecialidadeRN especialidadeRN = new EspecialidadeRN();
			List<Especialidade> especialidades = especialidadeRN.buscarPorClinica(codClinica);
			itensEspecialidades.clear();
			for (Especialidade espec : especialidades) {
				SelectItem selectItens = new SelectItem(espec.getCodigo(), espec.getDescricao());
				this.itensEspecialidades.add(selectItens);
			}
		} else {
			itensEspecialidades = new ArrayList<>();
		}
		return itensEspecialidades;
	}

	public void setItensEspecialidades(List<SelectItem> itensEspecialidades) {
		this.itensEspecialidades = itensEspecialidades;
	}
	
	
	
	
}
