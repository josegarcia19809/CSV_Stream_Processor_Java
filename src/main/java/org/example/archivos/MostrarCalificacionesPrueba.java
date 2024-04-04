package org.example.archivos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MostrarCalificacionesPrueba {
    public static void main(String[] args) {
        try {
            FileReader archivo = new FileReader("calificaciones_examenes.txt");
            BufferedReader lector = new BufferedReader(archivo);

            System.out.println();
            System.out.printf("%10s%10s%5s%5s%5s%n", "Nombre", "Apellido", "1C",
                    "2C", "3C");
            System.out.println("-".repeat(36));

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] elementos = linea.split(", ");
                String nombre = elementos[0];
                String apellido = elementos[1];
                int c1 = Integer.parseInt(elementos[2]);
                int c2 = Integer.parseInt(elementos[3]);
                int c3 = Integer.parseInt(elementos[4]);
                System.out.printf("%10s%10s%5d%5d%5d%n", nombre, apellido, c1, c2, c3);
            }

            archivo.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

