package DAO;

import java.util.List;

import Modelo.Cliente;
import Modelo.Vehiculo;

public interface VehiculoDAO extends GenericDAO<Vehiculo, String> {
	
	List<Vehiculo> buscarCedula(String cedula);

}
