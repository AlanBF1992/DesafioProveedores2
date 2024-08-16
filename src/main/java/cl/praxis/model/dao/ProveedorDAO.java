package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.connection.Conexion;
import cl.praxis.model.dto.Proveedor;

public class ProveedorDAO {

	public void create(Proveedor p) {
		try {
			
			Connection c = Conexion.getConnection();

			//Quedaría mejor con un prepared statement
			Statement s = c.createStatement();

			String query =
					"INSERT INTO public.proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto)"
					+ " VALUES ('"
					+ p.getNombre() + "','"
					+ p.getRut() + "','"
					+ p.getDireccion() + "','"
					+ p.getCorreo() + "','"
					+ p.getTelefono() + "','"
					+ p.getContacto() + "','"
					+ p.getTelefonoContacto() + "')";

			s.execute(query);
			
		} catch (SQLException ex){
			System.out.println("Error en método create()");
			ex.printStackTrace();
		}
	}
	
	public Proveedor read(int id) {		
		List<Proveedor> proveedores = read();
		Proveedor p = proveedores.stream().filter(x -> x.getId() == id).findAny().orElse(null);
		return p;
	}
	
	public List<Proveedor> read() {
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM public.proveedores";
			
			ResultSet rs = s.executeQuery(query);
			
			while (rs.next()) {
				proveedores.add(new Proveedor(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("rut"),
						rs.getString("direccion"),
						rs.getString("correo"),
						rs.getString("telefono"),
						rs.getString("contacto"),
						rs.getString("telefono_contacto")
						));
			}
			
		} catch (SQLException ex){
			System.out.println("Error en método read()");
			ex.printStackTrace();
		}
		
		
		return proveedores;
	}
	
	public void update(Proveedor p) {
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "UPDATE public.proveedores SET "
					+ "nombre = '" + p.getNombre() + "',"
					+ "rut = '" + p.getRut() + "',"
					+ "direccion = '" + p.getDireccion() + "',"
					+ "correo = '" + p.getCorreo() + "',"
					+ "telefono = '" + p.getTelefono() + "',"
					+ "contacto = '" + p.getContacto() + "',"
					+ "telefono_contacto = '" + p.getTelefonoContacto() + "' "
					+ "WHERE id = " + p.getId();
			
			s.execute(query);
		} catch (SQLException ex){
			System.out.println("Error en método update()");
			ex.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "DELETE FROM public.proveedores "
					+ "WHERE id = " + id;

			s.execute(query);
		} catch (SQLException ex){
			System.out.println("Error en método delete()");
			ex.printStackTrace();
		}
	}
	
}
