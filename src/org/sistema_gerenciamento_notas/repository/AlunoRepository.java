package org.sistema_gerenciamento_notas.repository;

import org.sistema_gerenciamento_notas.model.Aluno;

public interface AlunoRepository {
    void matricularAluno(Aluno aluno);
    void desmatricularAluno(int matriculaAluno);
    void listarAlunos();
    void gerarHistorico();
    Aluno pegarAlunoPorMatricula(int matricula);
}