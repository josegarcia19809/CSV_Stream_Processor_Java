package org.example.Personas;

import java.util.ArrayList;

public class PruebaPersonas {
    public static void main(String[] args) {
        OperacionesPersona operaciones = new OperacionesPersona();

        ArrayList<Persona> personas;

        System.out.print("-".repeat(20) + "Total de personas: ");
        int total = operaciones.numeroPersonas();
        System.out.printf("%d\n", total);

        System.out.print("-".repeat(20) + "Suma de todos los salarios: ");
        double sumaSalarios = operaciones.sumaTodosLosSalarios();
        System.out.printf("$%.2f\n", sumaSalarios);

        System.out.print("-".repeat(20) + "Número de personas con un salario " +
                "mayor a 500: ");
        int cantidad = operaciones.numeroPersonasSalarioMayor500();
        System.out.printf("%d\n", cantidad);


        System.out.print("-".repeat(20) + "Mayor salario entre las personas que " +
                "tengan el apellido \"Robles\": ");
        double mayorSalario = operaciones.mayorSalarioRobles();
        System.out.printf("$%.2f\n", mayorSalario);

        // Imprimir todas las personas
        System.out.print("-".repeat(100) + "Todas las personas: ");
        personas = operaciones.getListaPersonas();
        imprimirLista(personas);

        // Personas que hayan nacido después del 2000
        System.out.print("-".repeat(100) + "Personas que nacieron después del 2000: ");
        personas = operaciones.personasDespues2000();
        imprimirLista(personas);

        System.out.print("-".repeat(100) + "Personas que se apellidan Robles: ");
        personas = operaciones.losRobles();
        imprimirLista(personas);

        // Pasar por parámetro el apellido
        System.out.print("-".repeat(100) + "Personas que se apellidan Méndez: ");
        personas = operaciones.obtenerPersonasPorApellido("Méndez");
        imprimirLista(personas);

        System.out.print("-".repeat(100) + "Personas que se apellidan Munguia: ");
        personas = operaciones.obtenerPersonasPorApellido("Munguia");
        imprimirLista(personas);

        System.out.print("-".repeat(100) + "Personas cuyo coeficiente sea entre 5 y " +
                "10: ");
        personas = operaciones.conCoeficienteEntre5y10();
        imprimirLista(personas);

    }

    public static void imprimirLista(ArrayList<Persona> personas) {
        System.out.println(personas.size());
        for (Persona persona : personas) {
            System.out.println(persona);
        }
        System.out.println();
    }
}
