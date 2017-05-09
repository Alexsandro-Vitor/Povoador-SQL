package povoadorSQL.exception;

public class ChavesDemaisException extends Exception {
	public ChavesDemaisException() {
		super("Só pode haver uma chave na tabela");
	}
}
