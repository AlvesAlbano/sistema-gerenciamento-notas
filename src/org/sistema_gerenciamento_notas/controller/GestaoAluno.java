package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.repository.AlunoRepository;
import org.sistema_gerenciamento_notas.service.AlunoService;

public class GestaoAluno implements AlunoRepository {

    private final AlunoService alunoService = new AlunoService();

    @Override
    public void matricularAluno(Aluno aluno) {
        alunoService.matricularAluno(aluno);
        System.out.printf("%sAluno(a) matriculado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
    }

    @Override
    public void desmatricularAluno(int matriculaAluno) {
        alunoService.desmatricularAluno(matriculaAluno);
        System.out.printf("%sAluno(a) desmatriculado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
    }

    @Override
    public void listarAlunos() {
        alunoService.listarAlunos();
    }

    @Override
    public void gerarHistorico() {
        alunoService.gerarHistorico();
    }

    @Override
    public Aluno pegarAlunoPorMatricula(int matricula) {
        return alunoService.pegarAlunoPorMatricula(matricula);
    }
}
