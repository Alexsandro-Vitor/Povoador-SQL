package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;

/**
 * Classe que gera entradas aleat�rias de um conjunto qualquer.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorEspecial extends GeradorAbstrato {
	private String comando;
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se for um texto entre chaves, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return (entrada.startsWith("{") && entrada.endsWith("}"));
	}
	
	/**
	 * Construtor de GeradorEspecial, recebe um comando que cont�m os poss�veis valores a serem retornados.
	 * @param comando Cont�m os valores que ser�o sorteados
	 */
	public GeradorEspecial(String comando) {
		this.comando = comando.substring(1, comando.length() - 1);
	}
	
	/**
	 * Gera uma sa�da do conjunto dado no comando.
	 * @return Uma sa�da aleat�riamente escolhida do conjunto
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
