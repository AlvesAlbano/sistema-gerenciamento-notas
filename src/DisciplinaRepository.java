public interface DisciplinaRepository {
    void adicionarDisciplina(Disciplina disciplina);
    void removerDisciplina(int idDisciplina);
    void listarDisciplinas();
    Disciplina pegarDisciplinaPorId(int idDisciplina);
}