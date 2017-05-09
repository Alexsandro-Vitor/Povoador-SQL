package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso a tabela esteja sem nome.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class SemNomeException extends Exception {
	/**
	 * Lan�a exce��o informando que a tabela precisa de nome.
	 */
	public SemNomeException() {
		super("O nome da tabela precisa ser preenchido");
	}
}