package geradores.numero;

import exception.ComandoInvalidoException;
import geradores.GeradorAbstrato;

public class GeradorInt extends GeradorAbstrato {
	private String comando;
	
	public GeradorInt(String comando) {
		this.comando = comando;
	}
	
	public String gerar() throws ComandoInvalidoException {
		if (!comando.endsWith(")")) throw new ComandoInvalidoException(comando);
		if ((comando.indexOf(',') == -1) || (comando.indexOf(',') != comando.lastIndexOf(','))) throw new ComandoInvalidoException(comando);
		String[] valores = comando.substring(4, comando.length() - 1).split(",", 2);
		int min = Integer.parseInt(valores[0]), max = Integer.parseInt(valores[1]);
		return "" + intAleatorio(min, max+1);
	}
}
