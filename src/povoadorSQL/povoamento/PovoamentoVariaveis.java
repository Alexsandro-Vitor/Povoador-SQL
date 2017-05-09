package povoadorSQL.povoamento;

import povoadorSQL.geradores.MetodosGerador;

/**
 * Classe que cont�m as variaveis de um povoamento.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class PovoamentoVariaveis {
	/**
	 * O sexo da pessoa cujos dados est�o sendo gerados.
	 */
	public byte sexo = 0;
	
	/**
	 * Valor do parametro sexo quando est� representando um homem.
	 */
	public static final byte MASCULINO = 1;
	
	/**
	 * Valor do parametro sexo quando est� representando uma mulher.
	 */
	public static final byte FEMININO = 2;
	
	/**
	 * Se j� foi gerada uma chave no povoamento.
	 */
	public boolean existeChave = false;
	
	/**
	 * O nome da pessoa cujos dados est�o sendo gerados.
	 */
	public String nome = null;
	
	/**
	 * O email da pessoa cujos dados est�o sendo gerados.
	 */
	public String email = null;
	
	/**
	 * A chave que ser� gerada agora, se o povoador estiver gerando chaves.
	 */
	public String chave;
	
	/**
	 * Construtor de PovoamentoVariaveis.
	 * @param chave A chave que ser� gerada agora
	 */
	public PovoamentoVariaveis(String chave) {
		this.chave = chave;
	}
	
	/**
	 * Define o sexo de uma pessoa, se isso ainda n�o aconteceu.
	 */
	public void definirSexo() {
		if (sexo == 0) sexo = (byte)MetodosGerador.intAleatorio(1, 3);
	}
}
