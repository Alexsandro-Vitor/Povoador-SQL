package geradores;

import exception.ComandoInvalidoException;
import exception.NumeroInvalidoException;
import exception.QtdParametrosInvalidaException;

public class GeradorReferencia extends GeradorAbstrato {
	private String comando;
	
	public static final String nomeComando = "REF";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}

	public GeradorReferencia(String comando) {
		this.comando = comando;
	}

	public String gerar() throws ComandoInvalidoException, QtdParametrosInvalidaException, NumeroInvalidoException {
		String[] valores = validar();
		int[] limites = {Integer.parseInt(valores[2]), Integer.parseInt(valores[3])};
		return "(SELECT REF(T) FROM "+valores[0]+" T WHERE "+valores[1]+" = "+MetodosGerador.intAleatorio(limites[0], limites[1]) + ")";
	}
	
	private String[] validar() throws ComandoInvalidoException, QtdParametrosInvalidaException, NumeroInvalidoException {
		return validarValores(MetodosGerador.validarSintaxe(comando, nomeComando.length(), 4));
	}

	private String[] validarValores(String[] valores) throws ComandoInvalidoException, QtdParametrosInvalidaException, NumeroInvalidoException {
		for (int i = 2; i < valores.length; i++) {
			try {
				Integer.parseInt(valores[i]);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(valores[i], comando);
			}
		}
		return valores;
	}
}
