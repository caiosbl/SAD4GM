package sistema;

import maquina.ControllerMaquinas;
import usuario.ControllerUsuarios;
import usuario.Usuario;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Sistema {

	private ControllerUsuarios cUsuarios;
	private ControllerMaquinas cMaquinas;

	public Sistema() {
		this.cUsuarios = new ControllerUsuarios();
		this.cMaquinas = new ControllerMaquinas();
	}

	// Funções de Usuário (CARB - [CADASTRAR ATUALIZAR REMOVER BUSCAR])

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

	// 3 - Remover um Usuário

	/*
	 * Verifica através do ID se o usuário existe. Caso esse não exista, uma
	 * mensagem é retornada informando que o usuário é inválido.
	 * 
	 * Caso contrário, o usuário é removido, e uma mensafem de sucesso é retornada.
	 */
	public String removerUsuario(String id) {
		try {
			cUsuarios.removerUsuario(id);
			return "USUÁRIO REMOVIDO COM SUCESSO!";
		} catch (RuntimeException e) {
			return "USUÁRIO INVÁLIDO!";
		}
	}

	// 4 - Buscar um Usuário

	/*
	 * Função Local, a ser utilizada somente nesta classe. O método tenta buscar um
	 * Usuário através de seu ID, caso ele não exista, uma exceção é lançada, vale
	 * salientar que tal exceção deverá ser capturada pelos métodos que utilizarem
	 * esta função. Caso o usuário seja encontrado, ele é retornado.
	 */
	private Usuario buscarUsuario(String id) {

		try {
			return cUsuarios.buscaUsuario(id);
		} catch (RuntimeException e) {
			throw new RuntimeException("USUÁRIO INVÁLIDO");
		}
	}
	
	public String buscaDadosUsuario(String id) {
		try {
			String dados = buscarUsuario(id).toString();
			return dados;
		}
		catch(RuntimeException e) {
			return e.getMessage();
		}
	}
	
	
	// Funções de Máquinas
	
	// 1 - Adicionar Máquinas
	// Esboço
	
	public void adicionaMaquina(String nome, int codigo, String descricao) {
		cMaquinas.adicionaMaquina(nome,codigo,descricao);
	}

}
