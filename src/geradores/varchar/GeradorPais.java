package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorPais extends GeradorAbstrato {
	private static String[] paises = {
		"Alemanha", "Argentina", "Brasil", "Chile", "China", "Espanha", "Fran�a", "Jap�o", "Portugal", "Uruguai"
	};
	
	public GeradorPais() {}
	
	public String gerar() {
		return escolhaAleatoria(paises);
	}
}

