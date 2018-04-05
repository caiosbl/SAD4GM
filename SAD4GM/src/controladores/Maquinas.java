package controladores;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import databaseTools.MachineTools;
import entidades.Maquina;
import validadorInformacoes.ValidaMaquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe Controladora de Máquinass
 * 
 * @author caiosbl
 *
 */

public class Maquinas {

	/**
	 * Instância de Classe de Comunicação com Tabela de Máquinas no Banco de Dados.
	 */
	private MachineTools mTools;

	public Maquinas(MachineTools mTools) {
		this.mTools = mTools;

	}

	/**
	 * Insere uma Máquina no Banco de Dados
	 * 
	 * @param nome
	 *            Nome da Máquina
	 * @param codigo
	 *            Código da Máquina
	 * @param descricao
	 *            Descrição da Máquina
	 * @param idUsuario
	 *            ID do Usuário que cadastrou a Máquina
	 * @return Status da Operação.
	 */
	public String inserir(String nome, String codigo, String descricao, String idUsuario) {
		String status;
		Maquina machine;

		try {
			machine = new Maquina(nome, codigo, descricao, idUsuario);
		} catch (Exception e) {
			return e.getMessage();
		}

		try {
			mTools.insert(machine);
			status = "Máquina Inserida com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Remove uma Máquina do Banco de Dados
	 * 
	 * @param codigo
	 *            Código da Máquina a ser Removida.
	 * @return Status da Operação.
	 */
	public String remover(String codigo) {
		String status;
		int codigoInt;

		try {
			codigoInt = Maquina.parseCodigo(codigo);
		} catch (Exception e) {
			return e.getMessage();
		}

		try {
			mTools.deletar(codigoInt);
			status = "Máquina removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Retorna o nome de uma Máquina
	 * 
	 * @param codigo
	 *            Código da Máquina
	 * @return Nome da Máquina
	 */
	public String getNome(String codigo) {
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		}

		catch (Exception e) {
			throw new RuntimeErrorException(null, "Código Inválido!");

		}

		String nome;

		try {
			nome = mTools.getNome(codigoInt);
		} catch (Exception e) {
			throw new RuntimeErrorException(null, "Falha na conexão com Banco de Dados!");
		}

		return nome;
	}

	/**
	 * Retorna a Descrição de uma Máquina
	 * 
	 * @param codigo
	 *            Código da Máquina
	 * @return Descrição da Máquina
	 */
	public String getDescricao(String codigo) {
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		}

		catch (Exception e) {
			throw new RuntimeErrorException(null, "Código Inválido!");

		}

		String descricao;

		try {
			descricao = mTools.getDescricao(codigoInt);
		} catch (Exception e) {
			throw new RuntimeErrorException(null, "Falha na conexão com Banco de Dados!");
		}

		return descricao;
	}

	/**
	 * Altera o nome de uma Máquina no Banco de Dados
	 * 
	 * @param codigo
	 *            Código da Máquina a ser alterada.
	 * @param nome
	 *            Novo nome da Máquina a ser alterada.
	 * @return Status da Operação.
	 */
	public String setNome(String codigo, String nome) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaNome(nome);
			mTools.setNome(codigoInt, nome);
			status = "Nome atualizado com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Altera o Código de uma Máquina
	 * 
	 * @param codigo
	 *            Código da Máquina a ser Alterada.
	 * @param novoCodigo
	 *            Novo Código da Máquina a ser Alterada.
	 * @return Status da Operação.
	 */
	public String setCodigo(String codigo, String novoCodigo) {
		String status;
		int codigoInt;
		int novoCodigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			novoCodigoInt = Integer.parseInt(novoCodigo);
		} catch (Exception e) {
			return "NOVO CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaCodigo(novoCodigoInt);
			mTools.setCodigo(codigoInt, novoCodigoInt);
			status = "Código atualizado com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Altera a descrição de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ser Alterada.
	 * @param descricao
	 *            Nova Descrição da Máquina a ser Alterada.
	 * @return Status da Operação.
	 */
	public String setDescricao(String codigo, String descricao) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaDescricao(descricao);
			mTools.setDescricao(codigoInt, descricao);
			status = "Descrição atualizada com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/**
	 * Retorna as Informações de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ter informações retornadas.
	 * @return Status da Operação.
	 */
	public String getInfo(String codigo) {
		String info;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			info = mTools.getInfo(codigoInt);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	/**
	 * Retorna uma listagem das Máquinas Cadastradas no Banco de Dados.
	 * 
	 * @return listagem de máquinas
	 */

	public String listar() {
		String listagem;

		listagem = mTools.listar();

		if (listagem.equals(""))
			listagem = "Nenhuma máquina cadastrada!";

		return listagem;
	}

	/**
	 * Retorna um valor booleano informando se há ou não uma Máquina cadastrada no
	 * Banco de Dados.
	 * 
	 * @param codigo
	 *            Código da Máquina a ser checada.
	 * @return Valor Booleano indicando sua presença
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 */
	public boolean hasMaquina(String codigo) throws SQLException {

		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		}

		catch (Exception e) {
			throw new RuntimeErrorException(null, "Código não númerico!");
		}

		return mTools.hasMaquina(codigoInt);

	}

}
