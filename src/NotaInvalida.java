public class NotaInvalida extends RuntimeException {
    public NotaInvalida() {
        super("Nota inválida: O valor deve estar entre 0 e 10");
    }
}
