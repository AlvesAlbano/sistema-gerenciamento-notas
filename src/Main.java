import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner input = new Scanner(System.in);
        final GestaoEscolar gestaoEscolar = new GestaoEscolar();
        int opcao;
        int autoIncrementAluno = 0;
        int autoIncrementProfessor = 0;
        int autoIncrementDisicplina = 0;

//        Aluno alunoTeste = new Aluno(1,"pedro silva");
//        Professor professorTeste = new Professor(1,"joão silva");
//        Disciplina disciplinaTeste = new Disciplina(1,"quimica");
//        Disciplina disciplinaTeste2 = new Disciplina(2,"fisica");
//        Disciplina disciplinaTeste3 = new Disciplina(3,"biologia");
//
//        gestaoEscolar.getListaAlunos().add(alunoTeste);
//        gestaoEscolar.getListaDisciplinas().add(disciplinaTeste);
//        gestaoEscolar.getListaDisciplinas().add(disciplinaTeste2);
//        gestaoEscolar.getListaDisciplinas().add(disciplinaTeste3);
//        gestaoEscolar.getListaProfessores().add(professorTeste);
//        gestaoEscolar.atribuirDisciplina(professorTeste,disciplinaTeste);
//        gestaoEscolar.atribuirDisciplina(professorTeste,disciplinaTeste2);

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
            System.out.println("Digite 0 para sair");

            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    final int matriculaAluno  = autoIncrementAluno+=1;
                    System.out.println("Digite o nome do aluno(a):");
                    input.nextLine();
                    final String nomeAluno = input.nextLine();

                    Aluno aluno = new Aluno(matriculaAluno,nomeAluno);
                    gestaoEscolar.matricularAluno(aluno);

                    System.out.printf("%sAluno(a) matriculado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
                    break;
                case 2:
                    final int matriculaProfessor  = autoIncrementProfessor+=1;
                    System.out.println("Digite o nome do professor(a):");
                    input.nextLine();
                    final String nomeProfessor = input.nextLine();

                    Professor professor = new Professor(matriculaProfessor,nomeProfessor);
                    gestaoEscolar.contratarProfessor(professor);

                    System.out.printf("%sProfessor(a) contratado(a) com sucesso!%s\n","\u001B[32m","\u001B[0m");
                    break;
                case 3:
                    final int idDisciplina = autoIncrementDisicplina+=1;

                    System.out.println("Digite o nome da disciplina:");
                    input.nextLine();
                    final String nomeDisciplina = input.nextLine();
                    Disciplina disciplina = new Disciplina(idDisciplina,nomeDisciplina);

                    gestaoEscolar.adicionarDisciplina(disciplina);
                    break;
                case 4:
                    gestaoEscolar.adicionarNota();
                    break;
                case 5:
//                    for (Aluno alunoIndice: gestaoEscolar.getListaAlunos()) {
//                        System.out.printf("Matricula: %s - Nome: %s\n",alunoIndice.getMatricula(),alunoIndice.getNome());
//                    }

                    gestaoEscolar.listarAlunos();

                    System.out.println("Digite a matricula do aluno que deseja remover: ");
                    final int matriculaAluno_ = input.nextInt();

                    gestaoEscolar.desmatricularAluno(matriculaAluno_);
                    break;
                case 6:
//                    for (Professor professorIndice: gestaoEscolar.getListaProfessores()) {
//                        System.out.printf("Matricula: %s - Nome: %s",professorIndice.getMatricula(),professorIndice.getNome());
//                    }

                    gestaoEscolar.listarProfessores();

                    System.out.println("Digite a matricula do professor que deseja remover: ");
                    final int matriculaProfessor_ = input.nextInt();

                    gestaoEscolar.demitirProfessor(matriculaProfessor_);
                    break;
                case 7:
//                    for (Disciplina disciplinaIndice: gestaoEscolar.getListaDisciplinas()) {
//                        System.out.printf("ID: %s - Nome: %s\n",disciplinaIndice.getIdDisciplina(), disciplinaIndice.getNomeDisciplina());
//                    }

                    gestaoEscolar.listarDisciplinas();

                    System.out.println("Digite o id da disciplina que deseja remover: ");
                    final int idDisciplina_ = input.nextInt();

                    gestaoEscolar.removerDisciplina(idDisciplina_);
                    break;
                case 8:
                    System.out.println(gestaoEscolar.gerarHistoricoAluno());
                    break;
                case 9:

//                    for (int i = 0;i < gestaoEscolar.getListaDisciplinas().size();i++) {
//                        System.out.printf("%d - %s\n",i,gestaoEscolar.getListaDisciplinas().get(i));
//                    }
//
//                    for (int i = 0;i < gestaoEscolar.getListaProfessores().size();i++) {
//                        System.out.printf("%d - %s\n",i,gestaoEscolar.getListaProfessores().get(i));
//                    }

                    gestaoEscolar.listarDisciplinas();
                    gestaoEscolar.listarProfessores();

                    System.out.println("Digite o ID da disciplina:");
                    int id = input.nextInt();

                    System.out.println("Digite a matricula do professor para ser atribuido a disciplina:");
                    int matricula = input.nextInt();

                    var disciplina_ = gestaoEscolar.getListaDisciplinas().stream()
                            .filter(d -> d.getIdDisciplina() == id)
                            .findFirst()
                            .orElse(null);

                    var professor_ = gestaoEscolar.getListaProfessores().stream()
                            .filter(p -> p.getMatricula() == matricula)
                            .findFirst()
                            .orElse(null);

                    gestaoEscolar.atribuirDisciplina(professor_,disciplina_);
                    break;
                case 10:
                    gestaoEscolar.listarAlunos();
                    break;
                case 11:
                    gestaoEscolar.listarProfessores();
                    break;
                case 12:
                    gestaoEscolar.listarDisciplinas();
                    break;
            }
        } while(opcao != 0);
    }
}