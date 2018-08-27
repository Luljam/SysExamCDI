package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.ProfissionalDAO;
import hspm.cdi.model.Profissional;
import hspm.util.DAOFactory;

public class ProfissionalRN {
private ProfissionalDAO profissionalDAO;
	
	public ProfissionalRN(){
		this.profissionalDAO = DAOFactory.criaProfissionalDAO();
	}

	public Profissional carregar(Integer codigo){
		return this.profissionalDAO.carregar(codigo);
	}
	
	public void salvar(Profissional profissional){
		String cpf = profissional.getCpf();
		if(cpf == null || cpf == "0"){
			this.profissionalDAO.salvar(profissional);
		}else{
			this.profissionalDAO.atualizar(profissional);
		}
	}
	
	public void excluir(Profissional profissional){
		this.profissionalDAO.excluir(profissional);
	}
	
	public List<Profissional> listar(){
		return this.profissionalDAO.listar();
	}
	
	public List<Profissional> listarProfAgenda(Integer cod){
		return this.profissionalDAO.listarProfissionalAgenda(cod);
	}
	
}