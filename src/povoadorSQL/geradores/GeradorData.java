package povoadorSQL.geradores;

import povoadorSQL.exception.ComandoInvalidoException;
import povoadorSQL.exception.DataInvalidaException;
import povoadorSQL.exception.QtdParametrosInvalidaException;
import povoadorSQL.povoamento.Povoamento;

/**
 * Classe que gera entradas de data.
 *
 * @author Alexsandro Vítor Serafim de Carvalho - avsc@cin.ufpe.br
 */
public class GeradorData extends GeradorAbstrato {
	private String comando;
	
	/**
	 * O comando para usar esta classe.
	 */
	public static final String NOME_COMANDO = "DATA";
	
	/**
	 * Checa se o comando recebido é o comando desta classe.
	 * @param entrada Comando a ser checado
	 * @return true se o comando for o correto, false se não for
	 */
	public static boolean checarComando(String entrada) {
		return MetodosGerador.checarComando(entrada, NOME_COMANDO);
	}
	
	/**
	 * Construtor de GeradorData, recebe um comando que contém as datas mínima e máxima que devem ser geradas.
	 * @param comando Contém as datas limite para gerar uma data
	 */
	public GeradorData(String comando) {
		this.comando = comando;
	}
	
	/**
	 * Gera uma data na forma TO_DATE('[dia]/[mes]/[ano]', 'dd/MM/yyyy').
	 * @return Uma data, com dia, mês e ano
	 * @throws ComandoInvalidoException Se houverem parênteses faltando no comando
	 * @throws DataInvalidaException Se alguma data estiver mal formatada (4/5) ou não existir (30/02/2017)
	 * @throws QtdParametrosInvalidaException Se houver uma quantidade de parâmetros diferente de 2
	 */
	public String gerar() throws ComandoInvalidoException, DataInvalidaException, QtdParametrosInvalidaException {
		checagemComandoData(comando);
		String[] limite = comando.substring(5, comando.length()-1).split(",");
		int[] anos = {Integer.parseInt(limite[0].substring(6)), Integer.parseInt(limite[1].substring(6))};
		int[] meses = {Integer.parseInt(limite[0].substring(3, 5)), Integer.parseInt(limite[1].substring(3, 5))};
		int[] dias = {Integer.parseInt(limite[0].substring(0, 2)), Integer.parseInt(limite[1].substring(0, 2))};
		return retornarData(dias, meses, anos);
	}
	
	private void checagemComandoData(String entrada) throws ComandoInvalidoException, DataInvalidaException, QtdParametrosInvalidaException {
		if (!entrada.endsWith(")")) throw new ComandoInvalidoException(entrada);
		if ((entrada.indexOf(',') == -1) || (entrada.indexOf(',') != entrada.lastIndexOf(','))) throw new QtdParametrosInvalidaException(entrada, 2);
		String[] limite = entrada.substring(5, entrada.length()-1).split(",");
		if (!checagemFormatoData(limite[0]) || !checagemFormatoData(limite[1])) throw new DataInvalidaException(entrada);
	}
	
	private boolean checagemFormatoData(String data) {
		if (data.length() != 10) return false;
		if ((data.charAt(2) != '/') || (data.charAt(5) != '/')) return false;
		int ano = Integer.parseInt(data.substring(6));
		int mes = Integer.parseInt(data.substring(3, 5));
		int dia = Integer.parseInt(data.substring(0, 2));
		if (mes < 0 || mes > 12) return false;
		if (dia < 0 || dia > 31) return false;
		if (dia == 31 && !mes31Dias(mes)) return false;
		if (dia > 29 && mes == 2) return false;
		if (dia == 29 && mes == 2 && !anoBissexto(ano)) return false;
		return true;
	}
	
	private String retornarData(int[] dias, int[] meses, int[] anos) {
		int ano = gerarAno(anos[0], anos[1]);
		int mes = gerarMes(meses[0], meses[1], anos[0], ano, anos[1]);
		int min = diaMinimo(dias[0], mes, meses[0], ano, anos[0]);
		int max = diaMaximo(dias[1], mes, meses[1], ano, anos[1]);
		int dia = min + Povoamento.random.nextInt(max - min + 1);
		return "TO_DATE('" + dia + "/" + mes + "/" + ano + "', 'dd/MM/yyyy')";
	}
	
	private int gerarAno(int anoMin, int anoMax) {
		return anoMin + Povoamento.random.nextInt(anoMax - anoMin + 1);
	}
	
	private int gerarMes(int mesMin, int mesMax, int anoMin, int ano, int anoMax) {
		int min = (ano == anoMin) ? mesMin : 1;
		int max = (ano == anoMax) ? mesMax : 12;
		return min + Povoamento.random.nextInt(max - min + 1);
	}
	
	private int diaMinimo(int diaMin, int mes, int mesMin, int ano, int anoMin) {
		return (ano == anoMin && mes == mesMin) ? diaMin : 1;
	}
	
	private int diaMaximo(int diaMax, int mes, int mesMax, int ano, int anoMax) {
		if (ano == anoMax && mes == mesMax) return diaMax;
		else if (mes31Dias(mes)) return 31;
		else if (mes != 2) return 30;
		else if (anoBissexto(ano)) return 29;
		return 28;
	}
	
	private boolean mes31Dias(int mes) {
		if (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11) return false;
		return true;
	}
	
	private boolean anoBissexto(int ano) {
		if (ano % 400 == 0) return true;
		else if (ano % 100 == 0) return false;
		else if (ano % 4 == 0) return true;
		else return false;
	}
}
