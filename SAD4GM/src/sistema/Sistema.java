package sistema;

import usuario.ControllerUsuarios;

public class Sistema {

	private ControllerUsuarios cUsuarios;

	public Sistema() {
		this.cUsuarios = new ControllerUsuarios();
	}

	// Funções de Usuário

	// 1 - Cadastrar um Usuário

	/*
	 * Tenta cadastrar um Usuário. A Operação terá sucesso se todos os dados forem
	 * Válidos. Caso algum dado seja inválido, a função captura a exceção, a qual
	 * foi lançada na classe ValidaUsuario e retorna uma mensagem informando qual o
	 * dado inválido.
	 */

	public String cadastrarUsuario(String nome, String id, String auditor) {

		String status;
		try {
			cUsuarios.adicionaUsuario(nome, id, auditor);
			status = "USUÁRIO CADASTRADO COM SUCESSO!";
		} catch (NullPointerException e) {
			status = e.getMessage();
		} catch (IllegalArgumentException e) {
			status = e.getMessage();
		}
		return status;
	}

	// 2 - Atualizar um Usuário

	/*
	 * Tenta atualizar um dado do Usuário. Primeiro verifica através do ID se o
	 * usuário existe. Caso o usuário não exista, o método retorna um mensagem
	 * informando que o usuário é inválido, tal mensagem é lançada na classe
	 * ControllerUsuarios, atráves de uma exceção, e aqui é capturada e retornada.
	 * 
	 * Posteriormente verifica se o dado escolhido a ser alterado é válido, caso não
	 * seja é retornada uma mensagem informando que o dado é inválido. Tal mensagem
	 * também é lançada através de exceção na classe ControllerUsuarios, e capturada
	 * aqui e retornada.
	 * 
	 * Por fim verifica-se o novo valor dado, caso este seja inválido uma mensagem
	 * também é retornada informando qual o dado é inválido.
	 * 
	 * Caso passe das verificações mencionadas anteriormente, o dado foi atualizado
	 * com sucesso, e uma mensagem de Sucesso é retornada.
	 * 
	 */

	public String atualizarUsuario(String id, String dado, String novoValor) {
		try {
			cUsuarios.atualizaUsuario(id, dado, novoValor);
			return "USUÁRIO ATUALIZADO COM SUCESSO!";
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}

		catch (RuntimeException e) {
			return e.getMessage();
		}
	}

}
