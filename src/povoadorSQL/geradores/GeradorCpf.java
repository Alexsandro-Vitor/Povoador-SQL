package povoadorSQL.geradores;

/**
 * Classe que gera n�meros de CPF, sem formata��o.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorCpf extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CPF";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um n�mero de CPF entre aspas simples, sem formata��o.
	 * @return Um n�mero de CPF
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaAlgarismos(11));
	}
}
