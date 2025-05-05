package org.sistema_gerenciamento_notas.factory;

import org.sistema_gerenciamento_notas.model.Turma;
import org.sistema_gerenciamento_notas.model.TurmaFundamental;
import org.sistema_gerenciamento_notas.model.TurmaMedio;

public class TurmaFactory {

    public static Turma criarTurma(byte serie, String turno, char id){
        if(serie >= 1 && serie <= 3){
            return new TurmaMedio(serie, turno, id);
        } else if (serie >= 4 && serie <= 9) {
            return new TurmaFundamental(serie, turno, id);
        }
        return null;
    }
}