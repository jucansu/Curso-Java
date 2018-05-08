package Avante.domain;
import java.time.LocalDate;

public class Prueba {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1989, 11, 11);
		Persona p = new EmpleadoPublico("pepe","sanchez","30224083J",25, date,2050, TipoContrato.TEMPORAL,"bnu",1);
		
		Persona p1 = new EmpleadoPublico("juan","sanchez","30784083J",70, date,2050, TipoContrato.INDEFINIDO,"ai",8);
		boolean res1= false;
		boolean res2= false;
	
		res1 = p.estaJubilado( p);
		res2 = p1.estaJubilado(p1);
		
		
		System.out.println("Esta Jubilado"+ res1);
		System.out.println("Esta Jubilado"+ res2);
		
	}
}
