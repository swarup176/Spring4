package cts.service;

import java.util.List;

import cts.domain.Course;
import cts.model.student.Registration;


public interface AppService {
	public List<Course> getAllCourses();

	public void addStudent(Registration registration);
}