package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorProfissao extends GeradorAbstrato {
	private static String[] profissoes = {
		"Bombeiro", "Cientista", "Empres�rio", "Enfermeiro", "Engenheiro", "Estudante", "M�dico", "Professor", "Programador"
	};
	
	public GeradorProfissao() {}
	
	public String gerar() {
		return escolhaAleatoria(profissoes);
	}
}

