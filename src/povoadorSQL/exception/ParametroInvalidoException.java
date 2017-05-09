package povoadorSQL.exception;

/**
 * Exceção lançada caso uma entrada tenha valor inválido para o gerador.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class ParametroInvalidoException extends Exception {
	/**
	 * Lança exceção informando o valor mínimo para o parâmetro que está incorreto.
	 * @param parametro O parametro do comando que foi preenchido incorretamente
	 * @param comando O comando onde está o erro
	 * @param valorMinimo O menor valor possível que o parametro pode ter
	 */
	public ParametroInvalidoException(int parametro, String comando, int valorMinimo) {
		super("O valor em " + parametro + " em " + comando + " deve ser maior que " + valorMinimo);
	}
}
