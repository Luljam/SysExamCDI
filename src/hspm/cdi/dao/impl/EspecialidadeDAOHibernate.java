package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import hspm.cdi.dao.EspecialidadeDAO;
import hspm.cdi.model.Especialidade;

public class EspecialidadeDAOHibernate implements EspecialidadeDAO {


	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Especialidade especialidade) {
		this.session.save(especialidade);
	}

	@Override
	public void atualizar(Especialidade especialidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Especialidade especialidade) {
		// TODO Auto-generated method stub
	}

	@Override
	public Especialidade carregar(Integer codigo) {
		return (Especialidade) this.session.get(Especialidade.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidade> listar() {
		return this.session.createCriteria(Especialidade.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidade> buscarPorClinica(Integer codClinica) {
		try {
			Criteria criteria = this.session.createCriteria(Especialidade.class);
			criteria.add(Restrictions.eq("clinica.codigo", codClinica));
			criteria.addOrder(Order.asc("descricao"));
			List<Especialidade> especialidades = criteria.list();
			
			return especialidades;
		} catch (RuntimeException erro) {
			throw erro;
		} 
	}

}
