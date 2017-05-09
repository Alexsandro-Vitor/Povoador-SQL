package povoadorSQL.geradores;

/**
 * Classe que gera n�meros de CPF, com formata��o.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorCpfFormatado extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CPF_FORMATADO";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera um n�mero de CPF entre aspas simples, na forma 'XXX.XXX.XXX-XX'.
	 * @return Um n�mero de CPF formatado
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaAlgarismos(3) + "." + MetodosGerador.gerarSequenciaAlgarismos(3) + "."
				+ MetodosGerador.gerarSequenciaAlgarismos(3) + "-" + MetodosGerador.gerarSequenciaAlgarismos(2));
	}
}
