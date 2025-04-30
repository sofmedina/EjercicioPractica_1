package Relaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Escuela {

    private int numero;
    private String denominacion;
    private List<DivisionCurso> divisionCursos = new ArrayList();

    public Escuela() {
    }

    public Escuela(int numero, String denominacion) {
        this.numero = numero;
        this.denominacion = denominacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<DivisionCurso> getDivisionCursos() {
        return divisionCursos;
    }

    public void setDivisionCursos(List<DivisionCurso> divisionCursos) {
        this.divisionCursos = divisionCursos;
    }

    //A.5 Mejor alumno por año de nacimiento sin desaprobados
    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (DivisionCurso division : divisionCursos) {
            for (Alumno alumno : division.getAlumnos()) {
                if (alumno.getFechaNacimiento().getYear() == anioNacimientoAlumno &&
                        !alumno.tieneDesaprobados()) {

                    double promedio = alumno.promedioNotas(null);
                    if (promedio > mejorPromedio) {
                        mejorPromedio = promedio;
                        mejorAlumno = alumno;
                    }
                }
            }
        }

        return mejorAlumno;
    }

    // A.6 - Los 3 mejores alumnos por año de nacimiento sin desaprobados
    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {
        List<Alumno> candidatos = new ArrayList<>();
        for (DivisionCurso division : divisionCursos) {
            for (Alumno alumno : division.getAlumnos()) {
                if (alumno.getFechaNacimiento().getYear() == anioNacimientoAlumno &&
                        !alumno.tieneDesaprobados()) {
                    candidatos.add(alumno);
                }
            }
        }

        Collections.sort(candidatos, new Comparator<Alumno>() {
            @Override
            public int compare(Alumno a1, Alumno a2) {
                return Double.compare(
                        a2.promedioNotas(null),
                        a1.promedioNotas(null)
                );
            }
        });

        List<Alumno> mejores = new ArrayList<>();
        for (int i = 0; i < 3 && i < candidatos.size(); i++) {
            mejores.add(candidatos.get(i));
        }

        return mejores;
    }

}




