package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Session;

import hspm.cdi.dao.ConselhoDAO;
import hspm.cdi.model.Conselho;

public class ConselhoDAOHibernate implements ConselhoDAO {

	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Conselho conselho) {
		this.session.save(conselho);
	}

	@Override
	public void atualizar(Conselho conselho) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Conselho conselho) {
		// TODO Auto-generated method stub

	}

	@Override
	public Conselho carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conselho> listar() {
		return this.session.createCriteria(Conselho.class).list();
	}

}
