package org.example.Personas;

import java.util.ArrayList;

public class PruebaPersonas {
    public static void main(String[] args) {
        OperacionesPersona operaciones = new OperacionesPersona();

        ArrayList<Persona> personas;

        // Imprimir todas las personas
        System.out.println("-".repeat(100) + "Todas las personas");
        personas = operaciones.getListaPersonas();
        imprimirLista(personas);

        // Personas que hayan nacido después del 2000
        System.out.println("-".repeat(100) + "Personas que nacieron después del 2000:");
        personas = operaciones.personasDespues2000();
        imprimirLista(personas);

        System.out.println("-".repeat(100) + "Personas que se apellidan Robles:");
        personas = operaciones.losRobles();
        imprimirLista(personas);

    }

    public static void imprimirLista(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
        System.out.println("-".repeat(120));
        System.out.println("Cantidad de personas: " + personas.size());
    }
}
