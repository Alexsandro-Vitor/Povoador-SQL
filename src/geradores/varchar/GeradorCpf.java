package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorCpf extends GeradorAbstrato {
	public GeradorCpf() {}
	
	public String gerar() {
		return gerarSequenciaDigitos(9);
	}
}
