package JPA;

import DAO.ClienteDAO;

import Modelo.Cliente;
import Modelo.Vehiculo;
import Modelo.Ticket;

public class JPAClienteDAO extends JPAGenericDAO<Cliente, String> implements ClienteDAO{
	
	public JPAClienteDAO() {
		super(Cliente.class);
	}
	
	
}
