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
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 * @since v0.1.0
 */
public abstract class GeradorAbstrato {
	/**
	 * Método dos geradores responsável por retornar valores para o povoamento.
	 * @return Uma entrada para o povoamento
	 * @throws ChavesDemaisException Caso esteja gerando uma chave em um povoamento que já teve uma chave gerada
	 * @throws ComandoInvalidoException Se houver algum erro na formatação do comando
	 * @throws DataInvalidaException Se alguma data estiver mal formatada (4/5) ou não existir (30/02/2017)
	 * @throws NumeroInvalidoException Se alguma entrada não for um número inteiro
	 * @throws ParametroInvalidoException Se alguma entrada tiver valor inválido para o gerador
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de parâmetros diferente da correta para o comando
	 */
	public abstract String gerar() throws ChavesDemaisException, ComandoInvalidoException, DataInvalidaException,
			NumeroInvalidoException, ParametroInvalidoException, QtdParametrosInvalidaException;
}
