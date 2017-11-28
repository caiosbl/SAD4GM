package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DataBaseTools {

	protected Connection con;

	protected void criaConexao() {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void fechaConexao() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}