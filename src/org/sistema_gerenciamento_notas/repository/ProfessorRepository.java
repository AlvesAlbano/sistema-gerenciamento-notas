package org.sistema_gerenciamento_notas.repository;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Professor;

public interface ProfessorRepository {
    void contratarProfessor(Professor professor);
    void demitirProfessor(int matriculaProfessor);
    void atribuirDisciplina(Professor professor, Disciplina disciplina);
    void listarProfessores();
    Professor pegarProfessorPorMatricula(int matriculaProfessor);
}