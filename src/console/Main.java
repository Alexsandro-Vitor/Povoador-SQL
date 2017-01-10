package console;

import java.util.ArrayList;
import java.util.Scanner;

import exception.SemNomeException;
import povoamento.Povoamento;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Bem vindo ao povoador");
		System.out.println("Digite o nome da tabela que você quer povoar e em seguida o nome e o tipo de valor que você quer usar");
		System.out.println("Ex.:");
		System.out.println("Teste");
		System.out.println("sexo SEXO");
		System.out.println("nome NOME");
		System.out.println("cpf CPF");
		System.out.println("tel CELULAR_FORMATADO");
		System.out.println("nacionalidade PAIS");
		System.out.println("idade IDADE_ADULTO");
		System.out.println("id CHAVE_INT");
		System.out.println(";");
		ArrayList<String> comando = new ArrayList<String>();
		String entrada;
		do {
			entrada = in.nextLine();
			if (entrada.endsWith(";")) {
				entrada = entrada.substring(0, entrada.length()-1);
				break;
			}
			comando.add(entrada);
		} while (true);
		entrada = comando.remove(0);
		String[] colunas = new String[comando.size()];
		for (int i = 0; i < comando.size(); i++) {
			colunas[i] = comando.get(i);
		}
		Povoamento povoador;
		try {
			povoador = new Povoamento(entrada, colunas);
			System.out.println(povoador.povoar(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
	}

}
