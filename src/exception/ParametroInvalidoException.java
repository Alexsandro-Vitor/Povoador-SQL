package exception;

public class ParametroInvalidoException extends Exception {
	public ParametroInvalidoException(int parametro, String comando, int valorMinimo) {
		super("O valor em " + parametro + " em " + comando + " deve ser maior que " + valorMinimo);
	}
}
