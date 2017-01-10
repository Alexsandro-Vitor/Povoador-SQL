package geradores;

import exception.ComandoInvalidoException;

public class GeradorEspecial extends GeradorAbstrato {
	private String comando;
	
	public static boolean checarComando(String entrada) {
		return (entrada.startsWith("{") && entrada.endsWith("}"));
	}
	
	public GeradorEspecial(String comando) {
		this.comando = comando.substring(1, comando.length() - 1);
	}
	
	public String gerar() throws ComandoInvalidoException {
		validar();
		String[] saidas = comando.split(",");
		return MetodosGerador.escolhaAleatoria(saidas);
	}
	
	private void validar() throws ComandoInvalidoException {
		if (comando.contains("{") || comando.contains("}")) throw new ComandoInvalidoException("{" + comando + "}");
	}
}
