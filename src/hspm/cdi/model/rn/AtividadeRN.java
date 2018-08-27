package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.AtividadeDAO;
import hspm.cdi.model.Atividade;
import hspm.util.DAOFactory;

public class AtividadeRN {
	private AtividadeDAO atividadeDAO;

	public AtividadeRN() {
		this.atividadeDAO = DAOFactory.criaAtividadeDAO();
	}

	public Atividade carregar(Integer codigo) {
		return this.atividadeDAO.carregar(codigo);
	}

	public void salvar(Atividade atividade) {
		this.atividadeDAO.salvar(atividade);
	}

	public void excluir(Atividade profissional) {
		this.atividadeDAO.excluir(profissional);
	}

	public List<Atividade> listar() {
		return this.atividadeDAO.listar();
	}
}
