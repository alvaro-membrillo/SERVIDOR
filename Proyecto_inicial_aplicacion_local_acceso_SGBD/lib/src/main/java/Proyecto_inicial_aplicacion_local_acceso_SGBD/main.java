package Proyecto_inicial_aplicacion_local_acceso_SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class main {

	public static void main(String[] args) {
		
		try {
			//1. Creamos la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","root");
			
			//2. Creamos objeto Statement
			Statement statement = (Statement) conexion.createStatement();
			
			//3. Ejecutar SQL
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery("Select * from usuarios");
			
			//4. Recorremos el resultSet
			while (resultSet.next()) {
				System.out.println(resultSet.getString("nombre")+" "+resultSet.getInt("Edad"));
			}
			
		} catch (Exception e) {
			System.out.println("No conecta");
			
			e.printStackTrace();
		}

	}

}
