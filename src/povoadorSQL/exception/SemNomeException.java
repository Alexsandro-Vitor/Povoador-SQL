package povoadorSQL.exception;

/**
 * Exceção lançada caso a tabela esteja sem nome.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class SemNomeException extends Exception {
	/**
	 * Lança exceção informando que a tabela precisa de nome.
	 */
	public SemNomeException() {
		super("O nome da tabela precisa ser preenchido");
	}
}