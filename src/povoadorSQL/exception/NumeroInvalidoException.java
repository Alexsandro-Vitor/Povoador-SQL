package povoadorSQL.exception;

import javax.swing.JLabel;

/**
 * Exceção lançada caso uma entrada que deveria ser inteira não seja.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class NumeroInvalidoException extends Exception {
	/**
	 * Lança exceção informando que o texto deveria ser inteiro.
	 * @param numero O texto que está incorreto
	 * @param texto O comando onde está o número
	 */
	public NumeroInvalidoException(String numero, String texto) {
		super("O texto \"" + numero + "\" em \""+ texto +"\" deveria ser um número INTEIRO");
	}
	/**
	 * Lança exceção informando que o número de saídas deveria ser inteiro.
	 * @param numero O número de saídas que está incorreto
	 * @param campo O campo que não foi preenchido com um número
	 */
	//Trata erros no numero de saídas
	public NumeroInvalidoException(String numero, JLabel campo) {
		super("O texto \"" + numero + "\" no campo "+ campo.getText() +" deveria ser um número INTEIRO");
	}
}
