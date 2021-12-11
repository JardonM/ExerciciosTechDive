package exception;

public class LimiteInsuficienteException extends RuntimeException{
    public LimiteInsuficienteException() {
        super("Limite insuficiente.");
    }
}
