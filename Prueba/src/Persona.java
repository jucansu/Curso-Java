import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Persona implements Comparable<Persona>, Cotizable {
	// Atributos
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	private LocalDate anhoInicio;
	private int anhoJubilacion;
	private TipoContrato tipoContrato;

	private final static Logger LOGGER = Logger.getLogger(Persona.class.getName());


	// Constructor
	public Persona(String string, String string2, String string3, int i, LocalDate localDate, int j,
			TipoContrato contrato) {
		super();
		this.nombre = string;
		this.apellidos = string2;
		this.dni = string3;
		this.edad = i;
		this.anhoInicio = localDate;
		this.anhoJubilacion = j;
		this.tipoContrato = contrato;
		//logger
		LOGGER.log(Level.INFO, "prueba");
		LOGGER.log(Level.WARNING, "Cuidado");
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() throws DNINoValidoException {
		checkDNI(dni);
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getAnhoInicio() {

		return anhoInicio;
	}

	public void setAnhoInicio(LocalDate anhoInicio) {
		this.anhoInicio = anhoInicio;
	}

	public int getAnhoJubilacion() {
		return anhoJubilacion;
	}

	public void setAnhoJubilacion(int anhoJubilacion) {
		this.anhoJubilacion = anhoJubilacion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean estaJubilado(Persona p) {
		int a = p.anhoInicio.getYear();
		boolean res = false;
		if (p.tipoContrato.equals(TipoContrato.TEMPORAL)) {
			if (p.edad > 65 ^ (LocalDate.now().getYear() - a >= 33)) {
				res = true;
			}
		} else if (p.edad > 65 ^ (LocalDate.now().getYear() - a >= 30)) {
			res = true;
		}
		return res;
	}

	public boolean estaJubilado2(Persona p) {
		boolean res = false;
		int a = p.anhoInicio.getYear();
		switch (p.tipoContrato) {
		case TEMPORAL:
			if (p.edad > 65 ^ (LocalDate.now().getYear() - a >= 33)) {
				res = true;
			}
			break;

		default:
			if (p.edad > 65 ^ (LocalDate.now().getYear() - a >= 30)) {
				res = true;
			}
			break;
		}

		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	@Override
	public int compareTo(Persona o) {
		int res = 0;
		if (res == 0)
			try {
				res = this.getDni().compareTo(o.getDni());
			} catch (DNINoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return res;
	}

	private void checkDNI(String dni) throws DNINoValidoException {
		final String letra = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false) {
			throw new DNINoValidoException("DNI no válido");
		}
		Integer valor = new Integer(dni.substring(0, 8));
		int aux = valor % 23;
		Character letraReal = dni.charAt(8);
		Character letraCalculada = letra.charAt(aux);
		if (!letraReal.equals(letraCalculada)) {
			throw new DNINoValidoException("DNI no válido");
		}

	}

	@Override
	public String toString() {
		try {
			return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + this.getDni() + "]";
		} catch (DNINoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
