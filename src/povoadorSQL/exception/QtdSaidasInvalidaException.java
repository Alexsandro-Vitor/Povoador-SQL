package povoadorSQL.exception;

/**
 * Exceção lançada caso a quantidade de saídas seja menor ou igual a 0.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class QtdSaidasInvalidaException extends Exception {
	/**
	 * Lança exceção informando que a quantidade de saídas deve ser maior que 0.
	 */
	public QtdSaidasInvalidaException() {
		super("A quantidade de saídas deve ser maior que 0");
	}
}
