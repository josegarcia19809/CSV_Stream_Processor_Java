package org.example.ColeccionMapa;

import java.util.*;

public class PruebaMapas {
    public static void main(String[] args) {
        HashMap<String, Integer> calificaciones = new HashMap<>();
        calificaciones.put("Carlos", 100);
        calificaciones.put("Roberto", 90);
        calificaciones.put("Carolina", 80);
        imprimirMapa(calificaciones);

        // Actualizar calificación de Carlos
        calificaciones.put("Carlos", 60);
        imprimirMapa(calificaciones);

        // Borrar registro de Carlos
        calificaciones.remove("Carlos");
        imprimirMapa(calificaciones);

        // ¿Cuál fue la calificación de Carolina?
        System.out.println("Calificación de Carolina: " +
                calificaciones.get("Carolina")
        );

        // Existe una persona en el mapa?
        if (calificaciones.containsKey("Carolina")) {
            System.out.println("Carolina existe");
        } else {
            System.out.println("No existe Carolina");
        }
    }

    public static void imprimirMapa(HashMap<String, Integer> tabla) {
        // Mostrar los datos
        tabla.forEach(
                (nombre, calificacion) -> {
                    System.out.println(nombre + " " + calificacion);
                }
        );
        System.out.println("----------------------------");
    }
}


