package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.ParametroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;

/**
 * Classe que gera entradas de n�meros inteiros.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorInt extends GeradorAbstrato {
	private String comando;
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "INT";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Construtor de GeradorInt, recebe um comando que define o invervalo dentro do qual o n�mero ser� gerado.
	 * @param comando Cont�m o menor e o maior n�meros que podem ser gerados
	 */
	public GeradorInt(String comando) {
		this.comando = comando;
	}
	
	/**
	 * Gera um n�mero inteiro.
	 * @return Um n�mero inteiro dentro do intervalo [menorNumero, maiorNumero]
	 * @throws ComandoInvalidoException Caso o comando tenha parenteses faltando
	 * @throws NumeroInvalidoException Caso um dos par�metros n�o seja inteiro
	 * @throws ParametroInvalidoException Caso o 1� par�mtero seja maior que o 2�
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de par�metros diferente de 2
	 */
	public String gerar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
		int[] valores = validar();
		return "" + MetodosGerador.intAleatorio(valores[0], valores[1]+1);
	}
	
	private int[] validar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
		return validarValores(MetodosGerador.validarSintaxe(comando, NOME_COMANDO.length(), 2));
	}
	
	private int[] validarValores(String[] valores) throws NumeroInvalidoException, ParametroInvalidoException {
		int[] saida = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			try {
				saida[i] = Integer.parseInt(valores[i]);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(valores[i], comando);
			}
		}
		if (saida[0] >= saida[1]) throw new ParametroInvalidoException(saida[1], comando, saida[0]);
		return saida;
	}
}
