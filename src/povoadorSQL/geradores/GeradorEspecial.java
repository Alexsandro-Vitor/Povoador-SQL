package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;

/**
 * Classe que gera entradas aleatórias de um conjunto qualquer.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorEspecial extends GeradorAbstrato {
	private String comando;
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se for um texto entre chaves, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return (entrada.startsWith("{") && entrada.endsWith("}"));
	}
	
	/**
	 * Construtor de GeradorEspecial, recebe um comando que contém os possíveis valores a serem retornados.
	 * @param comando Contém os valores que serão sorteados
	 */
	public GeradorEspecial(String comando) {
		this.comando = comando.substring(1, comando.length() - 1);
	}
	
	/**
	 * Gera uma saída do conjunto dado no comando.
	 * @return Uma saída aleatóriamente escolhida do conjunto
	 * @throws ComandoInvalidoException Se o comando possuir mais chaves dentro dele
	 */
	public String gerar() throws ComandoInvalidoException {
		validar();
		String[] saidas = comando.split(",");
		return MetodosGerador.escolhaAleatoria(saidas);
	}
	
	private void validar() throws ComandoInvalidoException {
		if (comando.contains("{") || comando.contains("}")) throw new ComandoInvalidoException("{" + comando + "}");
	}
}
