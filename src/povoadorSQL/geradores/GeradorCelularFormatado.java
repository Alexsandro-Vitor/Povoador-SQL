package povoadorSQL.geradores;

/**
 * Classe que gera números de celular com formatação.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorCelularFormatado extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CELULAR_FORMATADO";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * @return Um número de celular dentro de aspas simples
	 */
	public String gerar() {
		return MetodosGerador.varchar(gerarCelular());
	}
	
	/**
	 * Gera um número de celular, na forma 9XXXX-XXXX.
	 * @return Um número de celular
	 */
	protected String gerarCelular() {
		return "9" + MetodosGerador.gerarSequenciaAlgarismos(4) + "-" + MetodosGerador.gerarSequenciaAlgarismos(4);
	}
}
