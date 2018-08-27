package hspm.cdi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import hspm.cdi.model.PacienteHospub;
import hspm.util.ConexaoOpenbase;

public class PacienteHospubDAOOpenbase {

	public PacienteHospub buscarRH(Integer rh) {
		
		
		Connection conn = new ConexaoOpenbase().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PacienteHospub pac = null;
		try {
			stmt = conn.prepareStatement("Select ib6regist, ib6prontuar,ib6pnome, ib6compos, ib6sexo, ib6dtnasc, ib6telef From intb6 Where ib6regist = ?");
			stmt.setInt(1, rh);
			rs = stmt.executeQuery();
			if (rs.next()) {
				pac = new PacienteHospub();
				pac.setRh(rs.getInt("ib6regist"));
				pac.setRf(rs.getInt("ib6prontuar"));
				pac.setNome(rs.getString("ib6pnome") + rs.getString("ib6compos"));
				pac.setSexo(rs.getInt("ib6sexo"));
				pac.setNascimento(rs.getString("ib6dtnasc"));
				pac.setTelefone(rs.getString("ib6telef"));
			}
			
		} catch (Throwable ex) {
			System.out.println("Erro ao buscar Paciente. Mensagem: " + ex.getMessage());
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (Throwable ex) {
				System.out.println("Erro ao fechar operações de busca. Mensagem: " + ex.getMessage());
			}
		}
		return pac;
	}

}
