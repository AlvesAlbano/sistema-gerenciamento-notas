package org.sistema_gerenciamento_notas.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private final List<Nota> listaNotas = new ArrayList<>();
    private int matricula;
    private String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    @Override
    public String toString() {

        return "org.sistema_gerenciamento_notas.model.Aluno{" +
                "listaNotas=" + listaNotas +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}