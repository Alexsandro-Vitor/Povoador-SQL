package povoadorSQL.exception;

public class DataInvalidaException extends Exception {
	public DataInvalidaException(String data) {
		super("A data " + data + " está em um formato incorreto");
	}
}
