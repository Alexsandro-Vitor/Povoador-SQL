package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso sejam geradas duas chaves na mesma entrada.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class ChavesDemaisException extends Exception {
	/**
	 * Lan�a exce��o informando que s� pode haver uma chave na tabela.
	 */
	public ChavesDemaisException() {
		super("S� pode haver uma chave na tabela");
	}
}
