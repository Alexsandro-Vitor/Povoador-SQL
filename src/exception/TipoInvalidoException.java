package exception;

public class TipoInvalidoException extends Exception {
	public TipoInvalidoException(String tipo) {
		super("O tipo " + tipo + " n�o foi reconhecido");
	}
}
