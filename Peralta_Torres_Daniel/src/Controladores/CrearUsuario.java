package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.DAOFactory;
import Modelo.Cliente;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String cedula="";
		String nombre="";
		String direccion="";
		String telefono="";
		
		Cliente cli = new Cliente();
		
		String accion = request.getParameter("resp");
		ClienteDAO clientedao = DAOFactory.getFactory().getClienteDAO();
		
		if(accion.equals("Registrarse")) {
			nombre = request.getParameter("nombre");
			cedula = request.getParameter("cedula");
			direccion = request.getParameter("direccion");
			telefono  = request.getParameter("telefono");
			
			cli = new Cliente(cedula, nombre, direccion, telefono);
			
			System.out.println("Usuario a ser creado: " + cli);
			if(clientedao.buscarCedula(cedula).size()==0) {
				clientedao.create(cli);
				System.out.println("Usuario creado");
				getServletContext().getRequestDispatcher("/JSPs/Registrado.jsp").forward(request, response);
			}
		}
	}

}
