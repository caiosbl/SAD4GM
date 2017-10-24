package validadorInformacoes;

public class validaUsuario {

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

	public static void validaSupervisor(String supervisor) {
		if (supervisor == null) {
			throw new NullPointerException();
		} else if (supervisor.trim().equals("")) {
			throw new IllegalArgumentException("Nome Inválido!");
		}
	}

}
