package exception;

import javax.swing.JLabel;

public class NumeroInvalidoException extends Exception {
	public NumeroInvalidoException(String numero, String texto) {
		super("O texto \"" + numero + "\" em \""+ texto +"\" deveria ser um n�mero inteiro");
	}
	//Trata erros no numero de sa�das
	public NumeroInvalidoException(String numero, JLabel campo) {
		super("O texto \"" + numero + "\" no campo "+ campo.getText() +" deveria ser um n�mero inteiro");
	}
}
