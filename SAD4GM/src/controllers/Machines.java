package controllers;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import bancoDeDados.MachineTools;
import entidades.Maquina;
import validadorInformacoes.ValidaMaquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Machines {

	private MachineTools mTools;

	public Machines(MachineTools mTools) {
		this.mTools = mTools;

	}

	public String insert(String name, String code, String description, String idUser) {
		String status;
		Maquina machine;

		try {
			machine = new Maquina(name, code, description, idUser);
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
	
	
	public String getNome(String codigo) {
		int codigoInt;

		
		try {
			codigoInt = Integer.parseInt(codigo);
		}
		
		catch(Exception e) {
			throw new RuntimeErrorException(null, "Código Inválido!");
			
		}
		
		String nome;
		
		try {
			nome = mTools.getNome(codigoInt);
		}
		catch (Exception e) {
			throw new RuntimeErrorException(null,"Falha na conexão com Banco de Dados!");
		}
	
		

		return nome;
	}
	
	public String getDescricao(String codigo) {
		int codigoInt;

		
		try {
			codigoInt = Integer.parseInt(codigo);
		}
		
		catch(Exception e) {
			throw new RuntimeErrorException(null, "Código Inválido!");
			
		}
		
		String descricao;
		
		try {
			descricao = mTools.getDescricao(codigoInt);
		}
		catch (Exception e) {
			throw new RuntimeErrorException(null,"Falha na conexão com Banco de Dados!");
		}
	
		

		return descricao;
	}

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

	public String listar() {
		String listagem;

		listagem = mTools.listar();

		if (listagem.equals(""))
			listagem = "Nenhuma máquina cadastrada!";

		return listagem;
	}

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