package controladores;

import java.sql.SQLException;

import databaseTools.AdminTools;
import validadorInformacoes.CheckUser;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe Controladora de Admins
 * 
 * @author caiosbl
 *
 *
 */

public class Admins {
	/**
	 * Instância de Classe de Comunicação com Tabela de Admins no Banco de Dados.
	 */
	private AdminTools admTools;

	public Admins(AdminTools admTools) {
		this.admTools = admTools;
	}

	/**
	 * Insere um Admin no Banco de Dados
	 * 
	 * @param nome
	 *            Nome do Admin
	 * @param senha
	 *            Senha do Admin
	 * @param id
	 *            Id do Admin
	 * @return Status da Operação
	 */
	public String inserir(String nome, String senha, String id) {

		String status;

		try {
			CheckUser.validateName(nome);
			CheckUser.validateId(id);
			admTools.insert(nome, senha, id);
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

	/**
	 * Remove um Admin do Banco de Dados
	 * 
	 * @param id
	 *            ID do Admin a ser Removido
	 * @return Status da Operação
	 */
	public String remover(String id) {
		String status;

		try {
			admTools.delete(id);
			status = "Admin Removido com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Altera o nome de um Admin no Banco de Dados
	 * 
	 * @param nome
	 *            Novo nome do Admin a ser alterado
	 * @param id
	 *            ID do Admin a ser Alterado
	 * @return Status da Operação
	 */
	public String setName(String nome, String id) {
		String status;

		try {
			CheckUser.validateName(nome);
			admTools.setName(nome, id);
			status = "Nome alterado com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Altera o ID de um Admin no Banco de Dados
	 * 
	 * @param id
	 *            ID do Admin a ser Alterado
	 * @param newId
	 *            Novo ID do Admin a ser Alterado
	 * @return Status da Operação
	 */

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

	/**
	 * Altera a senha de um Admin no Banco de Dados
	 * 
	 * @param id
	 *            ID do Admin a ser alterado
	 * @param password
	 *            Nova Senha do Admin
	 * @return Status da Operação
	 */
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

	/**
	 * Retorna as Informações de um Admin
	 * 
	 * @param id
	 *            ID do Admin a ter Informações retornadas
	 * @return Informações
	 */

	public String getInfo(String id) {
		String info;

		try {
			info = admTools.getInfo(id);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	/**
	 * Retorna o nome de um Admin
	 * 
	 * @param id
	 *            ID do Admin a ter nome retornado
	 * @return Nome
	 */
	public String getNome(String id) {
		String nome;
		try {
			nome = admTools.getName(id);
		} catch (Exception e) {
			nome = e.getMessage();
		}

		return nome;
	}

	/**
	 * Autentica o ID e Senha de um Admin, retorna um valor Booleano informando se
	 * as informações são válidas.
	 * 
	 * @param id
	 *            ID do Admin
	 * @param password
	 *            Senha do Admin
	 * @return Status da Autenticação
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha de Conexão com o Banco de
	 *             Dados.
	 */
	public boolean authenticate(String id, String password) throws SQLException {
		return admTools.authenticate(id, password);

	}

	/**
	 * Verifica se há um Admin no Banco de Dados com o ID informado.
	 * 
	 * @param id
	 *            ID a ser verificado.
	 * @return Valor Booleano informando existência ou não de tal ID no Banco de
	 *         Dados.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * 
	 */

	public boolean hasAdmin(String id) throws SQLException {
		return admTools.hasAdmin(id);
	}

	/**
	 * Retorna a Listagem dos Admins presentes no Banco de Dados.
	 * 
	 * @return Listagem de Admins.
	 */
	public String getListAdmins() {
		return admTools.listAdmins();
	}
}
