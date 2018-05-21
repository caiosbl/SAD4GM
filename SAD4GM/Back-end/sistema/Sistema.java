package sistema;

import java.sql.SQLException;
import java.util.Map;

import controladores.Admins;
import controladores.Componentes;
import controladores.Falhas;
import controladores.Maquinas;
import controladores.ModosFalha;
import controladores.Subsistemas;
import controladores.Usuarios;
import databaseTools.AdminTools;
import databaseTools.ComponenteTools;
import databaseTools.FalhaTools;
import databaseTools.MaquinaTools;
import databaseTools.ModosFalhaTools;
import databaseTools.SubsistemaTools;
import databaseTools.UsuarioTools;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Sistema {

	private Usuarios cUsuarios;
	private Maquinas cMaquinas;
	private Admins cAdmins;
	private Subsistemas cSubsistemas;
	private Componentes cComponentes;
	private Falhas cFalhas;
	private ModosFalha cMFalhas;

	private UsuarioTools uTools;
	private MaquinaTools mTools;
	private AdminTools admTools;
	private SubsistemaTools sTools;
	private ComponenteTools cTools;
	private FalhaTools fTools;
	private ModosFalhaTools mFTools;

	public Sistema() {

		this.uTools = new UsuarioTools();
		this.mTools = new MaquinaTools();
		this.admTools = new AdminTools();
		this.sTools = new SubsistemaTools();
		this.cTools = new ComponenteTools();
		this.fTools = new FalhaTools();
		this.mFTools = new ModosFalhaTools();

		this.cUsuarios = new Usuarios(uTools);
		this.cMaquinas = new Maquinas(mTools);
		this.cAdmins = new Admins(admTools);
		this.cSubsistemas = new Subsistemas(sTools);
		this.cComponentes = new Componentes(cTools);
		this.cFalhas = new Falhas(fTools);
		this.cMFalhas = new ModosFalha(mFTools);
	}

	// Funções de Admin

	public String inserirAdmin(String nome, String senha, String id) {
		return cAdmins.inserir(nome, senha, id);
	}

	public String deletarAdmin(String id) {
		return cAdmins.remover(id);
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
		return cAdmins.getNome(id);
	}

	public boolean autenticaAdmin(String id, String senha) throws SQLException {
		return cAdmins.autenticar(id, senha);
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
		return cMaquinas.inserir(nome, codigo, descricao, idUsuario);
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

	public Map<String, Integer> getMapaMaquinas() {
		return cMaquinas.getMapaMaquinas();
	}
	
	public String getCodigoMaquina(int chaveMaquina) throws SQLException {
		return String.valueOf(cMaquinas.getCodigo(chaveMaquina));
	}

	// Funções de Subsistema

	public String inserirSubsistema(String nome, int chaveMaquina) {
		return cSubsistemas.inserir(nome, chaveMaquina);
	}

	public Map<String, Integer> getMapaSubsistemas() {
		return cSubsistemas.getMapaSubsistemas();
	}

	// Funções de Componentes

	public String inserirComponente(String nome, int chaveSubsistema, String funcao) {
		return cComponentes.inserir(nome, chaveSubsistema, funcao);
	}

	public Map<String, Integer> getMapaComponentes() {
		return cComponentes.getMapaComponentes();
	}

	// Funções de Falhas

	public String inserirFalha(String nome, String descricao, int chaveComponente) {
		return cFalhas.inserir(nome, descricao, chaveComponente);
	}

	public Map<String, Integer> getMapaFalhas() {
		return cFalhas.getMapaFalhas();
	}

	// Funções de Modos de Falha

	public String inserirModoFalha(String descricao, int chaveFalha) {
		return cMFalhas.inserir(descricao, chaveFalha);
	}

	public Map<String, Integer> getMapaModosFalha() {
		return cMFalhas.getMapaModosFalha();
	}

}
