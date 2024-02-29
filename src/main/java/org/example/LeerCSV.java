package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeerCSV {
    public static void main(String[] args) {
        String csvFile = "imdb.csv"; // Nombre del archivo CSV
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> data = reader.readAll(); // Lee todo el contenido del archivo CSV
            // Procesa los datos
            for (String[] row : data) {
                for (String cell : row) {
                    System.out.print(cell + "\t\t");
                }
                System.out.println(); // Nueva línea para cada fila
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
