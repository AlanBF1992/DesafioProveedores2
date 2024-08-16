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
 * Servlet implementation class ProveedorEditController
 */
@WebServlet("/edit")
public class ProveedorEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProveedorDAO pDAO = new ProveedorDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("edit_id");
		if (id == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		Proveedor p = pDAO.read(Integer.parseInt(id));
		if (p == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		request.setAttribute("p", p);
		getServletContext().getRequestDispatcher("/edition.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String rut = request.getParameter("rut");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String contacto = request.getParameter("contacto");
		String telefonoContacto = request.getParameter("telefono_contacto");
		
		if (id != null && nombre != null && rut != null && direccion != null && correo != null && telefono != null && contacto != null
				&& telefonoContacto != null && !nombre.isBlank() && !rut.isBlank() && !direccion.isBlank() && !correo.isBlank()
				&& !telefono.isBlank() && !contacto.isBlank() && !telefonoContacto.isBlank()) {
			System.out.println("Llegamos hasta acá c");
			pDAO.update(new Proveedor(
					Integer.parseInt(id),
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
