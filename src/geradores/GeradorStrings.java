package geradores;

import java.util.Random;

public class GeradorStrings {
	private static Random random = new Random();
	private static String[] paises = {
		"Alemanha", "Argentina", "Brasil", "Chile", "China", "Espanha", "Fran�a", "Jap�o", "Portugal", "Uruguai"
	};
	private static String[] profissoes = {
		"Bombeiro", "Cientista", "Empres�rio", "Enfermeiro", "Engenheiro", "Estudante", "M�dico", "Professor", "Programador"
	};
	private static String[] emails = {
		"@cin.ufpe.br", "@gmail.com", "@hotmail.com"
	};
	
	public static String paisAleatorio() {
		return paises[random.nextInt(paises.length)];
	}
	
	public static String profissaoAleatoria() {
		return profissoes[random.nextInt(profissoes.length)];
	}
	
	public static String gerarEmail(String nome) {
		String saida = "" + nome.charAt(0);
		for (int i = 1; i < nome.length(); i++) {
			if (nome.charAt(i-1) == ' ') saida = saida + nome.charAt(i);
		}
		return removeAcentos(saida);
	}
	
	public static String emailAleatorio() {
		return emails[random.nextInt(emails.length)];
	}
	
	public static String siglaAleatoria() {
		int tamanho = 3 + random.nextInt(3);
		String saida = "";
		for (int i = 0; i < tamanho; i++) {
			saida = saida + (char)('a' + random.nextInt(26));
		}
		return saida;
	}
	
	private static String removeAcentos(String nome) {
		nome.toLowerCase();
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
}
