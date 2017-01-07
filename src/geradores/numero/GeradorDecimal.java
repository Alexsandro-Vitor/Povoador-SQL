package geradores.numero;

import exception.ComandoInvalidoException;
import geradores.GeradorAbstrato;

public class GeradorDecimal extends GeradorAbstrato {
	private String comando;
	private static final int tamTipo = 7;
	
	public GeradorDecimal(String comando) {
		this.comando = comando;
	}
	
	public String gerar() throws ComandoInvalidoException {
		validar();
		String[] valores = comando.substring(8, comando.length() - 1).split(",");
		int antesPonto = Integer.parseInt(valores[0]), aposPonto = Integer.parseInt(valores[1]);
		return intAleatorio(0, (int)Math.pow(10, antesPonto)) + "." + gerarSequenciaDigitos(aposPonto);
	}
	
	private void validar() throws ComandoInvalidoException {
		if (comando.charAt(tamTipo) != '(') throw new ComandoInvalidoException(comando);
		if (!comando.endsWith(")")) throw new ComandoInvalidoException(comando);
		if (comando.substring(tamTipo + 1, comando.length() - 1).split(",").length != 2) throw new ComandoInvalidoException(comando);
		//Falta checar se os parametros são nºs inteiros
	}
}
