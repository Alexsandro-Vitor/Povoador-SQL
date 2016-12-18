package exception;

public class QtdSaidasInvalidaException extends Exception {
	public QtdSaidasInvalidaException() {
		super("A quantidade de saídas deve ser maior que 0");
	}
}
