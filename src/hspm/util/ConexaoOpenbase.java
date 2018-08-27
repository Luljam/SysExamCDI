package hspm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOpenbase {

	public Connection getConnection() {
		String driver = "tsql.jdbc3.Driver";
		String url = "jdbc:tsql:HST=10.48.16.07;DSN=/home/hospub/banco/bdint;SEC=33;LEV=atua;";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return conn;
	}
}
