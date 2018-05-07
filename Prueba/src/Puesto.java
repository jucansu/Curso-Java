
public class Puesto<T> {
	private String nombre;
	private String ubicacion;
	private T elemento;

	public Puesto(String nombre, String ubicacion) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	public Puesto() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public T getT() {
		return elemento;
	}

	public void setT(T elemento) {
		this.elemento = elemento;
	}
	

}
