package povoadorSQL.geradores;

/**
 * Classe que gera entradas de idades de adolescentes.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorIdadeAdolescente extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "IDADE_ADOLESCENTE";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera uma idade de adolescente
	 * @return Um n�mero no intervalo [13, 17]
	 */
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(13, 18);
	}
}
