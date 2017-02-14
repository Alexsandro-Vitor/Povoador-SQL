package geradores;

import exception.ChavesDemaisException;
import exception.ComandoInvalidoException;
import exception.NumeroInvalidoException;
import exception.QtdParametrosInvalidaException;
import povoamento.PovoamentoVariaveis;

public class GeradorChave extends GeradorAbstrato {
	private String comando;
	private PovoamentoVariaveis variaveis;

	public static final String nomeComando = "CHAVE";
	public static final String inteiro = "_INT";
	public static final String varchar = "_VARCHAR";

	public static boolean checarComando(String entrada) {
		return entrada.toUpperCase().startsWith(nomeComando) && entrada.endsWith(")");
	}

	public GeradorChave(String comando, PovoamentoVariaveis variaveis) {
		this.comando = comando;
		this.variaveis = variaveis;
	}

	public String gerar() throws ComandoInvalidoException, ChavesDemaisException, QtdParametrosInvalidaException, NumeroInvalidoException {
		if (variaveis.existeChave) throw new ChavesDemaisException();
		else {
			variaveis.existeChave = true;
			String tipoChave = comando.substring(nomeComando.length());
			try {
				if (tipoChave.toUpperCase().startsWith(varchar)) {
					return MetodosGerador.varchar("" + (Integer.parseInt(MetodosGerador.validarSintaxe(tipoChave, varchar.length(), 1)[0])
							+ Integer.parseInt(variaveis.chave)));
				} else if (tipoChave.toUpperCase().startsWith(inteiro)) {
					return "" + (Integer.parseInt(MetodosGerador.validarSintaxe(tipoChave, inteiro.length(), 1)[0])
							+ Integer.parseInt(variaveis.chave));
				} else throw new ComandoInvalidoException(comando);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(MetodosGerador.validarSintaxe(tipoChave, varchar.length(), 1)[0], tipoChave);
			}
		}
	}
}
