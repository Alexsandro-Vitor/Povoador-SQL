package geradores.numero;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorIdadeAdolescente extends GeradorAbstrato {
	public static final String nomeComando = "IDADE_ADOLESCENTE";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorIdadeAdolescente() {}
	
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(13, 18);
	}
}
