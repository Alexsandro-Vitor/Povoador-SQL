package povoadorSQL.geradores;

import povoadorSQL.povoamento.Povoamento;
import povoadorSQL.povoamento.PovoamentoVariaveis;

/**
 * Classe que gera endereços de email.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorEmail extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	
	private static final String[] EMAILS = {
		"@cin.ufpe.br", "@gmail.com", "@hotmail.com"
	};
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "EMAIL";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Construtor de GeradorEmail.
	 * @param variaveis As variaveis do povoamento, onde está o nome que será usado para gerar o email e onde o email será guardado após ser criado
	 * @see GeradorNome
	 * @see PovoamentoVariaveis
	 */
	public GeradorEmail(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	/**
	 * Gera um email entre aspas simples e o inclui nas variaveis.
	 * @return Um email com as iniciais do nome contido nas variaveis do povoamento ou completamente aleatório, se não houver nenhum nome nelas
	 */
	public String gerar() {
		if (variaveis.email == null) variaveis.email = siglaLetrasDistintas();
		return MetodosGerador.varchar(variaveis.email + terminacaoAleatoria());
	}
	
	private String siglaLetrasDistintas() {
		int tamanho = 3 + Povoamento.random.nextInt(2);
		String saida = "";
		int[] letrasAleatorias = gerarNumerosDistintos(tamanho, 26);
		for (int i = 0; i < tamanho; i++) {
			saida = saida + (char)('a' + letrasAleatorias[i]);
		}
		return saida;
	}
	
	private static int[] gerarNumerosDistintos(int valores, int valorMaximo) {
		int[] numeros = new int[valores];
		boolean[] valorEscolhido = new boolean[valorMaximo];
		valorEscolhido['k' - 'a'] = true;	//Não há SOBRENOMES iniciando com k e w, então preciso disso
		valorEscolhido['w' - 'a'] = true;	// para garantir que o email nao tenha essas letras
		for (int i = 0; i < numeros.length; i++) {
			int proxNumero;
			proxNumero = Povoamento.random.nextInt(valorMaximo - i - 2);
			for (int j = 0; j <= proxNumero && j < valorMaximo; j++) {
				if (valorEscolhido[j]) proxNumero++;
			}
			numeros[i] = proxNumero;
			valorEscolhido[proxNumero] = true;
		}
		return numeros;
	}
	
	private String terminacaoAleatoria() {
		return MetodosGerador.escolhaAleatoria(EMAILS);
	}
}

