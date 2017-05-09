package povoadorSQL.exception;

/**
 * Exceção lançada caso sejam geradas duas chaves na mesma entrada.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class ChavesDemaisException extends Exception {
	/**
	 * Lança exceção informando que só pode haver uma chave na tabela.
	 */
	public ChavesDemaisException() {
		super("Só pode haver uma chave na tabela");
	}
}
