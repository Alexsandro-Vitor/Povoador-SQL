package geradores.numero;

import geradores.GeradorAbstrato;

public class GeradorIdadeCrianca extends GeradorAbstrato {
	public GeradorIdadeCrianca() {}
	
	public String gerar() {
		return "" + intAleatorio(0, 13);
	}
}
