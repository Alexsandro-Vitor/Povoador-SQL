package povoadorSQL.exception;

public class ComandoInvalidoException extends Exception {
	public ComandoInvalidoException(String comando) {
		super("O comando " + comando + " n�o foi reconhecido");
	}
}
