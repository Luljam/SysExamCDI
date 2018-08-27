package hspm.cdi.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import hspm.cdi.model.Conselho;
import hspm.cdi.model.Profissional;
import hspm.cdi.model.rn.ConselhoRN;
import hspm.cdi.model.rn.ProfissionalRN;


@ManagedBean
@ViewScoped
public class ProfissionalBean {
	
	private Profissional profissional;
	private Conselho conselho;
	private List<Conselho> conselhos;
	private List<Profissional> profissionais;
	
	
	@PostConstruct
	public void listar() {
		try {
			ProfissionalRN profissionalRN = new ProfissionalRN();
			profissionais = profissionalRN.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Profissionais");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ProfissionalRN profissionalRN = new ProfissionalRN();
			profissionalRN.salvar(profissional);
			profissional = new Profissional();
			profissionais = profissionalRN.listar();
			
			Messages.addGlobalInfo("Profissional salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Profissional");
			erro.printStackTrace();
		}
	}
	
	public String editar() {
		return "/administrativoCDI/cadprofissional";
	}
	
	public String excluir() {
		ProfissionalRN profissionalRN = new ProfissionalRN();
		profissionalRN.excluir(profissional);
		this.profissional = null;
		return null;
	}
	
	
	public String ativar() {
		if (this.profissional.isAtivo()) {
			this.profissional.setAtivo(false);
		} else {
			this.profissional.setAtivo(true);
		}
		ProfissionalRN profissionalRN = new ProfissionalRN();
		profissionalRN.salvar(profissional);
		return null;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Conselho getConselho() {
		return conselho;
	}

	public void setConselho(Conselho conselho) {
		this.conselho = conselho;
	}

	public List<Conselho> getConselhos() {
		if (this.conselhos == null){
			ConselhoRN conselhoRN = new ConselhoRN();
			this.conselhos = conselhoRN.listar();
		}
		return this.conselhos;
	}

	public void setConselhos(List<Conselho> conselhos) {
		this.conselhos = conselhos;
	}

	public List<Profissional> getProfissionais() {
		if (this.profissionais == null){
			ProfissionalRN profissionalRN = new ProfissionalRN();
			this.profissionais = profissionalRN.listar();
		}
		return this.profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

}
