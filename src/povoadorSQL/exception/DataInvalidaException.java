package povoadorSQL.exception;

/**
 * Exceção lançada caso uma data esteja mal formatada ou não exista.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class DataInvalidaException extends Exception {
	/**
	 * Lança exceção informando que a data está com formato incorreto.
	 * @param data A data que está incorreta
	 */
	public DataInvalidaException(String data) {
		super("A data " + data + " está em um formato incorreto");
	}
}
