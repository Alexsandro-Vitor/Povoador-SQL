package povoadorSQL.geradores;

/**
 * Classe que gera placas de carros.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorPlaca extends GeradorAbstrato {
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "PLACA";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Gera uma placa de carro entre aspas simples.
	 * @return Uma numera��o de placa de carro brasileira
	 */
	public String gerar() {
		return MetodosGerador.varchar(gerarLetras(3) + "-" + MetodosGerador.gerarSequenciaAlgarismos(4));
	}
	
	private String gerarLetras(int letras) {
		String saida = "";
		for (int i = 0; i < letras; i++) {
			saida += (char)MetodosGerador.intAleatorio('A', 'Z' + 1);
		}
		return saida;
	}
}
