package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hspm.cdi.dao.GradeDAO;
import hspm.cdi.model.Grade;

public class GradeDAOHibernate implements GradeDAO {
	private Session session;
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Grade grade) {
		this.session.save(grade);
		this.session.flush();
		this.session.clear();
	}

	@Override
	public void atualizar(Grade grade) {
			this.session.update(grade);
	}

	@Override
	public void excluir(Grade grade) {
		// TODO Auto-generated method stub

	}

	@Override
	public Grade carregar(Integer codigo) {
		return (Grade) this.session.get(Grade.class, codigo);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grade> listar() {
		return this.session.createCriteria(Grade.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grade> buscarPorGrupoProfissional(Integer grupoCodigo, String cpf) {
		try {
			Criteria criteria = this.session.createCriteria(Grade.class);
			criteria.add(Restrictions.eq("grupo.codigo", grupoCodigo));
			criteria.add(Restrictions.eq("profissional.cpf", cpf));
			//criteria.addOrder(Order.asc("descricao"));
			List<Grade> grades = criteria.list();
			
			return grades;
		} catch (RuntimeException erro) {
			throw erro;
		} 
	}

}
