package povoadorSQL.exception;

public class ChavesDemaisException extends Exception {
	public ChavesDemaisException() {
		super("S� pode haver uma chave na tabela");
	}
}
