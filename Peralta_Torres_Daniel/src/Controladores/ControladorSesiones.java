package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClienteDAO;
import DAO.DAOFactory;
import DAO.VehiculoDAO;
import Modelo.Cliente;


@WebServlet( name = "ControladorSesiones", urlPatterns= {"/ControladorSesiones"})
public class ControladorSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorSesiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		System.out.println("Id de sesion del controlador "+ sesion.getAttribute("accesos"));
		VehiculoDAO vehiculoDao = DAOFactory.getFactory().getVehiculoDAO();
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = DAOFactory.getFactory().getClienteDAO();
		
		if(Integer.parseInt(request.getParameter("id"))==1) {
			
			cliente = clienteDao.read(request.getParameter("c"));
			System.out.println("Cedula: "+request.getParameter("c"));
			
			request.setAttribute("idc", request.getParameter("c"));
			request.setAttribute("usuario", cliente);
			
			getServletContext().getRequestDispatcher("/JSPs/Agregar.jsp").forward(request, response);
		}else if(Integer.parseInt(request.getParameter("id"))==2) {

			cliente = clienteDao.read(request.getParameter("idU"));
			
			
			request.setAttribute("vehiculo", vehiculoDao.buscarCedula(cliente.getCedula()));
			request.setAttribute("usuario", cliente);
			
			getServletContext().getRequestDispatcher("/JSPs/Cliente.jsp").forward(request, response);
		}

		if(Integer.parseInt(request.getParameter("id"))==3) {
			System.out.println("Ingresando...");
			System.out.println(vehiculoDao.findAll());
			
			request.setAttribute("Vehiculo", vehiculoDao.findAll());
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
