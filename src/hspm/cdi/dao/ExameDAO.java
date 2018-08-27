package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Exame;


public interface ExameDAO {
	public void salvar(Exame exame);
	public void atualizar(Exame exame);
	public void excluir(Exame exame);
	public Exame carregar(Integer codigo);
	public List<Exame> listar();
	public List<Exame> buscarPorGrupo(Integer codigo);
}
