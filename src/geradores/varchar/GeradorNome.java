package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.Povoamento;
import geradores.PovoamentoVariaveis;

public class GeradorNome extends GeradorAbstrato {
	public static String[] nomesMasculinos = {"Abra�o", "Afonso", "Alan", "Alberto", "Alessandro", "Alex",
		"Alexandre", "Alexsandro", "Alfredo", "�lvaro", "Andr�", "�ngelo", "Anthony", "Ant�nio", "Apolo",
		"Aquiles", "Armando", "Arnaldo", "Arthur", "�tila",
		"Baco", "Benedito", "Bernardo", "Breno", "Bruno",
		"Caio", "Carlos", "Cau�", "C�sar", "Cristiano",
		"Daniel", "Danilo", "Dante", "Davi", "Diego",
		"Edmundo", "Eduardo", "Emanuel", "Em�lio", "Eric",
		"F�bio", "Felipe", "Fernando", "Fl�vio", "Francisco",
		"Gabriel", "Gilberto", "Giovanni", "Guilherme", "Gustavo",
		"Heitor", "H�lio", "Henrique", "Higor", "Hugo",
		"Iago", "Ian", "�caro", "�talo", "Ivan",
		"Jo�o", "Jonas", "Jorge", "Jos�", "J�lio"};
	
	public static String[] nomesFemininos = {"Alice", "Aline", "Ana", "Andressa", "�gata",
		"B�rbara", "Beatriz", "Benedita", "Bianca", "Bruna"};
	
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
