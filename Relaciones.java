package Relaciones;

import java.util.Date;

public class Relaciones {
    public static void main(String[] args) {

        // Creaamos una cátedra
        Catedra catedra = new Catedra(1, "Matemática");

        // Creamos los alumnos
        Alumno Luz = new Alumno(1001, "Luz", "Gómez", new Date());
        Alumno Matias = new Alumno(1002, "Matias", "Pérez", new Date());

        // Creamos las notas
        Nota notaLuz1 = new Nota(1, 8.5, new Date(), false);
        notaLuz1.setCatedra(catedra);
        notaLuz1.setAlumno(Luz);

        Nota notaLuz2 = new Nota(2, 9.0, new Date(), false);
        notaLuz2.setCatedra(catedra);
        notaLuz2.setAlumno(Luz);

        Nota notaMatias1 = new Nota(3, 7.0, new Date(), false);
        notaMatias1.setCatedra(catedra);
        notaMatias1.setAlumno(Matias);

        Nota notaMatias2 = new Nota(4, 6.5, new Date(), false);
        notaMatias2.setCatedra(catedra);
        notaMatias2.setAlumno(Matias);

        // Asignar notas a los alumnos
        Luz.getNotas().add(notaLuz1);
        Luz.getNotas().add(notaLuz2);
        Matias.getNotas().add(notaMatias1);
        Matias.getNotas().add(notaMatias2);

        // Asignar alumnos a la cátedra
        catedra.getAlumnos().add(Luz);
        catedra.getAlumnos().add(Matias);

        // Probando el metodo
        Alumno mejorAlumnoCatedra = catedra.mejorAlumnoCatedra();
        System.out.println("El mejor alumno de la cátedra es: " + mejorAlumnoCatedra.getNombre());

    // A.4
        // Creamos la escuela y la división
        Escuela escuela = new Escuela(1, "Escuela Técnica");
        DivisionCurso division = new DivisionCurso(101, 2024, 1);
        division.setEscuela(escuela);
        escuela.getDivisionCursos().add(division);

        // Creamos una cátedra y la agregamos a la división
        Catedra matematica = new Catedra(1, "Matemática");
        matematica.setDivisionCurso(division);
        division.getCatedras().add(matematica);

        // Creamos algunos alumnos
        Alumno maria = new Alumno(1001, "María", "Lopez", new Date());
        Alumno tomas = new Alumno(1002, "Tomás", "Suarez", new Date());

        // Agregamos notas para María (sin recuperatorios)
        for (int i = 0; i < 5; i++) {
            Nota nota = new Nota(i + 1, 9.0, new Date(), false);
            nota.setAlumno(maria);
            nota.setCatedra(matematica);
            maria.getNotas().add(nota);
        }

        // Agregamos notas para Tomás (una es recuperatorio)
        for (int i = 0; i < 4; i++) {
            Nota nota = new Nota(i + 10, 8.0, new Date(), false);
            nota.setAlumno(tomas);
            nota.setCatedra(matematica);
            tomas.getNotas().add(nota);
        }
        Nota recuperatorio = new Nota(20, 7.0, new Date(), true);
        recuperatorio.setAlumno(tomas);
        recuperatorio.setCatedra(matematica);
        tomas.getNotas().add(recuperatorio);

        // Agregamos a los alumnos a la cátedra
        matematica.getAlumnos().add(maria);
        matematica.getAlumnos().add(tomas);

        // Probando el metodo
        Alumno mejorAlumnoDivisionCurso = division.mejorAlumnoDivisionCurso();

        if (mejorAlumnoDivisionCurso != null) {
            System.out.println("El mejor alumno de la división es: " + mejorAlumnoDivisionCurso.getNombre());
        } else {
            System.out.println("No hay alumno que cumpla las condiciones.");
        }
    }
}
