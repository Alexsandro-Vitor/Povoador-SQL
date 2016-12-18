package geradores;

import java.util.Random;

public class GeradorNumeros {
	static Random random = new Random();
	
	static int[] gerarNumerosDistintos(int valores, int valorMaximo) {
		int[] numeros = new int[valores];
		boolean[] valorEscolhido = new boolean[valorMaximo];
		for (int i = 0; i < numeros.length; i++) {
			int proxNumero = random.nextInt(valorMaximo - i);
			for (int j = 0; j <= proxNumero && j < valorMaximo; j++) {
				if (valorEscolhido[j]) proxNumero++;
			}
			numeros[i] = proxNumero;
			valorEscolhido[proxNumero] = true;
		}
		return numeros;
	}
	
	static String gerarSequenciaDigitos(int digitos) {
		String sequencia = "";
		for (int i = 0; i < digitos; i++) {
			char digito = (char)('0' + random.nextInt(10));
			sequencia = sequencia + digito;
		}
		return sequencia;
	}
	
	static String gerarCelular() {
		return "9"+gerarSequenciaDigitos(8);
	}
	
	static String gerarCelularDDD() {
		return gerarSequenciaDigitos(2)+gerarCelular();
	}
	
	static String gerarCelularFormatado() {
		return "9"+gerarSequenciaDigitos(4)+"-"+gerarSequenciaDigitos(4);
	}
	
	static String gerarCelularDDDFormatado() {
		return "("+gerarSequenciaDigitos(2)+")"+gerarCelularFormatado();
	}
	
	static String gerarCPF() {
		return gerarSequenciaDigitos(3)+"."+gerarSequenciaDigitos(3)+"."+gerarSequenciaDigitos(3)+"-"+gerarSequenciaDigitos(2);
	}
	
	static String gerarCEP() {
		return gerarSequenciaDigitos(5)+"-"+gerarSequenciaDigitos(3);
	}
}
