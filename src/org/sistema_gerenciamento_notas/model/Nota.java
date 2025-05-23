package org.sistema_gerenciamento_notas.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nota {
    private final int matriculaAluno;

    private Map<Disciplina, List<Float>> notasMap = new HashMap<>();

    public Nota(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public Map<Disciplina, List<Float>> getNotasMap() {
        return notasMap;
    }

    public String getSituacao(Disciplina disciplina){
        float soma = 0f;

        List<Float> notas = notasMap.get(disciplina);

        for (Float nota: notas){
            soma += nota;
        }

        return (soma/3f > 4f) ? "Aprovado" : "Reprovado";
    }

    @Override
    public String toString() {
        return "org.sistema_gerenciamento_notas.model.Nota{" +
                "notasMap=" + notasMap +
                '}';
    }
}