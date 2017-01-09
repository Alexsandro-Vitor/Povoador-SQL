package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorProfissao extends GeradorAbstrato {
	private static String[] profissoes = {
		"Bombeiro", "Cientista", "Empres�rio", "Enfermeiro", "Engenheiro", "Estudante", "M�dico", "Professor", "Programador"
	};
	
	public static final String nomeComando = "PROFISSAO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(profissoes));
	}
}

