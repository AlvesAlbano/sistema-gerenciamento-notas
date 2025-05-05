package org.sistema_gerenciamento_notas.controller;

import org.sistema_gerenciamento_notas.factory.TurmaFactory;
import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Turma;
import org.sistema_gerenciamento_notas.service.TurmaService;

import java.util.ArrayList;

public class GestaoTurma {
    private final TurmaService turmaService = new TurmaService();

    public void criarTurma(){
        turmaService.criarTurma();
    }

    /*
    * construtor de teste
     */
    public GestaoTurma(){
        Turma turma = TurmaFactory.criarTurma((byte)1,"MANHA",'A');
        String turno = "MANHA";
        turmaService.getListaTurmas().putIfAbsent(turno, new ArrayList<>());
        turmaService.getListaTurmas().get(turno).add(turma);
    }

    public void listarTurmas(){
        turmaService.listarTurmas();
    }

    public void adicionarAluno(Aluno aluno){
        turmaService.adicionarAluno(aluno);
    }

    public void dissolverTurma(){
        turmaService.dissolverTurma();
    }

}