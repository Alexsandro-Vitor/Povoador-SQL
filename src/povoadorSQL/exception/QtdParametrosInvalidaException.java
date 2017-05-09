package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso a quantidade de parametros de um comando esteja errada.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class QtdParametrosInvalidaException extends Exception {
	/**
	 * Lan�a exce��o informando o n�mero correto de par�metros no comando.
	 * @param comando O comando com o n�mero de par�metros incorreto
	 * @param parametros O n�mero de par�metros correto
	 */
	public QtdParametrosInvalidaException(String comando, int parametros) {
		super("A quantidade de parametros em " + comando + " deve ser exatamente " + parametros);
	}
}
