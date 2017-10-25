package usuario;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class ControllerUsuarios {
	private Map<String, Usuario> mapaUsuarios;

	public ControllerUsuarios() {
		this.mapaUsuarios = new HashMap<>();
	}

	private void validaId(String id) {
		if (!mapaUsuarios.containsKey(id)) {
			throw new RuntimeErrorException(null, "Usuário Não Cadastrado!");
		}
	}

	public void adicionaUsuario(String nome, String id, String auditor) {
		Usuario usuario = new Usuario(nome, id, auditor);
		mapaUsuarios.put(usuario.getId(), usuario);
	}

	public Usuario buscaUsuario(String id) {
		validaId(id);
		return mapaUsuarios.get(id);

	}

	public boolean atualizaUsuario(String id, String dado, String novoValor) {
		validaId(id);

		Usuario usuario = mapaUsuarios.get(id);
		boolean status = false;

		switch (dado.toLowerCase()) {

		case "nome":
			try {
				usuario.setNome(novoValor);
				status = true;
			} catch (Exception e) {
				status = false;
			}
			break;

		case "id":
			Usuario usuarioTemporario = usuario;
			try {
				usuarioTemporario.setId(novoValor);
				status = true;
				removerUsuario(id);
				mapaUsuarios.put(usuarioTemporario.getId(), usuarioTemporario);
			} catch (Exception e) {
				status = false;
			}

			break;
		case "auditor":
			try {
				usuario.setAuditor(novoValor);
				status = true;
			} catch (Exception e) {
				status = false;
			}

		default:
			throw new RuntimeException("Novo valor inválido!");
		}

		return status;

	}

	public void removerUsuario(String id) {
		validaId(id);
		mapaUsuarios.remove(id);
	}

}
