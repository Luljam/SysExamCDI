package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.ConselhoDAO;
import hspm.cdi.model.Conselho;
import hspm.util.DAOFactory;

public class ConselhoRN {
private ConselhoDAO conselhoDAO;
	
	public ConselhoRN(){
		this.conselhoDAO = DAOFactory.criaConselhoDAO();
	}

	public Conselho carregar(Integer codigo){
		return this.conselhoDAO.carregar(codigo);
	}
	
	public void salvar(Conselho conselho){
		this.conselhoDAO.salvar(conselho);
	}
	
	public void excluir(Conselho conselho){
		this.conselhoDAO.excluir(conselho);
	}
	
	public List<Conselho> listar(){
		return this.conselhoDAO.listar();
	}
}
