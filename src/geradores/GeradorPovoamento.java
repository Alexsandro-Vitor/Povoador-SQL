package geradores;

import java.util.Random;

import exception.ChavesDemaisException;
import exception.DataInvalidaException;
import exception.TipoInvalidoException;
import exception.QtdSaidasInvalidaException;
import exception.SemNomeException;

public class GeradorPovoamento {
	private static Random random = new Random();
	private String nomeTabela;
	private String parametros;
	private String[] tipos;
	public GeradorPovoamento(String nome, String[] entrada) throws SemNomeException {
		if (nome.equals("")) throw new SemNomeException();
		nomeTabela = nome;
		parametros = "(";
		tipos = new String[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			String[] param = entrada[i].split(" ", 2);
			parametros = parametros + param[0];
			tipos[i] = removerEspacos(param[1]);
			if (i < entrada.length-1) parametros = parametros + ", ";
		}
		parametros = parametros + ")";
	}

	public String povoar(int qtd) throws Exception {
		if (qtd <= 0) throw new QtdSaidasInvalidaException();
		String saida = "";
		for (int i = 0; i < qtd; i++) {
			String insercao = this.gerarInsercao(i + "");
			saida = saida + insercao + "\n";
		}
		return saida;
	}

	public String gerarInsercao(String chave) throws Exception {
		String saida = "INSERT INTO " + nomeTabela + " " + parametros + " VALUES (\n";
		//Variaveis para evitar que chaves sejam repetidas, que uma mulher tenha nome de homem e vice-versa
		int sexo = 0;
		boolean existeChave = false;
		String email = null;
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].equalsIgnoreCase("NOME")) {
				if (sexo == 0) sexo = random.nextInt(2)+1;
				String nome = GeradorNomes.gerar(sexo == 1);
				saida = saida + "	'" + nome + "'";
				email = GeradorStrings.gerarEmail(nome);
			} else if (tipos[i].equalsIgnoreCase("SEXO")) {
				if (sexo == 0) sexo = random.nextInt(2)+1;
				if (sexo == 1) saida = saida + "	'M'";
				else saida = saida + "	'F'";
			} else if (tipos[i].equalsIgnoreCase("EMAIL")) {
				if (email != null) saida = saida + "	'" + email + GeradorStrings.emailAleatorio() + "'";
				else saida = saida + "	'" + GeradorStrings.siglaAleatoria() + GeradorStrings.emailAleatorio() + "'";
			} else if (tipos[i].equalsIgnoreCase("CPF")) saida = saida + "	'" + GeradorNumeros.gerarSequenciaDigitos(9) + "'";
			else if (tipos[i].equalsIgnoreCase("CPF_FORMATADO")) saida = saida + "	'" + GeradorNumeros.gerarCPF() + "'";
			else if (tipos[i].equalsIgnoreCase("CEP")) saida = saida + "	'" + GeradorNumeros.gerarCEP() + "'";
			else if (tipos[i].equalsIgnoreCase("CELULAR")) saida = saida + "	'" + GeradorNumeros.gerarCelular() + "'";
			else if (tipos[i].equalsIgnoreCase("CELULAR_DDD")) saida = saida + "	'" + GeradorNumeros.gerarCelularDDD() + "'";
			else if (tipos[i].equalsIgnoreCase("CELULAR_FORMATADO")) saida = saida + "	'" + GeradorNumeros.gerarCelularFormatado() + "'";
			else if (tipos[i].equalsIgnoreCase("CELULAR_FORMATADO_DDD")) saida = saida + "	'" + GeradorNumeros.gerarCelularFormatado() + "'";
			else if (tipos[i].substring(0, 5).equalsIgnoreCase("DATA(")) {
				checagemComandoData(tipos[i]);
				String[] limite = tipos[i].substring(5, tipos[i].length()-1).split(",");
				int[] anos = {Integer.parseInt(limite[0].substring(6)), Integer.parseInt(limite[1].substring(6))};
				int[] meses = {Integer.parseInt(limite[0].substring(3, 5)), Integer.parseInt(limite[1].substring(3, 5))};
				int[] dias = {Integer.parseInt(limite[0].substring(0, 2)), Integer.parseInt(limite[1].substring(0, 2))};
				int ano = anos[0] + random.nextInt(anos[1] - anos[0] + 1);
				int min = 1, max = 12;
				if (ano == anos[0]) min = meses[0];
				if (ano == anos[1]) max = meses[1];
				int mes = min + random.nextInt(max - min + 1);
				if (ano == anos[1] && mes == meses[1]) max = dias[1];
				else if (mes31Dias(mes)) max = 31;
				else if (mes != 2) max = 30;
				else if (anoBissexto(ano)) max = 29;
				else max = 28;
				if (ano == anos[0] && mes == meses[0]) min = dias[0];
				int dia = min + random.nextInt(max - min + 1);
				saida = saida + "	TO_DATE('" + dia + "/" + mes + "/" + ano + "', 'dd/MM/yyyy')";
			} else if (tipos[i].equalsIgnoreCase("PAIS")) saida = saida + "	'" + GeradorStrings.paisAleatorio() + "'";
			else if (tipos[i].equalsIgnoreCase("PROFISSAO")) saida = saida + "	'" + GeradorStrings.profissaoAleatoria() + "'";
			else if (tipos[i].equalsIgnoreCase("IDADE_ADULTO")) saida = saida + "	" + (18 + random.nextInt(47));
			else if (tipos[i].equalsIgnoreCase("IDADE_MENOR")) saida = saida + "	" + (0 + random.nextInt(18));
			else if (tipos[i].equalsIgnoreCase("IDADE_ADOLESCENTE")) saida = saida + "	" + (13 + random.nextInt(5));
			else if (tipos[i].equalsIgnoreCase("IDADE_CRIANCA")) saida = saida + "	" + (0 + random.nextInt(13));
			else if (tipos[i].substring(0, 4).equalsIgnoreCase("INT(")) {
				if (!tipos[i].endsWith(")")) throw new TipoInvalidoException(tipos[i]);
				if ((tipos[i].indexOf(',') == -1) || (tipos[i].indexOf(',') != tipos[i].lastIndexOf(','))) throw new TipoInvalidoException(tipos[i]);
				String[] valores = tipos[i].substring(4, tipos[i].length() - 1).split(",", 2);
				int min = Integer.parseInt(valores[0]), max = Integer.parseInt(valores[1]);
				saida = saida + "	" + (min + random.nextInt(max-min+1));
			} else if (tipos[i].equalsIgnoreCase("CHAVE_INT")) {
				saida = saida + "	" + chave;
				if (existeChave) throw new ChavesDemaisException();
				else existeChave = true;
			} else if (tipos[i].equalsIgnoreCase("CHAVE_STRING")) {
				saida = saida + "	'" + chave + "'";
				if (existeChave) throw new ChavesDemaisException();
				else existeChave = true;
			} else throw new TipoInvalidoException(tipos[i]);

			//Adiciona a virgula e a quebra de linha (p/ identação) ou fecha o INSERT INTO se for o último valor gerado
			if (i < tipos.length - 1) saida = saida + ",\n";
			else saida = saida + "\n);";
		}
		return saida;
	}
	
	private void checagemComandoData(String entrada) throws TipoInvalidoException, DataInvalidaException {
		if (!entrada.endsWith(")")) throw new TipoInvalidoException(entrada);
		if ((entrada.indexOf(',') == -1) || (entrada.indexOf(',') != entrada.lastIndexOf(','))) throw new TipoInvalidoException(entrada);
		String[] limite = entrada.substring(5, entrada.length()-1).split(",");
		if (!checagemFormatoData(limite[0]) || !checagemFormatoData(limite[1])) throw new DataInvalidaException(entrada);
	}

	private boolean checagemFormatoData(String data) {
		if (data.length() != 10) return false;
		if ((data.charAt(2) != '/') || (data.charAt(5) != '/')) return false;
		int ano = Integer.parseInt(data.substring(6));
		int mes = Integer.parseInt(data.substring(3, 5));
		int dia = Integer.parseInt(data.substring(0, 2));
		if (mes < 0 || mes > 12) return false;
		if (dia < 0 || dia > 31) return false;
		if (dia == 31 && !mes31Dias(mes)) return false;
		if (dia > 29 && mes == 2) return false;
		if (dia == 29 && mes == 2 && !anoBissexto(ano)) return false;
		return true;
	}
	
	private boolean mes31Dias(int mes) {
		if (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11) return false;
		return true;
	}
	
	private boolean anoBissexto(int ano) {
		if (ano % 400 == 0) return true;
		else if (ano % 100 == 0) return false;
		else if (ano % 4 == 0) return true;
		else return false;
	}

	private String removerEspacos(String entrada) {
		while (entrada.contains(" ")) {
			entrada = entrada.replace(" ", "");
		}
		return entrada;
	}
}
