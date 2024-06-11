package org.example.codigosQR_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatosAlumnos {
    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/registrosqr";
        String usuario = "root";
        String contrasenia = "";

        // Consulta SQL para insertar datos
        String consultaSQL = "INSERT INTO alumnos (nombreAlumno, noCuenta, carrera," +
                " grupo" + ") VALUES (?, ?, ?, ?)";

        // Conexión y ejecución
        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
             PreparedStatement ps = conexion.prepareStatement(consultaSQL)) {

            // Establece los parámetros de la consulta
            ps.setString(1, "Juan Perez");
            ps.setString(2, "991234");
            ps.setString(3, "Ingeniería Informática");
            ps.setString(4, "II401");

            // Ejecuta la consulta
            int filasInsertadas = ps.executeUpdate();

            // Verifica si la inserción fue exitosa
            if (filasInsertadas > 0) {
                System.out.println("¡Un nuevo usuario fue insertado exitosamente!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
