package org.sistema_gerenciamento_notas.service;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.repository.ProfessorRepository;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorRepository {

    // Instância única (Singleton)
    private static ProfessorService instancia;
    private List<Professor> listaProfessores = new ArrayList<>();

    // Construtor privado para evitar instanciamento externo
    private ProfessorService() {}

    // Método de acesso à instância única
    public static ProfessorService getInstancia() {
        if (instancia == null) {
            instancia = new ProfessorService();
        }
        return instancia;
    }

    // Getter e Setter da lista de professores
    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    // Implementação dos métodos da interface
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

    @Override
    public void atribuirDisciplina(Professor professor, Disciplina disciplina) {
        if (professor != null && disciplina != null) {
            professor.getDisciplinasMinistradas().add(disciplina);
            System.out.printf("Disciplina %s atribuída ao professor %s\n",
                disciplina.getNomeDisciplina(), professor.getNome());
        } else {
            System.out.println("Professor ou Disciplina inválidos para atribuição.");
        }
    }

    @Override
    public void listarProfessores() {
        System.out.printf("%sLista de Professores%s\n", "\u001B[34m", "\u001B[0m");
        for (Professor professorIndice : listaProfessores) {
            System.out.printf("Matrícula: %s | Nome: %s | Disciplinas Ministradas: %s\n",
                professorIndice.getMatricula(), professorIndice.getNome(), professorIndice.getDisciplinasMinistradas());
        }
    }

    @Override
    public Professor pegarProfessorPorMatricula(int matriculaProfessor) {
        for (Professor professor : listaProfessores) {
            if (professor.getMatricula() == matriculaProfessor) {
                return professor;
            }
        }
        return null;
    }
}
