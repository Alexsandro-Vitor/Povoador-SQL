package geradores;

public class GeradorEstadoSigla extends GeradorAbstrato {
	private static String[] estados = {
		"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "RR",
		"SC", "SE", "SP", "TO"
	}; 
	
	public static final String nomeComando = "ESTADO_SIGLA";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(estados));
	}
}

