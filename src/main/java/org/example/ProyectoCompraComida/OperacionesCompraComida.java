package org.example.ProyectoCompraComida;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperacionesCompraComida {
    private ArrayList<CompraComida> transacciones;

    public OperacionesCompraComida() {
        transacciones = leerArchivoCSV();
    }


    public ArrayList<CompraComida> leerArchivoCSV() {
        ArrayList<CompraComida> compras = new ArrayList<>();
        String archivo = "foods.csv";
        try (CSVReader reader = new CSVReader(new FileReader(archivo))) {
            reader.skip(1);
            List<String[]> data = reader.readAll();
            for (String[] row : data) {
                String nombre = row[0];
                String genero = row[1];
                 String ciudad= row[2];
                 String frecuencia= row[3];
                 String articulo=row[4];
                 double gasto=Double.parseDouble(row[5]);

                // Añadir a la lista personas
                compras.add(new CompraComida(nombre, genero, ciudad, frecuencia,
                        articulo, gasto));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return compras;
    }

    public void mostrarFrecuenciasCompraPorCiudad(){
        // Agrupar por ciudad y contar la frecuencia de compra para cada ciudad
        Map<String, Map<String, Long>> frecuenciaPorCiudad = transacciones.stream()
                .collect(Collectors.groupingBy(CompraComida::getCiudad,
                        Collectors.groupingBy(CompraComida::getFrecuencia,
                                Collectors.counting())));

        // Mostrar el reporte
        System.out.println("Reporte de frecuencia de compra por ciudad:");
        frecuenciaPorCiudad.forEach((ciudad, frecuencias) -> System.out.println(ciudad +
                ": " + frecuencias));

        // Calcular la frecuencia de compra promedio por ciudad
        Map<String, Map<String, Double>> frecuenciaPromedioPorCiudad = new HashMap<>();
        transacciones.stream()
                .collect(Collectors.groupingBy(CompraComida::getCiudad,
                        Collectors.groupingBy(CompraComida::getFrecuencia,
                                Collectors.averagingDouble(t -> 1))))
                .forEach((ciudad, frecuencias) -> {
                    Map<String, Double> promedios = frecuencias.entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getKey,
                                    e -> e.getValue().doubleValue()));
                    frecuenciaPromedioPorCiudad.put(ciudad, promedios);
                });

        // Mostrar la frecuencia de compra promedio por ciudad
        System.out.println("\nFrecuencia de compra promedio por ciudad:");
        frecuenciaPromedioPorCiudad.forEach(
                (ciudad, promedios) -> System.out.println(ciudad + ": " + promedios));
    }
}
