package org.sistema_gerenciamento_notas.observer;

import org.sistema_gerenciamento_notas.model.Professor;

public interface ProfessorObserver {
    void onProfessorContratado(Professor professor);
    void onProfessorDemitido(Professor professor);
}