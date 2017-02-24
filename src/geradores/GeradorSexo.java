package geradores;

import povoamento.PovoamentoVariaveis;

public class GeradorSexo extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	
	public static final String nomeComando = "SEXO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorSexo(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	public String gerar() {
		variaveis.definirSexo();
		if (variaveis.sexo == PovoamentoVariaveis.MASCULINO) return MetodosGerador.varchar("M");
		else return MetodosGerador.varchar("F");
	}
}
