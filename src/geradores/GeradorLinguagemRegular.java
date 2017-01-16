package geradores;

import exception.ComandoInvalidoException;

public class GeradorLinguagemRegular extends GeradorAbstrato {
	private String comando;
	
	public static boolean checarComando(String entrada) {
		return (entrada.startsWith("\"") && entrada.endsWith("\""));
	}

	public GeradorLinguagemRegular(String comando) {
		this.comando = comando.substring(1, comando.length() - 1);
	}

	public String gerar() throws ComandoInvalidoException {
		validar();
		String saida = "";
		for (int i = 0; i < comando.length(); i++) {
			if (comando.charAt(i) == '@') saida += (char)MetodosGerador.intAleatorio('a', 'z' + 1);
			else if (comando.charAt(i) == '#') saida += (char)MetodosGerador.intAleatorio('0', '9' + 1);
			else if (comando.charAt(i) == '+') saida = saida.substring(0, saida.length() - MetodosGerador.intAleatorio(0, 2));
			else if (comando.charAt(i) == '\\') {
				i++;
				saida += comando.charAt(i);
			} else saida += comando.charAt(i);
		}
		return saida;
	}
	
	private void validar() throws ComandoInvalidoException {
		if (comando.startsWith("+")) throw new ComandoInvalidoException(comando);
		else if (validarBarrasFim()) throw new ComandoInvalidoException(comando);
	}
	
	private boolean validarBarrasFim() {
		int i = comando.length() - 1;
		int contagem = 0;
		while (i-- > 0 && comando.charAt(i) == '\\') {
			contagem++;
		}
		return contagem % 2 != 0;
	}
}
