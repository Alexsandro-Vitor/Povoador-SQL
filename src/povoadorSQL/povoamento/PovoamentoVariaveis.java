package povoadorSQL.povoamento;

import povoadorSQL.geradores.MetodosGerador;

/**
 * Classe que contém as variaveis de um povoamento.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class PovoamentoVariaveis {
	/**
	 * O sexo da pessoa cujos dados estão sendo gerados.
	 */
	public byte sexo = 0;
	
	/**
	 * Valor do parametro sexo quando está representando um homem.
	 */
	public static final byte MASCULINO = 1;
	
	/**
	 * Valor do parametro sexo quando está representando uma mulher.
	 */
	public static final byte FEMININO = 2;
	
	/**
	 * Se já foi gerada uma chave no povoamento.
	 */
	public boolean existeChave = false;
	
	/**
	 * O nome da pessoa cujos dados estão sendo gerados.
	 */
	public String nome = null;
	
	/**
	 * O email da pessoa cujos dados estão sendo gerados.
	 */
	public String email = null;
	
	/**
	 * A chave que será gerada agora, se o povoador estiver gerando chaves.
	 */
	public String chave;
	
	/**
	 * Construtor de PovoamentoVariaveis.
	 * @param chave A chave que será gerada agora
	 */
	public PovoamentoVariaveis(String chave) {
		this.chave = chave;
	}
	
	/**
	 * Define o sexo de uma pessoa, se isso ainda não aconteceu.
	 */
	public void definirSexo() {
		if (sexo == 0) sexo = (byte)MetodosGerador.intAleatorio(1, 3);
	}
}
