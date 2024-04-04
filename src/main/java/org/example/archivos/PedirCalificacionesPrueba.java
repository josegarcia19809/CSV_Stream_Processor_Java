package org.example.archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PedirCalificacionesPrueba {
    public static void main(String[] args) {
        try {
            FileWriter archivo = new FileWriter("calificaciones_examenes.txt");
            PrintWriter escritor = new PrintWriter(archivo);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Dame número de alumnos: ");
            int numAlumnos = scanner.nextInt();

            for (int i = 0; i < numAlumnos; i++) {
                System.out.println("-".repeat(50));
                System.out.print("Dame nombre: ");
                String nombre = scanner.next();
                System.out.print("Dame apellido: ");
                String apellido = scanner.next();
                System.out.print("Ingresa la calificación 1: ");
                int calificacion1 = scanner.nextInt();
                System.out.print("Ingresa la calificación 2: ");
                int calificacion2 = scanner.nextInt();
                System.out.print("Ingresa la calificación 3: ");
                int calificacion3 = scanner.nextInt();
                escritor.printf("%s, %s, %d, %d, %d\n", nombre, apellido, calificacion1,
                        calificacion2, calificacion3);
            }

            scanner.close();
            escritor.close();
            archivo.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
