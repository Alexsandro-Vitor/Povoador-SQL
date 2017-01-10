package geradores;

public class GeradorIdadeMenor extends GeradorAbstrato {
	public static final String nomeComando = "IDADE_MENOR";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorIdadeMenor() {}
	
	public String gerar() {
		return "" + MetodosGerador.intAleatorio(0, 18);
	}
}
