package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.ConsultaDAO;
import hspm.cdi.model.Consulta;
import hspm.util.DAOFactory;

public class ConsultaRN {
	private ConsultaDAO consultaDAO;
	
	public ConsultaRN() {
		this.consultaDAO = DAOFactory.criaConsultaDAO();
	}
	
	public Consulta carregar(Integer codigo){
		return this.consultaDAO.carregar(codigo);
	}

	public Consulta buscarPorConsulta(Integer numero){
		return this.consultaDAO.buscarPorConsulta(numero);
	}

	public void salvar(Consulta consulta) {
		this.consultaDAO.salvar(consulta);
	}
	
	public void atualizar(Consulta consulta){
		this.consultaDAO.atualizar(consulta);
	}

	public void excluir(Consulta consulta) {
		this.consultaDAO.excluir(consulta);
	}

	public List<Consulta> listar() {
		return this.consultaDAO.listar();
	}

	public List<Consulta> buscarPorGrupoProfissional(Integer codGrupo, String cpf_profissional) {
		return this.consultaDAO.buscarPorGrupoProfissional(codGrupo, cpf_profissional);
	}

}
