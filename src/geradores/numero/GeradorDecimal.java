package geradores.numero;

import exception.ComandoInvalidoException;
import exception.NumeroInvalidoException;
import exception.ParametroInvalidoException;
import exception.QtdParametrosInvalidaException;
import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorDecimal extends GeradorAbstrato {
	private String comando;

	public static final String nomeComando = "DECIMAL";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorDecimal(String comando) {
		this.comando = comando;
	}
	
	public String gerar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
		int[] valores = validar();
		return MetodosGerador.intAleatorio(0, (int)Math.pow(10, valores[0])) + "." + MetodosGerador.gerarSequenciaDigitos(valores[1]);
	}
	
	private int[] validar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
		return validarValores(MetodosGerador.validarSintaxe(comando, nomeComando.length(), 2));
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
		return saida;	//Retorna os numeros para não ter que extraí-los novamente
	}
}
