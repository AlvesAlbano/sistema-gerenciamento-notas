package org.sistema_gerenciamento_notas.model;

public class TurmaFundamental extends Turma{
    public TurmaFundamental(byte serie, String turno, char id) {
        super(serie, turno, id);
    }

    @Override
    public String getTipo() {
        return "FUNDAMENTAL";
    }

}
