package hspm.cdi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import hspm.cdi.dao.ConsultaDAO;
import hspm.cdi.model.Consulta;

public class ConsultaDAOHibernate implements ConsultaDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Consulta consulta) {
		this.session.save(consulta);
		this.session.flush();
		this.session.clear();
	}

	@Override
	public void atualizar(Consulta consulta) {
		this.session.update(consulta);
	}

	@Override
	public void excluir(Consulta consulta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Consulta carregar(Integer codigo) {
		return (Consulta) this.session.get(Consulta.class, codigo);
	}
	
	public Consulta buscarPorConsulta(Integer num_consulta){
		String hql = "select c from Consulta c where c.num_consulta = :numero";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("numero", num_consulta);
		return (Consulta) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consulta> listar() {
		return this.session.createCriteria(Consulta.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consulta> buscarPorGrupoProfissional(Integer codGrupo, String cpf) {
		try {

			SQLQuery consulta = this.session.createSQLQuery("select {c.*} "
					+ "from consulta {c}, exame e, grupo_exame g, grade d " 
					+ "where c.cod_exame = e.cod_exame "
					+ "and e.cod_grupo_exame = g.cod_grupo_exame " 
					+ "and d.cod_grupo_agenda = ? "
					+ "and c.num_consulta = d.cod_grade " 
					+ "and d.cpf_profissional = ?");
			consulta.setInteger(0, codGrupo);
			consulta.setString(1, cpf);
			consulta.addEntity("c", Consulta.class);
			List<Consulta> lista = consulta.list();
			return lista;
		} catch (Exception e) {
			throw e;
		}
	}

}
