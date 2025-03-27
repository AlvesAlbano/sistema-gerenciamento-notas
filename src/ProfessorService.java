import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements ProfessorRepository{
    private List<Professor> listaProfessores = new ArrayList<>();

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    @Override
    public void contratarProfessor(Professor professor) {
        listaProfessores.add(professor);
    }

    @Override
    public void demitirProfessor(int matriculaProfessor) {
        listaProfessores.removeIf(
                professor -> professor.getMatricula() == matriculaProfessor
        );
    }

    @Override
    public void atribuirDisciplina(Professor professor, Disciplina disciplina) {
        professor.getDisciplinasMinistradas().add(disciplina);
    }

    @Override
    public void listarProfessores() {
        System.out.printf("%sLista Professores%s\n","\u001B[34m","\u001B[0m");
        for (Professor professorIndice: listaProfessores) {
            System.out.printf("Matricula: %s | Nome: %s | Disciplinas Ministradas: %s\n",professorIndice.getMatricula(),professorIndice.getNome(),professorIndice.getDisciplinasMinistradas());
        }
    }

    @Override
    public Professor pegarProfessorPorMatricula(int matriculaProfessor) {
        for(Professor professor: listaProfessores){
            if (professor.getMatricula() == matriculaProfessor){
                return professor;
            }
        }
        return null;
    }
}
