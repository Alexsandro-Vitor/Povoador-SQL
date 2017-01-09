package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorPais extends GeradorAbstrato {
	private static String[] paises = {
		"Afeganist�o", "�frica do Sul", "Alb�nia", "Alemanha", "Andorra", "Angola", "Ar�bia Saudita", "Arg�lia", "Argentina", "Arm�nia", "Austr�lia",
		"�ustria", "Azerbaij�o", "Bangladesh", "Barbados", "B�lgica", "Bielorr�ssia", "Bol�via", "B�snia e Herzegovina", "Botsuana", "Brasil",
		"Brunei", "Bulg�ria", "But�o", "Cabo Verde", "Camar�es", "Camboja", "Canad�", "Catar", "Cazaquist�o", "Chile", "China", "Chipre", "Col�mbia",
		"Congo", "Coreia do Norte", "Coreia do Sul", "Costa do Marfim", "Costa Rica", "Cro�cia", "Cuba", "Dinamarca", "Eg�to", "Emirados �rabes",
		"Equador", "Eslov�quia", "Eslov�nia", "Espanha", "Estados Unidos", "Eti�pia", "Fiji", "Filipinas", "Finl�ndia", "Fran�a", "Gana", "Ge�rgia",
		"Ge�rgia do Sul e Sandwich do Sul", "Gibraltar", "Granada", "Gr�cia", "Groenl�ndia", "Guatemala", "Guiana", "Guin�", "Haiti", "Honduras",
		"Hong Kong", "Hungria", "�ndia", "Indon�sia", "Ir�", "Iraque", "Irlanda", "Isl�ndia", "Israel", "It�lia", "Jamaica", "Jap�o", "Jord�nia",
		"Kuwait", "Lesoto", "L�bano", "Litu�nia", "Luxemburgo", "Maced�nia", "Madag�scar", "Mal�sia", "Mal�vi", "Malta", "Marrocos", "M�xico",
		"Mo�ambique", "M�naco", "Mong�lia", "Montenegro", "Nepal", "Nicar�gua", "Nig�ria", "Noruega", "Nova Zel�ndia", "Panam�", "Papua-Nova Guin�",
		"Paquist�o", "Paraguai", "Peru", "Pol�nia", "Porto Rico", "Portugal", "Qu�nia", "Quirguist�o", "Rep�blica Tcheca", "Rep�blica Dominicana",
		"Rom�nia", "Ruanda", "R�ssia", "S�o Tom� e Pr�ncipe", "Senegal", "Serra Leoa", "S�rvia", "Singapura", "S�ria", "Som�lia", "Sri Lanka",
		"Suazil�ndia", "Sud�o", "Su�cia", "Su��a", "Suriname", "Tail�ndia", "Taiwan", "Tajiquist�o", "Tanz�nia", "Timor Leste", "Togo",
		"Trindade e Tobago", "Tun�sia", "Turquia", "Ucr�nia", "Uganda", "Uruguai", "Usbequist�o", "Vaticano", "Venezuela", "Vietnam", "Z�mbia",
		"Zimbabu�"
	}; 
	
	public static final String nomeComando = "PAIS";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(paises));
	}
}

