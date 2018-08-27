package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.Paciente;

public interface PacienteDAO {
	public void salvar(Paciente paciente);
	public void atualizar(Paciente paciente);
	public void excluir(Paciente paciente);
	public List<Paciente> listar();
	public Paciente buscarRH(Integer rh);
}
