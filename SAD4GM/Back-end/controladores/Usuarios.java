package controladores;

import java.sql.SQLException;

import databaseTools.UsuarioTools;
import entidades.Usuario;
import validadorInformacoes.CheckUser;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe Controladora de Usuários
 * 
 * @author caiosbl
 *
 */
public class Usuarios {

	/**
	 * Instância de Classe de Comunicação com Tabela de Usuários no Banco de Dados.
	 */
	private UsuarioTools uTools;

	public Usuarios(UsuarioTools uTools) {
		this.uTools = uTools;
	}

	/**
	 * Insere um Usuário no Banco de Dados
	 * 
	 * @param nome
	 *            Nome do Usuário
	 * @param id
	 *            ID do Usuário
	 * @param senha
	 *            Senha do Usuário
	 * @param auditor
	 *            Nome do Auditor
	 * @return Status da Operação
	 */
	public String inserir(String nome, String id, String senha, String auditor) {

		Usuario usuario;
		String status;

		try {
			usuario = new Usuario(nome, id, senha, auditor);
		} catch (Exception e) {
			return e.getMessage();
		}

		try {
			uTools.inserir(usuario);
			status = "Usuário inserido com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Remove um Usuário do Banco de Dados
	 * 
	 * @param id
	 *            ID do Usuário a ser removido.
	 * @return Status da Operação
	 */
	public String remover(String id) {
		String status;
		try {
			uTools.deletar(id);
			status = "Usuário removido com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Altera o nome de um Usuário no Banco de Dados
	 * 
	 * @param id
	 *            ID do Usuário a ser alterado
	 * @param nome
	 *            Novo Nome do Usuário.
	 * @return Status da Operação.
	 */

	public String setNome(String id, String nome) {
		String status;
		try {
			CheckUser.validateName(nome);
		} catch (IllegalArgumentException e) {
			status = "Nome Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "Nome nulo Inválido!";
			return status;
		}

		try {
			uTools.setNome(nome, id);
			status = "Nome Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}

		return status;
	}

	/**
	 * Altera o ID de um Usuário no Banco de Dados.
	 * 
	 * @param id
	 *            ID do Usuário a ser alterado.
	 * @param novoId
	 *            Novo ID do Usuário.
	 * @return Status da Operação.
	 */
	public String setId(String id, String novoId) {
		String status;
		try {
			CheckUser.validateId(novoId);
		} catch (IllegalArgumentException e) {
			status = "ID Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "ID nulo Inválido!";
			return status;
		}

		try {
			uTools.setId(id, novoId);

			status = "ID Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar o ID!";
		}

		return status;
	}

	/**
	 * Altera o Auditor de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter Auditor alterado.
	 * @param auditor
	 *            Novo Auditor do Usuário.
	 * @return Status da Operação.
	 */
	public String setAuditor(String id, String auditor) {
		String status;
		try {
			CheckUser.validaAuditor(auditor);
		} catch (IllegalArgumentException e) {
			status = "Auditor Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "Auditor nulo Inválido!";
			return status;
		}

		try {
			uTools.setAuditor(id, auditor);
			;
			status = "Auditor Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar o Auditor!";
		}

		return status;
	}

	/**
	 * Altera a Senha de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter Senha Alterada.
	 * @param senha
	 *            Novo Senha do Usuário.
	 * @return Status da Operação.
	 */
	public String setSenha(String id, String senha) {

		String status;
		try {
			uTools.setSenha(id, senha);
			status = "Senha Atualizada com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar a Senha!";
		}

		return status;
	}

	/**
	 * Retorna as Informações de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter informações retornada.
	 * @return Informações.
	 */
	public String getInfo(String id) {
		String info;

		try {
			info = uTools.getInfo(id);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	/**
	 * Retorna o Nome de um Usuário.
	 * 
	 * @param id
	 *            Id do Usuário a ter Nome Retornado.
	 * @return Nome do Usuário.
	 */
	public String getNome(String id) {
		String nome;
		try {
			nome = uTools.getNome(id);
		} catch (Exception e) {
			nome = e.getMessage();
		}

		return nome;
	}

	/**
	 * Retorna o Nome do Auditor de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter Nome do Auditor Retornado.
	 * @return Nome do Auditor do Usuário.
	 */
	public String getNomeAuditor(String id) {
		String auditor;
		try {
			auditor = uTools.getNomeAuditor(id);
		} catch (Exception e) {
			auditor = e.getMessage();
		}

		return auditor;

	}

	/**
	 * Retorna a Listagem dos Usuários Cadastrados no Banco de Dados.
	 * 
	 * @return Listagem de Usuários.
	 */
	public String listar() {
		String listagem;

		listagem = uTools.listar();

		if (listagem.equals(""))
			listagem = "Nenhum usuário cadastrado!";

		return listagem;
	}

	/**
	 * Autentica ID e Senha de um Usuário e retorna o valor booleano correspondente
	 * 
	 * @param id
	 *            ID do Usuário
	 * @param senha
	 *            Senha do Usuário
	 * @return Valor Booleano referente a autenticação dos dados.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na Comunicação com o Banco
	 *             de Dados.
	 */
	public boolean autentica(String id, String senha) throws SQLException {
		boolean status;

		if (uTools.autenticador(id, senha))
			status = true;
		else
			status = false;

		return status;
	}

	/**
	 * Checa a Existência de um Usuário através de seu ID.
	 * 
	 * @param id
	 *            ID do Usuário a ser checado.
	 * @return Valor Booleano indicando sua existência.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na Comunicação com o Banco
	 *             de Dados.
	 */
	public boolean hasUsuario(String id) throws SQLException {
		return uTools.hasUsuario(id);
	}

	/**
	 * Verifica se um Usuário está Ativo.
	 * 
	 * @param id
	 *            ID do Usuário.
	 * @return Valor Booleano indicando se o Usuário está ativo.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na Comunicação com o Banco
	 *             de Dados.
	 */
	public boolean isAtivo(String id) throws SQLException {
		return uTools.isAtivo(id);
	}

	public boolean isAdmin(String id) {
		try {
			return uTools.isAdmin(id);
		} catch (SQLException e) {
			return false;
		}
	}

}
