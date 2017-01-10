package geradores;

import exception.ComandoInvalidoException;
import exception.QtdParametrosInvalidaException;
import povoamento.Povoamento;

public class MetodosGerador {

	public static boolean checarComando(String entrada, String comando) {
		if (entrada.equalsIgnoreCase(comando)) return true;
		else if (entrada.length() > comando.length()) return (entrada.substring(0, comando.length()+1).equalsIgnoreCase(comando + "("));
		return false;
	}
	
	protected static String varchar(String saida) {
		return "'" + saida + "'";
	}

	protected static String gerarSequenciaDigitos(int digitos) {
		String sequencia = "";
		for (int i = 0; i < digitos; i++) {
			char digito = (char)('0' + Povoamento.random.nextInt(10));
			sequencia = sequencia + digito;
		}
		return sequencia;
	}

	protected static String escolhaAleatoria(String[] array) {
		return array[Povoamento.random.nextInt(array.length)];
	}

	//Gera um valor inteiro aleatorio no intervalo [minimo, maximo[
	protected static int intAleatorio(int minimo, int maximo) {
		return (minimo + Povoamento.random.nextInt(maximo - minimo));
	}

	//Valida a sintaxe de um comando comando(param1,param2)
	protected static String[] validarSintaxe(String comando, int tamTipo, int numParametros) throws ComandoInvalidoException, QtdParametrosInvalidaException {
		if (comando.charAt(tamTipo) != '(') throw new ComandoInvalidoException(comando);
		if (!comando.endsWith(")")) throw new ComandoInvalidoException(comando);
		String[] valores = comando.substring(tamTipo + 1, comando.length() - 1).split(",");
		if (valores.length != numParametros) throw new QtdParametrosInvalidaException(comando, numParametros);
		return valores;
	}
}
