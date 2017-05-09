package povoadorSQL.geradores;

/**
 * Classe que gera números de celular com DDD, com formatação.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorCelularDddFormatado extends GeradorCelularFormatado {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CELULAR_DDD_FORMATADO";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um número de celular formatado e com DDD, dentro de aspas simples.
	 * @return Uma String contendo um número de celular na forma '(XX)9XXXX-XXXX'
	 */
	public String gerar() {
		return MetodosGerador.varchar("(" + MetodosGerador.gerarSequenciaAlgarismos(2) + ")" + gerarCelular());
	}
}
