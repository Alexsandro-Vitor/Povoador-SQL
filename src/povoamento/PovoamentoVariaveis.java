package povoamento;

import geradores.MetodosGerador;

public class PovoamentoVariaveis {
	public byte sexo = 0;
	public static final byte MASCULINO = 1;
	public static final byte FEMININO = 2;
	
	public boolean existeChave = false;
	public String nome = null;
	public String email = null;
	public String chave;
	
	public PovoamentoVariaveis(String chave) {
		this.chave = chave;
	}
	
	public void definirSexo() {
		if (sexo == 0) sexo = (byte)MetodosGerador.intAleatorio(1, 3);
	}
}
