package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Preparo;


public interface PreparoDAO {
	public void salvar(Preparo preparo);
	public void atualizar(Preparo preparo);
	public void excluir(Preparo preparo);
	public Preparo carregar(Integer codigo);
	public List<Preparo> listar();
}
