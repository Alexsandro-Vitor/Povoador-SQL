package povoadorSQL.geradores;

/**
 * Classe que gera entradas de idades de menores de idade (crian�as e adolescentes).
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorIdadeMenor extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "IDADE_MENOR";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera uma idade de um menor de idade (crian�as e adolescentes).
	 * @return Um n�mero no intervalo [0, 17]
	 */
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(0, 18);
	}
}
