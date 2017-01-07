package geradores.numero;

import exception.ComandoInvalidoException;
import exception.NumeroInvalidoException;
import exception.ParametroInvalidoException;
import exception.QtdParametrosInvalidaException;
import geradores.GeradorAbstrato;

public class GeradorInt extends GeradorAbstrato {
	private String comando;
	private static final int tamTipo = 3;
	
	public GeradorInt(String comando) {
		this.comando = comando;
	}
	
	public String gerar() throws NumeroInvalidoException, ParametroInvalidoException, ComandoInvalidoException, QtdParametrosInvalidaException {
		int[] valores = validar();
		return "" + intAleatorio(valores[0], valores[1]+1);
	}
	
	protected int[] validar() throws NumeroInvalidoException, ParametroInvalidoException, ComandoInvalidoException, QtdParametrosInvalidaException {
		return validarValores(validarSintaxe(comando, tamTipo, 2));
	}
	
	protected int[] validarValores(String[] valores) throws NumeroInvalidoException, ParametroInvalidoException {
		int[] saida = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			try {
				saida[i] = Integer.parseInt(valores[i]);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(valores[i], comando);
			}
		}
		if (saida[0] >= saida[1]) throw new ParametroInvalidoException(saida[1], comando, saida[0]);
		return saida;
	}
}
