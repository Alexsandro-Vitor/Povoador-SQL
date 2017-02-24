package geradores;

import povoamento.PovoamentoVariaveis;

public class GeradorNome extends GeradorAbstrato {
	public static String[] nomesMasculinos = {
			"Abra�o", "Afonso", "Alan", "Alberto", "Alessandro", "Alex", "Alexandre", "Alexsandro", "Alfredo", "�lvaro", "Andr�", "�ngelo",
			"Anthony", "Ant�nio", "Apolo", "Aquiles", "Armando", "Arnaldo", "Arthur", "�tila",
			"Baco", "Benedito", "Bernardo", "Breno", "Bruno",
			"Caio", "Carlos", "Cau�", "C�sar", "Cristiano",
			"Daniel", "Danilo", "Dante", "Davi", "Diego",
			"Edmundo", "Eduardo", "Emanuel", "Em�lio", "Eric",
			"F�bio", "Felipe", "Fernando", "Fl�vio", "Francisco",
			"Gabriel", "Gilberto", "Giovanni", "Guilherme", "Gustavo",
			"Heitor", "H�lio", "Henrique", "Higor", "Hugo",
			"Iago", "Ian", "�caro", "�talo", "Ivan",
			"Jo�o", "Jonas", "Jorge", "Jos�", "J�lio",
			"Kaique", "Kauan", "Kau�", "Kau�", "Kevin",
			"Leandro", "Leonardo", "Luan", "Lucas", "Luiz",
			"Marcelo", "Marcos", "Matheus", "Miguel", "Murilo",
			"Natan", "Natanael", "Nelson", "Nicolas", "Nuno",
			"Olavo", "Osmar", "Osvaldo", "Ot�vio", "Otto",
			"Patr�cio", "Paulo", "Pedro", "P�ricles", "Pl�nio",
			"Quintino",
			"Rafael", "Renan", "Renato", "Ricardo", "Rodrigo",
			"Samuel", "Saulo", "Sebasti�o", "S�rgio", "S�lvio",
			"T�o", "Thales", "Thiago", "Tom�s", "T�lio",
			"Ubirajara", "Ubiratan", "Ugo", "Ul�sses", "Uriel",
			"Vanderlei", "Vicente", "Victor", "Vin�cius", "Vitor",
			"Wagner", "Waldir", "Walter", "Wellington", "Wesley",
			"Xavier",
			"Yago", "Yan", "Yuri",
			"Zacarias", "Zaqueu"
	};

	public static String[] nomesFemininos = {
			"Alice", "Aline", "Ana", "Andressa", "�gata",
			"B�rbara", "Beatriz", "Benedita", "Bianca", "Bruna",
			"Camila", "Carolina", "Catarina", "Cec�lia", "Cristina",
			"Daiane", "Daniela", "Denise", "D�bora", "Diana",
			"Eduarda", "Elena", "Eliana", "�rica", "Eva",
			"Fabiana", "F�tima", "Fernanda", "Fl�via", "Francisca",
			"Gabriela", "Gabrielle", "Giovana", "Gisele", "Gl�ria",
			"Helen", "Helena", "Helo�sa", "Hera", "Hilda",
			"Ingrid", "Isabel", "Isabela", "Isadora", "Isis",
			"Jana�na", "J�ssica", "Joana", "Juliana", "J�lia",
			"Karina", "Karol", "K�tia", "Kelly", "Kiara",
			"Lara", "Larissa", "Laura", "Let�cia", "Luana",
			"Manuela", "Maria", "Mariana", "Marina", "Milena",
			"Natasha", "Nat�lia", "Nayara", "Nicole", "Nina",
			"Of�lia", "Olga", "Ol�via", "Oriana", "Opala",
			"Pamela", "Patr�cia", "Paula", "Poliana", "Priscila",
			"Quit�ria",
			"Rafaela", "Raissa", "Raquel", "Rebeca", "Renata",
			"Sabrina", "Sandra", "Sara", "Sofia", "Stephanie",
			"Talita", "Tain�", "Tatiana", "Tha�s", "Thaynara",
			"�rsula",
			"Valentina", "Val�ria", "Vanessa", "Vit�ria", "Viviane",
			"Walesca", "Walqu�ria", "Wanda", "Wilda", "Wilma",
			"Xena", "X�nia", "Xuxa",
			"Yara", "Yasmin", "Yolanda",
			"Z�lia", "Zilda"
	};

	public static String[] sobrenomes = {
			"Albuquerque",
			"Barbosa",
			"Carneiro", "Carvalho", "Costa",
			"Dantas",
			"Espindola",
			"Ferreira",
			"Gadelha", "Galdino",
			"Henriques",
			"Isg�ria",
			"Jacinto",

			"Lima", "Lucena",
			"Moraes",
			"Nogueira",
			"Oliveira",
			"Paganini",
			"Quaresma",
			"Rodrigues",
			"Santana", "Santos", "Serafim", "Silva",
			"Teixeira",
			"Ursulino",
			"Vasconcelos", "Vaz",
			
			"Ximeno",
			"Ygarap�",
			"Zeferino"
	};

	private static PovoamentoVariaveis variaveis;

	public static final String nomeComando = "NOME";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public GeradorNome(PovoamentoVariaveis variaveis) {
		GeradorNome.variaveis = variaveis;
	}

	public String gerar() {
		variaveis.definirSexo();
		variaveis.nome = (variaveis.email == null) ?
				gerar(variaveis.sexo == PovoamentoVariaveis.MASCULINO) : gerarIniciais(variaveis.sexo == PovoamentoVariaveis.MASCULINO);
		if (variaveis.email == null) variaveis.email = gerarEmail(variaveis.nome);
		return MetodosGerador.varchar(variaveis.nome);
	}

	//Gera um nome com o numero de nomes e sobrenomes dado e masculino se for true ou feminino, se for false
	private static String gerar(int nomes, int numSobrenomes, boolean masculino) {
		String nome = "";
		int[] arrayNomes;
		if (masculino) {
			arrayNomes = gerarNumerosDistintos(nomes, nomesMasculinos.length);
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
		return gerar(MetodosGerador.intAleatorio(1, 3), MetodosGerador.intAleatorio(1, 3), masculino);
	}
	
	//Gera uma sequencia de numeros distintos
	private static int[] gerarNumerosDistintos(int valores, int valorMaximo) {
		int[] numeros = new int[valores];
		boolean[] valorEscolhido = new boolean[valorMaximo];
		for (int i = 0; i < numeros.length; i++) {
			int proxNumero = MetodosGerador.intAleatorio(0, valorMaximo - i);
			for (int j = 0; j <= proxNumero && j < valorMaximo; j++) {
				if (valorEscolhido[j]) proxNumero++;
			}
			numeros[i] = proxNumero;
			valorEscolhido[proxNumero] = true;
		}
		return numeros;
	}

	private static String gerarEmail(String nome) {
		String saida = "" + nome.charAt(0);
		for (int i = 1; i < nome.length(); i++) {
			if (nome.charAt(i-1) == ' ') saida = saida + nome.charAt(i);
		}
		return removeAcentos(saida);
	}
	
	//Deixa uma String min�scula e remove sua acentua��o
	private static String removeAcentos(String nome) {
		nome = nome.toLowerCase();
		String saida = "";
		for (int i = 0; i < nome.length(); i++) {
			char letra = nome.charAt(i);
			if (letra == '�' || letra == '�' || letra == '�' || letra == '�') saida = saida + 'a';
			else if (letra == '�' || letra == '�' || letra == '�') saida = saida + 'e';
			else if (letra == '�' || letra == '�' || letra == '�') saida = saida + 'i';
			else if (letra == '�' || letra == '�' || letra == '�' || letra == '�') saida = saida + 'o';
			else if (letra == '�' || letra == '�' || letra == '�') saida = saida + 'u';
			else saida = saida + letra;
		}
		return saida;
	}
	
	//Gera um nome completo cujas iniciais s�o as mesmas em variaveis.email
	private static String gerarIniciais(boolean masculino) {
		int nomes = 0, numSobrenomes = 1;
		if (variaveis.email.length() > 2) {
			numSobrenomes = 2;
			nomes = variaveis.email.length() - 2;
		} else nomes = numSobrenomes = 1;
		String nome = "";
		int[] arrayNomes;
		if (masculino) {
			arrayNomes = selecionarNomes(0, nomes, nomesMasculinos);
			for (int i = 0; i < arrayNomes.length; i++) nome = nome + ' ' + nomesMasculinos[arrayNomes[i]];
		} else {
			arrayNomes = selecionarNomes(0, nomes, nomesFemininos);
			for (int i = 0; i < arrayNomes.length; i++) nome = nome + ' ' + nomesFemininos[arrayNomes[i]];
		}
		arrayNomes = selecionarNomes(nomes, numSobrenomes, sobrenomes);
		for (int i = 0; i < numSobrenomes; i++) nome = nome + ' ' + sobrenomes[arrayNomes[i]];
		return nome.substring(1);
	}
	
	//Escolhe nomes ou sobrenomes com um determinado conjunto de iniciais
	private static int[] selecionarNomes(int desvio, int valores, String[] array) {
		int[] numeros = new int[valores];
		boolean[] valorEscolhido = new boolean[array.length];
		for (int i = 0; i < valores; i++) {
			int min = acharPrimeiroNome(array, variaveis.email.charAt(i + desvio));
			int max = acharUltimoNome(min, array, variaveis.email.charAt(i + desvio));
			int proxNumero = MetodosGerador.intAleatorio(min, max);
			for (int j = min; j <= proxNumero && j < max; j++) {
				if (valorEscolhido[j]) proxNumero++;
			}
			numeros[i] = proxNumero;
			valorEscolhido[proxNumero] = true;
		}
		return numeros;
	}
	
	//Acha o primeiro nome ou sobrenome com uma determinada inicial
	private static int acharPrimeiroNome(String[] array, char letra) {
		for (int i = 0; i < array.length; i++) {
			if (removeAcentos(array[i]).startsWith("" + letra)) return i;
		}
		return array.length;
	}
	
	//Acha a posi��o do primeiro nome ou sobrenome que n�o tem uma determinada inicial
	private static int acharUltimoNome(int i, String[] array, char letra) {
		for (; i < array.length; i++) {
			if (removeAcentos(array[i]).startsWith("" + letra) == false) return i;
		}
		return array.length;
	}
}
