package org.sistema_gerenciamento_notas.model;

public class TurmaMedio extends Turma{

    public TurmaMedio(byte serie, String turno, char id) {
        super(serie, turno, id);
    }

    @Override
    public String getTipo() {
        return "MÉDIO";
    }
}
