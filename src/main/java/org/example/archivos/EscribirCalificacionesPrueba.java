package org.example.archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribirCalificacionesPrueba {
    public static void main(String[] args) {
        try {
            FileWriter archivo = new FileWriter("calificaciones_clase.txt");
            PrintWriter escritor = new PrintWriter(archivo);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Ingresa tu calificación (-1 para terminar): ");
                int calificacion = scanner.nextInt();
                if (calificacion == -1) {
                    break;
                }
                escritor.println(calificacion);
            }

            scanner.close();
            escritor.close();
            archivo.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

