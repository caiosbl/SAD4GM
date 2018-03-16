package validadorInformacoes;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class CheckUser {

	public static void validateName(String nome) {
		if (nome == null) {
			throw new NullPointerException("NOME NULO INVÁLIDO!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}

	}

	public static void validateId(String id) {
		if (id == null) {
			throw new NullPointerException("ID NULO INVÁLIDO!");
		} else if (id.trim().equals("")) {
			throw new IllegalArgumentException("ID INVÁLIDO");
		}
	}

	public static void validaAuditor(String auditor) {
		if (auditor == null) {
			throw new NullPointerException("AUDITOR NULO INVÁLIDO");
		} else if (auditor.trim().equals("")) {
			throw new IllegalArgumentException("AUDITOR INVÁLIDO");
		}
	}

}
