package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.NotaInvalida;
import org.sistema_gerenciamento_notas.command.AtribuirDisciplinaCommand;
import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Nota;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.service.AlunoService;
import org.sistema_gerenciamento_notas.service.DisciplinaService;
import org.sistema_gerenciamento_notas.service.ProfessorService;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoProfessor {

    private final ProfessorService professorService = new ProfessorService();

    public void contratarProfessor(Professor professor) {
        professorService.contratarProfessor(professor);
    }

    public void demitirProfessor(int matriculaProfessor) {
        professorService.demitirProfessor(matriculaProfessor);
    }

    public void atribuirDisciplina(Professor professor, Disciplina disciplina) {

        AtribuirDisciplinaCommand atribuirDisciplinaCommand = new AtribuirDisciplinaCommand(professorService,professor,disciplina);
        atribuirDisciplinaCommand.executar();

        //        professorService.atribuirDisciplina(professor, disciplina);
    }

    public void listarProfessores() {
        professorService.listarProfessores();
    }

    public Professor pegarProfessorPorMatricula(int matriculaProfessor) {
        return professorService.pegarProfessorPorMatricula(matriculaProfessor);
    }

    // Método para adicionar nota ao aluno
    public void adicionarNota(AlunoService alunoService, DisciplinaService disciplinaService) {
        // Listar alunos
        alunoService.listarAlunos();

        // Scanner para entrada de dados
        final Scanner input = new Scanner(System.in);
        System.out.println("Digite a matrícula do aluno que deseja atribuir a nota:");

        // Receber matrícula do aluno
        int matricula = input.nextInt();
        var aluno = alunoService.pegarAlunoPorMatricula(matricula);

        // Listar disciplinas
        disciplinaService.listarDisciplinas();

        System.out.println("Digite o ID da disciplina que deseja atribuir a nota:");
        int idDisciplina = input.nextInt();
        var disciplina = disciplinaService.pegarDisciplinaPorId(idDisciplina);

        System.out.println("Digite o valor da nota: ");
        float notaValor = input.nextFloat();

        // Validar se a nota está dentro do intervalo
        if (notaValor < 0f || notaValor > 10f) {
            throw new NotaInvalida();
        }

        // Usar o padrão Polymorphism sem criar subclasses de Nota:
        // Podemos aplicar o padrão polimorfismo, considerando um comportamento que pode ser alterado dependendo da situação.
        // Por exemplo, se tiver algum tipo especial de avaliação, podemos usar algo no comportamento da nota.
        // Nesse caso, vamos manter a nota simples e diretamente associada ao aluno e à disciplina.

        // Procurar uma nota existente ou criar uma nova
        Nota nota = aluno.getListaNotas().stream()
                .filter(n -> n.getMatriculaAluno() == aluno.getMatricula())
                .findFirst()
                .orElse(null);

        // Se não existir, criar uma nova
        if (nota == null) {
            nota = new Nota(aluno.getMatricula());
            // Adicionar a disciplina ao mapa de notas do aluno (conforme o fluxo do código)
            nota.getNotasMap().putIfAbsent(disciplina, new ArrayList<>(3));
            aluno.getListaNotas().add(nota);
        }

        // Adicionar o valor da nota à disciplina específica
        nota.getNotasMap().get(disciplina).add(notaValor);
    }
}
