package cts.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import cts.domain.Course;
import cts.model.student.Registration;
import cts.service.AppService;


@Service("appService")
public class AppServiceImpl implements AppService {

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Course> getAllCourses() {
		/* here you will call a DAO Class */
		Course c1 = new Course(1, "BCA");
		Course c2 = new Course(2, "MCA");
		Course c3 = new Course(3, "B.Tech");
		Course c4 = new Course(4, "M.Tech");
		Course c5 = new Course(5, "BBA");
		Course c6 = new Course(5, "MBA");
		List<Course> courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		courses.add(c5);
		courses.add(c6);
		return courses;
	}

	public void addStudent(Registration registration) {
				jdbcTemplate = new JdbcTemplate(dataSource);		
		// String sql = "INSERT INTO student(name,course,age,address) values('"+
		// registration.getName() + "','" + registration.getCourse()+ "'," +
		// registration.getAge() + ",'"+ registration.getAddress()+ "')";
		String sql = "INSERT INTO student_spring(name,course,age,address) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { registration.getName(),
				registration.getCourse(), registration.getAge(),
				registration.getAddress() });
	}
}