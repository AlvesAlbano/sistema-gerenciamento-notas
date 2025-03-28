package org.sistema_gerenciamento_notas.service;

import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Nota;
import org.sistema_gerenciamento_notas.repository.AlunoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlunoService implements AlunoRepository {

    private final List<Aluno> listaAlunos = new ArrayList<>();

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    @Override
    public void matricularAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    @Override
    public void desmatricularAluno(int matriculaAluno) {
        listaAlunos.removeIf(
                aluno -> aluno.getMatricula() == matriculaAluno
        );
    }

    @Override
    public void listarAlunos() {
        System.out.printf("%sLista Alunos%s\n","\u001B[34m","\u001B[0m");
        for (Aluno alunoIndice: listaAlunos) {
            System.out.printf("Matricula: %s | Nome: %s | Notas: %s\n",alunoIndice.getMatricula(),alunoIndice.getNome(),alunoIndice.getListaNotas());
        }
    }

    @Override
    public void gerarHistorico() {
        final Scanner input = new Scanner(System.in);

        listarAlunos();

        System.out.print("Digite a matrícula do aluno para gerar histórico: ");
        final int matricula = input.nextInt();

        final var aluno = pegarAlunoPorMatricula(matricula);

        System.out.printf("%s Historico org.sistema_gerenciamento_notas.model.Aluno: %s %s\n","\u001B[34m",aluno.getNome(),"\u001B[0m");


        for(Nota notas: aluno.getListaNotas()){

//            Map<org.sistema_gerenciamento_notas.model.Disciplina, Float> mapNotas = notas.getNotasMap();
            Map<Disciplina, List<Float>> mapNotas = notas.getNotasMap();

            for(Map.Entry<Disciplina, List<Float>> entry : mapNotas.entrySet()){
                final var nota = entry.getValue();
                final var disciplina = entry.getKey();

                System.out.printf("org.sistema_gerenciamento_notas.model.Disciplina: %s | Notas: %s | Situação: %s |\n",disciplina.getNomeDisciplina(),nota,notas.getSituacao(disciplina));
            }
        }
    }

    @Override
    public Aluno pegarAlunoPorMatricula(int matriculaAluno) {
        for(Aluno aluno: listaAlunos){
            if (aluno.getMatricula() == matriculaAluno){
                return aluno;
            }
        }
        return null;
    }
}