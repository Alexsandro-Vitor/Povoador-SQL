package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso o comando esteja mal formatado ou n�o exista.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class ComandoInvalidoException extends Exception {
	/**
	 * Lan�a exce��o informando que o comando n�o foi reconhecido.
	 * @param comando O comando que n�o foi reconhecido
	 */
	public ComandoInvalidoException(String comando) {
		super("O comando " + comando + " n�o foi reconhecido");
	}
}
