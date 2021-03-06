package povoadorSQL.povoamento;

import java.util.ArrayList;
import java.util.Random;

import povoadorSQL.exception.ChavesDemaisException;
import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.DataInvalidaException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.ParametroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;
import povoadorSQL.exception.QtdSaidasInvalidaException;
import povoadorSQL.exception.SemNomeException;
import povoadorSQL.geradores.*;
/**
 * Classe que produz povoamentos.
 * 
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public class Povoamento {
	/**
	 * Random utilizado pelos geradores.
	 */
	public static Random random = new Random();
	private String nomeTabela;
	private String parametros;
	private String[] tipos;
	private boolean modoOR;	//modoOR {true: Gera um povoadorSQL.povoamento OR; false: Gera um povoadorSQL.povoamento relacional}
	private int identacoes;
	private ArrayList<Integer> elementos;
	private PovoamentoVariaveis variaveis;

	/**
	 * Construtor de Povoamento. Recebe nome e comandos para produzir um povoador.
	 * @param nome Nome da tabela
	 * @param entrada Array com os comandos do povoamento
	 * @throws SemNomeException Se o nome da tabela estiver vazio
	 */
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
	
	/**
	 * Produz um povoamento com a quantidade dada de inser��es.
	 * @param qtd A quantidade de inser��es do povoamento
	 * @return Um povoamento completo de uma tabela
	 * @throws ChavesDemaisException Caso esteja gerando uma chave em um povoamento que j� teve uma chave gerada
	 * @throws ComandoInvalidoException Se houver algum erro na formata��o do comando
	 * @throws DataInvalidaException Se alguma data estiver mal formatada (4/5) ou n�o existir (30/02/2017)
	 * @throws NumeroInvalidoException Se alguma entrada n�o for um n�mero inteiro
	 * @throws ParametroInvalidoException Se alguma entrada tiver valor inv�lido para o gerador
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de par�metros diferente da correta para o comando
	 * @throws QtdSaidasInvalidaException Se a quantidade de sa�das for menor ou igual a 0
	 */
	public String povoar(int qtd) throws ChavesDemaisException, ComandoInvalidoException, DataInvalidaException, NumeroInvalidoException,
			ParametroInvalidoException, QtdParametrosInvalidaException, QtdSaidasInvalidaException {
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

	private String gerarInsercao(String chave) throws ChavesDemaisException, ComandoInvalidoException, DataInvalidaException,
			NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
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
	
	//Checa o comando e o executa se ele for reconhecido ou lan�a exce��es se houver algum erro
	private String executarComando(String comando, PovoamentoVariaveis variaveis) throws ChavesDemaisException, ComandoInvalidoException,
			DataInvalidaException, NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
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
		else if (GeradorEstado.checarComando(comando)) return gerar(new GeradorEstado());
		else if (GeradorEstadoSigla.checarComando(comando)) return gerar(new GeradorEstadoSigla());
		else if (GeradorIdadeAdolescente.checarComando(comando)) return gerar(new GeradorIdadeAdolescente());
		else if (GeradorIdadeAdulto.checarComando(comando)) return gerar(new GeradorIdadeAdulto());
		else if (GeradorIdadeCrianca.checarComando(comando)) return gerar(new GeradorIdadeCrianca());
		else if (GeradorIdadeMenor.checarComando(comando)) return gerar(new GeradorIdadeMenor());
		else if (GeradorInt.checarComando(comando)) return gerar(new GeradorInt(comando));
		else if (GeradorNome.checarComando(comando)) return gerar(new GeradorNome(variaveis));
		else if (GeradorPais.checarComando(comando)) return gerar(new GeradorPais());
		else if (GeradorPlaca.checarComando(comando)) return gerar(new GeradorPlaca());
		else if (GeradorProfissao.checarComando(comando)) return gerar(new GeradorProfissao(variaveis));
		else if (GeradorReferencia.checarComando(comando)) return gerar(new GeradorReferencia(comando));
		else if (GeradorSexo.checarComando(comando)) return gerar(new GeradorSexo(variaveis));
		else if (GeradorEspecial.checarComando(comando)) return gerar(new GeradorEspecial(comando));
		else if (GeradorLinguagemRegular.checarComando(comando)) return gerar(new GeradorLinguagemRegular(comando));
		else if (MetodosGerador.checarComando(comando, "TIPO")) return gerarTipo(comando);
		else throw new ComandoInvalidoException(comando);
	}
	
	/* Caso o povoamento esteja preenchendo um tipo OR, conta os elementos do tipo que
	 * ainda precisam ser gerados e os fecha se j� tiver terminado de preench�-los
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
	
	//Adiciona a virgula e a quebra de linha (p/ identa��o) ou fecha o INSERT INTO se for o �ltimo valor gerado
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
	private String gerar(GeradorAbstrato gerador) throws ChavesDemaisException, ComandoInvalidoException, DataInvalidaException,
			NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException {
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