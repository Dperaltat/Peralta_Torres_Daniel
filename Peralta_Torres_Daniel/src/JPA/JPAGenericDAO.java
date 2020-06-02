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
		this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
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
	public void update(T entity) {
		em.getTransaction().begin();
		try {
		    em.merge(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
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
    public void deleteByID(ID id) {
	T entity = this.read(id);
	if (entity != null)
	    this.delete(entity);
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
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehiculo> buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Consulta Realizada...");
		Query nativeQuery = em.createNativeQuery("SELECT placa, marca, modelo, cliente_cedula, vehiculo_placa FROM cliente, vehiculo, ticket WHERE vehiculo.cliente_cedula=cliente.cedula and cliente.cedula=?", Vehiculo.class);
		nativeQuery.setParameter(1, cedula);
		return (List<Vehiculo>)nativeQuery.getResultList();
	}
	

	@Override
	public List<Ticket> buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cliente buscar(String cedula, String nombre) {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM cliente where cedula =? AND nombre=?", Cliente.class);
		nativeQuery.setParameter(1, cedula);
		nativeQuery.setParameter(2, nombre);
		
		return (Cliente) nativeQuery.getSingleResult();
	}
	
}