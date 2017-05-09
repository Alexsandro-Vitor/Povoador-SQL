package povoadorSQL.geradores;

/**
 * Classe que gera números de celular com DDD, sem formatação.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorCelularDdd extends GeradorCelular {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CELULAR_DDD";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um número de celular com DDD, dentro de aspas simples.
	 * @return Uma String contendo um número de celular na forma 'XX9XXXXXXXX'
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaAlgarismos(2) + gerarCelular());
	}
}
