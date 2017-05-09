package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso a quantidade de sa�das seja menor ou igual a 0.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class QtdSaidasInvalidaException extends Exception {
	/**
	 * Lan�a exce��o informando que a quantidade de sa�das deve ser maior que 0.
	 */
	public QtdSaidasInvalidaException() {
		super("A quantidade de sa�das deve ser maior que 0");
	}
}
