package usuario;

import java.util.HashMap;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
import java.util.Map;

import javax.management.RuntimeErrorException;

import usuario.enums.AtributosUsuario;

public class ControllerUsuarios {
	private Map<String, Usuario> mapaUsuarios;

	public ControllerUsuarios() {
		this.mapaUsuarios = new HashMap<>();
	}

	private void validaId(String id) {
		if (!mapaUsuarios.containsKey(id)) {
			throw new RuntimeErrorException(null, "USUÁRIO NÃO CADASTRADO!");
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

	public void atualizaUsuario(String id, String dado, String novoValor) {
		validaId(id);

		Usuario usuario = mapaUsuarios.get(id);

		final AtributosUsuario atributo;
		try {
			atributo = AtributosUsuario.valueOf(dado.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("DADO A SER ATUALIZADO INVÁLIDO!");
		}

		switch (atributo) {

		case NOME:
			try {
				usuario.setNome(novoValor);
			} catch (Exception e) {
				throw new IllegalArgumentException("NOVO NOME INVÁLIDO!");
			}
			break;

		case ID:
			Usuario usuarioTemporario = usuario;
			try {
				usuarioTemporario.setId(novoValor);
				removerUsuario(id);
				mapaUsuarios.put(usuarioTemporario.getId(), usuarioTemporario);
			} catch (Exception e) {
				throw new IllegalArgumentException("NOVO ID INVÁLIDO!");
			}
			break;

		case AUDITOR:
			try {
				usuario.setAuditor(novoValor);
			} catch (Exception e) {
				throw new IllegalArgumentException("NOVO AUDITOR INVÁLIDO");
			}
			break;

		}

	}

	public void removerUsuario(String id) {
		validaId(id);
		mapaUsuarios.remove(id);
	}

}
