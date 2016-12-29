package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorCelularFormatado extends GeradorAbstrato {
	public GeradorCelularFormatado() {}
	
	public String gerar() {
		return "9"+gerarSequenciaDigitos(4)+"-"+gerarSequenciaDigitos(4);
	}
}
