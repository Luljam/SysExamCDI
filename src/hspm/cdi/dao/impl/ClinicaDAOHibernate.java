package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Session;

import hspm.cdi.dao.ClinicaDAO;
import hspm.cdi.model.Clinica;

public class ClinicaDAOHibernate implements ClinicaDAO {


	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Clinica clinica) {
		this.session.save(clinica);
	}

	@Override
	public void atualizar(Clinica clinica) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Clinica clinicao) {
		// TODO Auto-generated method stub

	}

	@Override
	public Clinica carregar(Integer codigo) {
		return (Clinica) this.session.get(Clinica.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clinica> listar() {
		return this.session.createCriteria(Clinica.class).list();
	}

}
