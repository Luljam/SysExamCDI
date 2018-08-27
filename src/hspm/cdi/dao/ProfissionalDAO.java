package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Profissional;


public interface ProfissionalDAO {
	public void salvar(Profissional profissional);
	public void atualizar(Profissional profissional);
	public void excluir(Profissional profissional);
	public Profissional carregar(Integer codigo);
	public List<Profissional> listar();
	public List<Profissional> listarProfissionalAgenda(Integer cod);
}
