import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    private List<Disciplina> disciplinasMinistradas = new ArrayList<>();

    public Professor(int matricula, String nome) {
        super(matricula, nome);
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(List<Disciplina> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "disciplinasMinistradas=" + disciplinasMinistradas +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}
