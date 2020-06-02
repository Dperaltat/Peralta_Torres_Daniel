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


@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		System.out.print("Iniciar Sesion \n");
		
		ClienteDAO usuarioDAO = DAOFactory.getFactory().getClienteDAO();
		String cedula ="";
		String nombre = "";
		String url = null;
		int i=0;
		
		String accion  = request.getParameter("resp");
		Cliente user = new Cliente();
		
		
		if(accion.equals("Login")) {
			cedula = request.getParameter("user");
			nombre = request.getParameter("password");
			user = usuarioDAO.buscar(cedula, nombre);
		}

		//System.out.println("retorno de usuario: "+ usuarioDAO.buscar(correo, contrasena));
		//url="/JSPs/Usuario.jsp";
		try {
			if(user != null) {
				VehiculoDAO telefonoDao = DAOFactory.getFactory().getVehiculoDAO();
					
				request.setAttribute("vehiculo", telefonoDao.buscarCedula(user.getCedula()));
				request.setAttribute("usuario", user);
				getServletContext().getRequestDispatcher("/JSPs/Cliente.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/JSPs/login.jsp").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(">>>Error:LoginServlet:DOPOST "+e.getMessage());
		}
		

	}

}