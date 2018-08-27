package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Agenda;

public interface AgendaDAO {
	public void salvar(Agenda agenda);
	public void atualizar(Agenda agenda);
	public void excluir(Agenda agenda);
	public Agenda carregar(Integer codigo);
	public List<Agenda> listar();
	public List<Agenda> agendaUnica();
}
