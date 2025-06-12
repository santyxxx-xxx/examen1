package examen;

public class Estudiante {
    private String nombre;
    private int edad;
    private String id;

    public Estudiante(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + ", Edad: " + edad + ", ID: " + id);
    }

    public boolean validarEdad() {
        return edad >= 13 && edad <= 60;
    }
}
