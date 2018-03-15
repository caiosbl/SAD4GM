
package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class AdminTools extends DataBaseTools {

	public void insert(String name, String password, String id) throws SQLException {

		if (hasAdmin(id))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			String encodingPassword = encodePassword(password);

			final String INSERIR = "INSERT INTO sad4gm.admin (nome, senha,id) VALUES (?,?,?)";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, name);
			stmt.setString(2, encodingPassword);
			stmt.setString(3, id);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Administrador não cadastrado!");

		try {

			final String DELETE = "DELETE FROM sad4gm.admin where CAST(id AS VARCHAR(128)) = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setString(1, id);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setName(String name, String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET nome = ? WHERE CAST(id AS VARCHAR(128))= ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, name);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setId(String id, String newId) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET id = ? WHERE CAST(id AS VARCHAR(128))  = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, newId);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPassword(String id, String senha) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			String encodingPassword = encodePassword(senha);

			final String UPDATE = "UPDATE  sad4gm.admin SET senha = ? WHERE CAST(id AS VARCHAR(128)) = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, encodingPassword);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getInfo(String id) throws SQLException {
		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Admin inexistente!");

		String infoAdmin = "";
		String breakLine = System.lineSeparator();

		try {
			openConnection();
			PreparedStatement state = con
					.prepareStatement("SELECT  nome,id FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				infoAdmin += "Nome: " + resSet.getString(1) + breakLine;
				infoAdmin += "Id: " + resSet.getString(2) + breakLine;
			}
			state.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoAdmin;

	}

	public String getName(String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String name = "";

		try {
			openConnection();
			PreparedStatement state = con
					.prepareStatement("SELECT  nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				name = resSet.getString(1);
			}
			state.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;

	}

	public boolean authenticate(String id, String password) throws SQLException {

		boolean valid = false;

		if (!hasAdmin(id))
			return false;
		
		try {

			String encodingPassword = encodePassword(password);
			openConnection();
			PreparedStatement state = con.prepareStatement(
					"SELECT id FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ? AND CAST(senha AS VARCHAR(128)) =  ?");
			state.setString(1, id);
			state.setString(2, encodingPassword);

			ResultSet resSet = state.executeQuery();

			if (resSet.next())
				valid = true;

			state.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;

	}

	public boolean hasAdmin(String id) throws SQLException {
		boolean has;
		openConnection();
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
		state.setString(1, id);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			has = true;
		else
			has = false;
		state.close();
		closeConnection();

		return has;

	}

	public String listAdmins() {
		String list = "";
		String breakLine = System.lineSeparator();

		try {
			openConnection();
			PreparedStatement state = con.prepareStatement("SELECT  nome,id FROM sad4gm.admin");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				list += "----------------------------------------------------------------------------";
				list += breakLine + String.format("Nome: %s", resSet.getString(1)) + breakLine
						+ String.format("ID: %s", resSet.getString(2)) + breakLine;
			}
			state.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
