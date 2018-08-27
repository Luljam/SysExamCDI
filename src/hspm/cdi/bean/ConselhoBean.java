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
public class ConselhoBean {
	
	
	private String destinoSalvar;
	private Conselho conselho = new Conselho();
	private Profissional profissional;
	

	private List<Conselho> conselhos;
	private List<Profissional> profissionais;
	
	
	
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
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
		return profissionais;
	}
	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	public String novo() {
		this.destinoSalvar = "/administrativoCDI/cadconselhoclasse";
		this.conselho = new Conselho();
		return "cadconselhoclasse.xhtml";
	}
	
	
	@PostConstruct
	public void listar() {
		try {
			ConselhoRN conselhoRN = new ConselhoRN();
			conselhos = conselhoRN.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Exames");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ConselhoRN conselhoRN = new ConselhoRN();
			conselhoRN.salvar(conselho);
			conselho = new Conselho();
			conselhos = conselhoRN.listar();
			
			
			Messages.addGlobalInfo("Exame salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Exame");
			erro.printStackTrace();
		}
	}
	
	public String editar() {
		return "/administrativoCDI/cadconselhoclasse";
	}
	
	public String excluir() {
		ConselhoRN conselhoRN = new ConselhoRN();
		conselhoRN.excluir(conselho);
		this.conselho = null;
		return null;
	}

}
