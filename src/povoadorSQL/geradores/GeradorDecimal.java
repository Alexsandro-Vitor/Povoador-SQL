package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.ParametroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;

/**
 * Classe que gera entradas de n�meros decimais.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorDecimal extends GeradorAbstrato {
	private String comando;

	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "DECIMAL";
	
	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Construtor de GeradorDecimal, recebe um comando que define a quantidade de algarismos do n�mero gerado.
	 * @param comando Cont�m o n�mero m�ximo de algarismos antes da v�rgula e o n�mero de algarismos ap�s a v�rgula
	 */
	public GeradorDecimal(String comando) {
		this.comando = comando;
	}
	
	/**
	 * Gera um n�mero decimal.
	 * @return Uma string contendo um numero decimal
	 * @throws ComandoInvalidoException Se houverem par�nteses faltando no comando
	 * @throws NumeroInvalidoException Se alguma entrada n�o for um n�mero inteiro
	 * @throws ParametroInvalidoException Se alguma entrada for menor que 0
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de par�metros diferente de 2
	 */
	public String gerar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
		int[] valores = validar();
		return MetodosGerador.intAleatorio(0, (int)Math.pow(10, valores[0])) + "." + MetodosGerador.gerarSequenciaAlgarismos(valores[1]);
	}
	
	private int[] validar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
		return validarValores(MetodosGerador.validarSintaxe(comando, NOME_COMANDO.length(), 2));
	}
	
	private int[] validarValores(String[] valores) throws ParametroInvalidoException, NumeroInvalidoException {
		int[] saida = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			try {
				saida[i] = Integer.parseInt(valores[i]);
				if (saida[i] <= 0) throw new ParametroInvalidoException(saida[i], "DECIMAL("+valores[0]+", "+valores[1]+")", 0);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(valores[i], comando);
			}
		}
		return saida;	//Retorna os numeros para n�o ter que extra�-los novamente
	}
}
