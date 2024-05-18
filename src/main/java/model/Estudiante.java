package model;

public class Estudiante {

    private String nombre;

    private String apellido;

    private String matricula;

    private String dni;

    public Estudiante(String nombre, String apellido, String matricula, String dni) {
        setNombre(nombre);
        setApellido(apellido);
        setMatricula(matricula);
        setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        //if (nombre == null || nombre.isEmpty()) {
        //   throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        //}
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
