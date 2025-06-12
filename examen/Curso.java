package examen;
public abstract class Curso {
    private String nombre;
    private int duracionSemanas;
    private double precio;
    private Docente docente;

    public Curso(String nombre, int duracionSemanas, double precio) {
        this.nombre = nombre;
        this.duracionSemanas = duracionSemanas;
        this.precio = precio;
    }

    public void asignarDocente(Docente docente) {
        this.docente = docente;
    }

    public void mostrarResumen() {
        System.out.println("Curso: " + nombre);
        System.out.println("Duración: " + duracionSemanas + " semanas");
        System.out.println("Precio: $" + precio);
        System.out.println("Docente: " + docente.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionSemanas() {
        return duracionSemanas;
    }

    public double getPrecio() {
        return precio;
    }

    public Docente getDocente() {
        return docente;
    }
}