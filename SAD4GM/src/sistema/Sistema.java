package sistema;

import java.sql.SQLException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import bancoDeDados.DataBaseTools;
import controllers.ControllerMaquinas;
import controllers.ControllerUsuarios;
import maquina.Maquina;
import usuario.Usuario;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Sistema {

	private ControllerUsuarios cUsuarios;
	private ControllerMaquinas cMaquinas;
	private DataBaseTools dTools;

	public Sistema() throws SQLException {
		this.dTools = new DataBaseTools();
		this.cUsuarios = new ControllerUsuarios(dTools);
		this.cMaquinas = new ControllerMaquinas(dTools);
	}

	public String cadastrarUsuario(String nome, String id, String senha, String auditor) {
		return cUsuarios.adicionaUsuario(nome, id, senha, auditor);
	}

	public String atualizarUsuario(String id, String dado, String novoValor) {
		try {
			return cUsuarios.atualizaNome(id,novoValor);
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
		} catch (RuntimeException e) {
			return e.getMessage();
		}
	}

	// 5 - Listar Usuários
	/*
	 * Lista os usuários cadastrados.
	 */
	public String listarUsuarios() {
		return cUsuarios.listarUsuarios();
	}


	public String adicionaMaquina(String nome, String codigo, String descricao) {
		return cMaquinas.adicionaMaquina(nome, codigo, descricao);
	}

	// 2 - Atualizar uma Máquina
	/*
	 * Tenta validar o código da máquina, caso o código seja inválido ou não esteja
	 * cadastrado, é retornada uma mensagem de erro, que é lançada na classe
	 * ControllerMaquinas, posteriormente é feita a tentativa de mudança do dado
	 * informada pelo usuário, caso o usuário informe um dado inválido a ser
	 * atualizado é retornada uma mensagem de erro, caso contrário, é feita a
	 * validação do novo dado, caso este seja inválido uma mensagem de erro é
	 * retornado, caso seja válido o dado é atualizado e uma mensagem de sucesso
	 * reteornada.
	 * 
	 */
	public String atualizarMaquina(String codigo, String dado, String novoValor) {
		int codigoInt;
		String status;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (ParseException e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			cMaquinas.atualizarMaquina(codigoInt, dado, novoValor);
			status = "MÁQUINA ATUALIZADA COM SUCESSO!";
		} catch (RuntimeException e) {
			status = e.getMessage();
		}
		return status;
	}

	// 3 - Remover uma Máquina
	/*
	 * A função verifica se o código é válido, caso não seja é retornada uma
	 * mensagem de erro, posteriormente é verificado se o código é de cadastrado, em
	 * caso negativa também é retornada uma mensagem de erro, em caso positivo é
	 * retornada uma mensagem de sucesso informando que a máquina foi removida.
	 */

	public String removerMaquina(String codigo) {
		int codigoInt;
		String status;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (ParseException e) {
			return "CÓDIGO INVÁLIDO";
		}

		try {
			cMaquinas.removerMaquina(codigoInt);
			status = "MÁQUINA REMOVIDA COM SUCESSO!";
		} catch (RuntimeException e) {
			status = e.getMessage();
		}

		return status;
	}

	// 4 - Buscar uma Máquina
	/*
	 * É feita a validação se o código é válido, caso não seja uma exceção é lançada
	 * com erro de código inválido, caso seja válido, é feita a busca pela máquina,
	 * caso esta não exista uma outra exceção é lançada informando o erro de
	 * inexistência, caso positivo a máquina é retornada.
	 */

	private Maquina buscarMaquina(String codigo) {
		int codigoInt;
		Maquina maquina;
		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (ParseException e) {
			throw new RuntimeException("CÓDIGO INVÁLIDO!");
		}

		try {
			maquina = cMaquinas.buscaMaquina(codigoInt);
		} catch (RuntimeException e) {
			throw new RuntimeException("MÁQUINA INEXISTENTE!");
		}
		return maquina;
	}

	public String buscarDadosMaquina(String codigo) {
		String dados;
		try {
			dados = buscarMaquina(codigo).toString();
		} catch (RuntimeException e) {
			return e.getMessage();
		}
		return dados;
	}

	// - 5 Listar Máquinas
	/*
	 * Lista as máquinas cadastradas.
	 */
	public String listarMaquinas() {
		return cMaquinas.listaMaquinas();
	}

	public void fechaConexao() {
		dTools.fechaConexao();
	}

}
