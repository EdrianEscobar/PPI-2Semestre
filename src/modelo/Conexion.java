package modelo;

import java.sql.*;


public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/punto_venta_java";
    public static final String USER = "root";
    public static final String CLAVE = "";

   
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la clase conexión: " + e.getMessage());
        }
        return con;
    }

}
