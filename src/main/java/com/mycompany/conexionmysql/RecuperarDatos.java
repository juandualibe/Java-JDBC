package com.mycompany.conexionmysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class RecuperarDatos {

    public void recuperar(Connection conexion) {
        String consulta = "SELECT * FROM productos";

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {

                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                System.out.println("ID Producto: " + id_producto);
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Cantidad: " + cantidad);

                System.out.println("-----------------------------------");
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al recuperar los datos. " + e.getMessage());
        }
    }

}
