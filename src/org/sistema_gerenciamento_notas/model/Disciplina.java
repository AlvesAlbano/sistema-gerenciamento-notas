package org.sistema_gerenciamento_notas.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private final int idDisciplina;
    private String nomeDisciplina;
    private List<Nota> notas = new ArrayList<>();

    public Disciplina(int idDisciplina, String nomeDisciplina) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "org.sistema_gerenciamento_notas.model.Disciplina{" +
                "idDisciplina=" + idDisciplina +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                '}';
    }
}