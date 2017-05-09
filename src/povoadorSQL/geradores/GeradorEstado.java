package povoadorSQL.geradores;

/**
 * Classe que gera entradas de estados brasileiros.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorEstado extends GeradorAbstrato {
	private static String[] estados = {
		"Acre", "Alagoas", "Amap�", "Amazonas", "Bahia", "Cear�", "Distrito Federal", "Esp�rito Santo", "Goi�s", "Maranh�o", "Mato Grosso",
		"Mato Grosso do Sul", "Minas Gerais", "Par�", "Para�ba", "Paran�", "Pernambuco", "Piau�", "Rio de Janeiro", "Rio Grande do Norte",
		"Rio Grande do Sul", "Rond�nia", "Roraima", "Santa Catarina", "S�o Paulo", "Sergipe", "Tocantins"
	}; 
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "ESTADO";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Retorna um estado dentro de aspas simples.
	 * @return Um estado selecionado aleatoriamente
	 */
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(estados));
	}
}

