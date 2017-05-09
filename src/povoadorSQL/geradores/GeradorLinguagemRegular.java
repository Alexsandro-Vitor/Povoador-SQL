package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;

/**
 * Classe que gera entradas de uma linguagem regular.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorLinguagemRegular extends GeradorAbstrato {
	private String comando;
	
	/**
	 * Checa se a entrada recebida é valida para esta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return (entrada.startsWith("\"") && entrada.endsWith("\""));
	}

	/**
	 * Construtor de GeradorLinguagemRegular. Recebe uma string de entrada a partir da qual a entrada aleatória será produzida.
	 * Alguns caracteres especiais geram letras específicas:
	 * \@: Será convertida em uma letra minúscula.
	 * #: Será convertido em um algarismo.
	 * +: Faz com que um caractere antes dele possa aparecer ou não. Repetindo esse caractere N vezes fará com que os N caracteres antes dele possam aparecer ou não.
	 * \\: Usando antes de um dos caracteres acima, ele aparece na saída.
	 * @param entrada Uma linguagem regular entre aspas que gerará uma entrada para o povoadorSQL.povoamento
	 */
	public GeradorLinguagemRegular(String entrada) {
		this.comando = entrada.substring(1, entrada.length() - 1);
	}

	/**
	 * Gera uma entrada que é aceita pela linguagem regular dada.
	 * @throws ComandoInvalidoException Caso a linguagem regular esteja mal formada
	 * @return Uma entrada que é aceita pela linguagem dada ao gerar o gerador
	 */
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
