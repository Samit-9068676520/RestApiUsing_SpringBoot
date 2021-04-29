package com.springrest.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springboot.entities.Courses;
import com.springrest.springboot.services.CourseService;

import java.util.*;
@RestController
public class MyController {
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home/")
	public String home() {
		return "Welcome to my page";
	}
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseservice.getCourses();
	}
	@GetMapping("/course/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	} 
	@PostMapping("/course")
	public Courses addCourse(@RequestBody Courses course)
	{
		return this.courseservice.addCourse(course);
	}
	@PutMapping("/course/{courseId}")
	public Courses updateCourse(@RequestBody Courses course,@PathVariable String courseId )
	{
		return this.courseservice.updateCourse(course,Long.parseLong(courseId));
	}
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
