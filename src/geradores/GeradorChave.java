package geradores;

import exception.ChavesDemaisException;
import exception.ComandoInvalidoException;
import povoamento.PovoamentoVariaveis;

public class GeradorChave extends GeradorAbstrato {
	private String comando;
	private PovoamentoVariaveis variaveis;
	
	public static final String nomeComando = "CHAVE";
	public static final String inteiro = "_INT";
	public static final String varchar = "_VARCHAR";
	
	public static boolean checarComando(String entrada) {
		return entrada.toUpperCase().startsWith(nomeComando);
	}
	
	public GeradorChave(String comando, PovoamentoVariaveis variaveis) {
		this.comando = comando;
		this.variaveis = variaveis;
	}
	
	public String gerar() throws ComandoInvalidoException, ChavesDemaisException {
		if (variaveis.existeChave) throw new ChavesDemaisException();
		else {
			variaveis.existeChave = true;
			String tipoChave = comando.substring(nomeComando.length());
			if (tipoChave.equalsIgnoreCase(varchar)) return "'" + variaveis.chave + "'";
			else if (tipoChave.equalsIgnoreCase(inteiro)) return variaveis.chave;
			else throw new ComandoInvalidoException(comando);
		}
	}
}
