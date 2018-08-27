package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Conselho;

public interface ConselhoDAO {
	public void salvar(Conselho conselho);
	public void atualizar(Conselho conselho);
	public void excluir(Conselho conselho);
	public Conselho carregar(Integer codigo);
	public List<Conselho> listar();
}
