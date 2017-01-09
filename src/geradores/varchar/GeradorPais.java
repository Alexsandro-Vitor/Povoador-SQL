package geradores.varchar;

import geradores.GeradorAbstrato;
import geradores.MetodosGerador;

public class GeradorPais extends GeradorAbstrato {
	private static String[] paises = {
		"Afeganistão", "África do Sul", "Albânia", "Alemanha", "Andorra", "Angola", "Arábia Saudita", "Argélia", "Argentina", "Arménia", "Austrália",
		"Áustria", "Azerbaijão", "Bangladesh", "Barbados", "Bélgica", "Bielorrússia", "Bolívia", "Bósnia e Herzegovina", "Botsuana", "Brasil",
		"Brunei", "Bulgária", "Butão", "Cabo Verde", "Camarões", "Camboja", "Canadá", "Catar", "Cazaquistão", "Chile", "China", "Chipre", "Colômbia",
		"Congo", "Coreia do Norte", "Coreia do Sul", "Costa do Marfim", "Costa Rica", "Croácia", "Cuba", "Dinamarca", "Egíto", "Emirados Árabes",
		"Equador", "Eslováquia", "Eslovênia", "Espanha", "Estados Unidos", "Etiópia", "Fiji", "Filipinas", "Finlândia", "França", "Gana", "Geórgia",
		"Geórgia do Sul e Sandwich do Sul", "Gibraltar", "Granada", "Grécia", "Groenlândia", "Guatemala", "Guiana", "Guiné", "Haiti", "Honduras",
		"Hong Kong", "Hungria", "Índia", "Indonésia", "Irã", "Iraque", "Irlanda", "Islândia", "Israel", "Itália", "Jamaica", "Japão", "Jordânia",
		"Kuwait", "Lesoto", "Líbano", "Lituânia", "Luxemburgo", "Macedônia", "Madagáscar", "Malásia", "Malávi", "Malta", "Marrocos", "México",
		"Moçambique", "Mônaco", "Mongólia", "Montenegro", "Nepal", "Nicarágua", "Nigéria", "Noruega", "Nova Zelândia", "Panamá", "Papua-Nova Guiné",
		"Paquistão", "Paraguai", "Peru", "Polônia", "Porto Rico", "Portugal", "Quénia", "Quirguistão", "República Tcheca", "República Dominicana",
		"Romênia", "Ruanda", "Rússia", "São Tomé e Príncipe", "Senegal", "Serra Leoa", "Sérvia", "Singapura", "Síria", "Somália", "Sri Lanka",
		"Suazilândia", "Sudão", "Suécia", "Suíça", "Suriname", "Tailândia", "Taiwan", "Tajiquistão", "Tanzânia", "Timor Leste", "Togo",
		"Trindade e Tobago", "Tunísia", "Turquia", "Ucrânia", "Uganda", "Uruguai", "Usbequistão", "Vaticano", "Venezuela", "Vietnam", "Zâmbia",
		"Zimbabué"
	}; 
	
	public static final String nomeComando = "PAIS";
	
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, nomeComando);
	}
	
	public String gerar() {
		return MetodosGerador.varchar(MetodosGerador.escolhaAleatoria(paises));
	}
}

