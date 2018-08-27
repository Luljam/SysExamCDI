package hspm.cdi.model.rn;

import hspm.cdi.dao.PacienteDAO;
import hspm.cdi.model.Paciente;
import hspm.util.DAOFactory;

public class PacienteRN {
	private PacienteDAO pacienteDAO;
	
	public PacienteRN(){
		this.pacienteDAO = DAOFactory.criarPacienteDAO();
	}
	
	public void salvar(Paciente paciente){
//		String rh = paciente.getNome();
//		if(rh == null || rh == "0"){
			this.pacienteDAO.salvar(paciente);
//		}else{
//			this.pacienteDAO.atualizar(paciente);
//		}
	}
	
	public Paciente carregar(Integer rh){
		return this.pacienteDAO.buscarRH(rh);
	}

}
