package hspm.cdi.dao;

import java.util.List;

import hspm.cdi.model.GrupoExame;

public interface GrupoExameDAO {
		public void salvar(GrupoExame grupo);
		public void atualizar(GrupoExame grupo);
		public void excluir(GrupoExame grupo);
		public GrupoExame carregar(Integer codigo);
		public List<GrupoExame> listar();
}
