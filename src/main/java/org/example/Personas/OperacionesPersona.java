package org.example.Personas;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperacionesPersona {
    private ArrayList<Persona> listaPersonas;

    public OperacionesPersona() {
        this.listaPersonas = leerArchivoCSV();
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Persona> leerArchivoCSV() {
        ArrayList<Persona> personas = new ArrayList<>();
        String archivo = "personas.csv";
        try (CSVReader reader = new CSVReader(new FileReader(archivo))) {
            reader.skip(1);
            List<String[]> data = reader.readAll();
            for (String[] row : data) {
                int id = Integer.parseInt(row[0]);
                String nombre = row[1];
                String apellido = row[2];
                int anioNacimiento = Integer.parseInt(row[3]);
                int salario = Integer.parseInt(row[4]);
                double coeficiente = Double.parseDouble(row[5]);

                // Añadir a la lista personas
                personas.add(new Persona(id, nombre, apellido,
                        anioNacimiento, salario, coeficiente));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return personas;
    }

    public ArrayList<Persona> personasDespues2000() {
        return listaPersonas.stream()
                .filter(persona -> persona.getAnioNacimiento() > 2000)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int numeroPersonas() {
        return (int) listaPersonas.stream().count();
    }

    public ArrayList<Persona> losRobles() {
        return listaPersonas.stream()
                .filter(persona -> persona.getApellido().equalsIgnoreCase("Robles"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Persona> obtenerPersonasPorApellido(String apellido) {
        return listaPersonas.stream()
                .filter(persona -> persona.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Persona> conCoeficienteEntre5y10() {
        return listaPersonas.stream()
                .filter(persona -> persona.getCoeficiente() >= 5
                        && persona.getCoeficiente() <= 10)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public double sumaTodosLosSalarios() {
        return listaPersonas.stream()
                .mapToDouble(persona -> persona.getSalario())
                .sum();
    }


    public int numeroPersonasSalarioMayor500() {
        return (int) listaPersonas.stream()
                .filter(persona -> persona.getSalario() > 500)
                .count();
    }


    public double mayorSalarioRobles() {
        return listaPersonas.stream()
                .filter(persona -> persona.getApellido().
                        equalsIgnoreCase("Robles"))
                .mapToDouble(persona -> persona.getSalario())
                .max().getAsDouble();
    }

}
