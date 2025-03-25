import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoEscolar {

    private final List<Aluno> listaAlunos = new ArrayList<>();
    private final List<Professor> listaProfessores = new ArrayList<>();
    private final List<Disciplina> listaDisciplinas = new ArrayList<>();

    public void matricularAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public void desmatricularAluno(int matriculaAluno){
        listaAlunos.removeIf(
                aluno -> aluno.getMatricula() == matriculaAluno
        );
    }

    public void contratarProfessor(Professor professor){
        listaProfessores.add(professor);
    }

    public void demitirProfessor(int matriculaProfessor){
        listaProfessores.removeIf(
                professor -> professor.getMatricula() == matriculaProfessor
        );
    }

    public void adicionarDisciplina(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }

    public void atribuirDisciplina(Professor professor, Disciplina disciplina){
        professor.getDisciplinasMinistradas().add(disciplina);
    }

    public void removerDisciplina(int idDisciplina){
        listaDisciplinas.removeIf(
                disciplina -> disciplina.getIdDisciplina() == idDisciplina
        );
    }

    public Aluno gerarHistoricoAluno() {
        Scanner input = new Scanner(System.in);

        for (Aluno aluno : listaAlunos) {
            System.out.printf("%s - %s\n", aluno.nome, aluno.matricula);
        }

        System.out.print("Digite a matrícula do aluno para gerar histórico: ");
        int matricula = input.nextInt();

        for (Aluno aluno : listaAlunos) {
            if (aluno.matricula == matricula) {
                return aluno;
            }
        }

        return null;
    }

    public void adicionarNota(){
//        for (int i = 0; i < listaAlunos.size(); i++) {
//            System.out.printf("%d- %s\n", i, listaAlunos.get(i));
//        }

        listarAlunos();


//        var disciplina_ = gestaoEscolar.getListaDisciplinas().stream()
//                .filter(d -> d.getIdDisciplina() == id)
//                .findFirst()
//                .orElse(null);

        final Scanner input = new Scanner(System.in);
        System.out.println("Digite a matricula do aluno que deseja atribuir a nota:");

        int alunoMatricula = input.nextInt();

        var aluno = listaAlunos.stream()
                .filter(a -> a.matricula == alunoMatricula)
                .findFirst()
                .orElse(null);

//        for (int i = 0; i < listaDisciplinas.size(); i++) {
//            System.out.printf("%d- %s\n", i, listaDisciplinas.get(i));
//        }

        listarDisciplinas();

        System.out.println("Digite o ID da disciplina que deseja atribuir a nota:");

        int disciplinaId = input.nextInt();
        var disciplina = listaDisciplinas.stream()
                        .filter(d -> d.getIdDisciplina() == disciplinaId)
                        .findFirst()
                        .orElse(null);

        System.out.println("Digite o valor da nota");
        float notaValor = input.nextFloat();

        Nota nota = new Nota(aluno.getMatricula());
        nota.getNotasMap().put(disciplina,notaValor);

        aluno.getListaNotas().add(nota);
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void listarAlunos(){
        System.out.printf("%sLista Alunos%s\n","\u001B[34m","\u001B[0m");
        for (Aluno alunoIndice: listaAlunos) {
            System.out.printf("Matricula: %s | Nome: %s | Notas: %s\n",alunoIndice.getMatricula(),alunoIndice.getNome(),alunoIndice.getListaNotas());
        }
    }

    public void listarProfessores(){
        System.out.printf("%sLista Professores%s\n","\u001B[34m","\u001B[0m");
        for (Professor professorIndice: listaProfessores) {
            System.out.printf("Matricula: %s | Nome: %s | Disciplinas Ministradas: %s\n",professorIndice.getMatricula(),professorIndice.getNome(),professorIndice.getDisciplinasMinistradas());
        }
    }

    public void listarDisciplinas(){
        System.out.printf("%sLista Disciplinas%s\n","\u001B[34m","\u001B[0m");
        for (Disciplina disciplinaIndice: listaDisciplinas) {
            System.out.printf("ID: %s | Nome: %s\n",disciplinaIndice.getIdDisciplina(), disciplinaIndice.getNomeDisciplina());
        }
    }
}