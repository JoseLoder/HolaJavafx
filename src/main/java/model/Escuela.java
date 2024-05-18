package model;

import java.util.ArrayList;

public class Escuela {

    private ArrayList<Estudiante> listaEstudiantes;

    private static Escuela instance;

    private Escuela() {
        listaEstudiantes = new ArrayList<>();
    }

    public static Escuela getInstance() {
        if (instance == null) {
            instance = new Escuela();
        }
        return instance;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void aniadirEstudiante(Estudiante estudiante) {

        listaEstudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        listaEstudiantes.remove(estudiante);
    }

    public void modificarEstudiante(Estudiante estudiante) {

        for (Estudiante e : listaEstudiantes) {
            if (e.getDni().equals(estudiante.getDni())) {
                e.setNombre(estudiante.getNombre());
                e.setApellido(estudiante.getApellido());
                e.setDni(estudiante.getDni());
                e.setMatricula(estudiante.getMatricula());

            }
        }
    }

}
