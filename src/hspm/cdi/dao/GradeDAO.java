package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Grade;

public interface GradeDAO {
	public void salvar(Grade grade);
	public void atualizar(Grade grade);
	public void excluir(Grade grade);
	public Grade carregar(Integer codigo);
	public List<Grade> listar();
	List<Grade> buscarPorGrupoProfissional(Integer grupoCodigo, String cpf);
}
