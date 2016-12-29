package geradores.varchar;

public class GeradorCelularDddFormatado extends GeradorCelularFormatado {
	public GeradorCelularDddFormatado() {}
	
	public String gerar() {
		return "("+gerarSequenciaDigitos(2)+")"+super.gerar();
	}
}
