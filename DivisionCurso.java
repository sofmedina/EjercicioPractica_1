package Relaciones;

import java.util.ArrayList;
import java.util.List;

public class DivisionCurso {

    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private List<Catedra> catedras = new ArrayList();

    public DivisionCurso() {
    }

    public DivisionCurso(int codigo, int anio, int division) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public List<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(List<Catedra> catedras) {
        this.catedras = catedras;
    }

    // A.4
    public Alumno mejorAlumnoDivisionCurso(){
        Alumno mejorAlumno = null; // Acá vamos a guardar el mejor
        double mejorPromedio = 0;

        // Recorremos todas las cátedras
        for (Catedra catedra : catedras) {
            // Recorremos todos los alumnos de cada cátedra
            for (Alumno alumno : catedra.getAlumnos()) {
                List<Nota> notas = alumno.getNotas();
                int cantidad = 0;
                double suma = 0;
                boolean tieneRecuperatorio = false;

                // Recorremos las notas del alumno
                for (Nota nota : notas) {
                    if (nota.isEsRecuperatorio()) {
                        tieneRecuperatorio = true;  //si el alumno tiene recuperatorios, no se cuenta.
                        break;
                    }
                    cantidad++;
                    suma += nota.getValor();
                }

                // Evaluamos si cumple las condiciones (de tener 5 notas y que no haya recuperado)
                if (!tieneRecuperatorio && cantidad >= 5) {
                    double promedio = suma / cantidad;
                    if (promedio > mejorPromedio) {
                        mejorPromedio = promedio;
                        mejorAlumno = alumno;
                    }
                }
            }
        }

        return mejorAlumno;
    }

}
