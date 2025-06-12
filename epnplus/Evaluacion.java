package epnplus;

public class Evaluacion {
    private double nota;

    public Evaluacion(double nota) {
        this.nota = nota;
    }

    public String getResultado() {
        return (nota >= 7) ? "Aprobado" : "Reprobado";
    }

    public double getNota() {
        return nota;
    }
}

