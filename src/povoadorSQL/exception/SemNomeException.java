package povoadorSQL.exception;

public class SemNomeException extends Exception {
	public SemNomeException() {
		super("O nome da tabela precisa ser preenchido");
	}
}