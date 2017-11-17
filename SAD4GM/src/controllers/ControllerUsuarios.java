package controllers;

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

import bancoDeDados.DataBaseTools;
import usuario.Usuario;
import usuario.enums.AtributosUsuario;
import validadorInformacoes.ValidaUsuario;

public class ControllerUsuarios {
	private Map<String, Usuario> mapaUsuarios;
	private DataBaseTools dTools;

	public ControllerUsuarios(DataBaseTools dTools) {
		this.mapaUsuarios = new HashMap<>();
		this.dTools = dTools;
	}

	public String adicionaUsuario(String nome, String id, String senha, String auditor) {

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
			ValidaUsuario.validaAuditor(auditor);
			dTools.inserirUsuario(nome, id, senhaInt, auditor);
			status = "USUÁRIO CADASTRADO COM SUCESSO!";
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

	public Usuario buscaUsuario(String id) {
		return mapaUsuarios.get(id);

	}

	public String atualizaNome(String id, String nome) {
		String status;
		try {
			ValidaUsuario.validaNome(nome);
		} catch (IllegalArgumentException e) {
			status = "Nome Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "Nome nulo Inválido!";
			return status;
		}

		try {
			dTools.atualizarNomeUsuario(nome, id);
			status = "Nome Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}

		return status;
	}

	public void atualizaUsuario(String id, String dado, String novoValor) {

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
		mapaUsuarios.remove(id);
	}

	public String listarUsuarios() {
		String quebraLinha = System.lineSeparator();
		String listagem = "USUÁRIOS CADASTRADOS: " + quebraLinha;

		for (String chave : mapaUsuarios.keySet()) {
			listagem += quebraLinha;
			listagem += mapaUsuarios.get(chave).toString();
			listagem += quebraLinha;
		}

		return listagem;
	}

}
