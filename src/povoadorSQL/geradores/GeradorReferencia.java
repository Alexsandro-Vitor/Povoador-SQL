package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;

/**
 * Classe que gera referencias.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorReferencia extends GeradorAbstrato {
	private String comando;
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "REF";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}

	/**
	 * Construtor de GeradorReferencia.
	 * @param comando O comando que contém a tabela, o atributo-chave, e os limites para os valores do atributo
	 */
	public GeradorReferencia(String comando) {
		this.comando = comando;
	}

	/**
	 * Gera uma referencia a um objeto de outra tabela.
	 * @throws ComandoInvalidoException Se houverem parênteses faltando no comando
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de parâmetros diferente de 4
	 * @throws NumeroInvalidoException Se alguma entrada não for um número inteiro
	 * @return Um comando SELECT para procurar um objeto cujo parametro seja igual ao gerado
	 */
	public String gerar() throws ComandoInvalidoException, QtdParametrosInvalidaException, NumeroInvalidoException {
		String[] valores = validar();
		int[] limites = {Integer.parseInt(valores[2]), Integer.parseInt(valores[3])};
		return "(SELECT REF(T) FROM "+valores[0]+" T WHERE "+valores[1]+" = "+MetodosGerador.intAleatorio(limites[0], limites[1]) + ")";
	}
	
	private String[] validar() throws ComandoInvalidoException, QtdParametrosInvalidaException, NumeroInvalidoException {
		return validarValores(MetodosGerador.validarSintaxe(comando, NOME_COMANDO.length(), 4));
	}

	private String[] validarValores(String[] valores) throws NumeroInvalidoException {
		for (int i = 2; i < valores.length; i++) {
			try {
				Integer.parseInt(valores[i]);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(valores[i], comando);
			}
		}
		return valores;
	}
}
