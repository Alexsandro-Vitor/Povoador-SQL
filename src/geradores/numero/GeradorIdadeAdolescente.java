package geradores.numero;

import geradores.GeradorAbstrato;

public class GeradorIdadeAdolescente extends GeradorAbstrato {
	public GeradorIdadeAdolescente() {}
	
	public String gerar() {
		return "" + intAleatorio(13, 18);
	}
}
