package com.mycompany.conexionmysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ModificarDatos {
    public void modificar(Connection conexion, int id_producto, String nombre, double precio, int cantidad){
        String consulta = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id_producto = ?";
        
        try{
            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, cantidad);
            pstmt.setInt(4, id_producto);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if(filasAfectadas > 0){
                System.out.println(filasAfectadas + " dato(s) modificado(s) con éxito.");            
            } else {
                System.out.println("No se encuentra empleado con el id proporcionado.");            
            }           
        
        }catch(SQLException e){
            System.out.println("Error al modificar los datos. " + e.getMessage());
        }
    
    }
}
