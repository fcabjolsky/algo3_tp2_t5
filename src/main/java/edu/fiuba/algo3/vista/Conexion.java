package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.Manager;

import java.sql.*;
public class Conexion {

    private String getURL() {
        return "jdbc:mysql://" + edu.fiuba.algo3.vista.Manager.HOST + ":" + edu.fiuba.algo3.vista.Manager.PORT + "/" + edu.fiuba.algo3.vista.Manager.DB;
    }

    public Connection getConexion() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = java.sql.DriverManager.getConnection(this.getURL(), edu.fiuba.algo3.vista.Manager.USER, Manager.PWD);

            if (conexion != null) {
                System.out.println("La conexion a la base se genero exitosamente");
                return conexion;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de seguimiento en getconnection():" + e.getMessage());
        }
        return conexion;
    }


}
