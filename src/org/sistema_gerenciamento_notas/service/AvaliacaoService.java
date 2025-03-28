package org.sistema_gerenciamento_notas.service;

import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Disciplina;
import org.sistema_gerenciamento_notas.model.Nota;
import org.sistema_gerenciamento_notas.repository.AvaliacaoRepository;

import java.util.HashMap;
import java.util.Map;

// Implementação do AvaliacaoRepository.
public class AvaliacaoService implements AvaliacaoRepository {

    // Aqui usamos um Map para armazenar as notas por aluno e disciplina (isso é apenas um exemplo de implementação)
    private final Map<Aluno, Map<Disciplina, Nota>> avaliacaoMap = new HashMap<>();

    @Override
    public void aplicar(Aluno aluno, Disciplina disciplina, Nota nota) {
        // Verifica se o aluno já tem um mapa de disciplinas e notas
        avaliacaoMap.putIfAbsent(aluno, new HashMap<>());

        // Aplica a nota ao aluno na disciplina correspondente
        avaliacaoMap.get(aluno).put(disciplina, nota);

        // Exibe uma mensagem de confirmação
        System.out.println("Nota de " + nota.getNotasMap() + " aplicada a " + aluno.getNome() + " na disciplina " + disciplina.getNomeDisciplina());
    }

    // Método para acessar as notas armazenadas (poderia ser útil em testes ou outras operações)
    public Map<Aluno, Map<Disciplina, Nota>> getAvaliacoes() {
        return avaliacaoMap;
    }
}
