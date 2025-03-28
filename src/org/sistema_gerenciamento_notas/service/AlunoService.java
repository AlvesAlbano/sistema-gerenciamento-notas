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
        Scanner input = new Scanner(System.in);
        listarAlunos();
        
        System.out.print("\nDigite a matrícula do aluno para gerar histórico: ");
        int matricula = input.nextInt();
        
        Aluno aluno = pegarAlunoPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        
        System.out.println("\n=== HISTÓRICO ESCOLAR ===");
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("----------------------------------");
        
        if (aluno.getListaNotas().isEmpty()) {
            System.out.println("Nenhuma nota registrada para este aluno.");
            return;
        }
        
        // Itera por todas as notas do aluno
        for (Nota nota : aluno.getListaNotas()) {
            for (Map.Entry<Disciplina, List<Float>> entry : nota.getNotasMap().entrySet()) {
                Disciplina disciplina = entry.getKey();
                List<Float> notas = entry.getValue();
                
                // Calcula média
                float soma = 0;
                for (Float n : notas) {
                    soma += n;
                }
                float media = soma / notas.size();
                
                // Formata a saída
                System.out.println("Disciplina: " + disciplina.getNomeDisciplina());
                System.out.println("Notas: " + notas);
                System.out.printf("Média: %.1f - Situação: %s%n", 
                    media, 
                    media >= 5 ? "Aprovado" : "Reprovado");
                System.out.println("----------------------------------");
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