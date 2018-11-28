package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.OrigemCausaTools;

import entidades.Origem;

public class OrigemCausas {

	private OrigemCausaTools origemTools;

	public OrigemCausas(OrigemCausaTools cPTools) {
		this.origemTools = cPTools;
	}

	public String inserir(String nome, int chaveCausaPotencial) {

		String status;

		try {
			origemTools.inserir(nome, chaveCausaPotencial);
			status = "Origem de Causa inserida com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaOrigemCausas(int chaveCausaPotencial) {

		try {
			return origemTools.getMapaOrigemCausas(chaveCausaPotencial);
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}

	public Map<Integer, Origem> getOrigemCausasMap(int chaveCausaPotencial) {
		try {
			return origemTools.getOrigemCausasMap(chaveCausaPotencial);
		} catch (SQLException e) {
			return new HashMap<Integer, Origem>();
		}
	}

	public String getNome(int chaveOrigem) {
		String nome;

		try {
			nome = origemTools.getNomeOrigemCausa(chaveOrigem);
		} catch (SQLException e) {
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}

	public String setNome(String nome, int chaveOrigem) {
		String status;

		try {
			origemTools.setNomeOrigem(nome, chaveOrigem);
			status = "Nome atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}

		return status;
	}

	public String remover(int chave) {
		String status;

		try {
			origemTools.deletar(chave);
			status = "Origem removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

}
