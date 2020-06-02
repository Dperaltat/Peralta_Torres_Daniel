package DAO;

import Modelo.Vehiculo;

import java.util.List;

import Modelo.Cliente;
import Modelo.Vehiculo;
import Modelo.Ticket;

public interface TicketDAO  extends GenericDAO<Ticket, Integer> {
	
	public List<Ticket> buscarPlaca(String placa);
}
