package usuario;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class ControllerUsuarios {
	private Map<String, Usuario> usuarios;

	public ControllerUsuarios() {
		this.usuarios = new HashMap<>();
	}

	private void validaId(String id) {
		if (!usuarios.containsKey(id)) {
			throw new RuntimeErrorException(null, "Usuário Não Cadastrado!");
		}
	}

	public void adicionaUsuario(String nome, String id, String supervisor) {
		Usuario usuario = new Usuario(nome, id, supervisor);
		usuarios.put(usuario.getId(), usuario);
	}

	public Usuario buscaUsuario(String id) {
		validaId(id);
		return usuarios.get(id);

	}

	public void atualizaUsuario(String id, String dado, String novoValor) {
		validaId(id);

		Usuario usuario = usuarios.get(id);

		switch (dado.toLowerCase()) {

		case "nome":
			usuario.setNome(novoValor);
			break;
		case "id":
			Usuario usuarioTemporario = usuario;
			usuarioTemporario.setId(novoValor);
			removerUsuario(id);
			usuarios.put(usuarioTemporario.getId(), usuarioTemporario);
			break;
		case "auditor":
			usuario.setAuditor(novoValor);

		default:
			throw new RuntimeException("Novo valor inválido!");
		}

	}

	public void removerUsuario(String id) {
		validaId(id);
		usuarios.remove(id);
	}

}
