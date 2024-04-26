package org.example.ColeccionMapa;

import java.util.HashMap;
import java.util.Map;

public class MapasJugadores {
    public static void main(String[] args) {
        // Ejemplo de un mapa que almacena el par: nombre de jugador y su equipo
        // Tanto el nombre del jugador como el nombre del equipo, serán String
        Map<String, String> jugadores = new HashMap<>();

        //Inserción de elementos en el mapa
        jugadores.put("Leo Messi", "Barcelona");
        jugadores.put("Luis Suarez", "Barcelona");
        jugadores.put("Arturo Vidal", "Barcelona");
        jugadores.put("Rakitik", "Barcelona");
        jugadores.put("Sergio Ramos", "Real Madrid");
        jugadores.put("Toni Kroos", "Real Madrid");
        jugadores.put("Luka Modric", "Real Madrid");
        jugadores.put("Ansu Fati", null);

        imprimirLinea();
        System.out.println("El equipo de Sergio Ramos es: " +
                jugadores.get("Sergio Ramos"));
        imprimirLinea();

        // Obtener los valores de un mapa
        String equipoLeo = jugadores.get("Leo Messi");
        System.out.println("El equipo de Leo es: " + equipoLeo);
        imprimirLinea();

        String equipoCristiano = jugadores.getOrDefault("Cristiano Ronaldo",
                "No está registrado");
        System.out.println("El equipo de Cristiano Ronaldo es: " + equipoCristiano);
        imprimirLinea();

        // Obtener todas las claves (keys) del mapa
        System.out.println("¿Qué jugadores están registrados?");
        System.out.println(jugadores.keySet());
        imprimirLinea();

        // Obtener todos los valores del mapa
        System.out.println("¿Qué equipos están registrados en relación a los jugadores?");
        System.out.println(jugadores.values());
        imprimirLinea();

        // También podemos conocer el tamaño del mapa (el número de entradas en el mapa).
        System.out.println("El tamaño del mapa es: " + jugadores.size());
        imprimirLinea();

        // Imprimir el par de valores del mapa con un forEach
        System.out.println("Impresión de jugadores y equipos utilizando forEach");
        jugadores.forEach((player, team) -> System.out.println("Jugador: " + player +
                " Equipo: " + team));
        imprimirLinea();
        // Limpiar el mapa por completo.
        jugadores.clear();
        System.out.println("La cantidad de jugadores en el mapa después de " +
                "limpiarlo es: " + jugadores.size());
    }

    public static void imprimirLinea() {
        System.out.println("-".repeat(100));
        System.out.println();
    }
}

