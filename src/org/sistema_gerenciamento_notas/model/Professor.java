package org.sistema_gerenciamento_notas.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    private final List<Disciplina> disciplinasMinistradas = new ArrayList<>();
    private final int matricula;
    private final String nome;

    public Professor(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    @Override
    public String toString() {
        return "org.sistema_gerenciamento_notas.model.Professor{" +
                "disciplinasMinistradas=" + disciplinasMinistradas +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}
