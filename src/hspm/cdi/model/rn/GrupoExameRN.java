package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.GrupoExameDAO;
import hspm.cdi.model.GrupoExame;
import hspm.util.DAOFactory;

public class GrupoExameRN {
	
	private GrupoExameDAO grupoExameDAO;
	
	public GrupoExameRN(){
		this.grupoExameDAO = DAOFactory.criaGrupoExameDAO();
	}

	public GrupoExame carregar(Integer codigo){
		return this.grupoExameDAO.carregar(codigo);
	}
	
	public void salvar(GrupoExame grupoExame){
		this.grupoExameDAO.salvar(grupoExame);
	}
	
	public void excluir(GrupoExame grupoExame){
		this.grupoExameDAO.excluir(grupoExame);
	}
	
	public List<GrupoExame> listar(){
		return this.grupoExameDAO.listar();
	}
}
