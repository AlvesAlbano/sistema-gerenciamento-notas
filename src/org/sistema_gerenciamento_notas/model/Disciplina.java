package org.sistema_gerenciamento_notas.model;

public class Disciplina {
    private final int idDisciplina;
    private String nomeDisciplina;

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

    @Override
    public String toString() {
        return "org.sistema_gerenciamento_notas.model.Disciplina{" +
                "idDisciplina=" + idDisciplina +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                '}';
    }
}