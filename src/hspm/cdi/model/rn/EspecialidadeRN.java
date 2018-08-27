package hspm.cdi.model.rn;

import java.util.List;

import hspm.cdi.dao.EspecialidadeDAO;
import hspm.cdi.model.Especialidade;
import hspm.util.DAOFactory;

public class EspecialidadeRN {
		private EspecialidadeDAO especialidadeDAO;
		
		public EspecialidadeRN() {
			this.especialidadeDAO = DAOFactory.criaEspecialidadeDAO();
		}
		
		public Especialidade carregar(Integer codigo){
			return this.especialidadeDAO.carregar(codigo);
		}


		public void salvar(Especialidade espec) {
			this.especialidadeDAO.salvar(espec);
		}

		public void excluir(Especialidade espec) {
			this.especialidadeDAO.excluir(espec);
		}

		public List<Especialidade> listar() {
			return this.especialidadeDAO.listar();
		}
		
		public List<Especialidade> buscarPorClinica(Integer codClinica) {
			return this.especialidadeDAO.buscarPorClinica(codClinica);
		}
}
