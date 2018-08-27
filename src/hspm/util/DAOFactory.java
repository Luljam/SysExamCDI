package hspm.util;

import hspm.cdi.dao.AgendaDAO;
import hspm.cdi.dao.AtividadeDAO;
import hspm.cdi.dao.ClinicaDAO;
import hspm.cdi.dao.ConselhoDAO;
import hspm.cdi.dao.ConsultaDAO;
import hspm.cdi.dao.EspecialidadeDAO;
import hspm.cdi.dao.ExameDAO;
import hspm.cdi.dao.GradeDAO;
import hspm.cdi.dao.GrupoExameDAO;
import hspm.cdi.dao.LogDAO;
import hspm.cdi.dao.PacienteDAO;
import hspm.cdi.dao.ProfissionalDAO;
import hspm.cdi.dao.impl.AgendaDAOHibernate;
import hspm.cdi.dao.impl.AtividadeDAOHibernate;
import hspm.cdi.dao.impl.ClinicaDAOHibernate;
import hspm.cdi.dao.impl.ConselhoDAOHibernate;
import hspm.cdi.dao.impl.ConsultaDAOHibernate;
import hspm.cdi.dao.impl.EspecialidadeDAOHibernate;
import hspm.cdi.dao.impl.ExameDAOHibernate;
import hspm.cdi.dao.impl.GradeDAOHibernate;
import hspm.cdi.dao.impl.GrupoExameDAOHibernate;
import hspm.cdi.dao.impl.LogDAOHibernate;
import hspm.cdi.dao.impl.PacienteDAOHibernate;
import hspm.cdi.dao.impl.ProfissionalDAOHibernate;
import hspm.usuario.UsuarioDAO;
import hspm.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static GrupoExameDAO criaGrupoExameDAO() {
		GrupoExameDAOHibernate grupoExameDAO = new GrupoExameDAOHibernate();
		grupoExameDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return grupoExameDAO;
	}

	public static ExameDAO criaExameDAO() {
		ExameDAOHibernate exameDAO = new ExameDAOHibernate();
		exameDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return exameDAO;
	}

	public static GradeDAO criaGradeDAO() {
		GradeDAOHibernate gradeDAO = new GradeDAOHibernate();
		gradeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return gradeDAO;
	}

	public static ConselhoDAO criaConselhoDAO() {
		ConselhoDAOHibernate conselhoDAO = new ConselhoDAOHibernate();
		conselhoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return conselhoDAO;
	}

	public static ProfissionalDAO criaProfissionalDAO() {
		ProfissionalDAOHibernate profissionalDAO = new ProfissionalDAOHibernate();
		profissionalDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return profissionalDAO;
	}

	public static AgendaDAO criaAgendaDAO() {
		AgendaDAOHibernate agendaDAO = new AgendaDAOHibernate();
		agendaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return agendaDAO;
	}

	public static AtividadeDAO criaAtividadeDAO() {
		AtividadeDAOHibernate atividadeDAO = new AtividadeDAOHibernate();
		atividadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return atividadeDAO;
	}

	public static EspecialidadeDAO criaEspecialidadeDAO() {
		EspecialidadeDAOHibernate especialidadeDAO = new EspecialidadeDAOHibernate();
		especialidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return especialidadeDAO;
	}

	public static ClinicaDAO criaClinicaDAO() {
		ClinicaDAOHibernate clinicaDAO = new ClinicaDAOHibernate();
		clinicaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return clinicaDAO;
	}

	public static ConsultaDAO criaConsultaDAO() {
		ConsultaDAOHibernate consultaDAO = new ConsultaDAOHibernate();
		consultaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return consultaDAO;
	}

	public static PacienteDAO criarPacienteDAO() {
		PacienteDAOHibernate pacienteDAO = new PacienteDAOHibernate();
		pacienteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pacienteDAO;
	}

	public static LogDAO criaLogDAO() {
		LogDAOHibernate logDAO = new LogDAOHibernate();
		logDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return logDAO;
	}
}
