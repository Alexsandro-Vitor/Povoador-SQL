package geradores;

public class GeradorPlaca extends GeradorAbstrato {
	public static final String nomeComando = "PLACA";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(gerarLetras(3)+"-"+MetodosGerador.gerarSequenciaDigitos(4));
	}
	
	public String gerarLetras(int letras) {
		String saida = "";
		for (int i = 0; i < letras; i++) {
			saida += (char)MetodosGerador.intAleatorio('A', 'Z' + 1);
		}
		return saida;
	}
}
