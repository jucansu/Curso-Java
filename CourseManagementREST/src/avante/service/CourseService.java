package avante.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import avante.domain.Course;
import avante.domain.Teacher;

@Path("/course")
public class CourseService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("get/{courseId}")
	public Course getCourse(@PathParam("courseId") int id) {

		// To keep the example simple, we will return
		// hardcoded values here. However, you could get
		// data from database using, for example, JDO or JDBC

		return new Course(id, "Course-" + id, 5, new Teacher(2, "Teacher1"));
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("get2/{courseId}")
	public List<Course> listaCurso() {
		List<Course> cursos = new ArrayList<Course>();
		Teacher t1 = new Teacher(2, "pepe");
		Teacher t2 = new Teacher(2, "manuel");
		Course c1 = new Course(1, "curso 1", 6, t1);
		Course c2 = new Course(2, "curso 2", 12, t2);

		cursos.add(c1);
		cursos.add(c2);

		return cursos;

	}
	
	

}