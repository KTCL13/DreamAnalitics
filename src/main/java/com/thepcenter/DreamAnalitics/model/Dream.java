package com.thepcenter.DreamAnalitics.model;


public class Dream {
    private String descripcion;
    private int duracion;
    private String intensidadEmocional;
    private String claridadVisual;
    private String nivelConciencia;

    // Constructor sin argumentos requerido por Jackson
    public Dream() {
    }

    public Dream(String descripcion, int duracion, String intensidadEmocional, String claridadVisual, String nivelConciencia) {
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.intensidadEmocional = intensidadEmocional;
        this.claridadVisual = claridadVisual;
        this.nivelConciencia = nivelConciencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getIntensidadEmocional() {
        return intensidadEmocional;
    }

    public void setIntensidadEmocional(String intensidadEmocional) {
        this.intensidadEmocional = intensidadEmocional;
    }

    public String getClaridadVisual() {
        return claridadVisual;
    }

    public void setClaridadVisual(String claridadVisual) {
        this.claridadVisual = claridadVisual;
    }

    public String getNivelConciencia() {
        return nivelConciencia;
    }

    public void setNivelConciencia(String nivelConciencia) {
        this.nivelConciencia = nivelConciencia;
    }

    @Override
    public String toString() {
        return "Descripción: " + descripcion + ", duración: " + duracion + " min, intensidad emocional: " +
                intensidadEmocional + ", claridad visual: " + claridadVisual + ", nivel de conciencia: " + nivelConciencia;
    }
}