package hspm.cdi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import hspm.cdi.model.GrupoExame;
import hspm.cdi.model.rn.GrupoExameRN;

@RequestScoped
@ManagedBean(name="grupoExameBean")
public class GrupoExameBean {
	
	private String codigo;
	private String descricao;
	
	
	private GrupoExame grupoExame = new GrupoExame();
	private String destinoSalvar;
	private List<GrupoExame> lista;
	
	public String novo() {
		this.destinoSalvar = "/administrativoCDI/grupoexames";
		this.grupoExame = new GrupoExame();
		return "cadastrogrupo.xhtml";
	}

	public String editar() {
		return "/administrativoCDI/cadastrogrupo";
	}
	
	public String salvar() {
		this.destinoSalvar = "/administrativoCDI/grupoexames";
		@SuppressWarnings("unused")
		FacesContext context = FacesContext.getCurrentInstance();
		GrupoExameRN grupoExameRN = new GrupoExameRN();
		grupoExameRN.salvar(grupoExame);
		return this.destinoSalvar;
	}

	public String excluir() {
		GrupoExameRN grupoExameRN = new GrupoExameRN();
		grupoExameRN.excluir(grupoExame);
		this.lista = null;
		return null;
	}
	
	public List<GrupoExame> getLista(){
		if (this.lista == null){
			GrupoExameRN grupoExameRN = new GrupoExameRN();
			this.lista = grupoExameRN.listar();
		}
		return this.lista;
	}

	public GrupoExame getGrupoExame() {
		return grupoExame;
	}

	public void setGrupoExame(GrupoExame grupoExame) {
		this.grupoExame = grupoExame;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public void setLista(List<GrupoExame> lista) {
		this.lista = lista;
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

	
}
