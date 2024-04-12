package org.example.Peliculas;

public class Pelicula {
    private int id;
    private String nombre;
    private String genero;
    private int anio;
    private double calificacion_imdb;

    public Pelicula(int id, String nombre, String genero, int anio, double calificacion_imdb) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.anio = anio;
        this.calificacion_imdb = calificacion_imdb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getCalificacion_imdb() {
        return calificacion_imdb;
    }

    public void setCalificacion_imdb(double calificacion_imdb) {
        this.calificacion_imdb = calificacion_imdb;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id: " + id +
                ", nombre: '" + nombre + '\'' +
                ", genero: '" + genero + '\'' +
                ", anio: " + anio +
                ", calificacion_imdb: " + calificacion_imdb +
                '}';
    }
}
