
public enum TipoContrato {
	INDEFINIDO("completo", 3.0), TEMPORAL("poco", 2.0), BECARIO("practicas", 1.0);
	private final String nombre;
	private final double multiplicador;

	TipoContrato(String nombre, double multiplicador) {
		this.nombre = nombre;
		this.multiplicador = multiplicador;
	}

	@SuppressWarnings("unused")
	private String nombre() {
		return nombre;
	}

	@SuppressWarnings("unused")
	private double multiplicador() {
		return multiplicador;
	}
	
	public static void main(String[] args) {
		
	System.out.println(TipoContrato.BECARIO.nombre);
	}
	
	public double calcula(int anyos) {
		double res = 0.0;
		
		res= anyos* TipoContrato.BECARIO.multiplicador;
		
		return res;
	}

}
