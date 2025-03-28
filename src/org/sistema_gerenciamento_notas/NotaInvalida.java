package org.sistema_gerenciamento_notas;

public class NotaInvalida extends RuntimeException {
    public NotaInvalida() {
        super("org.sistema_gerenciamento_notas.model.Nota inválida: O valor deve estar entre 0 e 10");
    }
}
