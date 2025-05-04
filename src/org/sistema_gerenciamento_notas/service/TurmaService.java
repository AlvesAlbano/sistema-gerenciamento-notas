package org.sistema_gerenciamento_notas.service;

import org.sistema_gerenciamento_notas.Turnos;
import org.sistema_gerenciamento_notas.factory.TurmaFactory;
import org.sistema_gerenciamento_notas.model.Aluno;
import org.sistema_gerenciamento_notas.model.Professor;
import org.sistema_gerenciamento_notas.model.Turma;
import org.sistema_gerenciamento_notas.repository.TurmaRepository;

import java.util.*;

public class TurmaService implements TurmaRepository {

//    private final ArrayList<Turma> listaTurmas = new ArrayList<>();
//    private final Map<String,Turma> listaTurmas = new HashMap<>();
    private final Map<String, List<Turma>> listaTurmas = new HashMap<>();

//    public Map<String, Turma> getListaTurmas() {
//        return listaTurmas;
//    }

    public Map<String, List<Turma>> getListaTurmas() {
        return listaTurmas;
    }

    @Override
    public void criarTurma() {

        final Scanner input = new Scanner(System.in);

        System.out.println("Digite o turno na turma: ");
        System.out.println("1 - MANHÃ");
        System.out.println("2 - TARDE");
        System.out.println("3 - NOITE");
        System.out.println("4 - INTEGRAL");

        final int codigoTurno = input.nextInt();
        String turno = Turnos.getTurno(codigoTurno).toString();

        System.out.println("Digite a série (Entre 1 - 9): ");
        final byte serie = input.nextByte();

        System.out.println("Digite a letra da turma: ");
        final char id = input.next().toUpperCase().charAt(0);

        Turma novaTurma = TurmaFactory.criarTurma(serie,turno,id);

        listaTurmas.putIfAbsent(turno,new ArrayList<>());
        listaTurmas.get(turno).add(novaTurma);



//        final int codigoTurno = input.nextInt();
//
//        String turno = Turnos.getTurno(codigoTurno).name();
//
//        System.out.println("Digite a serie: (Entre 1 - 9)");
//        final byte serie = input.nextByte();
//
//        System.out.println("Digite a letra da turma: ");
//        final char id = input.next().toUpperCase().charAt(0);
//
    }

    @Override
    public void adicionarAluno(Aluno aluno) {
        listarTurmas();

        final Scanner input = new Scanner(System.in);

        System.out.println("Digite o id do turno: ");
        System.out.println("1 - MANHÃ");
        System.out.println("2 - TARDE");
        System.out.println("3 - NOITE");
        System.out.println("4 - INTEGRAL");

        final int idTurno = input.nextInt();

        System.out.println("Digite o indice da turma");
        final int indiceTurma = input.nextInt();

        var turma = retornarTurmaPorId(idTurno,indiceTurma);

        turma.getListaAlunos().add(aluno);
    }

    @Override
    public void dissolverTurma() {
        listarTurmas();

        System.out.println("Digite o turno na turma: ");
        System.out.println("1 - MANHÃ");
        System.out.println("2 - TARDE");
        System.out.println("3 - NOITE");
        System.out.println("4 - INTEGRAL");

        final Scanner input = new Scanner(System.in);
        final int codigoTurno = input.nextInt();

        System.out.println("Digite o indice da turma:");
        final int indiceTurma = input.nextInt();

        String turno = Turnos.getTurno(codigoTurno).name();
        List<Turma> turmasTurno = listaTurmas.get(turno);

        turmasTurno.remove(indiceTurma);
    }

    @Override
    public void listarTurmas() {
        for(String turno: listaTurmas.keySet()){
            System.out.printf("TURNO %s\n",turno);
//            for(Turma turma: listaTurmas.get(turno)){
//                System.out.println();
//            }

            for(int i = 0;i < listaTurmas.get(turno).size();i++){
                Turma turma = listaTurmas.get(turno).get(i);
                System.out.printf("%d - %s\n",i,turma);
            }
        }
    }

    @Override
    public Turma retornarTurmaPorId(int idTurno, int indiceTurma) {
        Turnos turnoEnum = Turnos.getTurno(idTurno);

        if (turnoEnum == null) {
            System.out.println("Turno inválido.");
            return null;
        }

        String turno = turnoEnum.name();

        List<Turma> turmasTurno = listaTurmas.get(turno);

        if (turmasTurno != null && indiceTurma >= 0 && indiceTurma < turmasTurno.size()) {
            return turmasTurno.get(indiceTurma);
        }

        return null;
    }

}