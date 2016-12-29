package geradores.numero;

import exception.TipoInvalidoException;
import geradores.GeradorAbstrato;

public class GeradorInt extends GeradorAbstrato {
	private String comando;
	
	public GeradorInt(String comando) {
		this.comando = comando;
	}
	
	public String gerar() throws TipoInvalidoException {
		if (!comando.endsWith(")")) throw new TipoInvalidoException(comando);
		if ((comando.indexOf(',') == -1) || (comando.indexOf(',') != comando.lastIndexOf(','))) throw new TipoInvalidoException(comando);
		String[] valores = comando.substring(4, comando.length() - 1).split(",", 2);
		int min = Integer.parseInt(valores[0]), max = Integer.parseInt(valores[1]);
		return "" + intAleatorio(min, max+1);
	}
}
