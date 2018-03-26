package sistema;

import java.sql.SQLException;

import bancoDeDados.AdminTools;
import bancoDeDados.MachineTools;
import bancoDeDados.UserTools;
import controllers.Admins;
import controllers.Machines;
import controllers.Users;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Sistema {

	private Users cUsuarios;
	private Machines cMaquinas;
	private Admins cAdmins;
	private UserTools uTools;
	private MachineTools mTools;
	private AdminTools admTools;

	public Sistema() {

		this.uTools = new UserTools();
		this.mTools = new MachineTools();
		this.admTools = new AdminTools();

		this.cUsuarios = new Users(uTools);
		this.cMaquinas = new Machines(mTools);
		this.cAdmins = new Admins(admTools);
	}

	// Funções de Admin

	public String inserirAdmin(String nome, String senha, String id) {
		return cAdmins.insert(nome, senha, id);
	}

	public String deletarAdmin(String id) {
		return cAdmins.delete(id);
	}

	public String setNomeAdmin(String nome, String id) {
		return cAdmins.setName(nome, id);
	}

	public String setIdAdmin(String id, String novoId) {
		return cAdmins.setId(id, novoId);
	}

	public String setSenhaAdmin(String id, String senha) {
		return cAdmins.setPassword(id, senha);
	}

	public String getInfoAdmin(String id) {
		return cAdmins.getInfo(id);
	}

	public String getNomeAdmin(String id) {
		return cAdmins.getName(id);
	}

	public boolean autenticaAdmin(String id, String senha) throws SQLException {
		return cAdmins.authenticate(id, senha);
	}

	public boolean hasIdAdmin(String id) throws SQLException {
		return cAdmins.hasAdmin(id);
	}

	public String getListagemAdm() {
		return cAdmins.getListAdmins();
	}

	// Funções de Usuário

	public String cadastrarUsuario(String nome, String id, String senha, String auditor) {
		return cUsuarios.inserir(nome, id, senha, auditor);
	}

	public String removerUsuario(String id) {
		return cUsuarios.remover(id);
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

	public String setSenhaUsuario(String id, String senha) {
		return cUsuarios.setSenha(id, senha);
	}

	public String getInfoUsuario(String id) {
		return cUsuarios.getInfo(id);
	}

	public String getNomeUsuario(String id) {
		return cUsuarios.getNome(id);
	}

	public String getNomeAuditor(String id) {
		return cUsuarios.getNomeAuditor(id);
	}

	public String listarUsuarios() {
		return cUsuarios.listar();
	}

	public boolean autenticaUsuario(String id, String senha) throws SQLException {
		return cUsuarios.autentica(id, senha);
	}

	public boolean hasIdUsuario(String id) throws SQLException {
		return cUsuarios.hasUsuario(id);
	}

	public boolean isUsuarioAtivo(String id) throws SQLException {
		return cUsuarios.isAtivo(id);
	}

	// Funções de Máquina

	public String adicionaMaquina(String nome, String codigo, String descricao, String idUsuario) {
		return cMaquinas.insert(nome, codigo, descricao, idUsuario);
	}

	public String removerMaquina(String codigo) {
		return cMaquinas.remover(codigo);
	}

	public String setNomeMaquina(String codigo, String novoNome) {
		return cMaquinas.setNome(codigo, novoNome);
	}

	public String setCodigoMaquina(String codigo, String novoCodigo) {
		return cMaquinas.setCodigo(codigo, novoCodigo);
	}

	public String setDescricaoMaquina(String codigo, String descricao) {
		return cMaquinas.setDescricao(codigo, descricao);
	}

	public String getInfoMaquina(String codigo) {
		return cMaquinas.getInfo(codigo);
	}

	public String listarMaquinas() {
		return cMaquinas.listar();
	}

	public boolean hasMaquina(String codigo) throws SQLException {
		return cMaquinas.hasMaquina(codigo);
	}
	
	
	public String getNomeMaquina(String codigo) {
		return cMaquinas.getNome(codigo);
	}
	
	public String getDescricaoMaquina(String codigo) {
		return cMaquinas.getDescricao(codigo);
	}

}
