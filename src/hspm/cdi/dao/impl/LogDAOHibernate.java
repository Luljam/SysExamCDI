package hspm.cdi.dao.impl;

import org.hibernate.Session;

import hspm.cdi.dao.LogDAO;
import hspm.cdi.model.Log_atendimento;

public class LogDAOHibernate implements LogDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;

	}
	
	@Override
	public void salvar(Log_atendimento log) {
		this.session.save(log);
	}

}
