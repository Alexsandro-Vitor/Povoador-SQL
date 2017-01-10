package geradores;

public class GeradorProfissao extends GeradorAbstrato {
	private static String[] profissoes = {
		"Atleta", "Bombeiro", "Cientista", "Empres�rio", "Enfermeiro", "Engenheiro", "Estudante", "Mec�nico", "M�dico", "Motorista", "Professor",
		"Programador"
	};
	
	public static final String nomeComando = "PROFISSAO";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(profissoes));
	}
}

