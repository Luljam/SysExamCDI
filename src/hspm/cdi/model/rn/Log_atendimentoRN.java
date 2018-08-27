package hspm.cdi.model.rn;

import hspm.cdi.dao.LogDAO;
import hspm.cdi.model.Log_atendimento;
import hspm.util.DAOFactory;

public class Log_atendimentoRN {
	private LogDAO logDAO;
	
	public Log_atendimentoRN() {
		this.logDAO = DAOFactory.criaLogDAO();
	}
	
	public void salvar(Log_atendimento log) {
		this.logDAO.salvar(log);
	}
}
