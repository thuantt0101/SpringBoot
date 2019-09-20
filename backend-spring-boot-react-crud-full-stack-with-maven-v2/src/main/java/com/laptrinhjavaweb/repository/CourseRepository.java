package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{

}
