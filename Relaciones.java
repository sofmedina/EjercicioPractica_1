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
        Alumno mejor = catedra.mejorAlumnoCatedra();
        System.out.println("El mejor alumno de la cátedra es: " + mejor.getNombre());
    }

    }
