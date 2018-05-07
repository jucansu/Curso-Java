import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

public class PruebaPersona {
	
	private final static Logger LOGGER = Logger.getLogger(Persona.class.getName());
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1989, 11, 11);
		EmpleadoPublico p0 = new EmpleadoPublico("pepe", "sanchez", "30224083J", 25, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p1 = new EmpleadoPublico("juan", "sanchez", "50440596D", 55, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p2 = new EmpleadoPublico("david", "austero", "63613182N", 25, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p3 = new EmpleadoPublico("laura", "sanchez", "36250153Z", 64, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p4 = new EmpleadoPublico("antonio", "sanchez", "60128157Q", 19, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p5 = new EmpleadoPublico("juan423", "austero", "42713209R", 44, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p6 = new EmpleadoPublico("pepe234", "martin", "94004864T", 29, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p7 = new EmpleadoPublico("juan444", "sanchez", "76360988E", 32, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p8 = new EmpleadoPublico("pepe55", "sanchez", "98841747Y", 35, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p9 = new EmpleadoPublico("juan66", "sanchez", "66071557D", 65, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p10 = new EmpleadoPublico("pepe667", "martin", "07212637K", 25, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p11 = new EmpleadoPublico("juan88", "martin", "23029718W", 29, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p12 = new EmpleadoPublico("pepe888", "martin", "13469282E", 17, date, 2050, TipoContrato.TEMPORAL, null, 0);
		EmpleadoPublico p13 = new EmpleadoPublico("juan99", "martin", "24397017C", 80, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico p14 = new EmpleadoPublico("juan169", "martin", "12456786D", 49, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		EmpleadoPublico pIgual = new EmpleadoPublico("bu", "carmona", "12456786D", 49, date, 2050, TipoContrato.INDEFINIDO, null, 0);
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		ArrayList<Persona> personas10000= new ArrayList<Persona>();
		
		for(int i=0; i<10000000;i++) {
			personas10000.add(p0);
			personas10000.add(p1);
		}
		
		personas.add(p0);
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		personas.add(p5);
		personas.add(p6);
		personas.add(p7);
		personas.add(p8);
		personas.add(p9);
		personas.add(p10);
		personas.add(p11);
		personas.add(p12);
		personas.add(p13);
		personas.add(p14);
		personas.add(pIgual);
		
		GestorPersonas g = GestorPersonas.getInstancia();
		g.setPersonas(personas);
		
		GestorPersonas g1 = GestorPersonas.getInstancia();
		g1.setPersonas(personas10000);
		
//		Long time_start= System.currentTimeMillis();
//		System.out.println("tiempo inicio:"+time_start);
//		g1.filtraMas40Con();
//		Long time_final= System.currentTimeMillis();
//		System.out.println("tiempo final:"+time_final);
//
//	System.out.println(time_final-time_start);
		


//		// Collections.sort(personas);
//		TreeSet<Persona> res = new TreeSet<Persona>();
//		res = metodo1(p0, p1, p2,p8);

//		for (Persona p : personas) {
//			System.out.println(p.getNombre());
//		}
		
		
//		
//		Cotizable c = new EmpleadoPublico();
//		Persona p= new EmpleadoPublico();
//		EmpleadoPublico empleadoP= new EmpleadoPublico();
		
//		g.imprime((Persona p)->{return p.getApellidos().endsWith("chez");});
//		
//		g.procesaPersona( p->p.estaJubilado(p) == true,p->p.imprimeHistorial() );	
		
		
		//personas.stream().filter(x -> x.estaJubilado(x)== true).sorted().forEach(System.out::println);
		//System.out.println(g.edadMediaJubilados());
		//System.out.println( g.sobreEdadMedia()); 
		//System.out.println(g.iguales().size());
		//System.out.println(g.agruparPrimeraLetraApellido());
		//System.out.println(g.mergeDni());
		//g.masMayorSinJubilar();
		//System.out.println(g1.filtraMas40Con());
		//System.out.println(g1.filtraMas40Sin());
	
		for(Persona p: personas) {
		System.out.println(p);
		}
		
	}

	public void procesaExpediente() {
		LocalDate date = LocalDate.of(1989, 11, 11);

		try (EmpleadoPublico e = new EmpleadoPublico("pepe", "sanchez", "224083J", 25, date, 2050,
				TipoContrato.TEMPORAL, null, 0)) {
			System.out.println(e);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static TreeSet<Persona> metodo1(Persona... listaPersonas) {

		TreeSet<Persona> res = new TreeSet<Persona>();

		for (Persona p : listaPersonas) {
			res.add(p);
			System.out.println(p.toString());
		}

		return res;
	}

	public static ArrayList<Persona> arrayToList(ArrayList personas) {
		ArrayList<Persona> res = new ArrayList<Persona>();

		return res;
	}

}
