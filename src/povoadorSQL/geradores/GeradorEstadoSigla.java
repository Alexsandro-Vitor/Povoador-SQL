package povoadorSQL.geradores;

/**
 * Classe que gera siglas de estados brasileiros.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorEstadoSigla extends GeradorAbstrato {
	private static String[] estados = {
		"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "RR",
		"SC", "SE", "SP", "TO"
	}; 
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "ESTADO_SIGLA";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Retorna uma sigla dentro de aspas simples.
	 * @return Uma sigla de um estado brasileiro selecionada aleatoriamente
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(estados));
	}
}

