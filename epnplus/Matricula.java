package epnplus;

public class Matricula {
    private Estudiante estudiante;
    private Curso curso;
    private Evaluacion evaluacion;

    public Matricula(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public void registrarEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public void mostrarDetalle() {
        estudiante.mostrarDatos();
        curso.mostrarResumen();
        if (evaluacion != null) {
            System.out.println("Nota: " + evaluacion.getNota() + " - Resultado: " + evaluacion.getResultado());
        } else {
            System.out.println("Sin evaluación registrada.");
        }
    }
}
