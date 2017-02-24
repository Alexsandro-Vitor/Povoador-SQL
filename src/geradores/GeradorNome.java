package geradores;

import povoamento.PovoamentoVariaveis;

public class GeradorNome extends GeradorAbstrato {
	public static String[] nomesMasculinos = {
			"Abraão", "Afonso", "Alan", "Alberto", "Alessandro", "Alex", "Alexandre", "Alexsandro", "Alfredo", "Álvaro", "André", "Ângelo",
			"Anthony", "Antônio", "Apolo", "Aquiles", "Armando", "Arnaldo", "Arthur", "Átila",
			"Baco", "Benedito", "Bernardo", "Breno", "Bruno",
			"Caio", "Carlos", "Cauã", "César", "Cristiano",
			"Daniel", "Danilo", "Dante", "Davi", "Diego",
			"Edmundo", "Eduardo", "Emanuel", "Emílio", "Eric",
			"Fábio", "Felipe", "Fernando", "Flávio", "Francisco",
			"Gabriel", "Gilberto", "Giovanni", "Guilherme", "Gustavo",
			"Heitor", "Hélio", "Henrique", "Higor", "Hugo",
			"Iago", "Ian", "Ícaro", "Ítalo", "Ivan",
			"João", "Jonas", "Jorge", "José", "Júlio",
			"Kaique", "Kauan", "Kauã", "Kauê", "Kevin",
			"Leandro", "Leonardo", "Luan", "Lucas", "Luiz",
			"Marcelo", "Marcos", "Matheus", "Miguel", "Murilo",
			"Natan", "Natanael", "Nelson", "Nicolas", "Nuno",
			"Olavo", "Osmar", "Osvaldo", "Otávio", "Otto",
			"Patrício", "Paulo", "Pedro", "Péricles", "Plínio",
			"Quintino",
			"Rafael", "Renan", "Renato", "Ricardo", "Rodrigo",
			"Samuel", "Saulo", "Sebastião", "Sérgio", "Sílvio",
			"Téo", "Thales", "Thiago", "Tomás", "Túlio",
			"Ubirajara", "Ubiratan", "Ugo", "Ulísses", "Uriel",
			"Vanderlei", "Vicente", "Victor", "Vinícius", "Vitor",
			"Wagner", "Waldir", "Walter", "Wellington", "Wesley",
			"Xavier",
			"Yago", "Yan", "Yuri",
			"Zacarias", "Zaqueu"
	};

	public static String[] nomesFemininos = {
			"Alice", "Aline", "Ana", "Andressa", "Ágata",
			"Bárbara", "Beatriz", "Benedita", "Bianca", "Bruna",
			"Camila", "Carolina", "Catarina", "Cecília", "Cristina",
			"Daiane", "Daniela", "Denise", "Débora", "Diana",
			"Eduarda", "Elena", "Eliana", "Érica", "Eva",
			"Fabiana", "Fátima", "Fernanda", "Flávia", "Francisca",
			"Gabriela", "Gabrielle", "Giovana", "Gisele", "Glória",
			"Helen", "Helena", "Heloísa", "Hera", "Hilda",
			"Ingrid", "Isabel", "Isabela", "Isadora", "Isis",
			"Janaína", "Jéssica", "Joana", "Juliana", "Júlia",
			"Karina", "Karol", "Kátia", "Kelly", "Kiara",
			"Lara", "Larissa", "Laura", "Letícia", "Luana",
			"Manuela", "Maria", "Mariana", "Marina", "Milena",
			"Natasha", "Natália", "Nayara", "Nicole", "Nina",
			"Ofélia", "Olga", "Olívia", "Oriana", "Opala",
			"Pamela", "Patrícia", "Paula", "Poliana", "Priscila",
			"Quitéria",
			"Rafaela", "Raissa", "Raquel", "Rebeca", "Renata",
			"Sabrina", "Sandra", "Sara", "Sofia", "Stephanie",
			"Talita", "Tainá", "Tatiana", "Thaís", "Thaynara",
			"Úrsula",
			"Valentina", "Valéria", "Vanessa", "Vitória", "Viviane",
			"Walesca", "Walquíria", "Wanda", "Wilda", "Wilma",
			"Xena", "Xênia", "Xuxa",
			"Yara", "Yasmin", "Yolanda",
			"Zélia", "Zilda"
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
			"Isgária",
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
			"Ygarapé",
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
	
	//Deixa uma String minúscula e remove sua acentuação
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
	
	//Gera um nome completo cujas iniciais são as mesmas em variaveis.email
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
	
	//Acha a posição do primeiro nome ou sobrenome que não tem uma determinada inicial
	private static int acharUltimoNome(int i, String[] array, char letra) {
		for (; i < array.length; i++) {
			if (removeAcentos(array[i]).startsWith("" + letra) == false) return i;
		}
		return array.length;
	}
}
