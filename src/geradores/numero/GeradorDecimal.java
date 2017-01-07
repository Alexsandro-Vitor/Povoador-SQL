package geradores.numero;

import exception.ComandoInvalidoException;
import exception.NumeroInvalidoException;
import exception.ParametroInvalidoException;
import geradores.GeradorAbstrato;

public class GeradorDecimal extends GeradorAbstrato {
	private String comando;
	private static final int tamTipo = 7;
	
	public GeradorDecimal(String comando) {
		this.comando = comando;
	}
	
	public String gerar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException {
		int[] valores = validar();
		return intAleatorio(0, (int)Math.pow(10, valores[0])) + "." + gerarSequenciaDigitos(valores[1]);
	}
	
	private int[] validar() throws ComandoInvalidoException, NumeroInvalidoException, ParametroInvalidoException {
		return validarValores(validarSintaxe());
	}
	
	private String[] validarSintaxe() throws ComandoInvalidoException {
		if (comando.charAt(tamTipo) != '(') throw new ComandoInvalidoException(comando);
		if (!comando.endsWith(")")) throw new ComandoInvalidoException(comando);
		String[] valores = comando.substring(tamTipo + 1, comando.length() - 1).split(",");
		if (valores.length != 2) throw new ComandoInvalidoException(comando);
		return valores;
	}
	
	private int[] validarValores(String[] valores) throws ParametroInvalidoException, NumeroInvalidoException {
		int[] saida = new int[valores.length];
		for (int i = 0; i < valores.length; i++) {
			try {
				saida[i] = Integer.parseInt(valores[i]);
				if (saida[i] <= 0) throw new ParametroInvalidoException(saida[i] + "", "DECIMAL("+valores[0]+", "+valores[1]+")", "0");
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(valores[i], comando);
			}
		}
		return saida;	//Retorna os numeros para não ter que extraí-los novamente
	}
}
