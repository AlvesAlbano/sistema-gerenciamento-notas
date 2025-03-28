package org.sistema_gerenciamento_notas.repository;

import org.sistema_gerenciamento_notas.model.Disciplina;

public interface DisciplinaRepository {
    void adicionarDisciplina(Disciplina disciplina);
    void removerDisciplina(int idDisciplina);
    void listarDisciplinas();
    Disciplina pegarDisciplinaPorId(int idDisciplina);
}