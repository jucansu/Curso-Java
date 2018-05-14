package avante.domain;

import java.sql.SQLException;
import java.util.List;

import avante.dao.CourseDAO;

public class Course {
	private int id;
	private String name;
	private int credits;
	private int teacherId;

	private Teacher teacher;

	private CourseDAO courseDAO = new CourseDAO();

	public void addCourse() throws SQLException {
		courseDAO.addCourse(this);
	}
	
	public void removeCourse() throws SQLException {
		courseDAO.removeCourse(this.id);
	}

	public void editCourse(Course c) throws SQLException {
		courseDAO.editCourse(c);
	}
	public List<Course> getCourses() throws SQLException {
		return courseDAO.getCourses();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public boolean isValidCourse() {
		return name != null && credits != 0;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
}
