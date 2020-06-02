package Modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import DAO.GenericDAO;
import DAO.ClienteDAO;
import DAO.DAOFactory;
import DAO.VehiculoDAO;
import DAO.TicketDAO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		
		/*ClienteDAO clieD = DAOFactory.getFactory().getClienteDAO();
		VehiculoDAO vehiD = DAOFactory.getFactory().getVehiculoDAO();
		TicketDAO tickD = DAOFactory.getFactory().getTicketDAO();*/
		
		Cliente cli1 = new Cliente("0105534614","Daniel", "direccion1", "0995296639");
		Cliente cli2 = new Cliente("0105534615","Antonio", "direccion2", "0995296638");
		System.out.println("Creando entidades");
		em.getTransaction().begin();
		em.persist(cli1);
		em.getTransaction().commit();
		em.persist(cli2);
		em.getTransaction().commit();
		
		Vehiculo veh = new Vehiculo("PBA-001", "Toyota", "Yaris", cli1);
		veh.setTicket(new Ticket(1, new GregorianCalendar(2020,6,2), new GregorianCalendar(2020,7,2),veh));
		System.out.println("Creando entidades");
		em.getTransaction().begin();
		em.persist(veh);
		em.getTransaction().commit();
		
	}

}
