package Avante.domain;
import java.time.LocalDate;

public class EmpleadoPublico extends Persona implements AutoCloseable {

	private String organismoPublico;
	private int numeroTrienios;

	public EmpleadoPublico(String nombre, String apellidos, String dni, int edad, LocalDate anhoInicio,
			int anhoJubilacion, TipoContrato tipoContrato,String password,String user, String organismoPublico, int numeroTrienios) {
		super(nombre, apellidos, dni, edad, anhoInicio, anhoJubilacion, tipoContrato,password,user);
		this.organismoPublico = organismoPublico;
		this.numeroTrienios = numeroTrienios;
	}
	
	public EmpleadoPublico() {
		super();
	}

	public String getOrganismoPublico() {
		return organismoPublico;
	}

	public void setOrganismoPublico(String organismoPublico) {
		this.organismoPublico = organismoPublico;
	}

	public int getNumeroTrienios() {
		return numeroTrienios;
	}

	public void setNumeroTrienios(int numeroTrienios) {
		this.numeroTrienios = numeroTrienios;
	}

	public String imprimeHistorial() {
		String res = null;
		LocalDate date = LocalDate.of(1989, 11, 11);

		EmpleadoPublico e = new EmpleadoPublico("pepe", "sanchez", "30224083J", 25, date, 2050, TipoContrato.TEMPORAL,"admin","admin",
				"bnu", 1);
		res = e.getNombre();
		return res;

	}

	@Override
	public void close() throws Exception {
		System.out.println("cierra expediente");
	}
	


}
