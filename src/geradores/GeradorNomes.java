package geradores;

import java.util.Random;

public class GeradorNomes {
	static Random random = new Random();
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
	
	//Gera um nome com o numero de nomes e sobrenomes dado e masculino se for true ou feminino, se for false
	public static String gerar(int nomes, int numSobrenomes, boolean masculino) {
		String nome = "";
		int[] arrayNomes;
		if (masculino) {
			arrayNomes = GeradorNumeros.gerarNumerosDistintos(nomes ,nomesMasculinos.length);
			for (int i = 0; i < arrayNomes.length; i++) nome = nome + ' ' + nomesMasculinos[arrayNomes[i]];
		}
		else {
			arrayNomes = GeradorNumeros.gerarNumerosDistintos(nomes, nomesFemininos.length);
			for (int i = 0; i < arrayNomes.length; i++) nome = nome + ' ' + nomesFemininos[arrayNomes[i]];
		}
		arrayNomes = GeradorNumeros.gerarNumerosDistintos(numSobrenomes, sobrenomes.length);
		for (int i = 0; i < numSobrenomes; i++) nome = nome + ' ' + sobrenomes[arrayNomes[i]];
		return nome.substring(1);
	}
	
	public static String gerar() {return gerar(random.nextInt(2)+1, random.nextInt(2)+1, random.nextBoolean());}
	
	public static String gerar(int nomes, int sobrenomes) {return gerar(nomes, sobrenomes, random.nextBoolean());}
	
	public static String gerar(boolean masculino) {return gerar(random.nextInt(2)+1, random.nextInt(2)+1, masculino);}
}
