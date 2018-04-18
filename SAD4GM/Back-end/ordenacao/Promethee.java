package ordenacao;

public class Promethee {

	// Critério Usual
	public double tipo1(double valor1, double valor2) {
		double diferenca = valor1 - valor2;
		int update = 0;

		if (diferenca > 0)
			update = 1;

		return update;
	}

	// Quase Critério
	public double tipo2(double valor1, double valor2, double valor3) {
		double diferenca = valor1 - valor2;
		int update = 0;

		if (diferenca > valor3)
			update = 1;

		return update;

	}

	//Limiar de Preferência
	public double tipo3(double valor1, double valor2, double valor3) {
		double diferenca = valor1 - valor2;
		double update;

		if (diferenca > valor3)
			update = 1;

		else if (diferenca <= 0)
			update = 0;

		// else if (diferenca <= valor3)
		else
			update = diferenca / valor3;

		return update;
	}

	//Pseudo Critério
	public double tipo4(double valor1, double valor2, double valor3, double valor4) {
		double diferenca = valor1 - valor2;
		double update = 0.5;

		if (diferenca > valor3)
			update = 1;
		else if (diferenca <= valor4)
			update = 0;

		return update;
	}

	//Área de Indiferença
	public double tipo5(double valor1, double valor2, double valor3, double valor4) {
		double diferenca = valor1 - valor2;
		double update = (diferenca - valor4) / (valor3 - valor4);

		if (diferenca > valor3)
			update = 1;
		else if (diferenca <= valor4)
			update = 0;

		return update;
	}

}
