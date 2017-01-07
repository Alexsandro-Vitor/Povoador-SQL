package exception;

public class ParametroInvalidoException extends Exception {
	public ParametroInvalidoException(String parametro, String comando, String valorMinimo) {
		super("O valor do parametro " + parametro + " em " + comando + " deve ser maior que " + valorMinimo);
	}
}
