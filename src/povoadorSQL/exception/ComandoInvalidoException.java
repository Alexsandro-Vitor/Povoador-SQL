package povoadorSQL.exception;

public class ComandoInvalidoException extends Exception {
	public ComandoInvalidoException(String comando) {
		super("O comando " + comando + " não foi reconhecido");
	}
}
