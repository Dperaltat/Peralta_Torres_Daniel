package Modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Tikcet")
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar fechaIngreso;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar fechaSalida;
	@ManyToOne
	@JoinColumn
	private Vehiculo vehiculo;
	
	public Ticket() {
		
	}
	
	public Ticket(int numero, GregorianCalendar fechaIngreso, GregorianCalendar fechaSalida, Vehiculo vehiculo) {
		super();
		this.numero = numero;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public GregorianCalendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public GregorianCalendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(GregorianCalendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + numero;
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (numero != other.numero)
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [numero=" + numero + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida
				+ ", vehiculo=" + vehiculo + "]";
	}
	
	
}
