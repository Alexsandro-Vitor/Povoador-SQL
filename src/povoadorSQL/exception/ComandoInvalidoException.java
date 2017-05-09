package povoadorSQL.exception;

/**
 * Exceção lançada caso o comando esteja mal formatado ou não exista.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class ComandoInvalidoException extends Exception {
	/**
	 * Lança exceção informando que o comando não foi reconhecido.
	 * @param comando O comando que não foi reconhecido
	 */
	public ComandoInvalidoException(String comando) {
		super("O comando " + comando + " não foi reconhecido");
	}
}
