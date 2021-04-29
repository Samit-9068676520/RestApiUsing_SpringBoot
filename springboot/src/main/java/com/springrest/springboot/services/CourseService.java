package com.springrest.springboot.services;

import java.util.List;

import com.springrest.springboot.entities.Courses;

public interface CourseService {
	public List<Courses> getCourses();
	public Courses getCourse(long course);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course, long courseId);
	public void deleteCourse(long courseId);
}
