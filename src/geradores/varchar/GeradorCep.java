package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorCep extends GeradorAbstrato {
	public GeradorCep() {}
	
	public String gerar() {
		return gerarSequenciaDigitos(5)+"-"+gerarSequenciaDigitos(3);
	}
}
