public interface ProfessorRepository {
    void contratarProfessor(Professor professor);
    void demitirProfessor(int matriculaProfessor);
    void atribuirDisciplina(Professor professor, Disciplina disciplina);
    void listarProfessores();
    Professor pegarProfessorPorMatricula(int matriculaProfessor);
}