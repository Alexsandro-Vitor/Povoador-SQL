package geradores;

public class GeradorCnpj extends GeradorAbstrato {
	public static final String nomeComando = "CNPJ";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaDigitos(2) + '.' + MetodosGerador.gerarSequenciaDigitos(3) + '.' +
			MetodosGerador.gerarSequenciaDigitos(3) + '/' + MetodosGerador.gerarSequenciaDigitos(4) + '-' + MetodosGerador.gerarSequenciaDigitos(2));
	}
}
