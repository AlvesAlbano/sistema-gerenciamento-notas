package org.sistema_gerenciamento_notas.model;

import java.util.ArrayList;

public abstract class Turma {

    private volatile ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private volatile ArrayList<Professor> listaProfessores = new ArrayList<>();
    private final byte serie;
    private String turno;
    private char id;

    public Turma(byte serie, String turno, char id) {
        this.serie = serie;
        this.turno = turno;
        this.id = id;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public byte getSerie() {
        return serie;
    }

    public char getId() {
        return id;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setid(char id) {
        this.id = id;
    }

    public ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(ArrayList<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    @Override
    public String toString() {
//        return "Turma{" +
//                "listaAlunos=" + listaAlunos +
//                ", listaProfessores=" + listaProfessores +
//                ", turno='" + turno + '\'' +
//                ", id=" + id +
//                '}';

//        return serie + "º " + id + " " + turno + " Alunos: " + listaAlunos;
        return String.format("%dº Ano %s %s - %s",getSerie(),getId(),getTurno(),getTipo());
    }

    public abstract String getTipo();
}
