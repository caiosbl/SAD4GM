package ordenacao;

public abstract class Smarter {

	public static double smarter(double posicaoRank, double numeroAtributos) {
		double weight = 0;

		while (posicaoRank <= numeroAtributos)
			weight += (1 / posicaoRank++);

		return (1 / numeroAtributos) * weight;
	}

}
