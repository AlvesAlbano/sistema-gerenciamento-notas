import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestaoEscolar implements AlunoRepository, ProfessorRepository, DisciplinaRepository {

    private final List<Aluno> listaAlunos = new ArrayList<>();
    private final List<Professor> listaProfessores = new ArrayList<>();
    private final List<Disciplina> listaDisciplinas = new ArrayList<>();

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    @Override
    public void matricularAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    @Override
    public void desmatricularAluno(int matriculaAluno){
        listaAlunos.removeIf(
                aluno -> aluno.getMatricula() == matriculaAluno
        );
    }

    @Override
    public void contratarProfessor(Professor professor){
        listaProfessores.add(professor);
    }

    @Override
    public void demitirProfessor(int matriculaProfessor){
        listaProfessores.removeIf(
                professor -> professor.getMatricula() == matriculaProfessor
        );
    }

    @Override
    public void adicionarDisciplina(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }

    @Override
    public void atribuirDisciplina(Professor professor, Disciplina disciplina){
        professor.getDisciplinasMinistradas().add(disciplina);
    }

    @Override
    public void removerDisciplina(int idDisciplina){
        listaDisciplinas.removeIf(
                disciplina -> disciplina.getIdDisciplina() == idDisciplina
        );
    }

    @Override
    public void gerarHistorico() {
        final Scanner input = new Scanner(System.in);

        listarAlunos();

        System.out.print("Digite a matrícula do aluno para gerar histórico: ");
        final int matricula = input.nextInt();

        final var aluno = pegarAlunoPorMatricula(matricula);

        System.out.printf("%s Historico Aluno: %s %s\n","\u001B[34m",aluno.getNome(),"\u001B[0m");


        for(Nota notas: aluno.getListaNotas()){

//            Map<Disciplina, Float> mapNotas = notas.getNotasMap();
            Map<Disciplina, List<Float>> mapNotas = notas.getNotasMap();

            for(Map.Entry<Disciplina, List<Float>> entry : mapNotas.entrySet()){
                final var nota = entry.getValue();
                final var disciplina = entry.getKey();

                System.out.printf("Disciplina: %s | Notas: %s | Situação: %s |\n",disciplina.getNomeDisciplina(),nota,notas.getSituacao(disciplina));
            }
        }
    }

    public void adicionarNota(){
        listarAlunos();

        final Scanner input = new Scanner(System.in);
        System.out.println("Digite a matricula do aluno que deseja atribuir a nota:");

        int matricula = input.nextInt();

        var aluno = pegarAlunoPorMatricula(matricula);

        listarDisciplinas();

        System.out.println("Digite o ID da disciplina que deseja atribuir a nota:");

        int idDisciplina = input.nextInt();

        var disciplina = pegarDisciplinaPorId(idDisciplina);

        System.out.println("Digite o valor da nota: ");
        float notaValor = input.nextFloat();

        if (notaValor < 0f || notaValor > 0f){
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

    @Override
    public void listarAlunos(){
        System.out.printf("%sLista Alunos%s\n","\u001B[34m","\u001B[0m");
        for (Aluno alunoIndice: listaAlunos) {
            System.out.printf("Matricula: %s | Nome: %s | Notas: %s\n",alunoIndice.getMatricula(),alunoIndice.getNome(),alunoIndice.getListaNotas());
        }
    }

    @Override
    public void listarProfessores(){
        System.out.printf("%sLista Professores%s\n","\u001B[34m","\u001B[0m");
        for (Professor professorIndice: listaProfessores) {
            System.out.printf("Matricula: %s | Nome: %s | Disciplinas Ministradas: %s\n",professorIndice.getMatricula(),professorIndice.getNome(),professorIndice.getDisciplinasMinistradas());
        }
    }

    @Override
    public void listarDisciplinas(){
        System.out.printf("%sLista Disciplinas%s\n","\u001B[34m","\u001B[0m");
        for (Disciplina disciplinaIndice: listaDisciplinas) {
            System.out.printf("ID: %s | Nome: %s\n",disciplinaIndice.getIdDisciplina(), disciplinaIndice.getNomeDisciplina());
        }
    }

    @Override
    public Disciplina pegarDisciplinaPorId(int idDisciplina) {
        for(Disciplina disciplina: listaDisciplinas){
            if (disciplina.getIdDisciplina() == idDisciplina){
                return disciplina;
            }
        }
        return null;
    }

    @Override
    public Professor pegarProfessorPorMatricula(int matricula) {
        for(Professor professor: listaProfessores){
            if (professor.getMatricula() == matricula){
                return professor;
            }
        }
        return null;
    }

    @Override
    public Aluno pegarAlunoPorMatricula(int matricula) {
        for(Aluno aluno: listaAlunos){
            if (aluno.getMatricula() == matricula){
                return aluno;
            }
        }
        return null;
    }
}