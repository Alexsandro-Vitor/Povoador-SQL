package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorCpf extends GeradorAbstrato {
	public static final String nomeComando = "CPF";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaDigitos(9));
	}
}
