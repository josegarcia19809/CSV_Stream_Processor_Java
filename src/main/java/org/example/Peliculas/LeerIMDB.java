package org.example.Peliculas;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerIMDB {
    public static void main(String[] args) {
        String csvFile = "imdb.csv"; // Nombre del archivo CSV
        List<Pelicula> peliculas = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Omitir la primera línea(encabezado)
            reader.skip(1);

            List<String[]> data = reader.readAll(); // Lee todo el contenido del archivo CSV
            // Procesa los datos
            for (String[] row : data) {
                int id = Integer.parseInt(row[0]);
                String nombre = row[1];
                String genero = row[2];
                int anio = Integer.parseInt(row[3]);
                double calificacion_imdb =
                        Double.parseDouble(row[4]);
                peliculas.add(new Pelicula(id, nombre,
                        genero, anio, calificacion_imdb));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        // Imprimir el arrayList peliculas
        System.out.println();
        for(Pelicula p: peliculas){
            System.out.println(p.toString());
        }
        System.out.println();
    }
}
