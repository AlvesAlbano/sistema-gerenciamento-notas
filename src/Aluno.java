import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aluno extends Pessoa {
    private final List<Nota> listaNotas = new ArrayList<>();
    public Aluno(int matricula, String nome) {
        super(matricula, nome);
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    @Override
    public String toString() {

        return "Aluno{" +
                "listaNotas=" + listaNotas +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}