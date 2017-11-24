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

	/*
	 * private static boolean criaTabelas(Connection conn) { FileInputStream
	 * fileStream = null; try { fileStream = new
	 * FileInputStream("./scripts/create.sql"); int result = ij.runScript(conn,
	 * fileStream, "UTF-8", System.out, "UTF-8"); if (result == 1) { return true; }
	 * else { return false; } } catch (FileNotFoundException e) { return false; }
	 * catch (UnsupportedEncodingException e) { return false; } finally { if
	 * (fileStream != null) { try { fileStream.close(); } catch (IOException e) { }
	 * } } }
	 */

}