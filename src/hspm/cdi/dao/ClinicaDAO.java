package hspm.cdi.dao;

import java.util.List;
import hspm.cdi.model.Clinica;
public interface ClinicaDAO {
	public void salvar(Clinica clinica);
	public void atualizar(Clinica clinica);
	public void excluir(Clinica clinicao);
	public Clinica carregar(Integer codigo);
	public List<Clinica> listar();
}
