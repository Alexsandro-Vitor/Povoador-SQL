package povoadorSQL.geradores;

/**
 * Classe que gera números de CEP.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorCep extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CEP";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um número de CEP entre aspas simples, na forma XXXXX-XXX.
	 * @return Um número de CEP
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaAlgarismos(5)+"-"+MetodosGerador.gerarSequenciaAlgarismos(3));
	}
}
