package com.mycompany.conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMYSQL {

    public static final String URL = "jdbc:mysql://localhost:3306/ventas";
    public static final String USUARIO = "root";
    public static final String CONTRASENIA = "root";

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);

            if (conexion != null) {
//                System.out.println("Conexión a la base de datos exitosa!");
//                
                RecuperarDatos recuperarDatos = new RecuperarDatos();
                recuperarDatos.recuperar(conexion);

//                InsertarDatos insertarDatos = new InsertarDatos();
//                insertarDatos.inserta(conexion, 5, "Play Station 5", 1500000.50, 10);

//                ModificarDatos modificarDatos = new ModificarDatos();
//                modificarDatos.modificar(conexion, 3, "MACBOOK M3", 2500000.55, 4);

//                BorrarDatos borrarDatos = new BorrarDatos();
//                borrarDatos.eliminar(conexion, 5);
                        
                

            }

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion. " + e.getMessage());
            }

        }

    }
}
