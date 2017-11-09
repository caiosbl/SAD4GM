package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Teste {

	private static String dbURL = "jdbc:derby:myDB;create=true;user=sad4gm;password=mengohexa";
	private static String tableName = "usuario";
	// jdbc Connection
	private static Connection conn = null;
	private static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();
		insertUsuario("CAio", "Algum", 11, "Lira");;
		selectRestaurants();
		shutdown();
	}

	private static void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
		} catch (Exception except) {
			except.printStackTrace();
		}
	}

	private static void insertUsuario(String nome, String id, int senha, String auditor) {
		try {
			stmt = conn.createStatement();
			stmt.execute("insert into " + tableName + " values (" + "'" +  nome  + "'"+ "','" + id + "','" + senha +  "'," + auditor + ")");
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	private static void selectRestaurants() {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from " + tableName);
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.print(rsmd.getColumnLabel(i) + "\t\t");
			}

			System.out.println("\n-------------------------------------------------");

			while (results.next()) {
				String nome = results.getString(1);
				String id = results.getString(2);
				int senha = results.getInt(3);
				String auditor = results.getString(4);
				System.out.println(nome + "\t\t" + id + "\t\t" + senha+ "\t\t" + auditor);
			}
			results.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	private static void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				DriverManager.getConnection(dbURL + ";shutdown=true");
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}

}
