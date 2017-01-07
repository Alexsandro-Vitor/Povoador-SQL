package geradores.numero;

import exception.ChavesDemaisException;
import exception.ComandoInvalidoException;
import geradores.GeradorAbstrato;
import geradores.PovoamentoVariaveis;

public class GeradorChave extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	private String chave;
	
	public GeradorChave(PovoamentoVariaveis variaveis, String chave) {
		this.variaveis = variaveis;
		this.chave = chave;
	}
	
	public String gerar() throws ComandoInvalidoException, ChavesDemaisException {
		if (variaveis.existeChave) throw new ChavesDemaisException();
		else variaveis.existeChave = true;
		return chave;
	}
}
