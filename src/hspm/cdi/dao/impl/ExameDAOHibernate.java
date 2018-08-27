package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hspm.cdi.dao.ExameDAO;
import hspm.cdi.model.Exame;

public class ExameDAOHibernate implements ExameDAO {

	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Exame exame) {
		this.session.save(exame);
	}

	@Override
	public void atualizar(Exame exame) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Exame exame) {
		// TODO Auto-generated method stub

	}

	@Override
	public Exame carregar(Integer codigo) {
		return (Exame) this.session.get(Exame.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exame> listar() {
		return this.session.createCriteria(Exame.class).list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Exame> buscarPorGrupo(Integer grupoCodigo) {
		try {
			Criteria criteria = this.session.createCriteria(Exame.class);
			criteria.add(Restrictions.eq("grupo.codigo", grupoCodigo));
			criteria.addOrder(Order.asc("descricao"));
			List<Exame> exames = criteria.list();
			
			return exames;
		} catch (RuntimeException erro) {
			throw erro;
		} 
	}

}
