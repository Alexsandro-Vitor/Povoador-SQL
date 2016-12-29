package geradores.varchar;

public class GeradorCelularDdd extends GeradorCelular {
	public GeradorCelularDdd() {}
	
	public String gerar() {
		return gerarSequenciaDigitos(2) + super.gerar();
	}
}
