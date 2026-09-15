package com.venanaciob.dam.gestortareas;

public class Tarea {

    private final int id;
    private final String descripcion;
    private EstadoTarea estado;

    public Tarea(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = EstadoTarea.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void completar() {
        estado = EstadoTarea.COMPLETADA;
    }

    @Override
    public String toString() {
        return id + ". " + descripcion + " [" + estado + "]";
    }

}
