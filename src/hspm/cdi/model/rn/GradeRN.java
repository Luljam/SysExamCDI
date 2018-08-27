package hspm.cdi.model.rn;

import java.util.List;


import hspm.cdi.dao.GradeDAO;
import hspm.cdi.model.Grade;
import hspm.util.DAOFactory;

public class GradeRN {
	private GradeDAO gradeDAO;

	public GradeRN() {
		this.gradeDAO = DAOFactory.criaGradeDAO();
	}
	
	public Grade carregar(Integer codigo){
		return this.gradeDAO.carregar(codigo);
	}


	public void salvar(Grade grade) {
			this.gradeDAO.salvar(grade);
	}
	
	public void atualizar(Grade grade){
		this.gradeDAO.atualizar(grade);
	}

	public void excluir(Grade grade) {
		this.gradeDAO.excluir(grade);
	}

	public List<Grade> listar() {
		return this.gradeDAO.listar();
	}

	public List<Grade> buscarPorGrupoProfissional(Integer codGrupo, String cpf_profissional) {
		return this.gradeDAO.buscarPorGrupoProfissional(codGrupo, cpf_profissional);
	}
}
