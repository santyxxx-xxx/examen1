package epnplus;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Matricula> matriculas = new ArrayList<>();

        // Docentes predefinidos
        Docente d1 = new Docente("Carlos Pérez", "D001");
        Docente d2 = new Docente("Ana Torres", "D002");

        // Cursos predefinidos
        CursoRegular cr = new CursoRegular("Matemáticas Básicas", 8, 150.0);
        cr.asignarDocente(d1);

        CursoCertificado cc = new CursoCertificado("Programación en Java", 10, 200.0);
        cc.asignarDocente(d2);

        Curso cursoSeleccionado = null;

        // Elegir curso
        System.out.println("=== Bienvenido a EPN-PLUS ===");
        System.out.println("Seleccione el curso al que desea inscribir estudiantes:");
        System.out.println("1. " + cr.getNombre());
        System.out.println("2. " + cc.getNombre());
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            cursoSeleccionado = cr;
        } else if (opcion == 2) {
            cursoSeleccionado = cc;
        } else {
            System.out.println("Opción inválida.");
            return;
        }

        // Validación: curso debe tener docente
        if (cursoSeleccionado.getDocente() == null) {
            System.out.println("¡Error! El curso no tiene docente asignado.");
            return;
        }

        cursoSeleccionado.mostrarResumen();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n== Inscripción de estudiante ==");

            System.out.print("Nombre del estudiante: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            if (edad < 13 || edad > 60) {
                System.out.println("Edad no permitida. Debe estar entre 13 y 60 años.");
                continue;
            }

            System.out.print("ID del estudiante: ");
            String id = sc.nextLine();

            Estudiante est = new Estudiante(nombre, edad, id);
            Matricula m = new Matricula(est, cursoSeleccionado);

            System.out.print("Nota del estudiante (0-10): ");
            double nota = sc.nextDouble();
            sc.nextLine();

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                continue;
            }

            Evaluacion ev = new Evaluacion(nota);
            m.registrarEvaluacion(ev);
            matriculas.add(m);

            System.out.println("Estudiante inscrito con éxito.");
            System.out.print("¿Desea inscribir otro estudiante? (s/n): ");
            String resp = sc.nextLine();
            if (!resp.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("\n=== Resumen de Matrículas ===");
        for (Matricula m : matriculas) {
            m.mostrarDetalle();
            System.out.println("------------------------------");
        }

        sc.close();
    }
}



