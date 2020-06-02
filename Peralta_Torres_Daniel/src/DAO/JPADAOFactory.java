package DAO;

import JPA.JPAClienteDAO;
import JPA.JPATicketDAO;
import JPA.JPAVehiculoDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new JPAClienteDAO();
	}

	@Override
	public VehiculoDAO getVehiculoDAO() {
		// TODO Auto-generated method stub
		return new JPAVehiculoDAO();
	}
	
	@Override
	public TicketDAO getTicketDAO() {
		// TODO Auto-generated method stub
		return new JPATicketDAO();
	}
}
