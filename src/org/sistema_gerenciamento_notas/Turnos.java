package org.sistema_gerenciamento_notas;

public enum Turnos {
    MANHA (1),
    TARDE (2),
    NOITE (3),
    INTEGRAL (4);

    private final int codigoTurno;

    Turnos(int i) {
        this.codigoTurno = i;
    }

    public int getCodigoTurno(){
        return codigoTurno;
    }

    public static Turnos getTurno(int codigoTurno){

        for(Turnos turno: Turnos.values()){
            if (turno.getCodigoTurno() == codigoTurno){
                return turno;
            }
        }

        return null;
    }

}
