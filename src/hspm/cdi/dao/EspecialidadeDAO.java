package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Especialidade;

public interface EspecialidadeDAO {
	public void salvar(Especialidade especialidade);
	public void atualizar(Especialidade especialidade);
	public void excluir(Especialidade especialidade);
	public Especialidade carregar(Integer codigo);
	public List<Especialidade> listar();
	public List<Especialidade> buscarPorClinica(Integer codClinica);
}
