package povoadorSQL.exception;

import javax.swing.JLabel;

/**
 * Exce��o lan�ada caso uma entrada que deveria ser inteira n�o seja.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class NumeroInvalidoException extends Exception {
	/**
	 * Lan�a exce��o informando que o texto deveria ser inteiro.
	 * @param numero O texto que est� incorreto
	 * @param texto O comando onde est� o n�mero
	 */
	public NumeroInvalidoException(String numero, String texto) {
		super("O texto \"" + numero + "\" em \""+ texto +"\" deveria ser um n�mero INTEIRO");
	}
	/**
	 * Lan�a exce��o informando que o n�mero de sa�das deveria ser inteiro.
	 * @param numero O n�mero de sa�das que est� incorreto
	 * @param campo O campo que n�o foi preenchido com um n�mero
	 */
	//Trata erros no numero de sa�das
	public NumeroInvalidoException(String numero, JLabel campo) {
		super("O texto \"" + numero + "\" no campo "+ campo.getText() +" deveria ser um n�mero INTEIRO");
	}
}
