package geradores.varchar;

import geradores.GeradorAbstrato;

public class GeradorProfissao extends GeradorAbstrato {
	private static String[] profissoes = {
		"Bombeiro", "Cientista", "Empresário", "Enfermeiro", "Engenheiro", "Estudante", "Médico", "Professor", "Programador"
	};
	
	public GeradorProfissao() {}
	
	public String gerar() {
		return escolhaAleatoria(profissoes);
	}
}

