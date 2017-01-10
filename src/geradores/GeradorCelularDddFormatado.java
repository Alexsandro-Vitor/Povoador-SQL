package geradores;

public class GeradorCelularDddFormatado extends GeradorCelularFormatado {
	public static final String nomeComando = "CELULAR_DDD_FORMATADO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorCelularDddFormatado() {}
	
	public String gerar() {
		return MetodosGerador.varchar("(" + MetodosGerador.gerarSequenciaDigitos(2) + ")" + gerarCelular());
	}
}
