package cl.praxis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.ProveedorDAO;
import cl.praxis.model.dto.Proveedor;

/**
 * Servlet implementation class ProveedorController
 */
@WebServlet("/index")
public class ProveedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProveedorDAO pDAO = new ProveedorDAO();
	
    public ProveedorController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("proveedores", pDAO.read());
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8"); // Pinche Tomcat

		String deleteId = request.getParameter("delete_id");
		if (deleteId != null) {
			// Delete
			pDAO.delete(Integer.parseInt(deleteId));
			doGet(request, response);
			return;
		}
		
		String nombre = request.getParameter("nombre");
		String rut = request.getParameter("rut");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String contacto = request.getParameter("contacto");
		String telefonoContacto = request.getParameter("telefono_contacto");
		
		if (nombre != null && rut != null && direccion != null && correo != null && telefono != null && contacto != null
				&& telefonoContacto != null && !nombre.isBlank() && !rut.isBlank() && !direccion.isBlank() && !correo.isBlank()
				&& !telefono.isBlank() && !contacto.isBlank() && !telefonoContacto.isBlank()) {
			pDAO.create(new Proveedor(
					nombre,
					rut,
					direccion,
					correo,
					telefono,
					contacto,
					telefonoContacto
					));
		}
				
		doGet(request, response);
	}

}
