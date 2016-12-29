package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorCelular extends GeradorAbstrato {
	public GeradorCelular() {}
	
	public String gerar() {
		return "9" + gerarSequenciaDigitos(8);
	}
}
