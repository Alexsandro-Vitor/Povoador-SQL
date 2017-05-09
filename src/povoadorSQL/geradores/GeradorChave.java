package povoadorSQL.geradores;

import povoadorSQL.exception.ChavesDemaisException;
import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;
import povoadorSQL.povoamento.PovoamentoVariaveis;

/**
 * Classe que gera chaves, formatadas como n�mero ou texto.
 * 
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorChave extends GeradorAbstrato {
	private String comando;
	private PovoamentoVariaveis variaveis;
	
	/**
	 * 1� metade do comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "CHAVE";
	
	/**
	 * 2� metade do comando para usar esta classe. Quando usado, gera uma entrada inteira.
	 */
	public static final String INTEIRO = "_INT";
	
	/**
	 * 2� metade do comando para usar esta classe. Quando usado, gera uma entrada VARCHAR.
	 */
	public static final String VARCHAR = "_VARCHAR";

	/**
	 * Checa se o comando recebido � o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se n�o for
	 */
	public static boolean checarComando(String entrada) {
		return entrada.toUpperCase().startsWith(NOME_COMANDO) && entrada.endsWith(")");
	}

	/**
	 * Construtor do gerador de chaves, recebe uma string com o comando e as vari�veis do povoamento.
	 * @param comando O comando para executar o m�todo gerar
	 * @param variaveis Contem a informa��o da exist�ncia ou n�o de outras chaves geradas no povoadorSQL.povoamento e de onde deve come�ar a contagem das chaves
	 */
	public GeradorChave(String comando, PovoamentoVariaveis variaveis) {
		this.comando = comando;
		this.variaveis = variaveis;
	}

	/**
	 * Gera uma chave para o povoamento.
	 * @return Um n�mero que pode ou n�o estar entre aspas simples, dependendo do comando
	 * @throws ComandoInvalidoException Se o comando n�o tiver "_INT" ou "_VARCHAR" ap�s "CHAVE"
	 * @throws ChavesDemaisException Caso esteja gerando uma chave em um povoadorSQL.povoamento que j� teve uma chave gerada
	 * @throws QtdParametrosInvalidaException Se houver mais de um valor entre os par�nteses
	 * @throws NumeroInvalidoException Se o parametro dado n�o for um n�mero inteiro
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
