package povoamento;

import java.util.ArrayList;
import java.util.Random;

import exception.ComandoInvalidoException;
import geradores.*;
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
			if (MetodosGerador.checarComando(tipos[i], "TIPO")) {
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
			if (GeradorCelular.checarComando(tipos[i])) saida += gerar(new GeradorCelular());
			else if (GeradorCelularDdd.checarComando(tipos[i])) saida += gerar(new GeradorCelularDdd());
			else if (GeradorCelularDddFormatado.checarComando(tipos[i])) saida += gerar(new GeradorCelularDddFormatado());
			else if (GeradorCelularFormatado.checarComando(tipos[i])) saida += gerar(new GeradorCelularFormatado());
			else if (GeradorCep.checarComando(tipos[i])) saida += gerar(new GeradorCep());
			else if (GeradorChave.checarComando(tipos[i])) saida += gerar(new GeradorChave(tipos[i], variaveis, chave));
			else if (GeradorCpf.checarComando(tipos[i])) saida += gerar(new GeradorCpf());
			else if (GeradorCpfFormatado.checarComando(tipos[i])) saida += gerar(new GeradorCpfFormatado());
			else if (GeradorData.checarComando(tipos[i])) saida += gerar(new GeradorData(tipos[i]));
			else if (GeradorDecimal.checarComando(tipos[i])) saida += gerar(new GeradorDecimal(tipos[i]));
			else if (GeradorEmail.checarComando(tipos[i])) saida += gerar(new GeradorEmail(variaveis));
			else if (GeradorIdadeAdolescente.checarComando(tipos[i])) saida += gerar(new GeradorIdadeAdolescente());
			else if (GeradorIdadeAdulto.checarComando(tipos[i])) saida += gerar(new GeradorIdadeAdulto());
			else if (GeradorIdadeCrianca.checarComando(tipos[i])) saida += gerar(new GeradorIdadeCrianca());
			else if (GeradorIdadeMenor.checarComando(tipos[i])) saida += gerar(new GeradorIdadeMenor());
			else if (GeradorInt.checarComando(tipos[i])) saida += gerar(new GeradorInt(tipos[i]));
			else if (GeradorNome.checarComando(tipos[i])) saida += gerar(new GeradorNome(variaveis));
			else if (GeradorPais.checarComando(tipos[i])) saida += gerar(new GeradorPais());
			else if (GeradorProfissao.checarComando(tipos[i])) saida += gerar(new GeradorProfissao());
			else if (GeradorReferencia.checarComando(tipos[i])) saida += gerar(new GeradorReferencia(tipos[i]));
			else if (GeradorSexo.checarComando(tipos[i])) saida += gerar(new GeradorSexo(variaveis));
			else if (GeradorEspecial.checarComando(tipos[i])) saida += gerar(new GeradorEspecial(tipos[i]));
			else if (MetodosGerador.checarComando(tipos[i], "TIPO")) saida += gerarTipo(tipos[i]);
			else throw new ComandoInvalidoException(tipos[i]);

			//Conta os elementos do tipo para saber se todos já foram gerados
			while (elementos.size() > 0 && !MetodosGerador.checarComando(tipos[i], "TIPO")) {
				elementos.set(elementos.size()-1, elementos.get(elementos.size()-1) - 1);
				if (elementos.get(elementos.size()-1) <= 0) {
					elementos.remove(elementos.size()-1);
					saida += "\n" + "	" + identar(--identacoes) + ")";
				} else break;
			}

			//Adiciona a virgula e a quebra de linha (p/ identação) ou fecha o INSERT INTO se for o último valor gerado
			if (MetodosGerador.checarComando(tipos[i], "TIPO")) saida += "\n";
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
