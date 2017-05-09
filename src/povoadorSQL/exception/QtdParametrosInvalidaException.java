package povoadorSQL.exception;

/**
 * Exceção lançada caso a quantidade de parametros de um comando esteja errada.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class QtdParametrosInvalidaException extends Exception {
	/**
	 * Lança exceção informando o número correto de parâmetros no comando.
	 * @param comando O comando com o número de parâmetros incorreto
	 * @param parametros O número de parâmetros correto
	 */
	public QtdParametrosInvalidaException(String comando, int parametros) {
		super("A quantidade de parametros em " + comando + " deve ser exatamente " + parametros);
	}
}
