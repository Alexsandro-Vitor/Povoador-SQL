package povoadorSQL.geradores;

import povoadorSQL.exception.ChavesDemaisException;
import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;
import povoadorSQL.povoamento.PovoamentoVariaveis;

/**
 * Classe que gera chaves, formatadas como número ou texto.
 * 
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorChave extends GeradorAbstrato {
	private String comando;
	private PovoamentoVariaveis variaveis;
	
	/**
	 * 1ª metade do comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CHAVE";
	
	/**
	 * 2ª metade do comando para usar esta classe. Quando usado, gera uma entrada inteira.
	 */
	public static final String INTEIRO = "_INT";
	
	/**
	 * 2ª metade do comando para usar esta classe. Quando usado, gera uma entrada VARCHAR.
	 */
	public static final String VARCHAR = "_VARCHAR";

	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return entrada.toUpperCase().startsWith(NOME_COMANDO) && entrada.endsWith(")");
	}

	/**
	 * Construtor do gerador de chaves, recebe uma string com o comando e as variáveis do povoamento.
	 * @param comando O comando para executar o método gerar
	 * @param variaveis Contem a informação da existência ou não de outras chaves geradas no povoadorSQL.povoamento e de onde deve começar a contagem das chaves
	 */
	public GeradorChave(String comando, PovoamentoVariaveis variaveis) {
		this.comando = comando;
		this.variaveis = variaveis;
	}

	/**
	 * Gera uma chave para o povoamento.
	 * @return Um número que pode ou não estar entre aspas simples, dependendo do comando
	 * @throws ComandoInvalidoException Se o comando não tiver "_INT" ou "_VARCHAR" após "CHAVE"
	 * @throws ChavesDemaisException Caso esteja gerando uma chave em um povoadorSQL.povoamento que já teve uma chave gerada
	 * @throws QtdParametrosInvalidaException Se houver mais de um valor entre os parênteses
	 * @throws NumeroInvalidoException Se o parametro dado não for um número inteiro
	 */
	public String gerar() throws ComandoInvalidoException, ChavesDemaisException, QtdParametrosInvalidaException, NumeroInvalidoException {
		if (variaveis.existeChave) throw new ChavesDemaisException();
		else {
			variaveis.existeChave = true;
			String tipoChave = comando.substring(NOME_COMANDO.length());
			try {
				if (tipoChave.toUpperCase().startsWith(VARCHAR)) {
					return MetodosGerador.varchar("" + (Integer.parseInt(MetodosGerador.validarSintaxe(tipoChave, VARCHAR.length(), 1)[0])
							+ Integer.parseInt(variaveis.chave)));
				} else if (tipoChave.toUpperCase().startsWith(INTEIRO)) {
					return "" + (Integer.parseInt(MetodosGerador.validarSintaxe(tipoChave, INTEIRO.length(), 1)[0])
							+ Integer.parseInt(variaveis.chave));
				} else throw new ComandoInvalidoException(comando);
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(MetodosGerador.validarSintaxe(tipoChave, VARCHAR.length(), 1)[0], tipoChave);
			}
		}
	}
}
