package org.sistema_gerenciamento_notas.repository;

import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Nota;

//Pure Fabrication

public interface AvaliacaoRepository {
    void aplicar(Aluno aluno, Disciplina disciplina, Nota nota);
}