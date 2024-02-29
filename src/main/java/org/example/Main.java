package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String csvFile = "datos.csv"; // Nombre del archivo CSV

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Escribir encabezados
            writer.println("Nombre,Apellido,Edad");

            // Escribir datos
            writer.println("Juan,Perez,25");
            writer.println("María,Gomez,30");
            writer.println("Carlos,Rodriguez,35");

            System.out.println("Archivo CSV creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}