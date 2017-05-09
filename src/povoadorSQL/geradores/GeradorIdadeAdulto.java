package povoadorSQL.geradores;

/**
 * Classe que gera entradas de idades de adultos.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorIdadeAdulto extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "IDADE_ADULTO";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera uma idade de adulto n�o idoso.
	 * @return Um n�mero no intervalo [18, 64]
	 */
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(18, 65);
	}
}
