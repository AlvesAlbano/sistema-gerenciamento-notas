import org.sistema_gerenciamento_notas.controller.GestaoAluno;
import org.sistema_gerenciamento_notas.controller.GestaoDisciplina;
import org.sistema_gerenciamento_notas.controller.GestaoProfessor;
import org.sistema_gerenciamento_notas.controller.GestaoTurma;
import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Professor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner input = new Scanner(System.in);
        final GestaoAluno gestaoAluno = new GestaoAluno();
        final GestaoDisciplina gestaoDisciplina = new GestaoDisciplina();
        final GestaoProfessor gestaoProfessor = new GestaoProfessor();
        final GestaoTurma gestaoTurma = new GestaoTurma();

        int opcao;
        int autoIncrementAluno = 0;
        int autoIncrementProfessor = 0;
        int autoIncrementDisicplina = 0;

        Aluno alunoTeste = new Aluno(1,"pedro silva");
        Professor professorTeste = new Professor(1,"joão silva");
        Disciplina disciplinaTeste = new Disciplina(1,"quimica");
        Disciplina disciplinaTeste2 = new Disciplina(2,"fisica");
        Disciplina disciplinaTeste3 = new Disciplina(3,"biologia");

//        gestaoEscolar.getAlunoService().getListaAlunos().add(alunoTeste);
//
//        gestaoEscolar.getDisciplinaService().getListaDisciplinas().add(disciplinaTeste);
//        gestaoEscolar.getDisciplinaService().getListaDisciplinas().add(disciplinaTeste2);
//        gestaoEscolar.getDisciplinaService().getListaDisciplinas().add(disciplinaTeste3);
//        gestaoEscolar.getProfessorService().getListaProfessores().add(professorTeste);
//
//        gestaoEscolar.atribuirDisciplina(professorTeste,disciplinaTeste);
//        gestaoEscolar.atribuirDisciplina(professorTeste,disciplinaTeste2);

        gestaoAluno.matricularAluno(alunoTeste);

        gestaoDisciplina.adicionarDisciplina(disciplinaTeste);
        gestaoDisciplina.adicionarDisciplina(disciplinaTeste2);
        gestaoDisciplina.adicionarDisciplina(disciplinaTeste3);

        gestaoProfessor.contratarProfessor(professorTeste);

        gestaoProfessor.atribuirDisciplina(professorTeste,disciplinaTeste);
        gestaoProfessor.atribuirDisciplina(professorTeste,disciplinaTeste2);
        do {
            System.out.printf("%s--- Sistema Escola ---%s\n","\u001B[34m","\u001B[0m");

            System.out.println("Digite 1 para adicionar aluno");
            System.out.println("Digite 2 para adicionar professor");
            System.out.println("Digite 3 para adicionar disciplina");
            System.out.println("Digite 4 para adicionar nota");
            System.out.println("Digite 5 para desmatricular aluno");
            System.out.println("Digite 6 para demitir professor");
            System.out.println("Digite 7 para remover disciplina");
            System.out.println("Digite 8 para gerar historico aluno");
            System.out.println("Digite 9 para atribuir disciplina para professor");
            System.out.println("Digite 10 para listar alunos");
            System.out.println("Digite 11 para listar professores");
            System.out.println("Digite 12 para listar disciplinas");
            System.out.println("Digite 13 para criar turma");
            System.out.println("Digite 14 para listar turmas");
            System.out.println("Digite 15 para adicionar aluno na turma");
            System.out.println("Digite 16 para dissolver turma");
            System.out.println("Digite 0 para sair");

            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    final int matriculaAluno  = autoIncrementAluno+=1;
                    System.out.println("Digite o nome do aluno(a):");
                    input.nextLine();
                    final String nomeAluno = input.nextLine();

                    Aluno aluno = new Aluno(matriculaAluno,nomeAluno);
                    gestaoAluno.matricularAluno(aluno);

                    System.out.printf("%sAluno(a) matriculado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
                    break;
                case 2:
                    final int matriculaProfessor  = autoIncrementProfessor+=1;
                    System.out.println("Digite o nome do professor(a):");
                    input.nextLine();
                    final String nomeProfessor = input.nextLine();

                    Professor professor = new Professor(matriculaProfessor,nomeProfessor);
                    gestaoProfessor.contratarProfessor(professor);

                    System.out.printf("%sProfessor(a) contratado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
                    break;
                case 3:
                    final int idDisciplina = autoIncrementDisicplina+=1;

                    System.out.println("Digite o nome da disciplina:");
                    input.nextLine();
                    final String nomeDisciplina = input.nextLine();
                    Disciplina disciplina = new Disciplina(idDisciplina,nomeDisciplina);

                    gestaoDisciplina.adicionarDisciplina(disciplina);
                    break;
                case 4:
                    try {
                        var alunoService = gestaoAluno.getAlunoService();
                        var disciplinaService = gestaoDisciplina.getDisciplinaService();

                        gestaoProfessor.adicionarNota(alunoService,disciplinaService);
                    } catch (Exception e) {
//                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 5:
//                    for (org.sistema_gerenciamento_notas.model.Aluno alunoIndice: gestaoEscolar.getListaAlunos()) {
//                        System.out.printf("Matricula: %s - Nome: %s\n",alunoIndice.getMatricula(),alunoIndice.getNome());
//                    }

                    gestaoAluno.listarAlunos();

                    System.out.println("Digite a matricula do aluno que deseja remover: ");
                    final int matriculaAluno_ = input.nextInt();

                    gestaoAluno.desmatricularAluno(matriculaAluno_);
                    break;
                case 6:
//                    for (org.sistema_gerenciamento_notas.model.Professor professorIndice: gestaoEscolar.getListaProfessores()) {
//                        System.out.printf("Matricula: %s - Nome: %s",professorIndice.getMatricula(),professorIndice.getNome());
//                    }

                    gestaoProfessor.listarProfessores();

                    System.out.println("Digite a matricula do professor que deseja remover: ");
                    final int matriculaProfessor_ = input.nextInt();

                    gestaoProfessor.demitirProfessor(matriculaProfessor_);
                    break;
                case 7:
//                    for (org.sistema_gerenciamento_notas.model.Disciplina disciplinaIndice: gestaoEscolar.getListaDisciplinas()) {
//                        System.out.printf("ID: %s - Nome: %s\n",disciplinaIndice.getIdDisciplina(), disciplinaIndice.getNomeDisciplina());
//                    }

                    gestaoDisciplina.listarDisciplinas();

                    System.out.println("Digite o id da disciplina que deseja remover: ");
                    final int idDisciplina_ = input.nextInt();

                    gestaoDisciplina.removerDisciplina(idDisciplina_);

                    System.out.println("Lista com ID removido");
                    gestaoDisciplina.listarDisciplinas();
                    break;
                case 8:
                    gestaoAluno.gerarHistorico();
                    break;
                case 9:

//                    for (int i = 0;i < gestaoEscolar.getListaDisciplinas().size();i++) {
//                        System.out.printf("%d - %s\n",i,gestaoEscolar.getListaDisciplinas().get(i));
//                    }
//
//                    for (int i = 0;i < gestaoEscolar.getListaProfessores().size();i++) {
//                        System.out.printf("%d - %s\n",i,gestaoEscolar.getListaProfessores().get(i));
//                    }

                    gestaoDisciplina.listarDisciplinas();
                    gestaoProfessor.listarProfessores();

                    System.out.println("Digite o ID da disciplina:");
                    int id = input.nextInt();

                    System.out.println("Digite a matricula do professor para ser atribuido a disciplina:");
                    int matricula = input.nextInt();

//                    var disciplina_ = gestaoEscolar.getListaDisciplinas().stream()
//                            .filter(d -> d.getIdDisciplina() == id)
//                            .findFirst()
//                            .orElse(null);
//
//                    var professor_ = gestaoEscolar.getListaProfessores().stream()
//                            .filter(p -> p.getMatricula() == matricula)
//                            .findFirst()
//                            .orElse(null);

                    var disciplina_ = gestaoDisciplina.pegarDisciplinaPorId(id);

                    var professor_ = gestaoProfessor.pegarProfessorPorMatricula(matricula);

                    gestaoProfessor.atribuirDisciplina(professor_,disciplina_);
                    break;
                case 10:
                    gestaoAluno.listarAlunos();
                    break;
                case 11:
                    gestaoProfessor.listarProfessores();
                    break;
                case 12:
                    gestaoDisciplina.listarDisciplinas();
                    break;
                case 13:
                    gestaoTurma.criarTurma();
                    break;
                case 14:
                    gestaoTurma.listarTurmas();
                    break;
                case 15:
                    final int matriculaAluno__ = autoIncrementAluno+=1;
                    System.out.println("Digite o nome do aluno(a):");
                    input.nextLine();
                    final String nomeAluno_ = input.nextLine();

                    gestaoTurma.adicionarAluno(new Aluno(matriculaAluno__,nomeAluno_));
                    break;
                case 16:
                    gestaoTurma.dissolverTurma();
                    break;
            }
        } while(opcao != 0);
    }
}