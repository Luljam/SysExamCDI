package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Projections;

import hspm.cdi.dao.AgendaDAO;
import hspm.cdi.model.Agenda;

public class AgendaDAOHibernate implements AgendaDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;

	}

	@Override
	public void salvar(Agenda agenda) {
		this.session.save(agenda);
	}

	@Override
	public void atualizar(Agenda agenda) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Agenda agenda) {
		// TODO Auto-generated method stub

	}

	@Override
	public Agenda carregar(Integer codigo) {
		return (Agenda) this.session.get(Agenda.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agenda> listar() {
		return this.session.createCriteria(Agenda.class).list();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Agenda> agendaUnica() {
		Criteria criteria = session.createCriteria(Agenda.class);
		criteria.setProjection(Projections.distinct(Projections.property("grupo")));
		List<Agenda> results = criteria.list();
		return results;
	}

}
