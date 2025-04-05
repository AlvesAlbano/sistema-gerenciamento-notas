package org.sistema_gerenciamento_notas.service;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.repository.ProfessorRepository;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorRepository {
    private List<Professor> listaProfessores = new ArrayList<>();

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    @Override
    public void contratarProfessor(Professor professor) {
        listaProfessores.add(professor);
    }

    @Override
    public void demitirProfessor(int matriculaProfessor) {
        var professor = pegarProfessorPorMatricula(matriculaProfessor);

        if (professor != null) {
            listaProfessores.remove(professor);
        }
    }

    // Implementando o método atribuirDisciplina
    @Override
    public void atribuirDisciplina(Professor professor, Disciplina disciplina) {
        if (professor != null && disciplina != null) {
            // Adiciona a disciplina à lista de disciplinas ministradas pelo professor
            professor.getDisciplinasMinistradas().add(disciplina);
            System.out.printf("Disciplina %s atribuída ao professor %s\n", disciplina.getNomeDisciplina(), professor.getNome());
        } else {
            System.out.println("Professor ou Disciplina inválidos para atribuição.");
        }
    }

    @Override
    public void listarProfessores() {
        System.out.printf("%sLista de Professores%s\n","\u001B[34m","\u001B[0m");
        for (Professor professorIndice: listaProfessores) {
            System.out.printf("Matrícula: %s | Nome: %s | Disciplinas Ministradas: %s\n", professorIndice.getMatricula(), professorIndice.getNome(), professorIndice.getDisciplinasMinistradas());
        }
    }

    @Override
    public Professor pegarProfessorPorMatricula(int matriculaProfessor) {
        for (Professor professor: listaProfessores) {
            if (professor.getMatricula() == matriculaProfessor) {
                return professor;
            }
        }
        return null;
    }
}