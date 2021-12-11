package exception;

public class SaqueInvalidoException extends RuntimeException{
    public SaqueInvalidoException() {
        super("Saldo insuficiente.");
    }
}
