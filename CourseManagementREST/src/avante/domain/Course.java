package avante.domain;

import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import avante.dao.CourseDAO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
	@XmlAttribute
	private int id;
	@XmlElement(name = "course_name")
	private String name;
	private int credits;
	private Teacher teacher;
	private int teacherId;

	public Course() {
	}

	public Course(int id, String name, int credits, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.teacher = teacher;
	}

	private CourseDAO courseDAO = new CourseDAO();

	// Getters and setters follow

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

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

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

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}
