package povoadorSQL.geradores;

/**
 * Classe que gera entradas de estados brasileiros.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorEstado extends GeradorAbstrato {
	private static String[] estados = {
		"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso",
		"Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
		"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
	}; 
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "ESTADO";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
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

