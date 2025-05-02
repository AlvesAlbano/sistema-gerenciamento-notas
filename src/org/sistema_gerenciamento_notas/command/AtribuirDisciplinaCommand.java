package org.sistema_gerenciamento_notas.command;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.service.ProfessorService;

public class AtribuirDisciplinaCommand implements Command{

    private final ProfessorService professorService;
    private final Professor professor;
    private final Disciplina disciplina;

    public AtribuirDisciplinaCommand(ProfessorService professorService, Professor professor, Disciplina disciplina) {
        this.professorService = professorService;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    @Override
    public void executar() {
        professorService.atribuirDisciplina(professor, disciplina);
    }
}
