package hspm.cdi.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.omnifaces.util.Messages;

import hspm.cdi.model.Exame;
import hspm.cdi.model.GrupoExame;
import hspm.cdi.model.rn.ExameRN;
import hspm.cdi.model.rn.GrupoExameRN;

@ManagedBean
@ViewScoped
public class ExameBean {

	private Integer codGrupo;

	private String destinoSalvar;
	private Exame exame;
	private GrupoExame grupo;
	private List<Exame> exames;
	private List<GrupoExame> grupoexames;
	private List<SelectItem> itensGrupos;
	private List<SelectItem> itensExames;

	public GrupoExame getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoExame grupo) {
		this.grupo = grupo;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExames() {
		if (this.exames == null) {
			ExameRN exameRN = new ExameRN();
			this.exames = exameRN.listar();
		}
		return this.exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<GrupoExame> getGrupoexame() {

		if (this.grupoexames == null) {
			GrupoExameRN grupoExameRN = new GrupoExameRN();
			this.grupoexames = grupoExameRN.listar();
		}
		return this.grupoexames;
	}

	public void setGrupoexame(List<GrupoExame> grupoexame) {
		this.grupoexames = grupoexame;
	}

	public String novo() {
		this.destinoSalvar = "/administrativoCDI/exames";
		this.exame = new Exame();
		return "cadastroexames.xhtml";
	}

	@PostConstruct
	public void listar() {
		try {
			exame = new Exame();
			ExameRN exameRN = new ExameRN();
			exames = exameRN.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Exames");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ExameRN exameRN = new ExameRN();
			exameRN.salvar(exame);
			exame = new Exame();
			exames = exameRN.listar();

			Messages.addGlobalInfo("Exame salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Exame");
			erro.printStackTrace();
		}
	}

	public String editar() {
		return "/administrativoCDI/cadastroexames";
	}

	public String excluir() {
		ExameRN exameRN = new ExameRN();
		exameRN.excluir(exame);
		this.exames = null;
		return null;
	}


	public List<SelectItem> getItensGrupos() {
		this.itensGrupos = new ArrayList<>();
		GrupoExameRN grupoExameRN = new GrupoExameRN();
		List<GrupoExame> grupos = grupoExameRN.listar();

		itensGrupos.clear();

		for (GrupoExame ge : grupos) {
			SelectItem selectItens = new SelectItem(ge.getCodigo(), ge.getDescricao());
			this.itensGrupos.add(selectItens);
		}
		return itensGrupos;
	}

	public void setItensGrupos(List<SelectItem> itensGrupos) {
		this.itensGrupos = itensGrupos;
	}

	public List<SelectItem> getItensExames() {
		if (codGrupo != null) {
			this.itensExames = new ArrayList<>();
			ExameRN exameRN = new ExameRN();
			List<Exame> exames = exameRN.buscarPorGrupo(codGrupo);
			itensExames.clear();
			for (Exame exm : exames) {
				SelectItem selectItens = new SelectItem(exm.getCodigo(), exm.getDescricao());
				this.itensExames.add(selectItens);
			}
		} else {
			itensExames = new ArrayList<>();
		}
		return itensExames;
	}

	public void setItensExames(List<SelectItem> itensExames) {
		this.itensExames = itensExames;
	}

	public Integer getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Integer codGrupo) {
		this.codGrupo = codGrupo;
	}

}
