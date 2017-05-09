package povoadorSQL.geradores;

/**
 * Classe que gera n�meros de celular com formata��o.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorCelularFormatado extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CELULAR_FORMATADO";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * @return Um n�mero de celular dentro de aspas simples
	 */
	public String gerar() {
		return MetodosGerador.varchar(gerarCelular());
	}
	
	/**
	 * Gera um n�mero de celular, na forma 9XXXX-XXXX.
	 * @return Um n�mero de celular
	 */
	protected String gerarCelular() {
		return "9" + MetodosGerador.gerarSequenciaAlgarismos(4) + "-" + MetodosGerador.gerarSequenciaAlgarismos(4);
	}
}
