package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.service.AlunoService;

public class GestaoAluno {

    private final AlunoService alunoService = new AlunoService();

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public void matricularAluno(Aluno aluno) {
        alunoService.matricularAluno(aluno);
        System.out.printf("%sAluno(a) matriculado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
    }

    public void desmatricularAluno(int matriculaAluno) {
        alunoService.desmatricularAluno(matriculaAluno);
        System.out.printf("%sAluno(a) desmatriculado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
    }

    public void listarAlunos() {
        alunoService.listarAlunos();
    }

    public void gerarHistorico() {
        alunoService.gerarHistorico();
    }

    public Aluno pegarAlunoPorMatricula(int matricula) {
        return alunoService.pegarAlunoPorMatricula(matricula);
    }
}
