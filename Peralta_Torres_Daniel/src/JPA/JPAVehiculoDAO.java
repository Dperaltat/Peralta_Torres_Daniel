package JPA;

import DAO.VehiculoDAO;

import Modelo.Cliente;
import Modelo.Vehiculo;

public class JPAVehiculoDAO extends JPAGenericDAO<Vehiculo, String> implements VehiculoDAO{

	public JPAVehiculoDAO() {
		super(Vehiculo.class);
	}
	
}
