package exception;

public class TipoInvalidoException extends Exception {
	public TipoInvalidoException(String tipo) {
		super("O tipo " + tipo + " não foi reconhecido");
	}
}
