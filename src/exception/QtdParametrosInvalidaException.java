package exception;

public class QtdParametrosInvalidaException extends Exception {
	public QtdParametrosInvalidaException(String comando, int parametros) {
		super("A quantidade de parametros em "+comando+" deve ser exatamente "+parametros);
	}
}
