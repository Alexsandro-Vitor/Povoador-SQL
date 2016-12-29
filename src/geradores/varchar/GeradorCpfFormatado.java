package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorCpfFormatado extends GeradorAbstrato {
	public GeradorCpfFormatado() {}
	
	public String gerar() {
		return gerarSequenciaDigitos(3) + "." + gerarSequenciaDigitos(3) + "." + gerarSequenciaDigitos(3) + "-" + gerarSequenciaDigitos(2);
	}
}
