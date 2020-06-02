package JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import DAO.GenericDAO;
import Modelo.Cliente;
import Modelo.Vehiculo;
import Modelo.Ticket;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
	protected EntityManager em;
	
	
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("JPA").createEntityManager();
	}

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println(">>> ERROR: JPAGENERICDAO: create " + e);
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}

	@Override
	public void delete(T entity) {
		System.out.println("ELIMINANDO...");
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}
	
}