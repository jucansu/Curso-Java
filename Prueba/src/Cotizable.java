import java.util.List;

public interface Cotizable {

	String imprimeHistorial();
	
	public default boolean puedeTrabajar(List<Boolean> lista) {
		boolean res= false;
		for(boolean b: lista) {
			if(b=true) {
				res= true;
			}else {
				res= false;
			}
		}
		
		return res;
	}
}
