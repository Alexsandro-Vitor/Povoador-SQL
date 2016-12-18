package geradores;

import java.util.Random;

public class GeradorNomes {
	static Random random = new Random();
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
