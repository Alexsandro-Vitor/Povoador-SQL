package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;
import povoadorSQL.povoamento.Povoamento;

/**
 * Classe com metodos utilizados pelos povoadorSQL.geradores.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class MetodosGerador {

	/**
	 * Metodo que checa se uma entrada corresponde a um comando.
	 * @param entrada A entrada que será checada
	 * @param comando O nome do comando que será checado
	 * @return true se entrada e comando forem correspondentes, false se não
	 */
	public static boolean checarComando(String entrada, String comando) {
		if (entrada.equalsIgnoreCase(comando)) return true;
		else if (entrada.length() > comando.length()) return (entrada.substring(0, comando.length()+1).equalsIgnoreCase(comando + "("));
		return false;
	}
	
	/**
	 * Formata uma String gerada por algum gerador como um valor VARCHAR.
	 * @param saida A saída do gerador
	 * @return O texto de saida entre aspas simples
	 */
	protected static String varchar(String saida) {
		return "'" + saida + "'";
	}

	/**
	 * Gera uma sequencia de algarismos decimais.
	 * @param algarismos Número de algarismos a ser gerado
	 * @return Uma String com o número dado de algarismos decimais
	 */
	protected static String gerarSequenciaAlgarismos(int algarismos) {
		String sequencia = "";
		for (int i = 0; i < algarismos; i++) {
			char digito = (char)('0' + Povoamento.random.nextInt(10));
			sequencia = sequencia + digito;
		}
		return sequencia;
	}

	/**
	 * Seleciona um item aleatório de um array dado.
	 * @param array O array de onde o item será selecionado
	 * @return Um item aleatório
	 */
	protected static String escolhaAleatoria(String[] array) {
		return array[Povoamento.random.nextInt(array.length)];
	}

	/**
	 * Gera um número inteiro contido no intervalo [minimo, maximo[.
	 * @param minimo Valor mínimo que pode ser gerado
	 * @param maximo Limite máximo do valor que pode ser gerado
	 * @return Um número inteiro contido no intervalo [minimo, maximo[
	 */
	public static int intAleatorio(int minimo, int maximo) {
		return (minimo + Povoamento.random.nextInt(maximo - minimo));
	}

	/**
	 * Recebe um comando e checa se os parênteses estão no lugar certo e se o número de parametros está certo.
	 * @param comando O comando cuja sintaxe será checada
	 * @param tamTipo O tamanho do nome do comando
	 * @param numParametros O número de parametros que se espera que o comando tenha
	 * @return Um array com todos os parametros do comando
	 * @throws ComandoInvalidoException Se o comando tiver parênteses faltando
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de parâmetros diferente de numParametros
	 */
	protected static String[] validarSintaxe(String comando, int tamTipo, int numParametros) throws ComandoInvalidoException, QtdParametrosInvalidaException {
		if (comando.charAt(tamTipo) != '(') throw new ComandoInvalidoException(comando);
		if (!comando.endsWith(")")) throw new ComandoInvalidoException(comando);
		String[] valores = comando.substring(tamTipo + 1, comando.length() - 1).split(",");
		if (valores.length != numParametros) throw new QtdParametrosInvalidaException(comando, numParametros);
		return valores;
	}
}
