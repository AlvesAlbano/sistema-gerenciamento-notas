import java.util.HashMap;
import java.util.Map;

public class Nota {
    private final int matriculaAluno;

    private Map<Disciplina,Float> notasMap = new HashMap<>();

    public Nota(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public Map<Disciplina, Float> getNotasMap() {
        return notasMap;
    }

    public void setNotasMap(Map<Disciplina, Float> notasMap) {
        this.notasMap = notasMap;
    }

    public String getSituacao(){
        String situacao = "";

        return situacao;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "matriculaAluno=" + matriculaAluno +
                ", notasMap=" + notasMap +
                '}';
    }
}