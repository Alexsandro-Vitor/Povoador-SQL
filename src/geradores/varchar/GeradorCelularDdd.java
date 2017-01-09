package geradores.varchar;

import geradores.MetodosGerador;

public class GeradorCelularDdd extends GeradorCelular {
	public static final String nomeComando = "CELULAR_DDD";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaDigitos(2) + gerarCelular());
	}
}
