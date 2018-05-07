import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LineaEntrada {
	private LocalDateTime fechaHora;
	private String recurso, metodo;
	private int tiempoResp;
	private boolean isError;
	
//	public LineaEntrada(String cadena) {
//		fechaHora= DateTimeFormatter.ofPattern("")
//		this.fechaHora= cadena.substring(0, 10);
//		this.recurso = cadena.substring(12,15);
//		this.metodo= cadena.substring()
//	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	public int getTiempoResp() {
		return tiempoResp;
	}
	public void setTiempoResp(int tiempoResp) {
		this.tiempoResp = tiempoResp;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	

}
