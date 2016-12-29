package geradores;

import java.util.Random;

import exception.TipoInvalidoException;
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
	public Povoamento(String nome, String[] entrada) throws SemNomeException {
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
		PovoamentoVariaveis variaveis = new PovoamentoVariaveis();	//Variaveis para evitar inconsistencias
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].equalsIgnoreCase("CELULAR")) saida += gerarVarchar(new GeradorCelular());
			else if (tipos[i].equalsIgnoreCase("CELULAR_DDD")) saida += gerarVarchar(new GeradorCelularDdd());
			else if (tipos[i].equalsIgnoreCase("CELULAR_FORMATADO")) saida += gerarVarchar(new GeradorCelularFormatado());
			else if (tipos[i].equalsIgnoreCase("CELULAR_FORMATADO_DDD")) saida += gerarVarchar(new GeradorCelularDddFormatado());
			else if (tipos[i].equalsIgnoreCase("CEP")) saida += gerarVarchar(new GeradorCep());
			else if (tipos[i].equalsIgnoreCase("CHAVE_INT")) saida += gerar(new GeradorChave(variaveis, chave));
			else if (tipos[i].equalsIgnoreCase("CHAVE_STRING")) saida += gerarVarchar(new GeradorChave(variaveis, chave));
			else if (tipos[i].equalsIgnoreCase("CPF")) saida += gerarVarchar(new GeradorCpf());
			else if (tipos[i].equalsIgnoreCase("CPF_FORMATADO")) saida += gerarVarchar(new GeradorCpfFormatado());
			else if (tipos[i].substring(0, 5).equalsIgnoreCase("DATA(")) saida += gerar(new GeradorData(tipos[i]));
			else if (tipos[i].equalsIgnoreCase("EMAIL")) saida += gerarVarchar(new GeradorEmail(variaveis));
			else if (tipos[i].equalsIgnoreCase("IDADE_ADOLESCENTE")) saida += gerar(new GeradorIdadeAdolescente());
			else if (tipos[i].equalsIgnoreCase("IDADE_ADULTO")) saida += gerar(new GeradorIdadeAdulto());
			else if (tipos[i].equalsIgnoreCase("IDADE_CRIANCA")) saida += gerar(new GeradorIdadeCrianca());
			else if (tipos[i].equalsIgnoreCase("IDADE_MENOR")) saida += gerar(new GeradorIdadeMenor());
			else if (tipos[i].substring(0, 4).equalsIgnoreCase("INT(")) saida += gerar(new GeradorInt(tipos[i]));
			else if (tipos[i].equalsIgnoreCase("NOME")) saida += gerarVarchar(new GeradorNome(variaveis));
			else if (tipos[i].equalsIgnoreCase("PAIS")) saida += gerarVarchar(new GeradorPais());
			else if (tipos[i].equalsIgnoreCase("PROFISSAO")) saida += gerarVarchar(new GeradorProfissao());
			else if (tipos[i].equalsIgnoreCase("SEXO")) saida += gerarVarchar(new GeradorSexo(variaveis));
			else throw new TipoInvalidoException(tipos[i]);

			//Adiciona a virgula e a quebra de linha (p/ identação) ou fecha o INSERT INTO se for o último valor gerado
			if (i < tipos.length - 1) saida += ",\n";
			else saida = saida + "\n);";
		}
		return saida;
	}

	private String removerEspacos(String entrada) {
		while (entrada.contains(" ")) {
			entrada = entrada.replace(" ", "");
		}
		return entrada;
	}
	
	private String gerarVarchar(GeradorAbstrato gerador) throws Exception {
		return "	'" + gerador.gerar() + "'";
	}
	
	//Metodo para gerar entradas que nao sejam varchars
	private String gerar(GeradorAbstrato gerador) throws Exception {
		return "	" + gerador.gerar();
	}
}
