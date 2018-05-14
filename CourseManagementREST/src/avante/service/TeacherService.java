package avante.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import avante.domain.Teacher;

@Path("/teacher")
public class TeacherService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("get/{teacherId}")
	public Teacher getTeacher(@PathParam("teacherId") int id) {

		// To keep the example simple, we will return
		// hardcoded values here. However, you could get
		// data from database using, for example, JDO or JDBC

		return new Teacher(id, "Teacher-" + id);
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("get2/{teacherId}")
	public List<Teacher> listaTeacher(@PathParam("teacherId") int id) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		Teacher t1 = new Teacher(1, "pepe");
		Teacher t2 = new Teacher(2, "manuel");

		teachers.add(t1);
		teachers.add(t2);

		// To keep the example simple, we will return
		// hardcoded values here. However, you could get
		// data from database using, for example, JDO or JDBC

		return teachers;
	}

}
