package geradores;

import java.util.ArrayList;
import java.util.Random;

import exception.ComandoInvalidoException;
import geradores.data.*;
import geradores.numero.*;
import geradores.varchar.*;
import exception.QtdSaidasInvalidaException;
import exception.SemNomeException;

public class Povoamento {
	public static Random random = new Random();
	private String nomeTabela;
	private String parametros;
	private String[] tipos;
	private boolean modoOR;	//modoOR {true: Gera um povoamento OR; false: Gera um povoamento relacional}
	private int identacoes;
	private ArrayList<Integer> elementos;

	public Povoamento(String nome, String[] entrada) throws SemNomeException {
		if (nome.equals("")) throw new SemNomeException();
		nomeTabela = nome.toLowerCase();
		parametros = "(";
		tipos = new String[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			String[] param = entrada[i].split(" ", 2);
			tipos[i] = removerEspacos(param[1]);
			//Caso especial do comando TIPO
			if (checarComando(tipos[i], "TIPO")) {
				tipos[i] = "TIPO(" + removerParagrafos(param[0].toLowerCase()) + "," + tipos[i].substring(5);
				modoOR = true;
			} else {
				parametros = parametros + param[0].toLowerCase();
				if (i < entrada.length-1) parametros = parametros + ", ";
			}
		}
		parametros = parametros + ")";
		elementos = new ArrayList<Integer>();
	}

	public String povoar(int qtd) throws Exception {
		if (qtd <= 0) throw new QtdSaidasInvalidaException();
		String saida = "";
		for (int i = 0; i < qtd; i++) {
			String insercao = this.gerarInsercao(i + "");
			saida += insercao + "\n\n";
		}
		return saida;
	}
	
	private String removerParagrafos(String entrada) {
		return entrada.replace("	", "");
	}

	private String gerarInsercao(String chave) throws Exception {
		String saida = "INSERT INTO " + nomeTabela + " ";
		saida += modoOR ? ("VALUES (\n") : (parametros + " VALUES (\n") ;
		PovoamentoVariaveis variaveis = new PovoamentoVariaveis();	//Variaveis para evitar inconsistencias
		for (int i = 0; i < tipos.length; i++) {
			if (checarComando(tipos[i], "CELULAR")) saida += gerarVarchar(new GeradorCelular());
			else if (checarComando(tipos[i], "CELULAR_DDD")) saida += gerarVarchar(new GeradorCelularDdd());
			else if (checarComando(tipos[i], "CELULAR_FORMATADO")) saida += gerarVarchar(new GeradorCelularFormatado());
			else if (checarComando(tipos[i], "CELULAR_FORMATADO_DDD")) saida += gerarVarchar(new GeradorCelularDddFormatado());
			else if (checarComando(tipos[i], "CEP")) saida += gerarVarchar(new GeradorCep());
			else if (checarComando(tipos[i], "CHAVE_INT")) saida += gerar(new GeradorChave(variaveis, chave));
			else if (checarComando(tipos[i], "CHAVE_STRING")) saida += gerarVarchar(new GeradorChave(variaveis, chave));
			else if (checarComando(tipos[i], "CPF")) saida += gerarVarchar(new GeradorCpf());
			else if (checarComando(tipos[i], "CPF_FORMATADO")) saida += gerarVarchar(new GeradorCpfFormatado());
			else if (checarComando(tipos[i], "DATA")) saida += gerar(new GeradorData(tipos[i]));
			else if (checarComando(tipos[i], "EMAIL")) saida += gerarVarchar(new GeradorEmail(variaveis));
			else if (checarComando(tipos[i], "IDADE_ADOLESCENTE")) saida += gerar(new GeradorIdadeAdolescente());
			else if (checarComando(tipos[i], "IDADE_ADULTO")) saida += gerar(new GeradorIdadeAdulto());
			else if (checarComando(tipos[i], "IDADE_CRIANCA")) saida += gerar(new GeradorIdadeCrianca());
			else if (checarComando(tipos[i], "IDADE_MENOR")) saida += gerar(new GeradorIdadeMenor());
			else if (checarComando(tipos[i], "INT")) saida += gerar(new GeradorInt(tipos[i]));
			else if (checarComando(tipos[i], "NOME")) saida += gerarVarchar(new GeradorNome(variaveis));
			else if (checarComando(tipos[i], "PAIS")) saida += gerarVarchar(new GeradorPais());
			else if (checarComando(tipos[i], "PROFISSAO")) saida += gerarVarchar(new GeradorProfissao());
			else if (checarComando(tipos[i], "SEXO")) saida += gerarVarchar(new GeradorSexo(variaveis));
			else if ((tipos[i].charAt(0) == '{') && (tipos[i].charAt(tipos[i].length()-1) == '}')) saida += gerar(new GeradorEspecial(tipos[i]));
			else if (checarComando(tipos[i], "TIPO")) saida += gerarTipo(tipos[i]);
			else throw new ComandoInvalidoException(tipos[i]);

			//Conta os elementos do tipo para saber se todos já foram gerados
			while (elementos.size() > 0 && !checarComando(tipos[i], "TIPO")) {
				elementos.set(elementos.size()-1, elementos.get(elementos.size()-1) - 1);
				if (elementos.get(elementos.size()-1) <= 0) {
					elementos.remove(elementos.size()-1);
					saida += "\n" + "	" + identar(--identacoes) + ")";
				} else break;
			}

			//Adiciona a virgula e a quebra de linha (p/ identação) ou fecha o INSERT INTO se for o último valor gerado
			if (checarComando(tipos[i], "TIPO")) saida += "\n";
			else if (i < tipos.length - 1) saida += ",\n";
			else saida += "\n);";
		}
		return saida;
	}

	private String removerEspacos(String entrada) {
		entrada = removerEspacosCaractere(entrada, '(');
		entrada = removerEspacosCaractere(entrada, ',');
		entrada = removerEspacosCaractere(entrada, ')');
		return entrada;
	}

	private String removerEspacosCaractere(String entrada, char c) {
		while (entrada.contains(" " + c)) {
			entrada = entrada.replace(" " + c, "" + c);
		}
		while (entrada.contains(c + " ")) {
			entrada = entrada.replace(c + " ", c + "");
		}
		return entrada;
	}

	private boolean checarComando(String entrada, String comando) {
		if (entrada.equalsIgnoreCase(comando)) return true;
		else if (entrada.length() > comando.length()) return (entrada.substring(0, comando.length()+1).equalsIgnoreCase(comando + "("));
		return false;
	}

	private String gerarVarchar(GeradorAbstrato gerador) throws Exception {
		return identar(identacoes) + "	'" + gerador.gerar() + "'";
	}

	//Metodo para gerar entradas que nao sejam varchars
	private String gerar(GeradorAbstrato gerador) throws Exception {
		return identar(identacoes) + "	" + gerador.gerar();
	}

	private String gerarTipo(String comando) {
		identacoes++;
		String[] parametros = comando.substring(5, comando.length()-1).split(",");
		elementos.add(Integer.parseInt(parametros[1]));
		return identar(identacoes-1) + "	" + parametros[0] + "(";
	}

	private String identar(int tabulacoes) {
		String saida = "";
		while (tabulacoes-- > 0) {
			saida += "	";
		}
		return saida;
	}
}
