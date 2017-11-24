package sistema;

import java.sql.SQLException;

import bancoDeDados.AdminTools;
import bancoDeDados.MaquinaTools;
import bancoDeDados.UsuarioTools;
import controllers.ControllerMaquinas;
import controllers.ControllerUsuarios;
import validadorInformacoes.ValidaUsuario;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Sistema {

	private ControllerUsuarios cUsuarios;
	private ControllerMaquinas cMaquinas;
	private UsuarioTools uTools;
	private MaquinaTools mTools;
	private AdminTools admTools;

	public Sistema() throws SQLException {

		this.uTools = new UsuarioTools();
		this.mTools = new MaquinaTools();
		this.admTools = new AdminTools();

		this.cUsuarios = new ControllerUsuarios(uTools);
		this.cMaquinas = new ControllerMaquinas(mTools);
	}

	// Funções de Admin
	
	public String inserirAdmin(String nome,String senha,String id) {
		int senhaInt;
		String status;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			return "SENHA INVÁLIDA!";
		}
		try {
			ValidaUsuario.validaNome(nome);
			ValidaUsuario.validaId(id);
			admTools.inserirAdmin(nome, senhaInt, id);
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

	public boolean autenticaAdmin(String id, String senha) throws SQLException {
		int senhaInt;
		boolean status;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			return false;
		}

		if (admTools.validaIdAndSenha(id, senhaInt))
			status = true;
		else
			status = false;

		return status;
	}

	// Funções de Usuário

	public String cadastrarUsuario(String nome, String id, String senha, String auditor) {
		return cUsuarios.adicionaUsuario(nome, id, senha, auditor);
	}

	public String removerUsuario(String id) {
		return cUsuarios.removerUsuario(id);
	}

	public String setNomeUsuario(String id, String nome) {
		return cUsuarios.setNome(id, nome);
	}

	public String setIdUsuario(String id, String novoId) {
		return cUsuarios.setId(id, novoId);
	}

	public String setAuditorUsuario(String id, String auditor) {
		return cUsuarios.setAuditor(id, auditor);
	}

	public String getInfoUsuario(String id) {
		return cUsuarios.getInfoUsuario(id);
	}

	public String listarUsuarios() {
		return cUsuarios.listarUsuarios();
	}

	public String validaIdAndSenhaUsuario(String id, String senha) throws SQLException {
		return cUsuarios.validaIdAndSenha(id, senha);
	}

	// Funções de Máquina

	public String adicionaMaquina(String nome, String codigo, String descricao, String idUsuario) {
		return cMaquinas.adicionaMaquina(nome, codigo, descricao, idUsuario);
	}

	public String removerMaquina(String codigo) {
		return cMaquinas.removerMaquina(codigo);
	}

	public String setNomeMaquina(String codigo, String novoNome) {
		return cMaquinas.setNome(codigo, novoNome);
	}

	public String setCodigoMaquina(String codigo, String novoCodigo) {
		return cMaquinas.setCodigo(codigo, novoCodigo);
	}

	public String setDescricaoMaquinas(String codigo, String descricao) {
		return cMaquinas.setDescricao(codigo, descricao);
	}

	public String getInfoMaquina(String codigo) {
		return cMaquinas.getInfoMaquina(codigo);
	}

	public String listarMaquinas() {
		return cMaquinas.listarMaquinas();
	}

}
