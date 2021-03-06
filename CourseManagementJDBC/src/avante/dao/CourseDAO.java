package avante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import avante.domain.Course;
import avante.domain.DatabaseConnectionFactory;
import avante.domain.Teacher;

public class CourseDAO {

	public static void addCourse(Course course) throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "insert into Course (name, credits) values (?,?)";
			// create the prepared statement with an option to get auto-generated keys
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// set parameters
			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getCredits());

			stmt.execute();

			// Get auto-generated keys
			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next())
				course.setId(rs.getInt(1));

			rs.close();
			stmt.close();
		} finally {
			con.close();
		}
	}

	public static void removeCourse(int courseId) throws SQLException {
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "delete from Course where Id= (?) ";

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, courseId);
			stmt.execute();

			stmt.close();
		} finally {
			con.close();
		}

	}

	public static void editCourse(Course course) throws SQLException {
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "edit from Course where Id= (?) ";

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getCredits());

			stmt.execute();

			// Get auto-generated keys
			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next())
				course.setId(rs.getInt(1));

			rs.close();
			stmt.close();

		} finally {
			con.close();
		}

	}

	public List<Course> getCourses() throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		List<Course> courses = new ArrayList<Course>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			// create SQL statement using left outer join
			StringBuilder sb = new StringBuilder("select course.id as courseId, course.name as courseName,")
					.append("course.credits as credits, Teacher.id as teacherId, Teacher.first_name as firstName, ")
					.append("Teacher.last_name as lastName, Teacher.designation designation ")
					.append("from Course left outer join Teacher on ").append("course.Teacher_id = Teacher.id ")
					.append("order by course.name");

			// execute the query
			rs = stmt.executeQuery(sb.toString());

			// iterate over result set and create Course objects
			// add them to course list
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("courseId"));
				course.setName(rs.getString("courseName"));
				course.setCredits(rs.getInt("credits"));
				courses.add(course);

				int teacherId = rs.getInt("teacherId");
				// check whether teacher id was null in the table
				if (rs.wasNull()) // no teacher set for this course.
					continue;
				Teacher teacher = new Teacher();
				teacher.setId(teacherId);
				teacher.setFirstName(rs.getString("firstName"));
				teacher.setLastName(rs.getString("lastName"));
				teacher.setDesignation(rs.getString("designation"));
				course.setTeacher(teacher);
			}

			return courses;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
