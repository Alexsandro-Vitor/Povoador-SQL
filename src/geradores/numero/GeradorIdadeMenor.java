package geradores.numero;

import geradores.GeradorAbstrato;

public class GeradorIdadeMenor extends GeradorAbstrato {
	public GeradorIdadeMenor() {}
	
	public String gerar() {
		return "" + intAleatorio(0, 18);
	}
}
