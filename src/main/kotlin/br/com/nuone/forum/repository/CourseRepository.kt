package br.com.nuone.forum.repository;

import br.com.nuone.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
}