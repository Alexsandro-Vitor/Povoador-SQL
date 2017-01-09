package geradores.numero;

import exception.ChavesDemaisException;
import exception.ComandoInvalidoException;
import geradores.GeradorAbstrato;
import geradores.PovoamentoVariaveis;

public class GeradorChave extends GeradorAbstrato {
	private String comando;
	private PovoamentoVariaveis variaveis;
	private String chave;
	
	public static final String nomeComando = "CHAVE";
	public static final String inteiro = "_INT";
	public static final String varchar = "_STRING";
	
	public static boolean checarComando(String entrada) {
		return entrada.toUpperCase().startsWith(nomeComando);
	}
	
	public GeradorChave(String comando, PovoamentoVariaveis variaveis, String chave) {
		this.comando = comando;
		this.variaveis = variaveis;
		this.chave = chave;
	}
	
	public String gerar() throws ComandoInvalidoException, ChavesDemaisException {
		if (variaveis.existeChave) throw new ChavesDemaisException();
		else {
			variaveis.existeChave = true;
			String tipoChave = comando.substring(nomeComando.length());
			if (tipoChave.equalsIgnoreCase(varchar)) return "'" + chave + "'";
			else if (tipoChave.equalsIgnoreCase(inteiro)) return chave;
			else throw new ComandoInvalidoException(comando);
		}
	}
}
