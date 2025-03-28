package org.sistema_gerenciamento_notas.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private final List<Nota> listaNotas = new ArrayList<>();
    public Aluno(int matricula, String nome) {
        super(matricula, nome);
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