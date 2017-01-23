package geradores;

public class GeradorEstado extends GeradorAbstrato {
	private static String[] estados = {
		"Acre", "Alagoas", "Amap�", "Amazonas", "Bahia", "Cear�", "Distrito Federal", "Esp�rito Santo", "Goi�s", "Maranh�o", "Mato Grosso",
		"Mato Grosso do Sul", "Minas Gerais", "Par�", "Para�ba", "Paran�", "Pernambuco", "Piau�", "Rio de Janeiro", "Rio Grande do Norte",
		"Rio Grande do Sul", "Rond�nia", "Roraima", "Santa Catarina", "S�o Paulo", "Sergipe", "Tocantins"
	}; 
	
	public static final String nomeComando = "ESTADO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(estados));
	}
}
