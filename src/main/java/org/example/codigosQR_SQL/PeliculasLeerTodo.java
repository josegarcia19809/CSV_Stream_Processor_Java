package org.example.codigosQR_SQL;

import java.sql.*;

public class PeliculasLeerTodo {
    public static void main(String[] args) {
        // Configuración de la conexión, 127.0.0.1
        String url = "jdbc:mysql://localhost:3306/registrosqr"; // URL de tu base de datos MySQL
        String user = "root"; // Usuario de la base de datos
        String password = ""; // Contraseña de la base de datos

        try {
            // Establecer conexión
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos MySQL.");

            // Aquí puedes ejecutar consultas SQL, realizar operaciones en la base de datos, etc.
            // Crear un Statement
            Statement statement = connection.createStatement();

            // Ejecutar la consulta SQL
            String sqlQuery = "SELECT * FROM peliculas";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Procesar los resultados
            while (resultSet.next()) {
                // Aquí puedes obtener los datos de cada fila del ResultSet
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String genero = resultSet.getString("genero");
                int anio = resultSet.getInt("año");
                double calificacion = resultSet.getDouble("calificacion_imdb");

                // Hacer algo con los datos obtenidos
                System.out.println(id + ", Nombre: " + nombre +
                        ", genero: " + genero + ", año: " + anio +
                        ", calificacion: " + calificacion);
            }

            // Cerrar ResultSet, Statement y Connection
            resultSet.close();
            statement.close();
            // No olvides cerrar la conexión cuando hayas terminado
            connection.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
