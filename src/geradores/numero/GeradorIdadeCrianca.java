package geradores.numero;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorIdadeCrianca extends GeradorAbstrato {
	public static final String nomeComando = "IDADE_CRIANCA";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorIdadeCrianca() {}
	
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(0, 13);
	}
}
