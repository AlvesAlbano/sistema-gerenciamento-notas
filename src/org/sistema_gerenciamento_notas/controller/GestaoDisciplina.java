package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.service.DisciplinaService;

public class GestaoDisciplina {

    private final DisciplinaService disciplinaService = new DisciplinaService();


    public DisciplinaService getDisciplinaService() {
        return disciplinaService;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinaService.adicionarDisciplina(disciplina);
    }

    public void removerDisciplina(int idDisciplina) {
        disciplinaService.removerDisciplina(idDisciplina);
    }

    public void listarDisciplinas() {
        disciplinaService.listarDisciplinas();
    }

    public Disciplina pegarDisciplinaPorId(int idDisciplina) {
        return disciplinaService.pegarDisciplinaPorId(idDisciplina);
    }
}