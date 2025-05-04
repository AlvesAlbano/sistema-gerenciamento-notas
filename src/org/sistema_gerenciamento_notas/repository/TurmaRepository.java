package org.sistema_gerenciamento_notas.repository;

import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.model.Turma;

public interface TurmaRepository {
    void adicionarAluno(Aluno aluno);
//    void removerAluno(Aluno aluno);
//    void moverAluno(Aluno aluno);
    void criarTurma();
    void dissolverTurma();
    void listarTurmas();
    Turma retornarTurmaPorId(int idTurma, int indiceTurma);
//    void atribuirProfessor(Professor professor);
//    void dispensarProfessor(Professor professor);
}