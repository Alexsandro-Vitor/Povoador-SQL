package geradores.numero;

import geradores.GeradorAbstrato;

public class GeradorIdadeAdulto extends GeradorAbstrato {
	public GeradorIdadeAdulto() {}
	
	public String gerar() {
		return "" + intAleatorio(18, 65);
	}
}
