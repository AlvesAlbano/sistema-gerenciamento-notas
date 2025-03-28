package org.sistema_gerenciamento_notas.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nota {
    private final int matriculaAluno;

//    private Map<org.sistema_gerenciamento_notas.model.Disciplina,Float> notasMap = new HashMap<>();
    private Map<Disciplina, List<Float>> notasMap = new HashMap<>();

    public Nota(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

//    public Map<org.sistema_gerenciamento_notas.model.Disciplina, Float> getNotasMap() {
//        return notasMap;
//    }
//
//    public void setNotasMap(Map<org.sistema_gerenciamento_notas.model.Disciplina, Float> notasMap) {
//        this.notasMap = notasMap;
//    }


    public Map<Disciplina, List<Float>> getNotasMap() {
        return notasMap;
    }

    public void setNotasMap(Map<Disciplina, List<Float>> notasMap) {
        this.notasMap = notasMap;
    }

    public String getSituacao(Disciplina disciplina) {
        List<Float> notas = this.notasMap.get(disciplina);
        if (notas == null || notas.isEmpty()) {
            return "Sem notas";
        }
        
        float soma = 0;
        for (Float nota : notas) {
            soma += nota;
        }
        float media = soma / notas.size();
        
        return media >= 5 ? "Aprovado" : "Reprovado";
    }

    @Override
    public String toString() {
        return "org.sistema_gerenciamento_notas.model.Nota{" +
                "notasMap=" + notasMap +
                '}';
    }
}