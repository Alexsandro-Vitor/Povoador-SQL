package geradores;

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
			else throw new ComandoInvalidoException(tipos[i]);

			//Adiciona a virgula e a quebra de linha (p/ identa��o) ou fecha o INSERT INTO se for o �ltimo valor gerado
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
	
	private boolean checarComando(String entrada, String comando) {
		if (entrada.equalsIgnoreCase(comando)) return true;
		else if (entrada.length() > comando.length()) return (entrada.substring(0, comando.length()+1).equalsIgnoreCase(comando + "("));
		return false;
	}
	
	private String gerarVarchar(GeradorAbstrato gerador) throws Exception {
		return "	'" + gerador.gerar() + "'";
	}
	
	//Metodo para gerar entradas que nao sejam varchars
	private String gerar(GeradorAbstrato gerador) throws Exception {
		return "	" + gerador.gerar();
	}
}
