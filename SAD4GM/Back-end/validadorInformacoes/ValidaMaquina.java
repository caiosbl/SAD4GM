package validadorInformacoes;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class ValidaMaquina {
	
	public static void validaNome(String nome) {
		if (nome == null) {
			throw new NullPointerException("NOME NULO INVÁLIDO!");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}

	}
	
	public static void validaCodigo(int codigo) {
		if(codigo <= 0) {
			throw new IllegalArgumentException("CÓDIGO INVÁLIDO!");
		} 
	}
	
	public static void validaDescricao(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("DESCRIÇÃO NULA INVÁLIDO!");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO INVÁLIDA!");
		}

	}

}
