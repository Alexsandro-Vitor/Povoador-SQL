package geradores.numero;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorIdadeAdulto extends GeradorAbstrato {
	public static final String nomeComando = "IDADE_ADULTO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorIdadeAdulto() {}
	
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(18, 65);
	}
}
