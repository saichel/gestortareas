package com.venanaciob.dam.gestortareas;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {

    private final List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        tareas = new ArrayList<>();
        siguienteId = 1;
    }

    public Tarea crearTarea(String descripcion) {

        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        Tarea tarea = new Tarea(siguienteId++, descripcion);
        tareas.add(tarea);

        return tarea;
    }

    public List<Tarea> obtenerTareas() {
        return new ArrayList<>(tareas);
    }

    public boolean completarTarea(int id) {

        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.completar();
                return true;
            }
        }

        return false;
    }

    public boolean eliminarTarea(int id) {
        return tareas.removeIf(tarea -> tarea.getId() == id);
    }

}
