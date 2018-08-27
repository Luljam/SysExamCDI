package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Session;

import hspm.cdi.dao.PacienteDAO;
import hspm.cdi.model.Paciente;

public class PacienteDAOHibernate implements PacienteDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Paciente paciente) {
		this.session.save(paciente);
	}

	@Override
	public void atualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente buscarRH(Integer rh) {
		return (Paciente) this.session.get(Paciente.class, rh);
	}

}
