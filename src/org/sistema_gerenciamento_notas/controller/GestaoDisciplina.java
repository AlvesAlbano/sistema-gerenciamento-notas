package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.repository.DisciplinaRepository;
import org.sistema_gerenciamento_notas.service.DisciplinaService;

public class GestaoDisciplina implements DisciplinaRepository {

    private final DisciplinaService disciplinaService = new DisciplinaService();


    public DisciplinaService getDisciplinaService() {
        return disciplinaService;
    }

    @Override
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinaService.adicionarDisciplina(disciplina);
    }

    @Override
    public void removerDisciplina(int idDisciplina) {
        disciplinaService.removerDisciplina(idDisciplina);
    }

    @Override
    public void listarDisciplinas() {
        disciplinaService.listarDisciplinas();
    }

    @Override
    public Disciplina pegarDisciplinaPorId(int idDisciplina) {
        return disciplinaService.pegarDisciplinaPorId(idDisciplina);
    }
}
