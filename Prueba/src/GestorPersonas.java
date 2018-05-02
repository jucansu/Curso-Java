import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GestorPersonas {

	private static GestorPersonas gestorPersonas = null;
	private static List<Persona> personas;

	private GestorPersonas() {

	}

	public GestorPersonas(GestorPersonas gestor, List<Persona> personas) {

	}

	public static GestorPersonas getInstancia() {

		if (gestorPersonas == null) {
			gestorPersonas = new GestorPersonas();
		}
		return gestorPersonas;

	}

	public int edadMedia() {
		int sum = 0;
		int cont = 0;
		int res = 0;

		for (Persona p : personas) {
			sum += p.getEdad();
			cont++;
		}
		res = sum / cont;

		return res;
	}

	public double edadMedia2() {
		// Supplier<Stream<double>> streamSupplier = personas.stream().mapToInt(x ->
		// x.getEdad()).average().getAsDouble();
		return personas.stream().mapToInt(x -> x.getEdad()).average().getAsDouble();

	}

	public double edadMediaJubilados() {
		return personas.stream().filter(y -> {
			System.out.println("filter:" + y);
			return y.estaJubilado(y);
		}).mapToInt(x -> {
			System.out.println("map:" + x);
			return x.getEdad();
		}).average().getAsDouble();

	}

	public Set<Persona> iguales() {
		return personas.stream().collect(Collectors.toSet());
	}

	public List<Persona> sobreEdadMedia() {
		return personas.stream().filter(p -> p.getEdad() > edadMedia()).collect(Collectors.toList());
	}

	public List<Persona> bajoEdadMedia() {
		return personas.stream().filter(p -> p.getEdad() <= edadMedia()).collect(Collectors.toList());
	}

	public Map<Object, List<Persona>> agruparPrimeraLetraApellido() {

		Map<Object, List<Persona>> res = personas.stream()
				.collect(Collectors.groupingBy(p -> p.getApellidos().charAt(0)));
		return res;

	}

	public Collector<Persona, StringJoiner, String> mergeDni() {

		Collector<Persona, StringJoiner, String> res = Collector.of(() -> new StringJoiner("-"), (j, p) -> {
			try {
				j.add(p.getDni());
			} catch (DNINoValidoException e) {
				e.printStackTrace();
			}
		}, (j1, j2) -> j1.merge(j2), StringJoiner::toString);

		String names = personas.stream().collect(res);
		System.out.println(names);

		return res;

	}

	public Persona masMayorSinJubilar() {
		personas.stream().filter(x -> !x.estaJubilado(x)).reduce((p1, p2) -> p1.getEdad() > p2.getEdad() ? p1 : p2)
				.ifPresent(System.out::println);

		return null;

	}

	public List<Persona> filtraMas40Con() {
		
		List<Persona> res = personas.parallelStream().filter(x -> x.getEdad() > 40).sorted().collect(Collectors.toList());
		return res;

	}
	
	public List<Persona> convierteEmpleadoJubilado(){
		//List<Persona> res= personas.stream().filter(x->x.estaJubilado(x)).flatMap(y->y.)
				
				return null;
	}

	public List<Persona> filtraMas40Sin() {
		List<Persona> res = personas.stream().filter(x -> x.getEdad() > 40).collect(Collectors.toList());
		return res;

	}

	public void anyadeEmpleado(Persona p) throws DNIDuplicadoException {

		for (Persona p1 : personas) {
			try {
				if (p1.getDni().equals(p.getDni())) {
					throw new DNIDuplicadoException("DNI repetido");
				}
			} catch (DNINoValidoException e) {
				e.printStackTrace();
			}
		}
		personas.add(p);
	}

	public void imprime(Predicate<Persona> checker) {
		for (Persona p : personas) {
			if (checker.test(p)) {
				System.out.println(p.getApellidos() + " ");
			}
			System.out.println();

		}
	}

	public static GestorPersonas getGestorPersonas() {
		return gestorPersonas;
	}

	public static void setGestorPersonas(GestorPersonas gestorPersonas) {
		GestorPersonas.gestorPersonas = gestorPersonas;
	}

	public static List<Persona> getPersonas() {
		return personas;
	}

	public static void setPersonas(List<Persona> personas) {
		GestorPersonas.personas = personas;
	}

	public void procesaPersona(Predicate<Persona> test, Consumer<Persona> block) {

		for (Persona p : personas) {
			if (test.test(p)) {
				block.accept(p);
				System.out.println(p.getNombre());
			}
		}
	}

}
