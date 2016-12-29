package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.Povoamento;
import geradores.PovoamentoVariaveis;

public class GeradorNome extends GeradorAbstrato {
	public static String[] nomesMasculinos = {"Abraão", "Afonso", "Alan", "Alberto", "Alessandro", "Alex",
		"Alexandre", "Alexsandro", "Alfredo", "Álvaro", "André", "Ângelo", "Anthony", "Antônio", "Apolo",
		"Aquiles", "Armando", "Arnaldo", "Arthur", "Átila",
		"Baco", "Benedito", "Bernardo", "Breno", "Bruno",
		"Caio", "Carlos", "Cauã", "César", "Cristiano",
		"Daniel", "Danilo", "Dante", "Davi", "Diego",
		"Edmundo", "Eduardo", "Emanuel", "Emílio", "Eric",
		"Fábio", "Felipe", "Fernando", "Flávio", "Francisco",
		"Gabriel", "Gilberto", "Giovanni", "Guilherme", "Gustavo",
		"Heitor", "Hélio", "Henrique", "Higor", "Hugo",
		"Iago", "Ian", "Ícaro", "Ítalo", "Ivan",
		"João", "Jonas", "Jorge", "José", "Júlio"};
	
	public static String[] nomesFemininos = {"Alice", "Aline", "Ana", "Andressa", "Ágata",
		"Bárbara", "Beatriz", "Benedita", "Bianca", "Bruna"};
	
	public static String[] sobrenomes = {"Albuquerque", "Carneiro", "Carvalho", "Costa", "Gadelha", "Galdino", "Lima", "Lucena", "Moraes",
		"Paganini", "Santana", "Santos", "Serafim", "Silva", "Vasconcelos", "Vaz"};
	
	private PovoamentoVariaveis variaveis;
	
	public GeradorNome(PovoamentoVariaveis variaveis) {
		this.variaveis = variaveis;
	}
	
	public String gerar() {
		if (variaveis.sexo == 0) variaveis.sexo = intAleatorio(1, 3);
		variaveis.nome = gerar(variaveis.sexo == 1);
		//Implementar metodo para gerar nome com um conjunto de iniciais
		return variaveis.nome;
	}
	
	//Gera um nome com o numero de nomes e sobrenomes dado e masculino se for true ou feminino, se for false
	private static String gerar(int nomes, int numSobrenomes, boolean masculino) {
		String nome = "";
		int[] arrayNomes;
		if (masculino) {
			arrayNomes = gerarNumerosDistintos(nomes ,nomesMasculinos.length);
			for (int i = 0; i < arrayNomes.length; i++) nome = nome + ' ' + nomesMasculinos[arrayNomes[i]];
		}
		else {
			arrayNomes = gerarNumerosDistintos(nomes, nomesFemininos.length);
			for (int i = 0; i < arrayNomes.length; i++) nome = nome + ' ' + nomesFemininos[arrayNomes[i]];
		}
		arrayNomes = gerarNumerosDistintos(numSobrenomes, sobrenomes.length);
		for (int i = 0; i < numSobrenomes; i++) nome = nome + ' ' + sobrenomes[arrayNomes[i]];
		return nome.substring(1);
	}
	
	public static String gerar(boolean masculino) {
		return gerar(intAleatorio(1, 3), intAleatorio(1, 3), masculino);
	}
	
	private static int[] gerarNumerosDistintos(int valores, int valorMaximo) {
		int[] numeros = new int[valores];
		boolean[] valorEscolhido = new boolean[valorMaximo];
		for (int i = 0; i < numeros.length; i++) {
			int proxNumero = Povoamento.random.nextInt(valorMaximo - i);
			for (int j = 0; j <= proxNumero && j < valorMaximo; j++) {
				if (valorEscolhido[j]) proxNumero++;
			}
			numeros[i] = proxNumero;
			valorEscolhido[proxNumero] = true;
		}
		return numeros;
	}
}
