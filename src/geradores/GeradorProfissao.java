package geradores;

import povoamento.PovoamentoVariaveis;

public class GeradorProfissao extends GeradorAbstrato {
	private static String[] profissoes = {
		"Atleta", "Bombeir@", "Cientista", "Empresári@", "Enfermeir@", "Engenheir@", "Estudante", "Mecânic@", "Médic@", "Motorista", "Professorⱥ",
		"Programadorⱥ"
	};
	
	//Símbolo @: Pode ser um 'o' ou ser um 'a'
	//Símbolo æ: Pode ser um 'e' ou ser um 'a'
	//Símbolo ⱥ: Pode não ser nada ou ser um 'a'
	
	public static final String nomeComando = "PROFISSAO";
	
	private PovoamentoVariaveis variaveis;
	
	public GeradorProfissao(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		String profissao = MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(profissoes));
		profissao = adicionarGenero(profissao);
		return profissao;
	}
	
	private String adicionarGenero(String profissao) {
		variaveis.definirSexo();
		profissao = (variaveis.sexo == PovoamentoVariaveis.MASCULINO) ? profissao.replace("@", "o") : profissao.replace("@", "a");
		profissao = (variaveis.sexo == PovoamentoVariaveis.MASCULINO) ? profissao.replace("æ", "e") : profissao.replace("æ", "a");
		profissao = (variaveis.sexo == PovoamentoVariaveis.MASCULINO) ? profissao.replace("ⱥ", "") : profissao.replace("ⱥ", "a");
		return profissao;
	}
}

