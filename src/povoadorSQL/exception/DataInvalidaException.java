package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso uma data esteja mal formatada ou n�o exista.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class DataInvalidaException extends Exception {
	/**
	 * Lan�a exce��o informando que a data est� com formato incorreto.
	 * @param data A data que est� incorreta
	 */
	public DataInvalidaException(String data) {
		super("A data " + data + " est� em um formato incorreto");
	}
}
