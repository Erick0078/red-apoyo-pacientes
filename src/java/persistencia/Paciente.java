package persistencia;

public class Paciente {

    private String nombre;
    private int edad;
    private String historiaClinica;
    private String estado;

    public Paciente() {
    }

    public Paciente(String nombre, int edad, String historiaClinica, String estado) {
        this.nombre = nombre;
        this.edad = edad;
        this.historiaClinica = historiaClinica;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{"
                + "nombre=" + nombre
                + ", edad=" + edad
                + ", historiaClinica=" + historiaClinica
                + ", estado=" + estado + '}';
    }
}
