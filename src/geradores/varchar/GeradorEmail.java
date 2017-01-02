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
		if (variaveis.email == null) variaveis.email = siglaAleatoria();
		return variaveis.email + terminacaoAleatoria();
	}
	
	private String siglaAleatoria() {
		int tamanho = 3 + Povoamento.random.nextInt(2);
		String saida = "";
		int[] letrasAleatorias = gerarNumerosDistintos(tamanho, 26);
		for (int i = 0; i < tamanho; i++) {
			saida = saida + (char)('a' + letrasAleatorias[i]);
		}
		return saida;
	}
	
	private static int[] gerarNumerosDistintos(int valores, int valorMaximo) {
		int[] numeros = new int[valores];
		boolean[] valorEscolhido = new boolean[valorMaximo];
		valorEscolhido['k' - 'a'] = true;	//Não há sobrenomes iniciando com k e w, então preciso disso
		valorEscolhido['w' - 'a'] = true;	// para garantir que o email nao tenha essas letras
		for (int i = 0; i < numeros.length; i++) {
			int proxNumero;
			proxNumero = Povoamento.random.nextInt(valorMaximo - i - 2);
			for (int j = 0; j <= proxNumero && j < valorMaximo; j++) {
				if (valorEscolhido[j]) proxNumero++;
			}
			numeros[i] = proxNumero;
			valorEscolhido[proxNumero] = true;
		}
		return numeros;
	}
	
	private String terminacaoAleatoria() {
		return escolhaAleatoria(emails);
	}
}

