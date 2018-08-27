package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import hspm.cdi.dao.ProfissionalDAO;
import hspm.cdi.model.Agenda;
import hspm.cdi.model.Profissional;

public class ProfissionalDAOHibernate implements ProfissionalDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Profissional profissional) {
		this.session.save(profissional);
	}

	@Override
	public void atualizar(Profissional profissional) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Profissional profissional) {
		// TODO Auto-generated method stub

	}

	@Override
	public Profissional carregar(Integer codigo) {
		return (Profissional) this.session.get(Profissional.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profissional> listar() {
		Criteria criteria = session.createCriteria(Profissional.class);
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Profissional> listarProfissionalAgenda(Integer cod){
		Criteria criteria = this.session.createCriteria(Agenda.class);
		criteria.setProjection(Projections.distinct(Projections.property("profissional")));
		criteria.add(Restrictions.eq("grupo.codigo", cod));
		//criteria.addOrder(Order.asc("descricao"));
		
		return criteria.list();
	}

}
