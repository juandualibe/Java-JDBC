package com.mycompany.conexionmysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class InsertarDatos {
    public void inserta(Connection conexion, int id_producto, String nombre, double precio, int cantidad){
        String consulta = "INSERT INTO productos (id_producto, nombre, precio, cantidad) VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setInt(1, id_producto);
            pstmt.setString(2, nombre);
            pstmt.setDouble(3, precio);
            pstmt.setInt(4, cantidad);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if(filasAfectadas > 0){
                System.out.println(filasAfectadas + " dato(s) insertado(s) correctamente.");
            
            }
            
        
        }catch(SQLException e){
            System.out.println("Error al insertar datos. " + e.getMessage());
                 
        }
    
    }
}
