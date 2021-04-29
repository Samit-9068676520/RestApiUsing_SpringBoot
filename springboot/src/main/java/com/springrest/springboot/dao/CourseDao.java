package com.springrest.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springboot.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{

}
