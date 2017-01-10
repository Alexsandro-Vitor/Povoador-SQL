package geradores;

public class GeradorCpfFormatado extends GeradorAbstrato {
	public static final String nomeComando = "CPF_FORMATADO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.gerarSequenciaDigitos(3) + "." + MetodosGerador.gerarSequenciaDigitos(3) + "." + MetodosGerador.gerarSequenciaDigitos(3) + "-"
				+ MetodosGerador.gerarSequenciaDigitos(2));
	}
}
