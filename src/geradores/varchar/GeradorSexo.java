package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.PovoamentoVariaveis;

public class GeradorSexo extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	public GeradorSexo(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	public String gerar() {
		if (variaveis.sexo == 0) variaveis.sexo = intAleatorio(1, 3);
		if (variaveis.sexo == 1) return "M";
		else return "F";
	}
}
