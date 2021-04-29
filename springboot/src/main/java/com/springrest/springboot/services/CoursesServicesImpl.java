package com.springrest.springboot.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springboot.dao.CourseDao;
import com.springrest.springboot.entities.Courses;
@Service
public class CoursesServicesImpl implements CourseService 
{

//	List<Courses> list;
	@Autowired
	private CourseDao coursedao;
	 public CoursesServicesImpl() {
//		 list=new ArrayList<Courses>();
//		 list.add(new Courses(145,"Java Core","This course contain basic of java"));
//		 list.add(new Courses(143, "Python", "This course contain basic of Python"));
	}
	
	@Override
	public List<Courses> getCourses() {
		return coursedao.findAll();
	}
	public Courses getCourse(long courseId) {
//		for(Courses c:list)
//		{
//			if (c.getId()==courseId)
//			{
//				return c;
//			}
//		}
		return coursedao.getOne(courseId); 
	}
	public Courses addCourse(Courses course)
	{
//		list.add(course);
		coursedao.save(course);
		return course;
	}
	public Courses updateCourse(Courses course, long courseId) {
//		for (Courses c:list)
//		{
//			if (c.getId()==courseId)
//			{
//				c.setId(course.getId());
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//			}
//		}
		coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		int count=0;
//		for(Courses c:list)
//		{
//			if (c.getId()==courseId)
//			{
//				break;
//			}
//			else {
//				count++;
//			}
//		}
//		list.remove(count);
		Courses entity=coursedao.getOne(courseId);
		coursedao.delete(entity);
	}
}
