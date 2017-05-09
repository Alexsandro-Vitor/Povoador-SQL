package povoadorSQL.geradores;

import povoadorSQL.exception.ChavesDemaisException;
import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.DataInvalidaException;
import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.exception.ParametroInvalidoException;
import povoadorSQL.exception.QtdParametrosInvalidaException;

/**
 * Classe abstrata da qual todas as classes geradoras herdam.
 *
 * @author Alexsandro V�tor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public abstract class GeradorAbstrato {
	/**
	 * M�todo dos geradores respons�vel por retornar valores para o povoamento.
	 * @return Uma entrada para o povoamento
	 * @throws ChavesDemaisException Caso esteja gerando uma chave em um povoamento que j� teve uma chave gerada
	 * @throws ComandoInvalidoException Se houver algum erro na formata��o do comando
	 * @throws DataInvalidaException Se alguma data estiver mal formatada (4/5) ou n�o existir (30/02/2017)
	 * @throws NumeroInvalidoException Se alguma entrada n�o for um n�mero inteiro
	 * @throws ParametroInvalidoException Se alguma entrada tiver valor inv�lido para o gerador
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de par�metros diferente da correta para o comando
	 */
	public abstract String gerar() throws ChavesDemaisException, ComandoInvalidoException, DataInvalidaException,
			NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException;
}
