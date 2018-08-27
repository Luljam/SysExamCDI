package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.ClinicaDAO;
import hspm.cdi.model.Clinica;
import hspm.util.DAOFactory;

public class ClinicaRN {
	private ClinicaDAO clinicaDAO;

	public ClinicaRN() {
		this.clinicaDAO = DAOFactory.criaClinicaDAO();
	}
	
	public Clinica carregar(Integer codigo){
		return this.clinicaDAO.carregar(codigo);
	}

	public void salvar(Clinica grade) {
		this.clinicaDAO.salvar(grade);
	}

	public void excluir(Clinica grade) {
		this.clinicaDAO.excluir(grade);
	}

	public List<Clinica> listar() {
		return this.clinicaDAO.listar();
	}

}
