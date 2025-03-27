public interface AlunoRepository {
    void matricularAluno(Aluno aluno);
    void desmatricularAluno(int matriculaAluno);
    void listarAlunos();
    void gerarHistorico();
    Aluno pegarAlunoPorMatricula(int matricula);
}