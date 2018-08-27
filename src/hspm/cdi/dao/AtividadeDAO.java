package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Atividade;

public interface AtividadeDAO {

	public void salvar(Atividade atividade);
	public void atualizar(Atividade atividade);
	public void excluir(Atividade atividade);
	public Atividade carregar(Integer codigo);
	public List<Atividade> listar();
}
