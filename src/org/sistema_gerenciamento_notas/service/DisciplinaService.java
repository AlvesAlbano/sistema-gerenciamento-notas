package org.sistema_gerenciamento_notas.service;

import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.repository.DisciplinaRepository;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaService implements DisciplinaRepository {
    private List<Disciplina> listaDisciplinas = new ArrayList<>();

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    @Override
    public void adicionarDisciplina(Disciplina disciplina) {
        listaDisciplinas.add(disciplina);
    }

    @Override
    public void removerDisciplina(int idDisciplina) {
        listaDisciplinas.removeIf(
                disciplina -> disciplina.getIdDisciplina() == idDisciplina
        );
    }

    @Override
    public void listarDisciplinas() {
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
}
