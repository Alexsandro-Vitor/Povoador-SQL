package geradores;

public abstract class GeradorAbstrato {
	public GeradorAbstrato() {}
	
	public String gerar() throws Exception {
		return "";
	}
	
	protected static String gerarSequenciaDigitos(int digitos) {
		String sequencia = "";
		for (int i = 0; i < digitos; i++) {
			char digito = (char)('0' + Povoamento.random.nextInt(10));
			sequencia = sequencia + digito;
		}
		return sequencia;
	}
	
	protected String escolhaAleatoria(String[] array) {
		return array[Povoamento.random.nextInt(array.length)];
	}
	
	//Gera um valor inteiro aleatorio no intervalo [minimo, maximo[
	protected static int intAleatorio(int minimo, int maximo) {
		return (minimo + Povoamento.random.nextInt(maximo - minimo));
	}
}
