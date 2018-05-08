package Avante.domain;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ficheros {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("timelog.log");
		System.out.println(Files.exists(p));
		Files f = null;

		if (f.exists(p)) {
			System.out.println("Existe");
		} else {
			System.out.println("no existe");
		}
		// // lee fichero
		// f.lines(p).forEach(System.out::println);

		// // numero de entradas
		// System.out.println(Files.lines(p).count());

		// errores
//		System.out.println(Files.lines(p).filter(line -> line.contains("(4") || line.contains("(5")).count());

		// //Dia con mas visitas
		Map<String, List<String>> visitas = new TreeMap<String, List<String>>();
		visitas= Files.lines(p).collect(Collectors.groupingBy(x->x.toString().substring(0,10)));
		
		for(String s: visitas.keySet()){
			System.out.println(visitas.get(s));
			
		}


	}
}
