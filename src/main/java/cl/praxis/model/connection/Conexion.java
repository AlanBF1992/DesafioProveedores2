package cl.praxis.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection con = null;
	
	private Conexion() {
		try {
			//Conectar
			Class.forName("org.postgresql.Driver"); //Driver
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			
			boolean isValid = con.isValid(5000);
			
			System.out.println(isValid? "Test Ok": "Test Fallido");
			
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Error al crear la conexión.");
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (con == null) {
			new Conexion();
		}
		return con;
	}
}
