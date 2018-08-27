package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Session;

import hspm.cdi.dao.GrupoExameDAO;
import hspm.cdi.model.GrupoExame;

public class GrupoExameDAOHibernate implements GrupoExameDAO {

	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(GrupoExame grupo) {
		this.session.save(grupo);

	}

	@Override
	public void atualizar(GrupoExame grupo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(GrupoExame grupo) {
		// TODO Auto-generated method stub

	}

	@Override
	public GrupoExame carregar(Integer codigo) {
		return (GrupoExame) this.session.get(GrupoExame.class, codigo);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<GrupoExame> listar() {
		return this.session.createCriteria(GrupoExame.class).list();
	}

}
