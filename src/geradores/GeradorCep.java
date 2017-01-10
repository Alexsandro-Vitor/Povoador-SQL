package geradores;

public class GeradorCep extends GeradorAbstrato {
	public static final String nomeComando = "CEP";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaDigitos(5)+"-"+MetodosGerador.gerarSequenciaDigitos(3));
	}
}
