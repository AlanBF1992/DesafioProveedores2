package cl.praxis.model.dto;

public class Proveedor {
	private int id;
	private String nombre;
	private String rut;
	private String direccion;

	private String correo;
	private String telefono;
	private String contacto;
	private String telefonoContacto;

	public Proveedor(int id, String nombre, String rut, String direccion, String correo, String telefono, String contacto,
			String telefonoContacto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.contacto = contacto;
		this.telefonoContacto = telefonoContacto;
	}
	
	public Proveedor(String nombre, String rut, String direccion, String correo, String telefono, String contacto,
			String telefonoContacto) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.contacto = contacto;
		this.telefonoContacto = telefonoContacto;
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRut() {
		return rut;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getContacto() {
		return contacto;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", direccion=" + direccion + ", correo=" + correo + ", telefono="
				+ telefono + ", contacto=" + contacto + ", telefonoContacto=" + telefonoContacto + "]";
	}
}
