package povoadorSQL.exception;

/**
 * Exce��o lan�ada caso uma entrada tenha valor inv�lido para o gerador.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class ParametroInvalidoException extends Exception {
	/**
	 * Lan�a exce��o informando o valor m�nimo para o par�metro que est� incorreto.
	 * @param parametro O parametro do comando que foi preenchido incorretamente
	 * @param comando O comando onde est� o erro
	 * @param valorMinimo O menor valor poss�vel que o parametro pode ter
	 */
	public ParametroInvalidoException(int parametro, String comando, int valorMinimo) {
		super("O valor em " + parametro + " em " + comando + " deve ser maior que " + valorMinimo);
	}
}
