package com.mycompany.conexionmysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BorrarDatos {
    public void eliminar(Connection conexion, int id_producto){
        String consulta = "DELETE FROM productos WHERE id_producto = ?";
        
        try{
            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setInt(1, id_producto);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if(filasAfectadas > 0){
                System.out.println(filasAfectadas + " dato(s) eliminado(s) correctamente.");
            } else {
                System.out.println("No se encuentra empleado con id proporcionado.");
            }
        }catch(SQLException e){
            System.out.println("Error al eliminar los datos. " + e.getMessage());
        }
        
    }
}
