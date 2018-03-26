package controllers;

import java.sql.SQLException;

import bancoDeDados.AdminTools;
import validadorInformacoes.CheckUser;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Admins {
	private AdminTools admTools;

	public Admins(AdminTools admTools) {
		this.admTools = admTools;
	}

	public String insert(String name, String password, String id) {

		String status;

		try {
			CheckUser.validateName(name);
			CheckUser.validateId(id);
			admTools.insert(name, password, id);
			status = "Admin CADASTRADO COM SUCESSO!";

		} catch (NullPointerException e) {
			status = e.getMessage();
		} catch (IllegalArgumentException e) {
			status = e.getMessage();
		} catch (RuntimeException e) {
			status = e.getMessage();
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String delete(String id) {
		String status;

		try {
			admTools.delete(id);
			status = "Admin Removido com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setName(String name, String id) {
		String status;

		try {
			CheckUser.validateName(name);
			admTools.setName(name, id);
			status = "Nome alterado com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setId(String id, String newId) {
		String status;

		try {
			CheckUser.validateId(newId);
			admTools.setId(id, newId);
			status = "Nome alterado com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setPassword(String id, String password) {
		String status;

		try {

			admTools.setPassword(id, password);
			status = "Senha alterada com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String getInfo(String id) {
		String info;

		try {
			info = admTools.getInfo(id);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	public String getName(String id) {
		String nome;
		try {
			nome = admTools.getName(id);
		} catch (Exception e) {
			nome = e.getMessage();
		}

		return nome;
	}

	public boolean authenticate(String id, String password) throws SQLException {
		return admTools.authenticate(id, password);

	}

	public boolean hasAdmin(String id) throws SQLException {
		return admTools.hasAdmin(id);
	}

	public String getListAdmins() {
		return admTools.listAdmins();
	}
}
