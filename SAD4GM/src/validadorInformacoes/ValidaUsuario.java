package validadorInformacoes;

public class ValidaUsuario {

	public static void validaNome(String nome) {
		if (nome == null) {
			throw new NullPointerException();
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome Inválido!");
		}

	}

	public static void validaId(String id) {
		if (id == null) {
			throw new NullPointerException();
		} else if (id.trim().equals("")) {
			throw new IllegalArgumentException("Nome Inválido!");
		}
	}

	public static void validaAuditor(String auditor) {
		if (auditor == null) {
			throw new NullPointerException();
		} else if (auditor.trim().equals("")) {
			throw new IllegalArgumentException("Nome Inválido!");
		}
	}

}
