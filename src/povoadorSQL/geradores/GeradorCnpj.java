package povoadorSQL.geradores;

/**
 * Classe que gera n�meros de CNPJ.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorCnpj extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CNPJ";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um n�mero de CNPJ, na forma XX.XXX.XXX/XXXX-XX.
	 * @return Um n�mero de CNPJ
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaAlgarismos(2) + '.' + MetodosGerador.gerarSequenciaAlgarismos(3) + '.' +
			MetodosGerador.gerarSequenciaAlgarismos(3) + '/' + MetodosGerador.gerarSequenciaAlgarismos(4) + '-' + MetodosGerador.gerarSequenciaAlgarismos(2));
	}
}
