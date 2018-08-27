package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import hspm.cdi.dao.AtividadeDAO;
import hspm.cdi.model.Atividade;

public class AtividadeDAOHibernate implements AtividadeDAO {


	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Atividade atividade) {
		this.session.save(atividade);

	}

	@Override
	public void atualizar(Atividade atividade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Atividade atividade) {
		// TODO Auto-generated method stub

	}

	@Override
	public Atividade carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> listar() {
		Criteria criteria = session.createCriteria(Atividade.class);
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}

}
