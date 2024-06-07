package org.example.codigosQR_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerAlumnos {
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
            String sqlQuery = "SELECT * FROM alumnos";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Procesar los resultados
            while (resultSet.next()) {
                // Aquí puedes obtener los datos de cada fila del ResultSet
                int idAlumno = resultSet.getInt("idAlumno");
                String nombreAlumno = resultSet.getString("nombreAlumno");
                String carrera = resultSet.getString("carrera");

                // Hacer algo con los datos obtenidos
                System.out.println(idAlumno + ", Nombre: " + nombreAlumno +
                        ", carrera: " + carrera);
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
