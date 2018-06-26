package sistema;

import java.sql.SQLException;
import java.util.Map;
import controladores.Componentes;
import controladores.Falhas;
import controladores.Maquinas;
import controladores.ModosFalha;
import controladores.Subsistemas;
import controladores.Usuarios;

import databaseTools.ComponenteTools;
import databaseTools.FalhaTools;
import databaseTools.MaquinaTools;
import databaseTools.ModosFalhaTools;
import databaseTools.SubsistemaTools;
import databaseTools.UsuarioTools;
import entidades.Componente;
import entidades.Falha;
import entidades.Maquina;
import entidades.ModoFalha;
import entidades.Subsistema;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Sistema {

	private Usuarios cUsuarios;
	private Maquinas cMaquinas;
	
	private Subsistemas cSubsistemas;
	private Componentes cComponentes;
	private Falhas cFalhas;
	private ModosFalha cMFalhas;

	private UsuarioTools uTools;
	private MaquinaTools mTools;

	private SubsistemaTools sTools;
	private ComponenteTools cTools;
	private FalhaTools fTools;
	private ModosFalhaTools mFTools;

	public Sistema() {

		this.uTools = new UsuarioTools();
		this.mTools = new MaquinaTools();

		this.sTools = new SubsistemaTools();
		this.cTools = new ComponenteTools();
		this.fTools = new FalhaTools();
		this.mFTools = new ModosFalhaTools();

		this.cUsuarios = new Usuarios(uTools);
		this.cMaquinas = new Maquinas(mTools);

		this.cSubsistemas = new Subsistemas(sTools);
		this.cComponentes = new Componentes(cTools);
		this.cFalhas = new Falhas(fTools);
		this.cMFalhas = new ModosFalha(mFTools);
	}

	

	// Funções de Usuário

	public String cadastrarUsuario(String nome, String id, String senha, String auditor, boolean admin) {
		return cUsuarios.inserir(nome, id, senha, auditor, admin);
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

	public boolean isAdmin(String id) {
		return cUsuarios.isAdmin(id);
	}

	// Funções de Máquina

	public String adicionaMaquina(String nome, String codigo, String descricao, String idUsuario) {
		return cMaquinas.inserir(nome, codigo, descricao, idUsuario);
	}

	public String removerMaquina(int chave) {
		return cMaquinas.remover(chave);
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

	public Map<Integer, Maquina> getMaquinaMapa() {
		return cMaquinas.getMaquinasMapa();
	}

	public String getCodigoMaquina(int chaveMaquina) throws SQLException {
		return String.valueOf(cMaquinas.getCodigo(chaveMaquina));
	}

	// Funções de Subsistema

	public String inserirSubsistema(String nome, int chaveMaquina) {
		return cSubsistemas.inserir(nome, chaveMaquina);
	}

	public String removerSubsistema(int chave) {
		return cSubsistemas.remover(chave);
	}

	public Map<String, Integer> getMapaSubsistemas(int chaveMaquina) {
		return cSubsistemas.getMapaSubsistemas(chaveMaquina);
	}

	public Map<Integer, Subsistema> getSubsistemasMap(int chaveMaquina) {
		return cSubsistemas.getSubsistemasMap(chaveMaquina);
	}

	public String getNomeSubsistema(int chaveSubsistema) {
		return cSubsistemas.getNomeSubsistema(chaveSubsistema);
	}

	public String setNomeSubsistema(String nome, int chaveSubsistema) {
		return cSubsistemas.setNomeSubsistema(nome, chaveSubsistema);
	}

	// Funções de Componentes

	public String inserirComponente(String nome, int chaveSubsistema, String funcao) {
		return cComponentes.inserir(nome, chaveSubsistema, funcao);
	}

	public Map<String, Integer> getMapaComponentes(int chaveSubsistema) {
		return cComponentes.getMapaComponentes(chaveSubsistema);
	}
	
	public Map<Integer,Componente> getComponentesMap(int chaveSubsistema){
		return cComponentes.getComponentesMap(chaveSubsistema);
	}

	public String getNomeComponente(int chaveComponente) {
		return cComponentes.getNomeComponente(chaveComponente);
	}

	public String setNomeComponente(String nome, int chaveComponente) {
		return cComponentes.setNomeComponente(nome, chaveComponente);
	}

	public String getFuncaoComponente(int chaveComponente) {
		return cComponentes.getFuncaoComponente(chaveComponente);
	}

	public String setFuncaoComponente(String funcao, int chaveComponente) {
		return cComponentes.setFuncaoComponente(funcao, chaveComponente);
	}

	// Funções de Falhas

	public String inserirFalha(String nome, String descricao, int chaveComponente) {
		return cFalhas.inserir(nome, descricao, chaveComponente);
	}

	public Map<String, Integer> getMapaFalhas(int chaveComponente) {
		return cFalhas.getMapaFalhas(chaveComponente);
	}
	
	public Map<Integer,Falha> getFalhasMap(int chaveComponente){
		return cFalhas.getFalhasMap(chaveComponente);
	}

	public String getNomeFalha(int chaveFalha) {
		return cFalhas.getNome(chaveFalha);
	}

	public String setNomeFalha(String nome, int chaveFalha) {
		return cFalhas.setNome(nome, chaveFalha);
	}

	public String getDescricaoFalha(int chaveFalha) {
		return cFalhas.getDescricao(chaveFalha);
	}

	public String setDescricaoFalha(String nome, int chaveFalha) {
		return cFalhas.setDescricao(nome, chaveFalha);
	}

	// Funções de Modos de Falha

	public String inserirModoFalha(String descricao, int chaveFalha) {
		return cMFalhas.inserir(descricao, chaveFalha);
	}

	public Map<String, Integer> getMapaModosFalha(int chaveFalha) {
		return cMFalhas.getMapaModosFalha(chaveFalha);
	}
	
	public Map<Integer,ModoFalha> getModosFalhaMap(int chaveFalha){
		return cMFalhas.getModosFalhaMap(chaveFalha);
	}

	public String getDescricaoModoFalha(int chaveModoFalha) {
		return cMFalhas.getDescricao(chaveModoFalha);
	}

	public String setDescricaoModoFalha(String nome, int chaveModoFalha) {
		return cMFalhas.setDescricao(nome, chaveModoFalha);
	}

}
