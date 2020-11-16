package com.lzh.dao;


import com.lzh.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
}
