package povoadorSQL.geradores;

import povoadorSQL.povoamento.PovoamentoVariaveis;

/**
 * Classe que gera um sexo.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorSexo extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "SEXO";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Construtor de GeradorSexo.
	 * @param variaveis As variaveis do povoamento, onde o sexo gerado ser� guardado
	 * @see PovoamentoVariaveis
	 */
	public GeradorSexo(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	/**
	 * Gera um sexo.
	 * @return 'M' para sexo masculino, 'F' para feminino
	 */
	public String gerar() {
		variaveis.definirSexo();
		return (variaveis.sexo == PovoamentoVariaveis.MASCULINO) ? MetodosGerador.varchar("M") : MetodosGerador.varchar("F");
	}
}
