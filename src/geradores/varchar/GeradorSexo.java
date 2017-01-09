package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;
import geradores.PovoamentoVariaveis;

public class GeradorSexo extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	public GeradorSexo(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	public static final String nomeComando = "SEXO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		if (variaveis.sexo == 0) variaveis.sexo = MetodosGerador.intAleatorio(1, 3);
		if (variaveis.sexo == 1) return MetodosGerador.varchar("M");
		else return MetodosGerador.varchar("F");
	}
}
