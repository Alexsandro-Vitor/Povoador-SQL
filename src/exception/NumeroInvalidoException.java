package exception;

import javax.swing.JLabel;

public class NumeroInvalidoException extends Exception {
	public NumeroInvalidoException(String numero, String texto) {
		super("O texto \"" + numero + "\" em \""+ texto +"\" deveria ser um número inteiro");
	}
	//Trata erros no numero de saídas
	public NumeroInvalidoException(String numero, JLabel campo) {
		super("O texto \"" + numero + "\" no campo "+ campo.getText() +" deveria ser um número inteiro");
	}
}
