package povoadorSQL.geradores;

/**
 * Classe que gera entradas de idades de crianças.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorIdadeCrianca extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "IDADE_CRIANCA";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera uma idade de criança.
	 * @return Um número no intervalo [0, 12]
	 */
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(0, 13);
	}
}