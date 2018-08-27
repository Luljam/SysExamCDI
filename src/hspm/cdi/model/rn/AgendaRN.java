package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.AgendaDAO;
import hspm.cdi.model.Agenda;
import hspm.util.DAOFactory;

public class AgendaRN {
	private AgendaDAO agendaDAO;
	
	public AgendaRN() {
		this.agendaDAO = DAOFactory.criaAgendaDAO();
	}
	
	public Agenda carregar(Integer codigo){
		return this.agendaDAO.carregar(codigo);
	}


	public void salvar(Agenda agenda) {
		this.agendaDAO.salvar(agenda);
	}

	public void excluir(Agenda agenda) {
		this.agendaDAO.excluir(agenda);
	}

	public List<Agenda> listar() {
		return this.agendaDAO.listar();
	}
	
	public List<Agenda> listarDistinct(){
		return this.agendaDAO.agendaUnica();
	}
	
}
