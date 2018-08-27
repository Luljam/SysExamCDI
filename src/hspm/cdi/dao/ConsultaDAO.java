package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Consulta;

public interface ConsultaDAO {
	public void salvar(Consulta consulta);
	public void atualizar(Consulta consulta);
	public void excluir(Consulta consulta);
	public Consulta carregar(Integer codigo);
	public Consulta buscarPorConsulta(Integer num_consulta);
	public List<Consulta> listar();
	List<Consulta> buscarPorGrupoProfissional(Integer codGrupo, String cpf);
}
