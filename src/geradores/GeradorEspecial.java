package geradores;

public class GeradorEspecial extends GeradorAbstrato {
	private String comando;
	
	public GeradorEspecial(String comando) {
		this.comando = comando.substring(1, comando.length()-1);
	}
	
	public String gerar() {
		String[] saidas = comando.split(",");
		return MetodosGerador.escolhaAleatoria(saidas);
	}
}
