package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.ExameDAO;
import hspm.cdi.model.Exame;
import hspm.util.DAOFactory;

public class ExameRN {
private ExameDAO exameDAO;
	
	public ExameRN(){
		this.exameDAO = DAOFactory.criaExameDAO();
	}

	public Exame carregar(Integer codigo){
		return this.exameDAO.carregar(codigo);
	}
	
	public void salvar(Exame exame){
		this.exameDAO.salvar(exame);
	}
	
	public void excluir(Exame exame){
		this.exameDAO.excluir(exame);
	}
	
	public List<Exame> listar(){
		return this.exameDAO.listar();
	}
	
	public List<Exame> buscarPorGrupo(Integer grupoCodigo) {
		return this.exameDAO.buscarPorGrupo(grupoCodigo);
	}
}
