package Avante.Servelts;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Avante.domain.EmpleadoPublico;
import Avante.domain.GestorPersonas;
import Avante.domain.Persona;
import Avante.domain.TipoContrato;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GestorPersonas g = GestorPersonas.getInstancia();
		LocalDate date = LocalDate.of(1989, 11, 11);
		EmpleadoPublico p0 = new EmpleadoPublico("pepe", "sanchez", "30224083J", 25, date, 2050, TipoContrato.TEMPORAL,
				"admin", "admin", null, 0);
		EmpleadoPublico p1 = new EmpleadoPublico("juan", "sanchez", "50440596D", 55, date, 2050,
				TipoContrato.INDEFINIDO, "user", "user", null, 0);
		List<Persona> lista = new ArrayList<Persona>();

		lista.add(p0);
		lista.add(p1);

		g.setPersonas(lista);

		request.getSession().setAttribute("listaP", g.getPersonas());
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
