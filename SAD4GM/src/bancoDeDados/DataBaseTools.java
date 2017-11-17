package bancoDeDados;

import java.beans.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.derby.tools.ij;

public class DataBaseTools {

	private Connection con;

	public void criaConexao() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fechaConexao() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean criaTabelas(Connection conn) {
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream("./scripts/create.sql");
			int result = ij.runScript(conn, fileStream, "UTF-8", System.out, "UTF-8");
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			return false;
		} catch (UnsupportedEncodingException e) {
			return false;
		} finally {
			if (fileStream != null) {
				try {
					fileStream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public void inserirUsuario(String nome, String id, int senha, String auditor) {
		try {

			final String INSERIR = "INSERT INTO sad4gm.usuario (nome, id, senha,auditor) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, nome);
			stmt.setString(2, id);
			stmt.setInt(3, senha);
			stmt.setString(4, auditor);
			stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUsuarioInfo(String id) throws SQLException {
		
		if(!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");
		
		String infoUsuario = "";
		
		
		PreparedStatement State = con.prepareStatement("SELECT DISTINCT nome,id,auditor FROM sad4gm.usuario WHERE id = 'sdsd'");
		ResultSet ResSet = State.executeQuery();

		while (ResSet.next()) {
			infoUsuario += ResSet.getString(1);
			infoUsuario += ResSet.getString(2);
			infoUsuario += ResSet.getString(3);
		}

	}

	private boolean hasUsuario(String id) throws SQLException {
		boolean has;
		PreparedStatement State = con.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE id = ?");
		State.setString(1, id);
		ResultSet ResSet = State.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;

		return has;

	}

	public void deletarUsuario(String id) throws SQLException {
		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário não cadastrado!");

		try {

			final String INSERIR = "DELETE FROM sad4gm.usuario where id = ?";
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, id);
			stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarNomeUsuario(String nome, String id) {
		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET nome = ? WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setString(2, id);
			stmt.execute();

		} catch (Exception e) {
			throw new NullPointerException();
		}
	}

	public void inserirMaquina(String nome, int codigo, String descricao) {
		criaConexao();
		try {

			final String INSERIR = "INSERT INTO sad4gm.maquina (nome, codigo,descricao) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			stmt.setString(3, descricao);
			stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}