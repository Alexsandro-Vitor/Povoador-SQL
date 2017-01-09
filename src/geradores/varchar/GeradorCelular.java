package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorCelular extends GeradorAbstrato {
	public static final String nomeComando = "CELULAR";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(gerarCelular());
	}
	
	protected String gerarCelular() {
		return "9" + MetodosGerador.gerarSequenciaDigitos(8);
	}
}
