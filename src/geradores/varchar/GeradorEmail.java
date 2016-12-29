package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.Povoamento;
import geradores.PovoamentoVariaveis;

public class GeradorEmail extends GeradorAbstrato {
	private PovoamentoVariaveis variaveis;
	
	private static String[] emails = {
		"@cin.ufpe.br", "@gmail.com", "@hotmail.com"
	};
	
	public GeradorEmail(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	public String gerar() {
		if (variaveis.nome == null) variaveis.email = siglaAleatoria();
		else variaveis.email = gerarEmail(variaveis.nome);
		return variaveis.email + terminacaoAleatoria();
	}
	
	private static String gerarEmail(String nome) {
		String saida = "" + nome.charAt(0);
		for (int i = 1; i < nome.length(); i++) {
			if (nome.charAt(i-1) == ' ') saida = saida + nome.charAt(i);
		}
		return removeAcentos(saida);
	}
	
	private static String removeAcentos(String nome) {
		nome = nome.toLowerCase();
		String saida = "";
		for (int i = 0; i < nome.length(); i++) {
			char letra = nome.charAt(i);
			if (letra == 'ã' || letra == 'á' || letra == 'à' || letra == 'â') saida = saida + 'a';
			else if (letra == 'é' || letra == 'è' || letra == 'ê') saida = saida + 'e';
			else if (letra == 'í' || letra == 'ì' || letra == 'î') saida = saida + 'i';
			else if (letra == 'õ' || letra == 'ó' || letra == 'ò' || letra == 'ô') saida = saida + 'o';
			else if (letra == 'ú' || letra == 'ù' || letra == 'û') saida = saida + 'u';
			else saida = saida + letra;
		}
		return saida;
	}
	
	private String siglaAleatoria() {
		int tamanho = 3 + Povoamento.random.nextInt(2);
		String saida = "";
		for (int i = 0; i < tamanho; i++) {
			saida = saida + (char)('a' + Povoamento.random.nextInt(26));
		}
		return saida;
	}
	
	private String terminacaoAleatoria() {
		return escolhaAleatoria(emails);
	}
}

