package DAO;

import java.util.List;

import Modelo.Cliente;
import Modelo.Vehiculo;
import Modelo.Ticket;

public interface GenericDAO<T, ID> {
	
	public void createTable();

	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();

	public void deleteByID(ID id);
	
	public List<Vehiculo> buscarCedula(String cedula);
	
	public List<Ticket> buscarPlaca(String placa);
	
}
