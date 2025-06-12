package Main;
import examen.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Matricula> matriculas = new ArrayList<>();

        Docente d1 = new Docente("Carlos Pérez", "D001");
        Docente d2 = new Docente("Ana Torres", "D002");

        CursoRegular curso1 = new CursoRegular("Matemáticas Básicas", 8, 150.0);
        curso1.asignarDocente(d1);

        CursoCertificado curso2 = new CursoCertificado("Programación en Java", 10, 200.0);
        curso2.asignarDocente(d2);

        System.out.println("=== Bienvenido a EPN-PLUS ===");
        System.out.println("Cursos disponibles:");
        System.out.println("1. " + curso1.getNombre());
        System.out.println("2. " + curso2.getNombre());
        System.out.print("Elige una opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        Curso cursoElegido;
        if (op == 1) {
            cursoElegido = curso1;
        } else if (op == 2) {
            cursoElegido = curso2;
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        cursoElegido.mostrarResumen();

        String seguir = "s";
        while (seguir.equalsIgnoreCase("s")) {
            System.out.println("\n== Inscribir estudiante ==");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            if (edad < 13 || edad > 60) {
                System.out.println("Edad no permitida. (13 a 60 años)");
                continue;
            }

            System.out.print("Cedula: ");
            String id = sc.nextLine();

            System.out.print("Nota (0-10): ");
            double nota = sc.nextDouble();
            sc.nextLine();

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                continue;
            }

            Estudiante est = new Estudiante(nombre, edad, id);
            Matricula m = new Matricula(est, cursoElegido);
            m.registrarEvaluacion(new Evaluacion(nota));

            matriculas.add(m);
            System.out.println("Estudiante inscrito con éxito.");

            System.out.print("¿Deseas inscribir otro estudiante? (s/n): ");
            seguir = sc.nextLine();
        }

        System.out.println("\n=== Lista de Inscritos ===");
        for (Matricula m : matriculas) {
            m.mostrarDetalle();
            System.out.println("--------------------------");
        }

        sc.close();
    }
}



