package povoadorSQL.geradores;

import povoadorSQL.povoamento.PovoamentoVariaveis;

/**
 * Classe que gera entradas de profissões.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class GeradorProfissao extends GeradorAbstrato {
	private static final String[] PROFISSOES = {
		"Atleta", "Bombeir@", "Cientista", "Designer", "Empresári@", "Enfermeir@", "Engenheir@", "Estudante", "Mecânic@", "Médic@", "Motorista",
		"Professorⱥ", "Programadorⱥ"
	};
	
	//Símbolo @: Pode ser um 'o' ou ser um 'a'
	//Símbolo æ: Pode ser um 'e' ou ser um 'a'
	//Símbolo ⱥ: Pode não ser nada ou ser um 'a'
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "PROFISSAO";
	
	private PovoamentoVariaveis variaveis;
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Construtor de GeradorProfissao.
	 * @param variaveis As variaveis do povoamento, onde está o sexo que será usado para definir em alguns casos o gênero da profissão escolhida
	 */
	public GeradorProfissao(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	/**
	 * Retorna um profissão selecionada aleatoriamente.
	 * @return Uma profissão com gênero consistente com o sexo
	 */
	public String gerar() {
		String profissao = MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(PROFISSOES));
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

