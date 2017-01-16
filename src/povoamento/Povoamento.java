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
	public PovoamentoVariaveis variaveis;

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
				tipos[i] = "TIPO(" + removerParagrafos(param[0]) + "," + tipos[i].substring(5);
				modoOR = true;
			} else {
				parametros += removerParagrafos(param[0]);
				if (i < entrada.length-1) parametros = parametros + ", ";
			}
		}
		parametros += ")";
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
		return entrada.toLowerCase().replace("	", "");
	}

	private String gerarInsercao(String chave) throws Exception {
		String saida = "INSERT INTO " + nomeTabela + " ";
		saida += modoOR ? ("VALUES (\n") : (parametros + " VALUES (\n") ;
		variaveis = new PovoamentoVariaveis(chave);	//Variaveis para evitar inconsistencias
		for (int i = 0; i < tipos.length; i++) {
			saida += executarComando(tipos[i], variaveis);
			if (!MetodosGerador.checarComando(tipos[i], "TIPO")) saida += contarElementosTipo();
			saida += quebraLinhaInsercao(i);
		}
		return saida;
	}
	
	//Checa o comando e o executa se ele for reconhecido ou lança exceções se houver algum erro
	public String executarComando(String comando, PovoamentoVariaveis variaveis) throws Exception {
		if (GeradorCelular.checarComando(comando)) return gerar(new GeradorCelular());
		else if (GeradorCelularDdd.checarComando(comando)) return gerar(new GeradorCelularDdd());
		else if (GeradorCelularDddFormatado.checarComando(comando)) return gerar(new GeradorCelularDddFormatado());
		else if (GeradorCelularFormatado.checarComando(comando)) return gerar(new GeradorCelularFormatado());
		else if (GeradorCep.checarComando(comando)) return gerar(new GeradorCep());
		else if (GeradorChave.checarComando(comando)) return gerar(new GeradorChave(comando, variaveis));
		else if (GeradorCnpj.checarComando(comando)) return gerar(new GeradorCnpj());
		else if (GeradorCpf.checarComando(comando)) return gerar(new GeradorCpf());
		else if (GeradorCpfFormatado.checarComando(comando)) return gerar(new GeradorCpfFormatado());
		else if (GeradorData.checarComando(comando)) return gerar(new GeradorData(comando));
		else if (GeradorDecimal.checarComando(comando)) return gerar(new GeradorDecimal(comando));
		else if (GeradorEmail.checarComando(comando)) return gerar(new GeradorEmail(variaveis));
		else if (GeradorIdadeAdolescente.checarComando(comando)) return gerar(new GeradorIdadeAdolescente());
		else if (GeradorIdadeAdulto.checarComando(comando)) return gerar(new GeradorIdadeAdulto());
		else if (GeradorIdadeCrianca.checarComando(comando)) return gerar(new GeradorIdadeCrianca());
		else if (GeradorIdadeMenor.checarComando(comando)) return gerar(new GeradorIdadeMenor());
		else if (GeradorInt.checarComando(comando)) return gerar(new GeradorInt(comando));
		else if (GeradorNome.checarComando(comando)) return gerar(new GeradorNome(variaveis));
		else if (GeradorPais.checarComando(comando)) return gerar(new GeradorPais());
		else if (GeradorProfissao.checarComando(comando)) return gerar(new GeradorProfissao());
		else if (GeradorReferencia.checarComando(comando)) return gerar(new GeradorReferencia(comando));
		else if (GeradorSexo.checarComando(comando)) return gerar(new GeradorSexo(variaveis));
		else if (GeradorEspecial.checarComando(comando)) return gerar(new GeradorEspecial(comando));
		else if (GeradorLinguagemRegular.checarComando(comando)) return gerar(new GeradorLinguagemRegular(comando));
		else if (MetodosGerador.checarComando(comando, "TIPO")) return gerarTipo(comando);
		else throw new ComandoInvalidoException(comando);
	}
	
	/*Caso o povoamento esteja preenchendo um tipo OR, conta os elementos do tipo que
	 * ainda precisam ser gerados e os fecha se já tiver terminado de preenchê-los
	 */
	private String contarElementosTipo() {
		String saida = "";
		while (elementos.size() > 0) {
			elementos.set(elementos.size() - 1, elementos.get(elementos.size() - 1) - 1);
			if (elementos.get(elementos.size() - 1) <= 0) {
				elementos.remove(elementos.size() - 1);
				saida += "\n" + "	" + identar(--identacoes) + ")";
			} else break;
		}
		return saida;
	}
	
	//Adiciona a virgula e a quebra de linha (p/ identação) ou fecha o INSERT INTO se for o último valor gerado
	private String quebraLinhaInsercao(int comando) {
		if (MetodosGerador.checarComando(tipos[comando], "TIPO")) return "\n";
		else if (comando < tipos.length - 1) return ",\n";
		return "\n);";
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

	//Metodo para gerar entradas identadas
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