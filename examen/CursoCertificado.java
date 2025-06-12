package examen;


public class CursoCertificado extends CursoRegular {
    public CursoCertificado(String nombre, int duracionSemanas, double precio) {
        super(nombre, duracionSemanas, precio);
    }



    @Override
    public void mostrarResumen() {
        System.out.println("Curso Certificado: " + getNombre());
        System.out.println("Duración: " + getDuracionSemanas() + " semanas");
        System.out.println("Precio: "+getPrecio());
        System.out.println("Docente: " + getDocente().getNombre());
    }
}