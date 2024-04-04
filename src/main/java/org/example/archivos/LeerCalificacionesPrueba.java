package org.example.archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerCalificacionesPrueba {
    public static void main(String[] args) {
        try {
            FileReader archivo = new FileReader("calificaciones_clase.txt");
            BufferedReader lector = new BufferedReader(archivo);

            List<String> listaValores = new ArrayList<>();
            List<Integer> listaCalificaciones = new ArrayList<>();

            // Lee todas las calificaciones y las guarda en listaValores
            String linea;
            while ((linea = lector.readLine()) != null) {
                listaValores.add(linea);
            }

            archivo.close();
            lector.close();

            // Convertir la lista de valores a una lista numérica de calificaciones
            for (String valor : listaValores) {
                listaCalificaciones.add(Integer.parseInt(valor));
            }

            System.out.println(listaCalificaciones);

            // Suma todos los valores de la lista
            int suma = 0;
            for (int num : listaCalificaciones) {
                suma += num;
            }

            // Para obtener el número de elementos de listaCalificaciones
            int N = listaCalificaciones.size();

            System.out.println("La suma de todas las calificaciones es " + suma);
            System.out.println("Cantidad de calificaciones: " + N);
            System.out.println("El promedio es " + ((double) suma / N));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir la calificación a entero: " + e.getMessage());
        }
    }
}

