package JPA;

import DAO.TicketDAO;

import Modelo.Cliente;
import Modelo.Vehiculo;
import Modelo.Ticket;

public class JPATicketDAO extends JPAGenericDAO<Ticket, Integer> implements TicketDAO {
	
	public JPATicketDAO() {
		super(Ticket.class);
	}
	
	
}
