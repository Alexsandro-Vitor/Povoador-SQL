package povoadorSQL.geradores;

/**
 * Classe que gera números de CNPJ.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorCnpj extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CNPJ";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um número de CNPJ, na forma XX.XXX.XXX/XXXX-XX.
	 * @return Um número de CNPJ
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaAlgarismos(2) + '.' + MetodosGerador.gerarSequenciaAlgarismos(3) + '.' +
			MetodosGerador.gerarSequenciaAlgarismos(3) + '/' + MetodosGerador.gerarSequenciaAlgarismos(4) + '-' + MetodosGerador.gerarSequenciaAlgarismos(2));
	}
}
