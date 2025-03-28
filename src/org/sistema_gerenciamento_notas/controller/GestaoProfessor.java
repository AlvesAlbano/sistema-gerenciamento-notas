package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.NotaInvalida;
import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Nota;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.repository.ProfessorRepository;
import org.sistema_gerenciamento_notas.service.AlunoService;
import org.sistema_gerenciamento_notas.service.DisciplinaService;
import org.sistema_gerenciamento_notas.service.ProfessorService;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoProfessor implements ProfessorRepository {

    private final ProfessorService professorService = new ProfessorService();
    private final AlunoService alunoService = new AlunoService();
    private final DisciplinaService disciplinaService = new DisciplinaService();

    @Override
    public void contratarProfessor(Professor professor) {
        professorService.contratarProfessor(professor);
    }

    @Override
    public void demitirProfessor(int matriculaProfessor) {
        professorService.demitirProfessor(matriculaProfessor);
    }

    @Override
    public void atribuirDisciplina(Professor professor, Disciplina disciplina) {
        professorService.atribuirDisciplina(professor,disciplina);
    }

    @Override
    public void listarProfessores() {
        professorService.listarProfessores();
    }

    @Override
    public Professor pegarProfessorPorMatricula(int matriculaProfessor) {
        return professorService.pegarProfessorPorMatricula(matriculaProfessor);
    }

    public void adicionarNota(){
        alunoService.listarAlunos();

        final Scanner input = new Scanner(System.in);
        System.out.println("Digite a matricula do aluno que deseja atribuir a nota:");

        int matricula = input.nextInt();

        var aluno = alunoService.pegarAlunoPorMatricula(matricula);

        disciplinaService.listarDisciplinas();

        System.out.println("Digite o ID da disciplina que deseja atribuir a nota:");

        int idDisciplina = input.nextInt();

        var disciplina = disciplinaService.pegarDisciplinaPorId(idDisciplina);

        System.out.println("Digite o valor da nota: ");
        float notaValor = input.nextFloat();

        if (notaValor < 0f || notaValor > 10f){
            throw new NotaInvalida();
        }

        Nota nota = aluno.getListaNotas().stream()
                .filter(n -> n.getMatriculaAluno() == aluno.getMatricula())
                .findFirst()
                .orElse(null);

        if (nota == null){
            nota = new Nota(aluno.getMatricula());
            nota.getNotasMap().putIfAbsent(disciplina, new ArrayList<>(3));
            aluno.getListaNotas().add(nota);
        }

        nota.getNotasMap().get(disciplina).add(notaValor);
    }
}