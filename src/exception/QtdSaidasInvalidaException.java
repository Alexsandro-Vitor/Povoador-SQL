package exception;

public class QtdSaidasInvalidaException extends Exception {
	public QtdSaidasInvalidaException() {
		super("A quantidade de sa�das deve ser maior que 0");
	}
}
